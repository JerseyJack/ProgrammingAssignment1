/**
 * An application that calculates an avarage from numbers given by a user. 
 * It must ignore negative numbers and empty values to give accurate results
 * 
 * Jack Reynolds
 * 06/03/2020
 */

import javax.swing.*;        //JFrame, JPanel, JButton, and so fourth...
import javax.swing.table.DefaultTableModel; //Table stuff
import javax.swing.border.*; //Border stuff
import java.awt.*;           //Font and color
import java.awt.event.*;     //Event-handling


public class AverageCalc implements ActionListener
{
    //Data item definitions
    JFrame mainFrame;
    
    JPanel mainPanel,
           headerPanel,
           middlePanel,
           numberPanel,
           footerPanel;
           
    JLabel headerLabel,
           enteredLabel;
           
    JButton enterButton,
            refreshButton,
            exitButton,
            undoButton;
            
    JTextField numberInput;
    
    JTextArea rulesArea;
            
    Font myFont1,
         myFont2,
         myFont3;
    
    Border border1,
           border2,
           titledBorder;
    
    //Constructor method
    public AverageCalc() 
        {
        //Build frame
        mainFrame = new JFrame("Average Calculator");
        
        ////////////////////// PANELS ////////////////////////
        //Build panels
        mainPanel = new JPanel();
        headerPanel = new JPanel();
        middlePanel = new JPanel();
        numberPanel = new JPanel();
        footerPanel = new JPanel();
        //Use absolute postioning on all panels
        mainPanel.setLayout(null);
        headerPanel.setLayout(null);
        middlePanel.setLayout(null);
        numberPanel.setLayout(null);
        footerPanel.setLayout(null);
        
        //Put mainPanel onto frame
        mainFrame.add(mainPanel);
        
        //Pos and size of header panel
        headerPanel.setBounds(10, 20, 565, 50);
        //Put headerPanel onto mainPanel
        mainPanel.add(headerPanel);
        
        //Pos and size of middle panel
        middlePanel.setBounds(10, 90, 565, 250);
        //Put middlePanel onto mainPanel
        mainPanel.add(middlePanel);
        
        //Pos and size of number panel
        numberPanel.setBounds(10, 60, 310, 160);
        //Put numberPanel onto middlePanel
        middlePanel.add(numberPanel);
        
        //Pos and size of footer panel
        footerPanel.setBounds(10, 350, 565, 50);
        //Put middlePanel onto mainPanel
        mainPanel.add(footerPanel);
        
        ///////////////////// LABELS //////////////////////////
        //Build labels
        headerLabel = new JLabel("Average Calculator");
        enteredLabel = new JLabel("Please enter a number.");
        
        //Set bounds
        headerLabel.setBounds(150, 5, 400, 35);
        enteredLabel.setBounds(10, 10, 300, 40);
        
        //Add to panel
        headerPanel.add(headerLabel);
        numberPanel.add(enteredLabel);
        
        ////////////////////////// BUTTONS /////////////////////////
        //Build buttons
        enterButton = new JButton("Enter Number");
        exitButton = new JButton("Exit");
        refreshButton = new JButton("Refresh");
        undoButton = new JButton("Undo");
        
        //Pos and size of buttons
        enterButton.setBounds(120, 20, 200, 30);
        exitButton.setBounds(450, 10, 100, 30);
        refreshButton.setBounds(10, 10, 240, 30);
        undoButton.setBounds(200, 120, 100, 30);
        
        //Add buttons to panels
        middlePanel.add(enterButton);
        footerPanel.add(exitButton);
        footerPanel.add(refreshButton);
        numberPanel.add(undoButton);
        
        //Register buttons for an action event 
        exitButton.addActionListener(this);
        refreshButton.addActionListener(this);
        enterButton.addActionListener(this);
        undoButton.addActionListener(this);
        
        //Set refresh and print initally unenabled
        refreshButton.setEnabled(false);
        
        //Make undo button not visible
        undoButton.setVisible(false);
        
        ////////////////////////// INPUTS //////////////////////
        //Build
        numberInput = new JTextField("");
             
        //Pos and size of input
        numberInput.setBounds(10, 20, 100, 30);
        
        //Add to middle
        middlePanel.add(numberInput);
        
        //////////////////////// TEXT AREA /////////////////////////
        //Build
        rulesArea = new JTextArea();
        
        //Make it non-editable
        rulesArea.setEditable(false);
        
        //Result area pos and size
        rulesArea.setBounds(325, 20, 230, 200);
        
        //Add result area
        middlePanel.add(rulesArea);
        
        //Add text
        rulesArea.append("- Input a number and press \nthe 'Enter number' button.\n" +
                         "- To complete the calculation, \nenter 0.\n" +
                         "- Negative values will be \nignored.\n" +
                         "- You can undo a single \nnumber when it is entered.\n");
        
        ////////////////////// FONTS //////////////////////////
        //Build fonts
        myFont1 = new Font("TimesRoman", Font.BOLD, 30);
        myFont2 = new Font("TimesRoman", Font.BOLD, 15);
        myFont3 = new Font("TimesRoman", Font.BOLD, 17);
        
        //Apply fonts
        //Font1
        headerLabel.setFont(myFont1);
        
        //Font2
        numberInput.setFont(myFont2);
        rulesArea.setFont(myFont2);
        
        //Font3
        enteredLabel.setFont(myFont3);
        
        ////////////////////// BORDERS /////////////////////////
        //Build borders
        border1 = BorderFactory.createRaisedBevelBorder();
        border2 = BorderFactory.createLoweredBevelBorder();
        
        //Apply border1
        headerPanel.setBorder(border1);
        footerPanel.setBorder(border1);
        //Apply border2
        middlePanel.setBorder(border2);
        numberPanel.setBorder(border2);
        
        //Create titled border
        titledBorder = BorderFactory.createTitledBorder("Rules");
        //Add to text area
        rulesArea.setBorder(titledBorder);
        
        ////////////////////////////// FRAME ctnd. ////////////////
        //Pos and size of frame
        mainFrame.setBounds(100, 100, 600, 460);
        //Set visibility
        mainFrame.setVisible(true);
    }
    
    //Initialise variables outside of the actionPerformed method so that they are not overwritting with each action event
    String number;
    double enteredNumber = 0;
    double total = 0;
    double average = 0;
    int quantity = 0; //To count the quantity of numbers given
    
    //Implement action performed method from action listener
    //This is called everytime we click on a button
    public void actionPerformed(ActionEvent event) 
    {
        //Decide if exit clicked
        if (event.getSource() == exitButton)
        {
            // Exit the application
            int response = JOptionPane.showConfirmDialog
            (mainPanel, "Are you sure you want to exit?",
                        "Exit Confirmation"/*title of box*/,
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                                                           
            if (response == JOptionPane.YES_OPTION) 
            {
               //Create a software object from class commission
               AssignmentMenu start;
               //Allocate memory for the object 
               start = new AssignmentMenu();
        
                                                               
               //Dispose of the body
               mainFrame.dispose();      
            }
            else
            //if it equals no
            if (response == JOptionPane.NO_OPTION) 
            {
               //Leave empty
            }
        }
        else
         
        //Refresh button
        if (event.getSource() == refreshButton) 
        {
            //Set variables back to 0 
            number = "";
            enteredNumber = 0;
            total = 0;
            average = 0;
            quantity = 0;
            
            //Revert label
            enteredLabel.setText("Please enter a number.");
            enteredLabel.setForeground(Color.black);
            
            //Re-enable the text field and enter button
            numberInput.setEnabled(true);
            enterButton.setEnabled(true);
        }   
        else
        
        //Check is enter button is clicked
        if (event.getSource() == enterButton)
        {
            //Read the contents of the sales textfield
            number = numberInput.getText();
             
            //If no number has been given
            if (number.equals("")) 
            {
                //Alert the user that there is no number detected
                enteredLabel.setText("No number found."); 
                enteredLabel.setForeground(Color.red);
                    
                //Empty the number input
                numberInput.setText("");
                 
                //No reason to have undo here
                undoButton.setVisible(false);
            }
            else
             
            //If string is given
            if (number.contains("")) 
            {
                //Alert the user that there is no number detected
                enteredLabel.setText("Letters or words are unsupported."); 
                enteredLabel.setForeground(Color.red);
                   
                //Empty the number input
                numberInput.setText("");
                 
                //No reason to have undo here
                undoButton.setVisible(false);
            }

            //Convert to a number now that empty values have been checked
            enteredNumber = Double.valueOf(number);

            //Check for negatives
            if (enteredNumber < 0) 
            {
                //Alert user that negative numbers are invalid
                enteredLabel.setText("Negative numbers will be ignored.");
                enteredLabel.setForeground(Color.red);
                 
                //Empty the number input
                numberInput.setText("");
                 
                //No reason to have undo here
                undoButton.setVisible(false);
            }
            else
             
            //Check for 0 then calculate average
            if (enteredNumber == 0) 
            {
                //Allow the user to refresh and start again
                refreshButton.setEnabled(true);
                
                //Disable text field and enter button until refreshed
                numberInput.setEnabled(false);
                enterButton.setEnabled(false);
                 
                //Empty the number input
                numberInput.setText("");
                 
                //No reason to have undo here
                undoButton.setVisible(false);
                
                //If the total is 0 it means that no numbers, or no valid numbers, have been added, therefore the average cannot be calculated
                if (total == 0) 
                {
                    //Display the average
                    enteredLabel.setText("No numbers given. Please refresh.");
                    enteredLabel.setForeground(Color.black);
                }
                else
                
                //If the total is positive then the average can 
                if (total > 0) 
                {
                    //Calculate average
                    average = total / quantity;
                
                    //Convert the new average value in to a string, ready to be displayed
                    String finalAverage = String.valueOf(average);
                 
                    //Display the average
                    enteredLabel.setText("Your average is: " + finalAverage);
                    enteredLabel.setForeground(Color.black);    
                 } 
            }
            else
             
             //Check for positive then add to the total and the number quantity
            if (enteredNumber > 0) 
            {
                //Add 1 to the quantity of numbers given
                quantity += 1;
                //Add the given number to the total
                total += enteredNumber; 
                 
                //Alert the user that the number has been registered
                enteredLabel.setText("Number registered: " + enteredNumber);
                enteredLabel.setForeground(Color.green);
                 
                //Empty the number input
                numberInput.setText("");
                 
                //Set undo to enabled and visible
                undoButton.setVisible(true);
                undoButton.setEnabled(true);
            }             
        } 
        else
        
        //Check if user wants to undo last number
        if (event.getSource() == undoButton && enteredNumber > 0)
        {
            //Take away the value given and 1 from the quantity of given numbers
            total -= enteredNumber;
            quantity -= 1; 
                
            //Alert the user that the number has been undone
            enteredLabel.setText("Number undone");
                     
            //Can't be undone twice so set back to not enabled
            undoButton.setEnabled(false);
        }
    }
}

