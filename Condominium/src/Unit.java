
public class Unit {

	
	private int number;
	private Owner owner;
	
	public Unit(int number, Owner owner)
	{
	this.number = number;
	this.owner = owner;

	}
	
	public int getNumber()
	{
		return number;
	}
	
	public Owner getOwner()
	{
		return owner;
	}

	public String toString()
	{
	String unitInfo;
	
	unitInfo = ""+number+": " +owner;
	
	return unitInfo;
	}
}