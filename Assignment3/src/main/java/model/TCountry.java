package model;
/**
 * Model of the TCountry table
 * Contains necessary getters and setters. Overrides toString()
 */
public class TCountry {

	private int id_tcountry;
	private String country;
	/**
	 * Empty constructor
	 */
	public TCountry() {
	}
	/**
	 * Constructor
	 * @param id_tcountry
	 * @param country
	 */
	public TCountry(int id_tcountry, String country) {
		super();
		this.id_tcountry = id_tcountry;
		this.country = country;
	}
	/**
	 * Constructor
	 * @param country
	 */
	public TCountry(String country) {
		super();
		this.country = country;
	}

	public int getId_tcountry() {
		return id_tcountry;
	}

	public void setId_tcountry(int id_tcountry) {
		this.id_tcountry = id_tcountry;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "TCountry [id_tcountry=" + id_tcountry + ", country=" + country + "]";
	}
}
