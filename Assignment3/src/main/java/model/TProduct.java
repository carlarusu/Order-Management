package model;
/**
 * Model of the TProduct table
 * Contains necessary getters and setters. Overrides toString()
 */
public class TProduct {

	private int id_tproduct;
	private String product_name;
	private int stock;
	private int price;
	/**
	 * Empty constructor
	 */
	public TProduct() {
	}
	/**
	 * Constructor
	 * @param id_tproduct
	 * @param product_name
	 * @param stock
	 * @param price
	 */
	public TProduct(int id_tproduct, String product_name, int stock, int price) {
		super();
		this.id_tproduct = id_tproduct;
		this.product_name = product_name;
		this.stock = stock;
		this.price = price;
	}
	/**
	 * Constructor
	 * @param product_name
	 * @param stock
	 * @param price
	 */
	public TProduct(String product_name, int stock, int price) {
		super();
		this.product_name = product_name;
		this.stock = stock;
		this.price = price;
	}

	public int getId_tproduct() {
		return id_tproduct;
	}

	public void setId_tproduct(int id_tproduct) {
		this.id_tproduct = id_tproduct;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "TProduct [id_tproduct=" + id_tproduct + ", product_name=" + product_name + ", stock=" + stock
				+ ", price=" + price + "]";
	}

	
}
