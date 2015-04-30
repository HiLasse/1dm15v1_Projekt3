package model;
/**
 * A person accompanying a Participant through a Registration
 * @author Lasse
 * 
 */
public class Companion 
{
	//Fields
	
	/**
	 * Name of Companion
	 */
	private String name;

	//-----------------------------------------------------------------------------------------

	//Constructor
	
	/**
	 * Constructs a Companion
	 * @param name of Companion
	 */
	public Companion(String name)
	{
		this.name = name;
	}
	
	//-----------------------------------------------------------------------------------------

	//name methods
	
	/**
	 * 
	 * @return name of Companion
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param change name of Companion
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	//-----------------------------------------------------------------------------------------
}
