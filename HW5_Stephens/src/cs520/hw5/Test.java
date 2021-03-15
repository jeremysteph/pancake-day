package cs520.hw5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


public class Test {
static Queue<Student> studentQueue = new LinkedList<Student>();
static Map<String,Student> studentMap = new HashMap<String,Student>();


public static void main(String args[]){
String inputFile = "data.txt";
String line = null;
Student student = new Student();
try{
		BufferedReader br = new BufferedReader(new FileReader(inputFile));
	

		while((line = br.readLine())!=null){
			student = processInputData(line);
			
			studentQueue.add(student);
			studentMap.put(student.getStudentName(),student);

			System.out.println("Display studentList using iterator");
			Iterator<Student> iter = studentQueue.iterator();
			while (iter.hasNext()) {
			System.out.println(iter.next() +"\n");
			}
			}
		
		System.out.println("Display studentMap using iterator");
		
		Set<String> keySet = studentMap.keySet();
		Iterator<String> iterator = keySet.iterator();
		while (iterator.hasNext()) {
		System.out.println(studentMap.get(iterator.next()));

}}
	 catch(IOException e){
		 
	 }

}

private static Student processInputData(String line){

	StringTokenizer token = new StringTokenizer(line,",");
	String name = token.nextToken();
	Student currentStudent = new Student(name);
	currentStudent.addHomeworkGrade(Integer.parseInt(token.nextToken()));
	currentStudent.addHomeworkGrade(Integer.parseInt(token.nextToken()));
	currentStudent.addHomeworkGrade(Integer.parseInt(token.nextToken()));
	currentStudent.addHomeworkGrade(Integer.parseInt(token.nextToken()));
	currentStudent.addHomeworkGrade(Integer.parseInt(token.nextToken()));
	currentStudent.addHomeworkGrade(Integer.parseInt(token.nextToken()));
	
return currentStudent;
}

}
