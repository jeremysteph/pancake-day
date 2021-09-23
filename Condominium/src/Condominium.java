import java.util.ArrayList;


public class Condominium {
ArrayList<Unit> units = new ArrayList<Unit>();


public void addUnit(Unit unit)
{
	
units.add(unit);
}

public int numUnits()
{
	return units.size();	
}

public int numOwners()
{
	int numOwners=0;
	for(int i=0;i<units.size();i++)
	{
	for(int j=0; j<i;j++)
	{
		
	if(!units.get(i).equals(units.get(j+1)))
	{
		numOwners++;
	}
}
	
}
	return numOwners;

}

public String toString()
{
	String s = "";
	for(int i=0; i<units.size();i++)
	{
		
	s +=""+units.get(i)+'\n';
	
}
	return s;
}
}