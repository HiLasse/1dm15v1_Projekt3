package test;

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
	
	public Company(){
		
	}

}
