package cs520.hw5;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Student {
String name;
ArrayList<Integer> homeworks;
	

Student(String name){
this.name = name;
homeworks = new ArrayList<Integer>();

}

public Student() {
	// TODO Auto-generated constructor stub
}

public String getStudentName(){
	
	return name;
}

public void setStudentName(String name){
	this.name = name;
	
}
void addHomeworkGrade(int grade){
	homeworks.add(grade);
	

}

public double getHomeworkGrade(int index) throws IndexOutOfBoundsException{
	index =0;
	return homeworks.get(index);
	
}
public Double computeWeightedAverage(){
	double weightedAverage = 0;
	
	for(Integer grade:this.homeworks){
		weightedAverage +=grade;
	}
	return weightedAverage;
	
}
public String toString(){
	DecimalFormat df = new DecimalFormat("0.00");
	
	String s = name + "'s average grade is " + df.format(computeWeightedAverage());
	

	return s;
}
}
