	/*

	 * Project: Summative Assignment / Final Project
	
	 * Package: computer_assistant_code
	
	 * Class: GraphicsWindow
	
	 * Programmer: Peter Alpajaro
	
	 * Date Created: 11 09 2020
	 
	 * Description: This is the graphics window for ASH. This program has an input text field, a submit
	 * button and an output text area. The user can input commands into the input text field and then
	 * click submit and the program will execute certain programs and then output the result to the
	 * output field. This class contains all the graphics, action listeners and timers.
 
	 */

package computer_assistant_code;

import java.awt.*;
import java.awt.event.*;
import java.util.TimerTask;

import javax.swing.*;

public class GraphicsWindow extends JFrame implements ActionListener {

	JPanel myPanel; // Panel
	
	JButton submitInput; // Submit
	
	JTextField inputField; // Input
	
	JTextArea outputField; // Output
	
	
	
	public GraphicsWindow() { 
		
		super("A.S.H"); // Title of program
		
		myPanel = (JPanel) this.getContentPane();
		
		myPanel.setLayout(null); // No layout.
		
		myPanel.setBackground(Color.LIGHT_GRAY);
		
		JButton submitInput = new JButton("Submit"); // Submit Button
		submitInput.setBackground(Color.WHITE);
		submitInput.addActionListener(this);
		submitInput.setBounds(100, 100, 300, 30);
		
		inputField = new JTextField(20); // Input Field
		inputField.setBounds(20, 50, 450, 30);
		
		outputField = new JTextArea(10, 20); // Output Text Area
		outputField.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(outputField); // Adds scroll to the text area
		scrollPane.setBounds(20, 150, 450, 200);
		
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		
		myPanel.add(inputField);
		myPanel.add(submitInput); // Adds to the panel
		myPanel.add(scrollPane);
		
		
		
		
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setSize(500, 500); // Size of window.
		
		this.setVisible(true);
		
		try {
			
			run(); // Calls run()
			
		} catch (InterruptedException e) {

			e.printStackTrace();
			
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		
	}
	
	public void run() throws InterruptedException, Exception {
		
		for (int i = 0; i < 1000000000; i++) { // Very long loop
			
			outputField.append(DateMethods.dateEvent() + "\n\n"); // Adds the result of dateEvent to the textArea.
			
			Thread.sleep(30000); // Sleep for 30 seconds
			
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String action = e.getActionCommand(); // Gets action and sets it to a string
		
		String output = "Executions not run / Input error"; // Automatic output
		
		if (action.equals("Submit")) { // When the user pressed submit
			
			String inputString = inputField.getText(); // Grabs the string from the input box
			
			String[] inputWords = StringProcessing.wordProcessing(inputString); // Splits the string into words
				
			try {
				
				output = StringProcessing.executions(inputWords); // Sets output to the result of executions.
				
			} catch (Exception e1) {
			
				e1.printStackTrace();
				
			}
			
			if (output.equals("Quit")) { // If the output is "Quit" 
				
				System.exit(0); // Then close the program.
				
			}
				
			outputField.append(output + "\n\n"); // Adds the output to the text box
			
		}
		
		
	}
	
	public void paint(Graphics g) { // Paint Method
		
		super.paint(g);
		
		Font titleFont = new Font("Calibri Light", Font.PLAIN, 50); // Declaring title and normal fonts.
		Font normalFont = new Font("Calibri", Font.PLAIN, 15);
		g.setColor(Color.DARK_GRAY);
		
		g.setFont(titleFont); // Sets font
		g.drawString("A.S.H", 200, 70); // Draws "A.S.H"
		
		g.setFont(normalFont); // Sets font
		g.drawString("My name is Ash! My Capabilites include simple numeric", 80, 400);
		g.drawString("equations, reminders and a few automated greetings!", 80, 420); // Message to describe the program.
		g.drawString("Type !help to see all my functions.", 80, 450);
		
		
	}
	
}