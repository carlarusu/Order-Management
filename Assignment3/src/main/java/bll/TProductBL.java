package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import bll.validators.Validator;
import dao.TProductDAO;
import model.TClient;
import model.TProduct;

/**
 * Business Layer for model class TProduct
 * Validates input data, facilitates communication between Presentation Layer and Data Access Layer
 * Directly links the model to the data access by calling the specific CRUD methods
 */

public class TProductBL {
	private List<Validator<TProduct>> validators;
	private TProductDAO tProductDAO;
	
	/**
	 * Constructor
	 */
	public TProductBL() {
		validators = new ArrayList<Validator<TProduct>>();
		tProductDAO = new TProductDAO();
	}
	
	/**
	 * Read entry by id (CRUD)
	 * @param id
	 * @return TProduct
	 */
	public TProduct findProductById(int id) {
		TProduct st = tProductDAO.findById(id);
		if (st == null) {
			throw new NoSuchElementException("The product with id =" + id + " was not found!");
		}
		return st;
	}
	
	/**
	 * Insert entry (CRUD)
	 * @param c
	 * @return
	 */
	public int insertProduct(TProduct p) {
		for (Validator<TProduct> v : validators) {
			v.validate(p);
		}
		return tProductDAO.insert(p);
	}
	
	/**
	 * Update entry (CRUD)
	 * @param c
	 * @return
	 */
	public int updateProduct(TProduct c) {
		for (Validator<TProduct> v : validators) {
			v.validate(c);
		}
		return tProductDAO.update(c);
	}
	
	/**
	 * Read all entries (CRUD)
	 * @return List of entries
	 */
	public List<TProduct> findAllProducts() {
		List<TProduct> clients = tProductDAO.findAll();
		if (clients == null) {
			throw new NoSuchElementException("No products were found!");
		}
		return clients;
	}
	
	/**
	 * Delete entry by id (CRUD)
	 * @param id
	 * @return
	 */
	public int deleteProductById(int id) {
		int st = tProductDAO.deleteById(id);
		if (st == -1) {
			throw new NoSuchElementException("The product with id =" + id + " was not found!");
		}
		return st;
	}
}
