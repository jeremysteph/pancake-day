package cs520.hw2.part2;

public class Test {

public static  void main(String[] args){
	Course currentCourse = new Course("CS520", 390,4);

	System.out.println("Taking a regular course...");
	System.out.println("In Course Constructor values set:");
	System.out.println("CourseName = " + currentCourse.getCourseName() +", CostPerCredit = "  +currentCourse.getCostPerCredit() +", NumberOfCredits = " + currentCourse.getNumberOfCredits());
	System.out.println("Printing...");

System.out.println(currentCourse.toString() +"\n\n");

currentCourse = new OnlineCourse("CS520", 760,4, 60);

System.out.println("Taking an online course...");
System.out.println("In Course Constructor values set:");
System.out.println("CourseName = " + currentCourse.getCourseName() +", CostPerCredit = "  +currentCourse.getCostPerCredit() +", NumberOfCredits = " + currentCourse.getNumberOfCredits());
System.out.println("In OnlineCourse Constructor values set:");
System.out.println("CourseName = " + currentCourse.getCourseName() +", CostPerCredit = "  +currentCourse.getCostPerCredit() +", NumberOfCredits = " + currentCourse.getNumberOfCredits() + ", TechnologyFee = " +  ((OnlineCourse) currentCourse).getTechnologyFee());

System.out.println("Printing...");

System.out.println(currentCourse.toString());

}
}
