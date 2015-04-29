package model;

/**
 * A person with name, address, tel and email
 * Must be linked with the company class
 * and can be linked with attendance class
 */
public class Participant {
	/**
	 * First and last name of person
	 */
	private String name;
	
	/**
	 * Full address of person
	 */
	private String address;
	
	/**
	 * Telephone number of person
	 */
	
	private int telephone;
	
	/**
	 * e-mail address of person
	 */
	private String email;
	
	/**
	 * Company person works for (company class)
	 */
	// Implement
	
	/**
	 * One or more attendances of person implemented as a class (attendance) 
	 */
	// Implement
	
	public Participant(String name, String address, int telephone, String email){
		this.name = name;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		//Todo implement company class and attendance class
	}

	/**
	 * Get the name of person
	 * @return the persons name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Change the name of person
	 * @param name is set to the String name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the address of person
	 * @return the address of person
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Get the address of person
	 * @param address is set to address string
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Get the telephone number of person
	 * @return the persons telephone number
	 */
	public int getTelephone() {
		return telephone;
	}

	/**
	 * Change telephone number of person
	 * @param telephone sets the telephone number
	 */
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	/**
	 * Gets the email addres of person
	 * @return the persons email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Change the email address of person
	 * @param email the sets email address
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	//TODO; implement getters and setters for company and attendance classes

}
