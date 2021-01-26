/**
 * An application that generates lists of numbers and letters based on preset buttons
 * 
 * Jack Reynolds
 * 04/03/2020
 */

import javax.swing.*;        //JFrame, JPanel, JButton, and so fourth...
import javax.swing.table.DefaultTableModel; //Table stuff
import javax.swing.border.*; //Border stuff
import java.awt.*;           //Font and color
import java.awt.event.*;     //Event-handling

public class NumberGenerator implements ActionListener
{
    //Data item definitions
    JFrame mainFrame;
    
    JPanel mainPanel,
           headerPanel,
           middlePanel,
           footerPanel;
           
    JLabel headerLabel;
           
    JButton convertButton,            
            printButton,
            exitButton,
            oddButton,
            evenSquareButton,
            sumSquareOddButton,
            abcUpperButton,
            abcLowerButton,
            refreshButton;
    
    JTable numberTable;
            
    Font myFont1,
         myFont2;
    
    Border border1,
           border2,
           titledBorder;
           
    //Define table variables       
    public static DefaultTableModel tableModel;
    //Data is stored in an array
    private static final Object[][] data = {};
    //Column names are stored in an array
    private static final Object[] columnNames = {"Your Results"};
    
    //Constructor method
    public NumberGenerator() 
        {
        //Build frame
        mainFrame = new JFrame("Number Generator");
        
        ////////////////////// PANELS ////////////////////////
        //Build panels
        mainPanel = new JPanel();
        headerPanel = new JPanel();
        middlePanel = new JPanel();
        footerPanel = new JPanel();
        
        //Use absolute postioning on all panels
        mainPanel.setLayout(null);
        headerPanel.setLayout(null);
        middlePanel.setLayout(null);
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
        //Set middlePanel to false at first
        middlePanel.setVisible(true);
        
        //Pos and size of footer panel
        footerPanel.setBounds(10, 350, 565, 50);
        //Put middlePanel onto mainPanel
        mainPanel.add(footerPanel);
        
        ///////////////////// LABELS //////////////////////////
        //Build labels
        headerLabel = new JLabel("Number Generator");
        
        //Set bounds
        headerLabel.setBounds(150, 10, 400, 30);
        
        //Add to panel
        headerPanel.add(headerLabel);
        
        ////////////////////////// BUTTONS /////////////////////////
        //Build buttons
        exitButton = new JButton("Exit");
        printButton = new JButton("Print your results");
        oddButton = new JButton("Odd integers to 29");
        evenSquareButton = new JButton("Squares of even integers to 20");
        sumSquareOddButton = new JButton("Sum of odd squares to 13");
        abcUpperButton = new JButton("Uppercase alphabet");
        abcLowerButton = new JButton("Lowercase alphabet");
        refreshButton = new JButton("Try another generator");
        
        //Pos and size of buttons
        exitButton.setBounds(450, 10, 100, 30);
        printButton.setBounds(250, 10, 200, 30);
        oddButton.setBounds(10, 10, 300, 30);
        evenSquareButton.setBounds(10, 60, 300, 30);
        sumSquareOddButton.setBounds(10, 110, 300, 30);
        abcUpperButton.setBounds(10, 160, 300, 30);
        abcLowerButton.setBounds(10, 210, 300, 30);
        refreshButton.setBounds(10, 10, 240, 30);
        
        //Add buttons to panels
        footerPanel.add(exitButton);
        footerPanel.add(printButton);
        middlePanel.add(oddButton);
        middlePanel.add(evenSquareButton);
        middlePanel.add(sumSquareOddButton);
        middlePanel.add(abcUpperButton);
        middlePanel.add(abcLowerButton);
        footerPanel.add(refreshButton);
        
        //Register buttons for an action event 
        exitButton.addActionListener(this);
        printButton.addActionListener(this);
        oddButton.addActionListener(this);
        evenSquareButton.addActionListener(this);
        sumSquareOddButton.addActionListener(this);
        abcUpperButton.addActionListener(this);
        abcLowerButton.addActionListener(this);
        refreshButton.addActionListener(this);
        
        //Set refresh and print initally unenabled
        printButton.setEnabled(false);
        refreshButton.setEnabled(false);
        
        ////////////////////////// TABLE //////////////////////        
        //Define the table model
        tableModel = new DefaultTableModel(data, columnNames);
        //Build
        numberTable = new JTable(tableModel);
        //Set the cell editor to null
        numberTable.setCellEditor(null);
        //Set bounds 
        numberTable.setBounds(350, 10, 200, 232);
        //Add to middle
        middlePanel.add(numberTable);
        //Set to non-visible
        numberTable.setVisible(true);
        
        //ADDING A SCROLL FEATURE TO THE TABLE
        //Build scroll pane
        JScrollPane textScroll = new JScrollPane(numberTable);
        
        //Set bounds
        textScroll.setBounds(350, 10, 200, 232);
        
        //Set direction of the scroll to vertical
        textScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        //Add to the middle panel
        middlePanel.add(textScroll);
        
        ////////////////////// FONTS //////////////////////////
        //Build fonts
        myFont1 = new Font("TimesRoman", Font.BOLD, 30);
        myFont2 = new Font("TimesRoman", Font.BOLD, 15);
        
        //Apply fonts
        //Font 1
        headerLabel.setFont(myFont1);
        
        //Font 2
        numberTable.setFont(myFont2);
        
        ////////////////////// BORDERS /////////////////////////
        //Build borders
        border1 = BorderFactory.createRaisedBevelBorder();
        border2 = BorderFactory.createLoweredBevelBorder();
        
        //Border 1 
        headerPanel.setBorder(border1);
        footerPanel.setBorder(border1);
        
        //Border 2
        middlePanel.setBorder(border2);
        
        ////////////////////////////// FRAME ctnd. ////////////////
        //Pos and size of frame
        mainFrame.setBounds(100, 100, 600, 460);
        //Set visibility
        mainFrame.setVisible(true);
    }
    

    //Implement action performed method from action listener
    //This is called everytime we click on a button
    public void actionPerformed(ActionEvent event) 
    {
        //Initialise variables
        int square = 0;
        int row = 0;
        int total = 0;
        char letter;
        String number;
        
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
            //Remove contents of the table
            int rowCount = tableModel.getRowCount();
            //Delete each row one by one
            for (int rows = rowCount - 1; rows >= 0; rows--) 
            {
                tableModel.removeRow(rows);
            }
            
            //Make all buttons active
            oddButton.setEnabled(true);
            evenSquareButton.setEnabled(true);
            sumSquareOddButton.setEnabled(true);
            abcUpperButton.setEnabled(true);
            abcLowerButton.setEnabled(true);
            
            //Make refresh and print inactive
            refreshButton.setEnabled(false);
            printButton.setEnabled(false);
        }
        else
        
        //Print button
        if (event.getSource() == printButton)
        {
            //Open print window
            JOptionPane.showMessageDialog(mainFrame, "Your results have been sent to your printer.");
        }
        else
        
        //Check is oddButton is clicked
        if (event.getSource() == oddButton)
        {
            //List all odd numbers between 1 and 29
            for (row = 1; row <= 29; row++) 
            {
                //Check if it is odd
                if (row%2 !=0) 
                {
                    //Get the row number as a string
                    number = String.valueOf(row);
                    
                    //Display the odd numbers in the row
                    tableModel.addRow(new Object[] {number});
                }
            }
            //Make all buttons disabled to prevent further data being added to the table
            oddButton.setEnabled(false);
            evenSquareButton.setEnabled(false);
            sumSquareOddButton.setEnabled(false);
            abcUpperButton.setEnabled(false);
            abcLowerButton.setEnabled(false);
            
            //Make the refresh and print button enabled
            refreshButton.setEnabled(true);
            printButton.setEnabled(true);
        } 
        else
        
        //Check is evenSquareButton is clicked
        if (event.getSource() == evenSquareButton)
        {
            //List the sqared values of all even numbers between 2 and 20
            for (row = 2; row <= 20; row++) 
            {
                //Check if it is even
                if (row%2 ==0) 
                {
                    //Square the value of row
                    square = row * row;
                    
                    //Store the squared value in a string
                    number = String.valueOf(square);
                    
                    //Display the squared values
                    tableModel.addRow(new Object[] {number});
                }
            }
            
            //Make all buttons disabled to prevent further data being added to the table
            oddButton.setEnabled(false);
            evenSquareButton.setEnabled(false);
            sumSquareOddButton.setEnabled(false);
            abcUpperButton.setEnabled(false);
            abcLowerButton.setEnabled(false);
            
            //Make the refresh button enabled
            refreshButton.setEnabled(true);
            printButton.setEnabled(true);
        } 
        else
        
        //Check is sumSquareOddButton is clicked
        if (event.getSource() == sumSquareOddButton)
        {
            //Give the sum of squared values between 1 and 13
            for (row = 1; row <= 13; row++) 
            {
                //Check for add number
                if (row%2 !=0) 
                {
                    //Square the value of row
                    square = row * row;
                    
                    //Add the new squared value to the total
                    total += square;
                    
                    //Check for row 13, which is the final row, to output only the final sum
                    if (row == 13) 
                    {
                        //Get the total as a string
                        number = String.valueOf(total);
                        
                        //Display the total sum off all numbers calculated
                        tableModel.addRow(new Object[] {number});
                    }
                }
            }
            
            //Make all buttons disabled to prevent further data being added to the table
            oddButton.setEnabled(false);
            evenSquareButton.setEnabled(false);
            sumSquareOddButton.setEnabled(false);
            abcUpperButton.setEnabled(false);
            abcLowerButton.setEnabled(false);
            
            //Make the refresh button enabled
            refreshButton.setEnabled(true);
            printButton.setEnabled(true);
        } 
        else
        
        //Check is abcUpperButton is clicked
        if (event.getSource() == abcUpperButton)
        {
            //Display the alphabet in capital letters
            for (letter = 'A'; letter <= 'Z'; letter++) 
            {
                //Display the letters in the table
                tableModel.addRow(new Object[] {letter});
            }
            
            //Make all buttons disabled to prevent further data being added to the table
            oddButton.setEnabled(false);
            evenSquareButton.setEnabled(false);
            sumSquareOddButton.setEnabled(false);
            abcUpperButton.setEnabled(false);
            abcLowerButton.setEnabled(false);
            
            //Make the refresh button enabled
            refreshButton.setEnabled(true);
            printButton.setEnabled(true);
        } 
        else
        
        //Check is abcLowerButton is clicked
        if (event.getSource() == abcLowerButton)
        {
            //Display the alphabet in lowercase letters
            for (letter = 'a'; letter <= 'z'; letter++) 
            {
                //Display the letters in the table
                tableModel.addRow(new Object[] {letter});
            }
            
            //Make all buttons disabled to prevent further data being added to the table
            oddButton.setEnabled(false);
            evenSquareButton.setEnabled(false);
            sumSquareOddButton.setEnabled(false);
            abcUpperButton.setEnabled(false);
            abcLowerButton.setEnabled(false);
            
            //Make the refresh button enabled
            refreshButton.setEnabled(true);
            printButton.setEnabled(true);
        }
    }
}

