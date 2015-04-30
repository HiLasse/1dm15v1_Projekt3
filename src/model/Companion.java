package model;
/**
 * A person accompanying a Participant through a Registration
 * @author Lasse
 * 
 */
public class Companion 
{
	/**
	 * Name of Companion
	 */
	private String name;
	
	/**
	 * Constructs a Companion
	 * @param name of Companion
	 */
	public Companion(String name)
	{
		this.name = name;
	}
	
	
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
}
