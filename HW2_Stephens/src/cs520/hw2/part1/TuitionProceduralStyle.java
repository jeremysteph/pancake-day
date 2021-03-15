package cs520.hw2.part1;

import javax.swing.JOptionPane;

public class TuitionProceduralStyle {
	
	public static void main(String[] args){
	String courseName1 = JOptionPane.showInputDialog( null, "Enter the Course name of the 1st course");
	int numberOfCredits = Integer.parseInt(JOptionPane.showInputDialog( null, "Number of credits for 1st course"));
	int costPerCourse = Integer.parseInt(JOptionPane.showInputDialog( null, "Cost per credit for 1st course"));

	String courseName2 = JOptionPane.showInputDialog( null, "Enter the Course name of the 2nd course");
	int numberOfCredits2 = Integer.parseInt(JOptionPane.showInputDialog( null, "Number of credits for 2nd course"));
	int costPerCourse2 = Integer.parseInt(JOptionPane.showInputDialog( null, "Cost per credit for 2nd course"));

	
	int tuitionCourse1 = numberOfCredits*costPerCourse;
	
	String s= "Course 1 name: "+courseName1 +"\nTuition costs: $" +tuitionCourse1;
	JOptionPane.showMessageDialog(null, s);
	
int tuitionCourse2 = numberOfCredits2*costPerCourse2;
	
	String s2= "Course 1 name: "+courseName2 +"\nTuition costs: $" +tuitionCourse2;
	JOptionPane.showMessageDialog(null, s2);
	
	
	if(tuitionCourse2 >tuitionCourse1){
		
		int difference = tuitionCourse2-tuitionCourse1;
		String ds = "Cost of course: " + courseName2 + " is greater than the cost of " + courseName1 +"\n Difference: $" + difference;
		JOptionPane.showMessageDialog(null, ds);
	}
if(tuitionCourse2 <tuitionCourse1){
		
		int difference = tuitionCourse1-tuitionCourse2;
		String ds = "Cost of course: " + courseName1 + " is greater than the cost of " + courseName2 +"\n Difference: $" + difference;
		JOptionPane.showMessageDialog(null, ds);
	}
	
	else if(tuitionCourse2 == tuitionCourse1){
		JOptionPane.showMessageDialog(null, "They are the same price. \n Difference: $0");
	
	}
	}
	}
