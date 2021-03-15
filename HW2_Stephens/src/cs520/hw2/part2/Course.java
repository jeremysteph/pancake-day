package cs520.hw2.part2;

public class Course {
	
	private String courseName;
	private int costPerCredit;
	private int numberOfCredits;
	
	public Course(String name, int costPerCredit, int numOfCredits){
		this.courseName = name;
		this.costPerCredit = costPerCredit;
		this.numberOfCredits = numOfCredits;
		
	}

	public void setCourseName(String name){
		this.courseName = name;
	}
	public void setCostPerCredit(int costPerCredit){
		this.costPerCredit = costPerCredit;
	}
	public void setNumberOfCredits(int numOfCredits){
		this.numberOfCredits = numOfCredits;
	}
	
	public String getCourseName(){
		return courseName;
	}
	public int getCostPerCredit(){
		return costPerCredit;
	}
	public int getNumberOfCredits(){
		return numberOfCredits;
	}
	
	public int getTotalTuition(){
		int tuition = costPerCredit * numberOfCredits;
		return tuition;
	}
	
	public String toString(){
		
		return "Course: " +getCourseName()+ " @ $ " + getTotalTuition(); 
	}
}
