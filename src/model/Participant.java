package model;

/**
 * A Participant with name, address, tel and countryOrCity
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
	private String countryOrCity;

	/**
	 * Company person works for (company class)
	 */
	private Company company;
	
	private String CountryOrCity;
	
	private boolean lecture;
	
	private Companion companion;

	//-----------------------------------------------------------------------------------------

	//Constructor
	
	/**
	 * Constructs a Participant
	 * @param name of Participant
	 * @param address of Participant
	 * @param telephone of Participant
	 * @param countryOrCity of Participant
	 */
	public Participant(String name, String address, int telephone, String countryOrCity, boolean lecture){
		this.name = name;
		this.address = address;
		this.telephone = telephone;
		this.countryOrCity = countryOrCity;
		this.lecture = lecture;
	}

	//-----------------------------------------------------------------------------------------


	@Override
	public String toString() {
		return name;
	}
	
	
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

	//countryOrCity methods
	
	/**
	 * Gets the countryOrCity address of Participant
	 * @return the persons countryOrCity
	 */
	public String getCountryOrCity() {
		return countryOrCity;
	}

	/**
	 * Change the countryOrCity address of Participant
	 * @param countryOrCity the sets countryOrCity address
	 */
	public void setCountryOrCity(String countryOrCity) {
		this.countryOrCity = countryOrCity;
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
	
	public boolean isLecture() {
		return lecture;
	}
	
	public void setCompanion(Companion companion)
	{
		this.companion = companion;
	}
	
	public Companion getCompanion()
	{
		return companion;
	}

	
	
	
}
