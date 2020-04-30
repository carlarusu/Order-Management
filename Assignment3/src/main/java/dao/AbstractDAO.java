package dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;

/**
 *Class contains the methods used to access the database based on CRUD 
 *Uses reflection for each operation
 *Creates and executes queries
 */
public class AbstractDAO<T> {
	protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());
	private final Class<T> type;

	/**
	 * Constructor
	 * Gets the type of the class's parameter for reflection
	 */
	@SuppressWarnings("unchecked")
	public AbstractDAO() {
		this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

	}
	
	/**
	 * Creates the SELECT query
	 * @param field
	 * @return String query
	 */
	private String createSelectQuery(String field) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(" * ");
		sb.append(" FROM ");
		sb.append(type.getSimpleName());
		sb.append(" WHERE " + field + " =?");
		return sb.toString();
	}
	
	/**
	 * Creates the DLEETE query
	 * @param field
	 * @return
	 */
	private String createDeleteQuery(String field) {
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM ");
		sb.append(type.getSimpleName());
		sb.append(" WHERE " + field + " =?");
		return sb.toString();
	}
	
	/**
	 * Creates the INSERT query
	 * @return
	 */
	private String createInsertQuery() {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO  ");
		sb.append(type.getSimpleName());
		sb.append(" (");
		int i=0;
		for (Field field : type.getDeclaredFields()) {
			if (i!=0) {
				sb.append(field.getName()+",");
			}
			i++;
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append(") VALUES (");
		for (int j=1; j<i; j++) {
			sb.append("?,");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append(")");
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	/**
	 * Creates the UPDATE query
	 * @return
	 */
	private String createUpdateQuery() {
		StringBuilder sb = new StringBuilder();
		String id = "";
		sb.append("UPDATE  ");
		sb.append(type.getSimpleName());
		sb.append(" SET ");
		int i=0;
		for (Field field : type.getDeclaredFields()) {
			if (i!=0) {
				sb.append(field.getName()+" = ?,");
			} else {
				id = field.getName();
			}
			i++;
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append(" WHERE " + id + " =?");
		System.out.println(sb.toString());
		return sb.toString();
	}

	/**
	 * Reads all entries
	 * @return
	 */
	public List<T> findAll() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM "+type.getSimpleName());
		String query = sb.toString();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();

			return createObjects(resultSet);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}

	/**
	 * Reads entry based on id
	 * @param id
	 * @return
	 */
	public T findById(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String field = "id_"+type.getSimpleName();
		String query = createSelectQuery(field);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();

			return createObjects(resultSet).get(0);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}

	/**
	 * Creates a list of the result set 
	 * @param resultSet
	 * @return
	 */
	private List<T> createObjects(ResultSet resultSet) {
		List<T> list = new ArrayList<T>();

		try {
			while (resultSet.next()) {
				T instance = type.newInstance();
				for (Field field : type.getDeclaredFields()) {
					Object value = resultSet.getObject(field.getName());
					PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), type);
					Method method = propertyDescriptor.getWriteMethod();
					method.invoke(instance, value);
				}
				list.add(instance);
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * Inserts an entry
	 * @param t
	 * @return
	 */
	public int insert(T t) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int insertedId = -1;
		String query = createInsertQuery();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			int i = 1, j=0;
			for (Field field : type.getDeclaredFields()) {
				if (j!=0) {
					PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), type);
					Method method = propertyDescriptor.getReadMethod();
					if (method != null) {
						Object value = method.invoke(t);
						statement.setObject(i, value);
						i++;
					}
				}
				j++;
			}
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				insertedId = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:insert0 " + e.getMessage());
		} catch (IntrospectionException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:insert1 " + e.getMessage());
		} catch (IllegalAccessException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:insert2 " + e.getMessage());
		} catch (IllegalArgumentException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:insert3 " + e.getMessage());
		} catch (InvocationTargetException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:insert4 " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return insertedId;
	}

	/**
	 * Updates an entry
	 * @param t
	 * @return
	 */
	public int update(T t) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int updatedId = -1;
		String query = createUpdateQuery();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			int i = 1, j=0;
			Object valueId = null;
			for (Field field : type.getDeclaredFields()) {
				if (j!=0) {
					PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), type);
					Method method = propertyDescriptor.getReadMethod();
					if (method != null) {
						Object value = method.invoke(t);
						statement.setObject(i, value);
						i++;
					}
				} else {
					PropertyDescriptor propertyDescriptorId = new PropertyDescriptor(field.getName(), type);
					Method method = propertyDescriptorId.getReadMethod();
					if (method != null) {
						valueId = method.invoke(t);
					}
				}
				j++;
			}
			statement.setObject(i, valueId);
			statement.executeUpdate();
			updatedId = (Integer) valueId;

		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:update0 " + e.getMessage());
		} catch (IntrospectionException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:update1 " + e.getMessage());
		} catch (IllegalAccessException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:update2 " + e.getMessage());
		} catch (IllegalArgumentException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:update3 " + e.getMessage());
		} catch (InvocationTargetException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:update4 " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return updatedId;
	}
	
	/**
	 * Deletes an entry
	 * @param id
	 * @return
	 */
	public int deleteById(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String field = "id_"+type.getSimpleName();
		String query = createDeleteQuery(field);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			statement.executeUpdate();

			return 0;
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:deleteById " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return -1;
	}
}
