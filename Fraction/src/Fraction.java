
public class Fraction {

private int denominator;
private int numerator;

public Fraction(int num, int denom){
	
	this.numerator = num;
	this.denominator = denom;
}

public Fraction(){
this.numerator = 0;
this.denominator =1;

}

public boolean equals(Fraction f2){
	if(this == f2){
		return false;
	}
	return true;
}
public void setValue(int num, int denom){
	this.numerator = num;
this.denominator = denom;
}

public int getNum(){
	return this.numerator;
}

public int getDenom(){
	return this.denominator;
}

public double realValue(){

	int realValue = this.numerator/this.denominator;

return realValue;
}
public String toString(Fraction f){
	String s = "(" + f.numerator +"," +f.denominator+")";
	return s;
}
}