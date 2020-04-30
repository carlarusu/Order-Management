package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import bll.validators.Validator;
import dao.TOrderDAO;
import model.TClient;
import model.TOrder;

/**
 * Business Layer for model class TOrder
 * Validates input data, facilitates communication between Presentation Layer and Data Access Layer
 * Directly links the model to the data access by calling the specific CRUD methods
 */

public class TOrderBL {
	private List<Validator<TOrder>> validators;
	private TOrderDAO tOrderDAO;
	
	/**
	 * Constructor
	 */
	public TOrderBL() {
		validators = new ArrayList<Validator<TOrder>>();
		tOrderDAO = new TOrderDAO();
	}
	
	/**
	 * Read entry by id (CRUD)
	 * @param id
	 * @return TOrder
	 */
	public TOrder findOrderById(int id) {
		TOrder st = tOrderDAO.findById(id);
		if (st == null) {
			throw new NoSuchElementException("The order with id =" + id + " was not found!");
		}
		return st;
	}
	
	/**
	 * Insert entry (CRUD)
	 * @param c
	 * @return
	 */
	public int insertOrder(TOrder o) {
		for (Validator<TOrder> v : validators) {
			v.validate(o);
		}
		return tOrderDAO.insert(o);
	}
	
	
	/**
	 * Update entry (CRUD)
	 * @param c
	 * @return
	 */
	public int updateOrder(TOrder o) {
		for (Validator<TOrder> v : validators) {
			v.validate(o);
		}
		return tOrderDAO.update(o);
	}
	
	/**
	 * Read all entries (CRUD)
	 * @return List of entries
	 */
	public List<TOrder> findAllOrders() {
		List<TOrder> clients = tOrderDAO.findAll();
		if (clients == null) {
			throw new NoSuchElementException("No orders were found!");
		}
		return clients;
	}
	
	/**
	 * Delete entry by id (CRUD)
	 * @param id
	 * @return
	 */
	public int deleteOrderById(int id) {
		int st = tOrderDAO.deleteById(id);
		if (st == -1) {
			throw new NoSuchElementException("The order with id =" + id + " was not found!");
		}
		return st;
	}
}
