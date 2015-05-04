package model;

/**
 * A Participant with name, address, tel and email
 * Must be linked with the company class
 * and can be linked with attendance class
 */
public class Participant {
	//Fields
	/**
	 * First and last name of Participant
	 */
	private String name;

	/**
	 * Full address of Participant
	 */
	private String address;

	/**
	 * Telephone number of Participant
	 */

	private int telephone;

	/**
	 * e-mail address of Participant
	 */
	private String email;

	/**
	 * Company person works for (company class)
	 */
	private Company company;
	
	private boolean lecture;

	//-----------------------------------------------------------------------------------------

	//Constructor
	
	/**
	 * Constructs a Participant
	 * @param name of Participant
	 * @param address of Participant
	 * @param telephone of Participant
	 * @param email of Participant
	 */
	public Participant(String name, String address, int telephone, String email, boolean lecture){
		this.name = name;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		this.lecture = lecture;
	}

	//-----------------------------------------------------------------------------------------

	//name methods
	
	/**
	 * Get the name of Participant
	 * @return the persons name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Change the name of Participant
	 * @param name is set to the String name
	 */
	public void setName(String name) {
		this.name = name;
	}

	//-----------------------------------------------------------------------------------------

	//address methods
	
	/**
	 * Get the address of Participant
	 * @return the address of Participant
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Get the address of Participant
	 * @param address is set to address string
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	//-----------------------------------------------------------------------------------------

	//telephone methods
	
	/**
	 * Get the telephone number of Participant
	 * @return the persons telephone number
	 */
	public int getTelephone() {
		return telephone;
	}

	/**
	 * Change telephone number of Participant
	 * @param telephone sets the telephone number
	 */
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	//-----------------------------------------------------------------------------------------

	//email methods
	
	/**
	 * Gets the email address of Participant
	 * @return the persons email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Change the email address of Participant
	 * @param email the sets email address
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	//-----------------------------------------------------------------------------------------

	//company methods
	
	/**
	 * 
	 * @return company gets the Company Participant works for
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * 
	 * @param company sets the Company Participant works for
	 */
	public void setCompany(Company company) {
		this.company = company;
	}
	//-----------------------------------------------------------------------------------------
	
	public void setLecture(boolean lecture) {
		this.lecture = lecture;
	}
	
}
