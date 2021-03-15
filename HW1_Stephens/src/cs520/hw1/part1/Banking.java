package cs520.hw1.part1;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Banking {

	

	
	public static <E> void main(String[] args) {
		
		//variable declarations 
		String input;
		int hundreds;
		int twenties;
		int tens;	
		int fives;
		int ones;
		int remainingAmount;
		String output = "";
		List<Integer> denCount = new ArrayList<Integer>();
		input = JOptionPane.showInputDialog("Enter the amount you want to withdraw (whole dollars only): ");
		int amount = Integer.parseInt(input);
		remainingAmount =amount;
		
		//Array to hold the name of the dollar denominations 
		String[] denNames={"Hundreds", "Twenties","Tens","Fives","Ones"};
		
		//prints out requested amount
		System.out.println("Requested Amount = " + input);
	
	//sets output variable equal to requested amount	
	output = "Requested Amount (" + input + ")\n";
	
	//block of code for hundreds denomination
	hundreds = amount/100;
	denCount.add(hundreds);
	remainingAmount= amount%100;
	System.out.println("Hundreds = " + hundreds + ", " + "Remaining Amount = " + remainingAmount);
	
	//block of code for twenties denomination
	twenties = remainingAmount/20;
	denCount.add(twenties);
	remainingAmount= remainingAmount%20;
	System.out.println("Twenties = " + twenties + ", " + "Remaining Amount = " + remainingAmount);

	//block of code for tens denomination
	tens=  remainingAmount/10;
	denCount.add(tens);
	remainingAmount= remainingAmount%10;
	System.out.println("Tens = " + tens + ", " + "Remaining Amount = " + remainingAmount);

	//block of code for fives denomination
	fives = remainingAmount/5;
	denCount.add(fives);
	remainingAmount= remainingAmount%5;
	System.out.println("Fives = " + fives + ", " + "Remaining Amount = " + remainingAmount);

	//block of code for ones denomination
	ones = remainingAmount/1;
	denCount.add(ones);
	remainingAmount= remainingAmount%1;
	System.out.println("Ones = " + ones);

	
	//loop to set output string
	for (int i=0; i<5; i++){
		

	output+= denNames[i] + " (" + denCount.get(i) +  ")\n";

	}
	
	//Displays output to pop-up window 
	JOptionPane.showMessageDialog( null, output, "Message",1);
	

}
	


}
