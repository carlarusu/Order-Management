package model;

/**
 * Model of the TClient table
 * Contains necessary getters and setters. Overrides toString()
 */
public class TClient {
	private int id_tclient;
	private String name;
	private String address;
	private String email;
	private int age;
	private int id_tcountry;

	/**
	 * Empty constructor
	 */
	public TClient() {
	}
	/**
	 * Constructor
	 * @param id_tclient
	 * @param name
	 * @param address
	 * @param email
	 * @param age
	 * @param id_tcountry
	 */
	public TClient(int id_tclient, String name, String address, String email, int age, int id_tcountry) {
		super();
		this.id_tclient = id_tclient;
		this.name = name;
		this.address = address;
		this.email = email;
		this.age = age;
		this.id_tcountry = id_tcountry;
	}
	/**
	 * Constructor
	 * @param name
	 * @param address
	 * @param email
	 * @param age
	 * @param id_tcountry
	 */
	public TClient(String name, String address, String email, int age, int id_tcountry) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.age = age;
		this.id_tcountry = id_tcountry;
	}

	public int getId_tclient() {
		return id_tclient;
	}

	public void setId_tclient(int id_tclient) {
		this.id_tclient = id_tclient;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId_tcountry() {
		return id_tcountry;
	}

	public void setId_tcountry(int id_tcountry) {
		this.id_tcountry = id_tcountry;
	}

	@Override
	public String toString() {
		return "TClient [id_tclient=" + id_tclient + ", name=" + name + ", address=" + address + ", email=" + email
				+ ", age=" + age + ", id_tcountry=" + id_tcountry + "]";
	}

	
}
