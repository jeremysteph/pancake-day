package cs520.hw2.part1;

import javax.swing.JOptionPane;

public class TuitionObjectStyle {
	
public static void main(String[] args){
	Course course1; 
	Course course2;
	
	String courseName1 = JOptionPane.showInputDialog( null, "Enter the Course name of the 1st course");
	int numberOfCredits = Integer.parseInt(JOptionPane.showInputDialog( null, "Number of credits for 1st course"));
	int costPerCourse = Integer.parseInt(JOptionPane.showInputDialog( null, "Cost per credit for 1st course"));

	course1 = new Course(courseName1,numberOfCredits, costPerCourse);
	String courseName2 = JOptionPane.showInputDialog( null, "Enter the Course name of the 2nd course");
	int numberOfCredits2 = Integer.parseInt(JOptionPane.showInputDialog( null, "Number of credits for 2nd course"));
	int costPerCourse2 = Integer.parseInt(JOptionPane.showInputDialog( null, "Cost per credit for 2nd course"));
	course2 = new Course(courseName2,numberOfCredits2, costPerCourse2);
course1.printTuitionDetails();
course2.printTuitionDetails();

if(course2.getTotalTuition() >course1.getTotalTuition()){
	
	int difference = course2.getTotalTuition() - course1.getTotalTuition();

	String ds = "Cost of course: " + courseName2 + " is greater than the cost of " + courseName1 +"\n Difference: $" + difference;
	JOptionPane.showMessageDialog(null, ds);
}
if(course2.getTotalTuition() <course1.getTotalTuition()){

	int difference = course1.getTotalTuition() - course2.getTotalTuition();

	String ds = "Cost of course: " + courseName1 + " is greater than the cost of " + courseName2 +"\n Difference: $" + difference;
	JOptionPane.showMessageDialog(null, ds);
}

else if(course2.getTotalTuition() == course1.getTotalTuition()){
	JOptionPane.showMessageDialog(null, "They are the same price. \n Difference: $0");

}
}
	
}

