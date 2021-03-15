package cs520.hw2.part2;

public class OnlineCourse extends Course{
private int technologyFee;

	public OnlineCourse(String name, int costPerCredit, int numOfCredits, int technologyFee) {
		super(name, costPerCredit, numOfCredits);
this.technologyFee = 	technologyFee;
}

	public void setTechnologyFee(int technologyFee){
		
		this.technologyFee = technologyFee;
	}
	
public int getTechnologyFee(){
		
		return technologyFee;
	}

public int getTotalTuition(){
	
	return (getCostPerCredit()*getNumberOfCredits()) +(getNumberOfCredits()*technologyFee);
}

public String toString(){
	
	return "OnlineCourse: " +getCourseName() + " @ $" + getTotalTuition(); 
}
}
