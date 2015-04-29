package model;

/**
 *  * A company with name, address, tel.
 * Must be linked with the person class.
 * There is no field for person, linking is through a field in the person class
 * The company class is attached to a person. company cannot be attached to an attendance
 * @author Lasse
 *
 */
public class Company {
	/**
	 * Name of company
	 */
	private String name;
	
	/**
	 * Full address of company
	 */
	private String address;
	
	/**
	 * Telephone number of company
	 */
	private int telephone;
	
	
	/**
	 * @param name is the name of the company
	 * @param address is the address of the company
	 * @param telephone is the phone number of the company
	 */
	public Company(String name, String address, int telephone){
		this.name = name;
		this.address = address;
		this.telephone = telephone;		
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
	
	public int getTelephone() {
		return telephone;
	}
	
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	

}
