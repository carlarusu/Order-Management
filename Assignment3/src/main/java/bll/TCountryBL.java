package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import bll.validators.Validator;
import dao.TClientDAO;
import dao.TCountryDAO;
import model.TClient;
import model.TCountry;

/**
 * Business Layer for model class TCountry
 * Validates input data, facilitates communication between Presentation Layer and Data Access Layer
 * Directly links the model to the data access by calling the specific CRUD methods
 */

public class TCountryBL {

	private List<Validator<TCountry>> validators;
	private TCountryDAO tCountryDAO;
	
	/**
	 * Constructor
	 */
	public TCountryBL() {
		validators = new ArrayList<Validator<TCountry>>();
		tCountryDAO = new TCountryDAO();
	}
	
	/**
	 * Read entry by id (CRUD)
	 * @param id
	 * @return TCountry
	 */
	public TCountry findCountryById(int id) {
		TCountry st = tCountryDAO.findById(id);
		if (st == null) {
			throw new NoSuchElementException("The country with id =" + id + " was not found!");
		}
		return st;
	}
	
	/**
	 * Insert entry (CRUD)
	 * @param c
	 * @return
	 */
	public int insertCountry(TCountry c) {
		for (Validator<TCountry> v : validators) {
			v.validate(c);
		}
		return tCountryDAO.insert(c);
	}
	
	/**
	 * Update entry (CRUD)
	 * @param c
	 * @return
	 */
	public int updateCountry(TCountry c) {
		for (Validator<TCountry> v : validators) {
			v.validate(c);
		}
		return tCountryDAO.update(c);
	}
	
	/**
	 * Read all entries (CRUD)
	 * @return List of entries
	 */
	public List<TCountry> findAllCountries() {
		List<TCountry> clients = tCountryDAO.findAll();
		if (clients == null) {
			throw new NoSuchElementException("No countries were found!");
		}
		return clients;
	}
	
	/**
	 * Delete entry by id (CRUD)
	 * @param id
	 * @return
	 */
	public int deleteCountryById(int id) {
		int st = tCountryDAO.deleteById(id);
		if (st == -1) {
			throw new NoSuchElementException("The country with id =" + id + " was not found!");
		}
		return st;
	}
}
