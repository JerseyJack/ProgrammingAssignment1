/**
 * An application to convert miles in to kilometers
 * 
 * Jack Reynolds
 * 29/02/2020
 */

import javax.swing.*;        //JFrame, JPanel, JButton, and so fourth...
import javax.swing.table.DefaultTableModel;
import javax.swing.border.*; //Border stuff
import java.awt.*;           //Font and color
import java.awt.event.*;     //Event-handling

public class KmConverter implements ActionListener
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
            exitButton;
    
    JTable convertTable;
            
    Font myFont1,
         myFont2;
    
    Border border1,
           border2,
           titledBorder;
           
    //Define table variables       
    public static DefaultTableModel tableModel;
    //Data stored in an array
    private static final Object[][] data = {};
    //Column names stored in an array
    private static final Object[] columnNames = {"Miles", "Kilometres"};
    
    //Constructor method
    public KmConverter() 
        {
        //Build frame
        mainFrame = new JFrame("Km Converter");
        
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
        headerPanel.setBounds(10, 20, 282, 50);
        //Put headerPanel onto mainPanel
        mainPanel.add(headerPanel);
        
        //Pos and size of middle panel
        middlePanel.setBounds(10, 90, 282, 350);
        //Put middlePanel onto mainPanel
        mainPanel.add(middlePanel);
        //Set middlePanel to false at first
        middlePanel.setVisible(false);
        
        //Pos and size of footer panel
        footerPanel.setBounds(10, 140, 282, 50);
        //Put middlePanel onto mainPanel
        mainPanel.add(footerPanel);
        
        ///////////////////// LABELS //////////////////////////
        //Build labels
        headerLabel = new JLabel("Convert to km");
        
        //Set bounds
        headerLabel.setBounds(40, 10, 300, 30);
        
        //Add to panel
        headerPanel.add(headerLabel);
        
        ////////////////////////// BUTTONS /////////////////////////
        //Build buttons
        convertButton = new JButton("Begin Conversion");
        exitButton = new JButton("Exit");
        printButton = new JButton("Print Conversion");
        
        //Pos and size of buttons
        convertButton.setBounds(50, 90, 200, 30);
        exitButton.setBounds(90, 10, 100, 30);
        printButton.setBounds(10, 310, 260, 30);
        
        //Add buttons to panels
        mainPanel.add(convertButton);
        footerPanel.add(exitButton);
        middlePanel.add(printButton);
        
        //Register buttons for an action event 
        convertButton.addActionListener(this);
        exitButton.addActionListener(this);
        printButton.addActionListener(this);
        
        ////////////////////////// TABLE //////////////////////        
        //Define the table model 
        tableModel = new DefaultTableModel(data, columnNames);
        
        //Build
        convertTable = new JTable(tableModel);
        
        //Set the cell editor to null
        convertTable.setCellEditor(null);
        
        //Set bounds 
        convertTable.setBounds(10, 10, 260, 300);
        
        //Add to middle
        middlePanel.add(convertTable);
        
        //Set to non-visible
        convertTable.setVisible(false);
        
        //ADDING A SCROLL FEATURE TO THE TABLE
        //Build scroll
        JScrollPane textScroll = new JScrollPane(convertTable);
        
        //Set bounds
        textScroll.setBounds(10, 10, 260, 300);
        
        //Define the scroll bar direction
        textScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        //Add to main panel
        middlePanel.add(textScroll);
        
        ////////////////////// FONTS //////////////////////////
        //Build fonts
        myFont1 = new Font("TimesRoman", Font.BOLD, 30);
        myFont2 = new Font("TimesRoman", Font.BOLD, 15);
        
        //Apply fonts
        //Font 1
        headerLabel.setFont(myFont1);
        
        //Font 2
        convertTable.setFont(myFont2);
        
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
        mainFrame.setBounds(100, 100, 315, 240);
        //Set visibility
        mainFrame.setVisible(true);
    }
    

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
                //Create a software object from class Assignment Menu
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
        //Print button
        if (event.getSource() == printButton)
        {
           //Open print window
           JOptionPane.showMessageDialog(mainFrame, "Your commission slip has been sent to your printer.");
        }
        else
        
        //Decide if convert button is clicked
        if (event.getSource() == convertButton)
        {
           for (int row = 1; row <= 20; row++) {
               //miles increments in integers
               int miles = row;
               //Calculate kilometres through miles
               double kilometres = miles * 1.609;
                
               //Convert numbers to strings
               String mi = String.valueOf(miles);
               //Only allow 3 decimal points
               Double km = Double.parseDouble(String.format("%.3f", (Double.valueOf(kilometres))));
               
               //Create strings ready to be added to table
               String miColumn = mi + "mi";
               String kmColumn = km + "km";
                
               //Add the strings to the row
               tableModel.addRow(new Object[] {miColumn, kmColumn});
           }
             
           //Pos and size of frame
           mainFrame.setBounds(100, 100, 315, 560);
           
           //Pos of footer
           footerPanel.setBounds(10, 460, 282, 50);
           
           //Make middlePanel and convertArea visible
           middlePanel.setVisible(true);
           convertTable.setVisible(true);
           mainFrame.setVisible(true);
           
           //Make convertButton not visible
           convertButton.setVisible(false);
         } 
         
    }
}

