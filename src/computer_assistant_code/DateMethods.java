	/*

	 * Project: Summative Assignment / Final Project
	
	 * Package: computer_assistant_code
	
	 * Class: DateMethods
	
	 * Programmer: Peter Alpajaro
	
	 * Date Created: 11 09 2020
	 
	 * Description: This class handles anything that relates to dates. It converts dates into
	 * numbers and then compares them to dates. It collects information from the user and then
	 * writes that information down in a file, which it can then read from later. 
 
	 */

package computer_assistant_code;

import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class DateMethods {
		
	public static String dateEvent() throws Exception {

		String output = "Automatic Reminder Check Result: False"; // Output
			
		FileReader myFile = new FileReader("dates.txt"); // New file reader
			
		BufferedReader myReader = new BufferedReader(myFile); // New Buffered Reader
		
		String[] counterArray = new String[100]; // New String Array
		
		int line = 0; // Variable for the line index for the reader
		
		String firstDate = myReader.readLine(); // First line of the document
		
		while (firstDate != null) { // While the next line has a value
			
			counterArray[line] = firstDate; // Set the value in the counterArray to first date.
			
			line++; // Adds to the line count
			
			firstDate = myReader.readLine(); // Sets firstDate to the nextLine
			
		}
		
		String[] dateArray = new String[line]; // New array with the exact number of lines
		
		for (int i = 0; i < dateArray.length; i++) {
			
			dateArray[i] = counterArray[i]; // Sets each slot in dateArray to the value in counterArray.
			
		}
		
		String[] splitArray; // Temporary Array
		
		for (int i = 0; i < dateArray.length; i++) { // Loops through dateArray
			
			dateArray[i] = dateArray[i].replaceAll(":", " "); // Replaces colons with spaces
			
			dateArray[i] = dateArray[i].replaceAll("/", " "); // Replaces slashes with spaces
			
			splitArray = dateArray[i].split(" "); // Sets the tempArray to the split apart dateArray
			
			if (output.equals("Automatic Reminder Check Result: False")) { // If the output hasn't already been called.
				
				output = StringProcessing.executions(splitArray); // Run executions with the tempArray.
				
			}
			
		}
		
		myFile.close(); // Closes readers.
		myReader.close();
		
		return output; // Returns the output
		
	}
	
	
	
	public static double numberDateConverter(Date dateToConvert) throws Exception { // Converts a date into a numerical value.
		
		SimpleDateFormat newDateFormat = new SimpleDateFormat("dd/MM/yyyy HH/mm/ss"); // Sets the format for the date/
		
		String dateString = newDateFormat.format(dateToConvert); // Sets the date to the format.
		
		String dateNumberString = "";
		
		double result;
		
		dateString = dateString.replaceAll(":", " "); // Replaces : with a space
		
		dateString = dateString.replaceAll("/", " "); // Replaces / with a space
		
		String[] dateWords = dateString.split(" "); // New array made of the date that has been split with spaces.

		for (int i = 0; i < dateWords.length; i++) { // Loops through dateWords.
			
			if (StringProcessing.numberCheck(dateWords[i])) { // If the string is a number
				
				dateNumberString = dateNumberString + dateWords[i]; // Adds to a string.
				
			}
			
		}
		
		result = Double.parseDouble(dateNumberString); // Converts that string to a number.
		
		return result; // Returns the number.
		
	}
	
	public static boolean shouldRemind(String[] dateArray, double nowDateNumber) { // Checks to see if the current date matches a date in the file.
		
		boolean doRemind = false;
		
		String numberString = "";
		
		double timeNumber;
			
		numberString = dateArray[0]; // Sets the first word in the date to a string. Should be a number
			
		timeNumber = Double.parseDouble(numberString); // Converts it into a number format.
			
		if (nowDateNumber < timeNumber + 60 && nowDateNumber > timeNumber - 60) { // If the date from the document is within 60 seconds from the current time.
			
			doRemind = true; // Sets to true.
				
		}
		
		return doRemind; // Returns result.
		
	}
	
	public static boolean isItMorning() throws Exception { // Checks if the date is morning.
		
		boolean result;
		
		Date currentDate = new Date(); // Gets the current date
		
		double dateNumber = numberDateConverter(currentDate); // Converts date into a number
		
		double subtractionNumber = Math.round(dateNumber / 1000000) * 1000000; // Gets just the date and not the time.
		
		dateNumber = dateNumber - subtractionNumber; // Subtracts the date from the time, leaving just the time number.
		
		if (dateNumber > 115959) { // If the time is over 11:59 the it is false
			
			result = false;
			
		} else { // If not then it's true
			
			result = true;
			
		}
		
		return result; // Returns the result.
		
	}
	
	public static String dateInputToString(String[] inputWords) { // Takes in an input and converts it into the format in the document.
		
		String output = "";
		
		String[] numberArray = StringProcessing.numberProcessingString(inputWords); // Gets numbers out of the input and puts them into an array.
		
		if (numberArray.length != 6) { // If the array is not 6 long (It should be), then it changes the output to invalid input 
			
			output = "Invaid Input";
			
		} else { // If it is 6 long
			
			for (int i = 0; i < numberArray.length; i++) { // Loops through the numberArray and assembles them all together.
				
				output = output + numberArray[i];
				
			}
			
		}
		
		output = output + " EST"; // Adds EST at the end for detection purposes.
		
		return output; // Returns output.
		
	}
	
	public static void writeToFile(String wordToWrite) throws IOException { // Writes a string to a file.
		
		File myFile = new File("dates.txt"); // Gets dates.txt
		
		FileWriter myWriter = new FileWriter(myFile, true); // Opens a FileWriter
		
		BufferedWriter myPrinter = new BufferedWriter(myWriter); // Opens a BufferedWriter
		
		myPrinter.write("\n" + wordToWrite); // Writes the word on a new line.
		
		myPrinter.close(); // Closes writers.
		myWriter.close();
		
	}
	

	
}
