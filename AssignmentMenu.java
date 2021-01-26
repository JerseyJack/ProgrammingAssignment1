
/**
 * A menu for programming assignment 1
 * 
 * Author: Jack Reynolds
 * Date: 07/01/2020
 */

import javax.swing.*;        //JFrame, JPanel, JButton, and so fourth...
import javax.swing.border.*; //Border stuff
import java.awt.*;           //Font and color
import java.awt.event.*;     //Event-handling

public class AssignmentMenu implements ActionListener
{
    //Define data types
    JFrame menuFrame;
    
    JPanel headerPanel,
           buttonPanel,
           menuPanel;
    
    JLabel titleLabel,
           nameLabel;
    
    JButton task1Button,
            task2Button,
            task3Button,
            task4Button,
            task5Button,
            task6Button,
            task7Button,
            exitButton;
    
    Font myFont1,
         myFont2;
         
    Border border1,
           border2;
    
    
    
    //Constructor method
    public AssignmentMenu()
    {
        //Build frame
        menuFrame = new JFrame("Programming Assignment 1");
        
        ///////////////////// PANELS ////////////////////////////
        //Build Panels
        headerPanel = new JPanel();
        buttonPanel = new JPanel();
        menuPanel = new JPanel();
        
        //Panel layouts
        headerPanel.setLayout(null);
        buttonPanel.setLayout(null);
        menuPanel.setLayout(null);
        
        //Set panel bounds
        headerPanel.setBounds(10, 10, 560, 100);
        buttonPanel.setBounds(10, 120, 560, 135);
        
        //Add panels to main panel
        menuPanel.add(headerPanel);
        menuPanel.add(buttonPanel);
        
        //Add main to frame
        menuFrame.add(menuPanel);
        
        ///////////////////// LABELS ////////////////////////////
        //Build labels
        titleLabel = new JLabel("Programming Assignment Menu");
        nameLabel = new JLabel("Jack Reynolds'");
        
        //Set bounds
        titleLabel.setBounds(40, 30, 470, 35);
        nameLabel.setBounds(40, 15, 150, 20);
        
        //Add to header
        headerPanel.add(titleLabel);
        headerPanel.add(nameLabel);
        
        ////////////////////// BUTTONS /////////////////////////
        //Build buttons
        task1Button = new JButton("Commision Calculator v1");
        task2Button = new JButton("Commision Calculator v2");
        task3Button = new JButton("Course Grade Calculator");
        task4Button = new JButton("Miles to Kilometres Converter");
        task5Button = new JButton("Number Generator");
        task6Button = new JButton("Average Generator");
        task7Button = new JButton("Blood Type Compatibility");
        exitButton = new JButton("Exit App");
        
        //Set button bounds 
        task1Button.setBounds(10, 10, 265, 25);
        task2Button.setBounds(285, 10, 265, 25);
        task3Button.setBounds(10, 40, 265, 25);
        task4Button.setBounds(285, 40, 265, 25);
        task5Button.setBounds(10, 70, 265, 25);
        task6Button.setBounds(285, 70, 265, 25);
        task7Button.setBounds(10, 100, 265, 25);
        exitButton.setBounds(285, 100, 265, 25);
        
        //Add buttons to panel
        buttonPanel.add(task1Button);
        buttonPanel.add(task2Button);
        buttonPanel.add(task3Button);
        buttonPanel.add(task4Button);
        buttonPanel.add(task5Button);
        buttonPanel.add(task6Button);
        buttonPanel.add(task7Button);
        buttonPanel.add(exitButton);
        
        //Add action listener to buttons
        task1Button.addActionListener(this);
        task2Button.addActionListener(this);
        task3Button.addActionListener(this);
        task4Button.addActionListener(this);
        task5Button.addActionListener(this);
        task6Button.addActionListener(this);
        task7Button.addActionListener(this);
        exitButton.addActionListener(this);
        
        ////////////////////// FONTS ///////////////////////////
        //Build fonts
        myFont1 = new Font("TimesRoman", Font.BOLD, 30);
        myFont2 = new Font("TimesRoman", Font.BOLD, 15);
        
        //Font 1 
        titleLabel.setFont(myFont1);
        //Font2
        nameLabel.setFont(myFont2);
        task1Button.setFont(myFont2);
        task2Button.setFont(myFont2);
        task3Button.setFont(myFont2);
        task4Button.setFont(myFont2);
        task5Button.setFont(myFont2);
        task6Button.setFont(myFont2);
        task7Button.setFont(myFont2);
        exitButton.setFont(myFont2);
        
        ///////////////////// BORDER ///////////////////////////
        //Build borders
        border1 = BorderFactory.createRaisedBevelBorder();
        border2 = BorderFactory.createLoweredBevelBorder();
        
        //Border 1
        headerPanel.setBorder(border1);
        
        //Border 2
        buttonPanel.setBorder(border2);
        
        ////////////////// FRAME cntd. //////////////////////////
        //Set bounds
        menuFrame.setBounds(100, 100, 600, 300);
        //Set visible
        menuFrame.setVisible(true);
    }
    
    //Main() - This is where the processor will start
    public static void main() 
    {
        //Create a software object from class commission
        AssignmentMenu begin;
        //Allocate memory for the object 
        begin = new AssignmentMenu();
    }
    
    //actionPerformed - This is where the program will perform actions based on different button action events
    public void actionPerformed(ActionEvent event) 
    {
        if (event.getSource() == exitButton)
        {
            // Exit the application
            int response = JOptionPane.showConfirmDialog
            (menuPanel, "Are you sure you want to exit?",
            "Exit Confirmation"/*title of box*/,
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
                                                           
            if (response == JOptionPane.YES_OPTION) 
            {
                //Exit
                System.exit(0);  
            }
            else
            //if it equals no
            if (response == JOptionPane.NO_OPTION) 
            {
                //Leave empty
            }
        }
        else
        
        //Check which button has been clicked
        //Task1
        if (event.getSource() == task1Button)
        {
            //Create a software object from class CommissionWelcome
            CommissionWelcome start;
            //Allocate memory for the object 
            start = new CommissionWelcome();
         
            //Close title frame
            menuFrame.dispose();
        }
        else
        
        //Task 2
        if (event.getSource() == task2Button)
        {
            //Create a software object from class ModelWelcome
            ModelWelcome start;
            //Allocate memory for the object 
            start = new ModelWelcome();
         
            //Close title frame
            menuFrame.dispose();
        }
        else
        
        //Task 3
        if (event.getSource() == task3Button)
        {
            //Create a software object from class GradeWelcome
            GradeWelcome start;
            //Allocate memory for the object 
            start = new GradeWelcome();
         
            //Close title frame
            menuFrame.dispose();
        }
        else
        
        //Task 4
        if (event.getSource() == task4Button)
        {
            //Create a software object from class ConvertWelcome
            ConvertWelcome start;
            //Allocate memory for the object 
            start = new ConvertWelcome();
         
            //Close title frame
            menuFrame.dispose();
        }
        else
        
        //Task 5
        if (event.getSource() == task5Button)
        {
            //Create a software object from class NumberWelcome
            NumberWelcome start;
            //Allocate memory for the object 
            start = new NumberWelcome();
         
            //Close title frame
            menuFrame.dispose();
        }
        else
        
        //Task 6
        if (event.getSource() == task6Button)
        {
            //Create a software object from class AverageWelcome
            AverageWelcome start;
            //Allocate memory for the object 
            start = new AverageWelcome();
         
            //Close title frame
            menuFrame.dispose();
        }
        else
        
        //Task 7
        if (event.getSource() == task7Button)
        {
            //Create a software object from class BloodWelcome
            BloodWelcome start;
            //Allocate memory for the object 
            start = new BloodWelcome();
         
            //Close title frame
            menuFrame.dispose();
        }
    }
}
