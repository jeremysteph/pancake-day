	import java.io.*;
	import java.util.*;

	public class Chapter3Project4
	{
		public static void main (String[] arg){
			int MAXIMUM_DIGITS=50;
			int first_size, second_size, sum_size;
			int []first= new int[MAXIMUM_DIGITS+1];
			int []second= new int[MAXIMUM_DIGITS+1];
			int []sum= new int[MAXIMUM_DIGITS+1];
			
	first_size= inputArray(first);
	second_size =inputArray(second);
			
			sum_size = add(first,first_size, second, second_size,sum);
			System.out.print("/n Add above the two integers: ");
			
			output(first, first_size);
			
			System.out.println();
			output(second, second_size);
			System.out.println();
			
			output(sum, sum_size);
			
		}
		
		public static void output(int number[], int number_size)
			
		{
		for (int i = 50; i>=number_size; i--)
			System.out.print(" ");
			
			for (int i = number_size - 1; i >=0; i--)
				
				System.out.print(number[i]);
		}
		
		public static int inputArray(int number[])
			
		{
			
			
			Scanner input = new Scanner(System.in);
			System.out.println("Enter large digit number: ");
			
			int j= 0;
			
			for(int i = 0; i<50; i++)
			{
				number[j] = input.nextInt();
				j++;
			
		}
			return j-1;
		}
		public static int add(int first[], int first_size, int second[],
							  int second_size, int sum[])
		{
			int carry = 0;
			int sum_size;
			int larger_size;
			
			if(first_size>second_size)
			{
				for (int i = second_size; i<first_size; i++)
					second[i] = 0;
				larger_size = first_size;
			}
			else
			{
				for (int i = first_size; i <second_size; i++)
				first[i]=0;
				larger_size = second_size;
			}
			for (int i = 0; i <larger_size; i++)
			{	
			sum[i] = first[i] +second[i]+carry;
					if(sum[i]>9){
			
						carry = 1;
						sum[i] = sum[i] - 10;
					}
					else
						carry=0;
				}
				if(1==carry)
					{
						if (larger_size==20)
						
						{
							System.out.println("Overflow!");
							System.out.println("Result set to 0");
							sum_size =1;
							sum[0] = 0;
						}
					
					else 
						{
							sum[larger_size] = carry;
							sum_size = larger_size +1;
						}
					}
					
					else
						sum_size = larger_size;
					return sum_size;
				}
			
			
		}