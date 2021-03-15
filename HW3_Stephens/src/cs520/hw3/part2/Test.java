package cs520.hw3.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

public class Test {

	public static void main(String args[]){
		String inputFile = "data.txt";
		String line;
		
		
		try(
				BufferedReader input = Files.newBufferedReader(Paths.get(inputFile))){
			
			while((line = input.readLine()) !=null){
					processInputData(line);

			}
				
		
				
				
				}catch(IOException e)
		{
					e.printStackTrace();
		}

	}
	
	private static void processInputData(String line){
		StringTokenizer token = new StringTokenizer(line,",");
		String name = token.nextToken();
		Student currentStudent = new Student(name);
		currentStudent.setHomework1(Integer.parseInt(token.nextToken()));
		currentStudent.setHomework2(Integer.parseInt(token.nextToken()));
		currentStudent.setHomework3(Integer.parseInt(token.nextToken()));
		currentStudent.setHomework4(Integer.parseInt(token.nextToken()));
		currentStudent.setHomework5(Integer.parseInt(token.nextToken()));
		currentStudent.setHomework6(Integer.parseInt(token.nextToken()));
		
		System.out.println(currentStudent.toString());
	}
	
}