package edu.umb.cs680.hw02;
public class Calculator {

	public float multiply(float a, float b){
		return a*b;
	}

	public float divide (float a, float b) {
		if(b==0){
			throw new IllegalArgumentException("division by zero");
		}
		return a/b;
	}
	
	public static void main(String[] args){
		Calculator	calc = new Calculator();
		System.out.println( calc.multiply(6, 9) );
		System.out.println( calc.divide(125, 5) );
	}	
}