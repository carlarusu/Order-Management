package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import bll.validators.EmailValidator;
import bll.validators.ClientAgeValidator;
import bll.validators.Validator;
import dao.TClientDAO;
import model.TClient;

/**
 * Business Layer for model class TClient
 * Validates input data, facilitates communication between Presentation Layer and Data Access Layer
 * Directly links the model to the data access by calling the specific CRUD methods
 */

public class TClientBL {

	private List<Validator<TClient>> validators;
	private TClientDAO tClientDAO;

	/**
	 * Constructor
	 */
	public TClientBL() {
		validators = new ArrayList<Validator<TClient>>();
		validators.add(new EmailValidator());
		validators.add(new ClientAgeValidator());

		tClientDAO = new TClientDAO();
	}

	/**
	 * Read entry by id (CRUD)
	 * @param id
	 * @return TClient
	 */
	public TClient findClientById(int id) {
		TClient st = tClientDAO.findById(id);
		if (st == null) {
			throw new NoSuchElementException("The client with id =" + id + " was not found!");
		}
		return st;
	}
	
	/**
	 * Insert entry (CRUD)
	 * @param c
	 * @return
	 */
	public int insertClient(TClient c) {
		for (Validator<TClient> v : validators) {
			v.validate(c);
		}
		return tClientDAO.insert(c);
	}
	
	/**
	 * Update entry (CRUD)
	 * @param c
	 * @return
	 */
	public int updateClient(TClient c) {
		for (Validator<TClient> v : validators) {
			v.validate(c);
		}
		return tClientDAO.update(c);
	}
	
	/**
	 * Read all entries (CRUD)
	 * @return List of entries
	 */
	public List<TClient> findAllClients() {
		List<TClient> clients = tClientDAO.findAll();
		if (clients == null) {
			throw new NoSuchElementException("No clients were found!");
		}
		return clients;
	}
	
	/**
	 * Delete entry by id (CRUD)
	 * @param id
	 * @return
	 */
	public int deleteClientById(int id) {
		int st = tClientDAO.deleteById(id);
		if (st == -1) {
			throw new NoSuchElementException("The client with id =" + id + " was not found!");
		}
		return st;
	}

}
