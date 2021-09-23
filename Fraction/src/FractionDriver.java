import java.util.Scanner;
public class FractionDriver {
public static void main(String[] args) {
Scanner stdin = new Scanner(System.in);
Fraction f1, f2;
f1 = promptAndReadFraction(stdin, 1);
System.out.println("Should Fraction 2 to refer to " +
"the same object? (yes/no):");
String response = stdin.nextLine();
if (response.equals("yes"))
f2 = f1;
else
f2 = promptAndReadFraction(stdin, 2);
// Add code here to compare the two Fractions using == , 
// .equals, and real values.
// For each case, print appropriate messages saying whether
// the two Fractions match for that comparison 
System.out.println();
System.out.println("Fraction 1: " +f1.toString(f1));
System.out.printf("Fraction 1 real value: "+"%.0f\n",f1.realValue());
System.out.println("Fraction 2: " + f2.toString(f2));
System.out.printf("Fraction 2 real value: "+"%.0f\n",f2.realValue());
System.out.println();
if(f1==f2){
	System.out.println("Fractions are the same object");
}
else{
	System.out.println("Fractions are not the same object");
}
if(f1.equals(f2)){
	System.out.println("Fractions are .equals()");
	
}
else{
	System.out.println("Fractions are not .equals()");
}
if(f1.realValue() == f2.realValue()){
	
	System.out.println("Fraction real values are equal");
}
else{
	System.out.println("Fraction real values are not equal");
}
System.out.println("Goodbye!");

}
public static Fraction promptAndReadFraction(
Scanner sc, int fractionNum) {
String prompt = "Enter Fraction " + fractionNum +
" data (two integers separated by a space): ";
System.out.println(prompt);
// Use the Scanner parameter to read in two integers, using
// the nextInt() method
int num= sc.nextInt();
int denom= sc.nextInt();
// We call "nextLine()" in order to eat the newline character
// after the second number
sc.nextLine();
// Then instantiate a new Fraction object and return it
Fraction f = new Fraction(num,denom);

return f;
}

}