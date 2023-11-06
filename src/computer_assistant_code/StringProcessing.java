	/*

	 * Project: Summative Assignment / Final Project
	
	 * Package: computer_assistant_code
	
	 * Class: StringProcessing
	
	 * Programmer: Peter Alpajaro
	
	 * Date Created: 11 09 2020
	 
	 * Description: This class handles all of the data logic that is required, such as checking
	 * Strings for certain words or numbers and then running a program based on the words found.
	 * 
	 * It is the surface level of logic for this program, and is the translator from Graphics 
	 * to function.
 
	 */

package computer_assistant_code;

import java.util.Date;

public class StringProcessing {
	
	public static String[] wordProcessing(String inputString) { // Simple method that converts the string into an array.
		
		inputString = inputString.toLowerCase(); // Sets all to lower case.
		
		String[] inputWords = inputString.split(" "); // Splits through spaces.
		
		return inputWords; // Returns that array.
		
	} // Method
	
	public static double[] numberProcessing(String[] inputWords) {
		
		char[] charactersToRemove = {'%', '?', '!', '='}; // Character to remove.
		
		int numberCount = 0;
			
			for (int i = 0; i < inputWords.length; i++) { // Loops through the array and counts the amount of numbers.
				
				if (numberCheck(inputWords[i])) {
					
					numberCount++;
					
				}
				
			}
			
			double[] numberArray = new double[numberCount];
			
			int numberArrayIndex = 0;
			
			for (int i = 0; i < inputWords.length; i++) { // Loops through the words
				
				if (numberCheck(inputWords[i])) { // If the element is a number
					
					for (int j = 0; j < charactersToRemove.length; j++) { // Loops through the characters to remove.
						
						for (int t = 0; t < inputWords[i].length(); t++) { // Loops through the characters of the element.
							
							if (inputWords[i].charAt(t) == charactersToRemove[j]) { // If the character of the element is one of the characters to remove.
								
								inputWords[i] = inputWords[i].substring(0, t) + inputWords[i].substring(t + 1); // Removes that character.
								
							}
							
						} // t For Loop
						
					} // j For Loop
					
					numberArray[numberArrayIndex] = Double.parseDouble(inputWords[i]); // Converts typed numbers to double values and adds it to the array at the position of the number index.
					
					numberArrayIndex++; // Adds 1 to the number index so that it doesn't set an index to the same value.
					
				} // If
				
			} // i For Loop
		
		return numberArray; // Returns the number array.
		
	}
	
	public static String[] numberProcessingString(String[] inputWords) { // Extracts numbers from an array of strings and puts it into another array of strings.
		
		char[] charactersToRemove = {'%', '?', '!', '='}; // Characters to remove.
		
		int numberCount = 0;
		
			for (int i = 0; i < inputWords.length; i++) { // Loops through and counts the number of numbers in the array.
				
				if (numberCheck(inputWords[i])) {
					
					numberCount++;
					
				}
				
			}
			
			String[] numberArray = new String[numberCount]; // Creates a new array with the length of number count.
			
			int numberArrayIndex = 0;
			
			for (int i = 0; i < inputWords.length; i++) { // Loops through the words
				
				if (numberCheck(inputWords[i])) { // If the current element is a number
					
					for (int j = 0; j < charactersToRemove.length; j++) { // Loops through the characters to remove
						
						for (int t = 0; t < inputWords[i].length(); t++) { // Loops through the element's characters
							
							if (inputWords[i].charAt(t) == charactersToRemove[j]) { // If the character to remove is found
								
								inputWords[i] = inputWords[i].substring(0, t) + inputWords[i].substring(t + 1); // Creates a new string without that character
								
							}
							
						} // t For Loop
						
					} // j For Loop
					
					numberArray[numberArrayIndex] = inputWords[i]; // Adds the value to the array.
					
					numberArrayIndex++; // Adds 1 to the index so that it doesn't set the same index to different values.
					
				} // If
				
			} // i For Loop
		
		return numberArray; // Returns the array.
		
	}
	
	public static String executions(String[] inputWords) throws Exception { // Determines the program to be executed and returns an output.
		
		final String[] additionWords = {"add", "sum", "+", "plus"}; // The arrays of words to check for.
		final String[] subtractionWords = {"subtract", "minus", "-", "difference", "take"};
		final String[] subtractionReversal = {"from"};
		final String[] multiplicationWords = {"times", "multiply", "*", "product"};
		final String[] divisionWords = {"divide", "/", "quotient", "group", "split"};
		final String[] randomWords = {"random", "between"};
		final String[] powerWords = {"power", "exponent", "^"};
		final String[] greetingWords = {"hello", "hi", "yo", "hola"};
		final String[] morningWords = {"morning"};
		final String[] nightWords = {"night", "evening"};
		final String[] gratitudeWords = {"thank"};
		final String[] helpWords = {"!help", "command"};
		final String[] explanationWords = {"explain", "description", "explanation"};
		final String[] exitWords = {"leave", "bye", "quit", "exit"};
		final String[] doRemind = {"est", "EST"};
		final String[] setReminder = {"set", "reminder", "remind"};
		
		String output = "";
		
		if (wordCheck(additionWords, inputWords)) { // If it finds the addition words
			
			output = MathMethods.addition(StringProcessing.numberProcessing(inputWords)); // Adds all numbers
		
		} else if (wordCheck(subtractionWords, inputWords)) { // If it finds the subtraction words
			
			if (wordCheck(subtractionReversal, inputWords)) { // If 'from' is found
				
				output = MathMethods.subtractionReversal(StringProcessing.numberProcessing(inputWords)); // Subtracts in reverse order.
				
			} else { // If from is not found
			
				output = MathMethods.subtraction(StringProcessing.numberProcessing(inputWords)); // Subtracts all numbers
				
			}
			
		} else if (wordCheck(multiplicationWords, inputWords)) { // If it finds the multiplication words
			
			output = MathMethods.multiplication(StringProcessing.numberProcessing(inputWords)); // Calculates product of all numbers.
			
		} else if (wordCheck(divisionWords, inputWords)) { // If it finds the division words.
			
			output = MathMethods.division(StringProcessing.numberProcessing(inputWords)); // Calculates quotient of all numbers
			
		} else if (wordCheck(powerWords, inputWords)) {
		
			output = MathMethods.power(StringProcessing.numberProcessing(inputWords));
			
		} else if (wordCheck(randomWords, inputWords)) { // If it finds the random words.
			
			output = MathMethods.randomNumber(StringProcessing.numberProcessing(inputWords));
			
		} else if (wordCheck(gratitudeWords, inputWords)) { // If it finds the gratitude words.
			
			output = "No problem!"; // Replies
			
		} else if (wordCheck(nightWords, inputWords)) { // If it finds the nightWords
		
			if (DateMethods.isItMorning()) { // If it is morning.
				
				output = "Well, it isn't even afternoon yet but thank you I guess..."; // Ridicules the user
				
			} else { // If not
				
				output = "Good night! Type quit to close the program."; // Replies
				
			}
			
		} else if (wordCheck(morningWords, inputWords)) { // If it finds the morning words
		
			if (DateMethods.isItMorning()) { // If it is morning
				
				output = "Good morning!"; // Replies
				
			} else { // If not
				
				output = "Well, it isn't morning but thank you I guess..."; // Ridicules the user
				
			}
		
		} else if (wordCheck(greetingWords, inputWords)) { // If it finds the greeting words.
			
			output = "Hello to you as well!"; // Replies
			
		} else if (wordCheck(helpWords, inputWords)) { // If it finds the help words.
		
			output = "Type: | Function | {} Words To Enter | () Parameters | [] Extra Information" // All Functions
					+ "\nExplanation: Detailed explanation of the program. {explain, description}" 
					+ "\nAddition: Adds Numbers {add, plus, + sum} (takes numbers) "
					+ "\nSubtraction: Subtracts numbers {minus, subtract, -, difference} (takes numbers) [from reverses the equation] "
					+ "\nMultiplication Multiplies numbers {times, *, multiply, product} (takes numbers) "
					+ "\nDivision: Divides numbers {divide, quotient, split, group, /} (takes numbers) "
					+ "\nPower: Multiples a number by itself a specified amount of times {power, exponent, ^} (takes two numbers, first is the base and the second is the exponent)" 
					+ "\nRandom Number: Gives a random number between two values {random, between} (takes two numbers) "
					+ "\nSet Reminders: Sets a reminder. {remind, set, reminder} (enter numbers as such dd MM yyyy HH mm ss)"
					+ "\nReminders: Reminds the user at a certain time/date. [Automatically checks every 60 seconds]"
					+ "\nGreetings: Greets the user {hello, hi, yo, hola}"
					+ "\nGratitude: Replies to the gratitude of the user. {thank}"
					+ "\nMorning Greetings: Replies to the user when they say good morning. Ridicules them if it is not morning. {morning}"
					+ "\nNight Greetings: Replies to the user when they say good night. Ridicules them if it is the morning."
					+ "\nQuit: Exits the program. {quit, leave, bye, exit}";
			
		} else if (wordCheck(explanationWords, inputWords)) { // If the explanationWords are found.
			
			output = "A.S.H or Artificial System Helper is a program designed by Peter Alpajaro." // Description
					+ "\nIt has been designed to find words from user inputed strings. It then "
					+ "\nexecutes code and outputs the result to the text box. It can also set"
					+ "\nreminders and then remind the user at that time."
					+ "\n\nVersion 1.0 Last Edit 11/09/2020";
			
		} else if (wordCheck(exitWords, inputWords)) { // If the exit words are found
			
			output = "Quit"; // Gives a string that will trigger an if statement to close the program.
			
		} else if (wordCheck(setReminder, inputWords)) { // If setReminder words are found.
			
			output = "Set Reminder"; // Outputs confirmation.
			
			DateMethods.writeToFile(DateMethods.dateInputToString(inputWords)); // Writes the inputed date into the file.
			
		} else if (wordCheck(doRemind, inputWords)) { // If the input is a reminder check
			
			Date nowDate = new Date(); // Gets current date.
			
			if (numberCheck(inputWords)) { // If it has numbers.

				if (DateMethods.shouldRemind(inputWords, DateMethods.numberDateConverter(nowDate))) { // If the current date matches a date in the file.
				
					output = "Reminder!"; // Reminds the user.
				
				} else { // If not
				
					output = "Automatic Reminder Check Result: False"; // Doesn't remind
				
				}
			
			} else { // If it doesn't
				
				output = "Automatic Reminder Check Result: False"; // Doesn't remind
				
			}
			
		} else { // If no words are picked up.
			
			output = "Execution method not found, please type !help for all functions."; // Incorrect input
			
		}
		
		return output; // Returns the output
		
	}
	
	public static boolean numberCheck(String[] inputWords) { // NumberCheck for entire arrays
		
		boolean hasNumbers = false;
		
		for (int i = 0; i < inputWords.length; i++) { // Loops through inputWords
			
			if (inputWords[i].contains("1") || inputWords[i].contains("2") || inputWords[i].contains("3") // If inputWords contains a number, then it returns true.
				|| inputWords[i].contains("4") || inputWords[i].contains("5") || inputWords[i].contains("6")
				|| inputWords[i].contains("7") || inputWords[i].contains("8") || inputWords[i].contains("9")
				|| inputWords[i].contains("0")) {
				
				hasNumbers = true;
					
			}
			
		}
		
		return hasNumbers;
		
	}
	
	public static boolean numberCheck(String inputWord) { // NumberCheck for individual words
		
		boolean isNumber = false;
		
		if (inputWord.contains("1") || inputWord.contains("2") || inputWord.contains("3") // If the word contains a number then it returns true.
			|| inputWord.contains("4") || inputWord.contains("5") || inputWord.contains("6")
			|| inputWord.contains("7") || inputWord.contains("8") || inputWord.contains("9")
			|| inputWord.contains("0")) {
		
			isNumber = true;
				
		}
			
		return isNumber;

	}
	
	public static boolean wordCheck(String[] wordsToCheck, String[] inputWords) { // Checks an array for inputed words.
		
		boolean hasCheckedWords = false;
		
		for (int i = 0; i < wordsToCheck.length; i++) {
			
			for (int j = 0; j < inputWords.length; j++) {
				
				if (inputWords[j].contains(wordsToCheck[i])) { // If the array contains the word that we are looking for, set to true.
					
					hasCheckedWords = true;
					
				}
				
			} // j For Loop
			
		} // i For Loop
		
		return hasCheckedWords;
		
	}
	

} // Class
