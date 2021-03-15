package cs520.hw3.part1;

import javax.swing.JOptionPane;

public class StringTest {
	
	public static void main(String[] args){
		int commaIndex;
		int commaIndexNext = 0;
			
		String courseID;
		String courseName;
		String tuition = null;
		int regularTuition = 0;
		int discountTuition = 0;
		int option;
	
	String input = JOptionPane.showInputDialog("Please enter data using the format CourseId,CourseName,Tuition");
	
	if(input == null){
		
		System.exit(0);
	}
	
	input = input.trim();
	System.out.println(input);
	


	commaIndex = input.indexOf(",");
	try{	courseID = input.substring(0,commaIndex);
	commaIndexNext = input.indexOf(",", commaIndex+1);
	System.out.println("First Comma Position:" + commaIndex + ", Course Id:" + courseID + ", Length:" +courseID.length());
	}catch(StringIndexOutOfBoundsException e){
		JOptionPane.showMessageDialog(null, "Nothing entered, program will terminate.");
		System.exit(0);
	}
	try{
	courseName = input.substring(commaIndex+1,commaIndexNext);
	commaIndex = commaIndexNext;
	System.out.println("Second Comma Position:" + commaIndex + ", Course Name:" + courseName + ", Length:" +courseName.length());

	tuition = input.substring(commaIndexNext+1, input.length());
	}catch(StringIndexOutOfBoundsException e){
		input = JOptionPane.showInputDialog("Missing course name and tuition. Program will terminate");
		System.exit(0);

		
	}
	try{
	regularTuition = Integer.parseInt(tuition);
	discountTuition =  (int) (regularTuition - (regularTuition*0.25));
	System.out.println("Regular Tuition: $" + regularTuition +", Discount Tuition $" + discountTuition );

	}catch(Exception e){
		JOptionPane.showMessageDialog(null, "Tuition not entered as a number. Program will terminate.");
	}

	
	}
	
	}
