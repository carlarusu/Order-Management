package reflectionUtility;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 * Class has methods that use reflection
 * Is used as a utility program to retrieve information about an entry,
 * to check the stock before placing an order
 * and to update the stock after placing an order
 *
 */
public class ReflectionExample {
	/**
	 * Retrieves the information of a record
	 * Uses reflection
	 * @param object
	 * @return string containing info
	 */
	public static String retrieveProperties(Object object) {

		String s = "";
		for (Field field : object.getClass().getDeclaredFields()) {
			field.setAccessible(true); 
			Object value;
			try {
				value = field.get(object);
				s+= field.getName() + "=" + value + "\n";

			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}

		}
		return s;
	}
	
	/**
	 * Checks is there is enough stock available
	 * Uses reflection
	 * Is specifically used when an order is inserted
	 * @param object
	 * @param quantity
	 * @param id_tproduct
	 * @return
	 */
	public static int checkStock(Object object, int quantity, int id_tproduct) {

		int ok = 0;
		for (Field field : object.getClass().getDeclaredFields()) {
			field.setAccessible(true); 
			Object value;
			try {
				value = field.get(object);
				if (field.getName().equals("id_tproduct") && value.equals(id_tproduct)) {
					ok++;
				}
				if (field.getName().equals("stock") && ok==1) {
					if(quantity<=(Integer)value) {
						return 1;
					}else {
						return 2;
					}
				}

			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	/**
	 * Updates the stock after an order was inserted
	 * Uses reflection
	 * Is specifically used when inserting an order
	 * @param object
	 * @param quantity
	 * @param id_tproduct
	 * @return
	 */
	public static int updateStock(Object object, int quantity, int id_tproduct) {

		int ok = 0;
		for (Field field : object.getClass().getDeclaredFields()) {
			field.setAccessible(true); 
			Object value;
			try {
				value = field.get(object);
				if (field.getName().equals("id_tproduct") && value.equals(id_tproduct)) {
					ok++;
				}
				if (field.getName().equals("stock") && ok==1) {
					PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), object.getClass());
					Method getter = propertyDescriptor.getReadMethod();
					if (getter != null) {
						int initValue = (Integer) getter.invoke(object);
						if (initValue - quantity <0)
							return 0;
						else
							return (initValue - quantity);
					}
				}

			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IntrospectionException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}
}



