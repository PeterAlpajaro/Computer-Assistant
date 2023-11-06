	/*

	 * Project: Summative Assignment / Final Project
	
	 * Package: computer_assistant_code
	
	 * Class: MathMethods
	
	 * Programmer: Peter Alpajaro
	
	 * Date Created: 11 09 2020
	 
	 * Description: This is all the math-based logic in the program. It collects inputs and then
	 * executes a certain program with those values. It contains addition, subtraction, multiplication,
	 * division, random numbers and powers.
 
	 */

package computer_assistant_code;

public class MathMethods {
	
	
	
	public static String addition(double[] numberArray) { // Adds all numbers
		
		double sum = numberArray[0];

		for (int i = 1; i < numberArray.length; i++) {
			
			sum = sum + numberArray[i];
			
		}
		
		String output = "The sum is: " + sum + ".";
		
		return output;
		
	}
	
	public static String subtraction(double[] numberArray) { // Subtracts all numbers from the first
		
		double difference = numberArray[0];
		
		for (int i = 1; i < numberArray.length; i++) {
			
			difference -= numberArray[i];
			
		}
		
		String output = "The difference is: " + difference + ".";
		
		return output;
		
	}
	
	public static String subtractionReversal(double[] numberArray) { // Reverses subtraction order
		
		double difference = numberArray[numberArray.length - 1];
		
		for (int i = numberArray.length - 2; i >= 0; i--) {
			
			difference = difference - numberArray[i];
			
		}
		
		String output = "The difference is: " + difference + ".";
		
		return output;
		
	}
	
	public static String multiplication(double[] numberArray) { // Multiplies all numbers
		
		double product = numberArray[0];
		
		for (int i = 1; i < numberArray.length; i++) {
			
			product = product * numberArray[i];
			
		}
		
		String output = "The product is: " + product + ".";
		
		return output;
		
		
	}
	
	public static String division(double[] numberArray) { // Divides all numbers
		
		double quotient = numberArray[0];
		
		for (int i = 1; i < numberArray.length; i++) {
			
			quotient = quotient / numberArray[i];
			
		}
		
		String output = "The quotient is: " + quotient + ".";
		
		return output;
		
	}
	
	public static String randomNumber (double[] numberArray) { // Gets a random number between two values.
		
		double lowestNumber = numberArray[0];
		
		double highestNumber = numberArray[1];
		
		double result = (int) (Math.random() * (highestNumber - lowestNumber) + lowestNumber);
		
		String output = "Your random number is: " + result + ".";
		
		return output;
		
	}
	
	public static String power(double[] numberArray) { // Multiplies a value by itself a certain amount of times.
		
		double result = numberArray[0];
		
		for (int i = 1; i < (int) numberArray[1]; i++) {
			
			result = result * numberArray[0];
			
		}
		
		String output = numberArray[0] + " multiplied by itself " + numberArray[1] + " times is equal to " + result;
		
		return output;
		
	}
	

}
