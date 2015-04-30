package model;

/**
 *  * A Company with name, address, tel.
 * Must be linked with the Participant class.
 * There is no field for Participant, linking is through a field in the Participant class
 * The Company class is attached to a person. Company cannot be attached to a Registration
 * @author Lasse
 *
 */
public class Company {

	//Fields
	
	/**
	 * Name of Company
	 */
	private String name;
	
	/**
	 * Full address of Company
	 */
	private String address;
	
	/**
	 * Telephone number of Company
	 */
	private int telephone;

	//-----------------------------------------------------------------------------------------

	//constructor
	
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
	
	//-----------------------------------------------------------------------------------------

	//name methods
	
	/**
	 * 
	 * @return name of Company
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @param name sets the name of Company
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	//-----------------------------------------------------------------------------------------

	//address methods
	
	/**
	 * 
	 * @return address of Company
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 
	 * @param address sets address of Company
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	//-----------------------------------------------------------------------------------------

	//telephone methods
	
	/**
	 * 
	 * @return telephone number of Company
	 */
	public int getTelephone() {
		return telephone;
	}
	
	/**
	 * 
	 * @param telephone set telephone number of Company
	 */
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	//-----------------------------------------------------------------------------------------

}
