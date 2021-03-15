package cs520.hw1.part2;

import javax.swing.JOptionPane;

public class oddNumbers {

	//main method
	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("Enter an integer(>=0): ");
		int inputNumber = Integer.parseInt(input);
		int result1 = sumWithLoop(inputNumber);
		int result2 = sumWithoutLoop(inputNumber);
		String output ="Requested number ("+inputNumber+")\n";
	
	//prints sum of variable result1 to the console
	System.out.println("Sum with loop: " + result1);

	//prints the sum of result2 to the console
	System.out.println("Sum without loop: " + result2);
	
	//if result1 = result2 
	if(result1==result2){
		
		//print the results are the same
		System.out.println("Results are same, my code is correct!");
	}
	else{
		
		//the results aren't the same
		System.out.println("Results are NOT the same, my code is NOT correct!");

	} 
	output+= "Sum with loop (" + result1 +")\n Sum without loop ("+result2+")";
	

	//Creates a pop-up window containing a message with the output variables
	JOptionPane.showMessageDialog( null, output, "Message",1);
	}
	
//method that caculates the sum of squares using a do while loop	
static int sumWithLoop(int n){
	int sum=0;
	do{
		
		sum += (int) (Math.pow((2*n-1),2));
		n--;
		
	}while(n>0);
			
			
		
	
	return sum;
	
	
}
// calculates the sunm of squares using a formula 
static int sumWithoutLoop(int n){
	int sum = (n*(2*n-1)*(2*n+1)/3);
	
	return sum;
	
}
}
