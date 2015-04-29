package model;
/**
 * A person accompanying a Deltager
 * @author Lasse
 *
 */
public class Ledsager 
{
	/**
	 * Name of Ledsager
	 */
	private String name;
	
	/**
	 * Constructs a Ledsager
	 * @param name
	 */
	public Ledsager(String name)
	{
		this.name = name;
	}
	
	
	/**
	 * 
	 * @return name of Ledsager
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param change name of Ledsager
	 */
	public void setName(String name) {
		this.name = name;
	}	
}
