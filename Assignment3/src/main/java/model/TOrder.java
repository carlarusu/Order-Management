package model;
/**
 * Model of the TOrder table
 * Contains necessary getters and setters. Overrides toString()
 */
public class TOrder {

	private int id_torder;
	private int id_tclient;
	private int id_tproduct;
	private int quantity;
	/**
	 * Empty constructor
	 */
	public TOrder() {
	}
	/**
	 * Constructor
	 * @param id_torder
	 * @param id_tclient
	 * @param id_tproduct
	 * @param quantity
	 */
	public TOrder(int id_torder, int id_tclient, int id_tproduct, int quantity) {
		super();
		this.id_torder = id_torder;
		this.id_tclient = id_tclient;
		this.id_tproduct = id_tproduct;
		this.quantity = quantity;
	}
	/**
	 * Constructor
	 * @param id_tclient
	 * @param id_tproduct
	 * @param quantity
	 */
	public TOrder(int id_tclient, int id_tproduct, int quantity) {
		super();
		this.id_tclient = id_tclient;
		this.id_tproduct = id_tproduct;
		this.quantity = quantity;
	}

	public int getId_torder() {
		return id_torder;
	}

	public void setId_torder(int id_torder) {
		this.id_torder = id_torder;
	}

	public int getId_tclient() {
		return id_tclient;
	}

	public void setId_tclient(int id_tclient) {
		this.id_tclient = id_tclient;
	}

	public int getId_tproduct() {
		return id_tproduct;
	}

	public void setId_tproduct(int id_tproduct) {
		this.id_tproduct = id_tproduct;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "TOrder [id_torder=" + id_torder + ", id_tclient=" + id_tclient + ", id_tproduct=" + id_tproduct
				+ ", quantity=" + quantity + "]";
	}
}
