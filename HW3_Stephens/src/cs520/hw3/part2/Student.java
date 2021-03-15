package cs520.hw3.part2;

import java.text.DecimalFormat;

public class Student {
	
	String name;
	int homework1;
	int homework2;
	int homework3;
	int homework4;
	int homework5;
	int homework6;

	public Student(String name){
		this.name = name;
	}

	public void setHomework1(int hw1){
		this.homework1 = hw1;
	}
	
	public void setHomework2(int hw2){
		this.homework2 = hw2;

	}

	public void setHomework3(int hw3){
		this.homework3 = hw3;

}
	public void setHomework4(int hw4){
		this.homework4 = hw4;
}
	public void setHomework5(int hw5){
		this.homework5 = hw5;

}
	public void setHomework6(int hw6){
		this.homework6 = hw6;

}
	public double computeAverage(){
		double average;
		average = (double)(homework1+homework2+homework3+homework4+homework5+homework6)/6;

		return average;
	}
	
	public String toString(){
		DecimalFormat df = new DecimalFormat(".00");
		
		String s = name + "'s average grade is " + df.format(computeAverage());
		

		return s;
	}
}
