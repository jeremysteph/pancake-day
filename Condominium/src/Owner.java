
public class Owner {
	private String name;
	private boolean female;
	public Owner(String n, boolean fem) { name = n; female = fem;}
	public String getName() { return name; }
	public String toString() { 
		return (female?"Ms. ":"Mr. ") + name;
	}
}
