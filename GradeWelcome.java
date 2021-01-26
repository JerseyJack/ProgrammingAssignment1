
/**
 * Welcome to the Grade Calculator.
 *
 * Jack Reynolds
 * 
 * 13/01/2020
 * 
 */

import javax.swing.*;        //JFrame, JPanel, JButton, and so fourth...
import javax.swing.border.*; //Border stuff
import java.awt.*;           //Font and color
import java.awt.event.*;     //Event-handling
public class GradeWelcome implements ActionListener
{   
    //Define data variables
    JFrame welcomeFrame;
    
    JPanel titlePanel;
    
    JLabel titleLabel,
           welcomeLabel,
           introLabel;
    
    Font titleFont,
         titleFont2;
    
    JButton enterButton;
    
    Border border;
    
    public GradeWelcome() 
    {
        //Build frame
        welcomeFrame = new JFrame("Exam Grade Calculator");
        
        ///////////////////////// PANEL ///////////////////////
        //Build panel
        titlePanel = new JPanel();
        //Layout
        titlePanel.setLayout(null);
        //Set bounds
        titlePanel.setBounds(10, 10, 780, 180);
        //Add to frame
        welcomeFrame.add(titlePanel);
        
        ////////////////////////// LABEL //////////////////////
        //Build title
        titleLabel = new JLabel("The Exam Grade Calculator");
        //Set bounds
        titleLabel.setBounds(60, 30, 500, 35);
        //Add to panel
        titlePanel.add(titleLabel);
        
        //Build welcome
        welcomeLabel = new JLabel("Welcome to");
        //Set bounds
        welcomeLabel.setBounds(60, 10, 200, 20);
        //Add to panel 
        titlePanel.add(welcomeLabel);
        
        //Build welcome
        introLabel = new JLabel("The exam grade calculating application.");
        //Set bounds
        introLabel.setBounds(235, 60, 500, 20);
        //Add to panel 
        titlePanel.add(introLabel);
        
        ///////////////////////// BUTTON ///////////////////////
        //Build button 
        enterButton = new JButton("Enter");
        //Set bounds
        enterButton.setBounds(210, 100, 100, 30);
        //Add to panel
        titlePanel.add(enterButton);
        //Action listener
        enterButton.addActionListener(this);
        
        //////////////////////// FONT //////////////////////////
        //Build font
        titleFont = new Font("TimesRoman", Font.BOLD, 30);
        titleFont2 = new Font("TimesRoman", Font.BOLD, 15);
        
        //Font 1
        titleLabel.setFont(titleFont);
        
        //Font 2
        enterButton.setFont(titleFont2);
        welcomeLabel.setFont(titleFont2);
        
        //////////////////////// BORDER ////////////////////////
        //Build borders
        border = BorderFactory.createRaisedBevelBorder();
        //Add border to panel
        titlePanel.setBorder(border);
        
        ///////////////// FRAME ctnd. /////////////////////////
        //Set bounds
        welcomeFrame.setBounds(100, 100, 550, 200);
        //Set visible
        welcomeFrame.setVisible(true);
        
    }
    
    
    
    //Action listener for enter button
    public void actionPerformed(ActionEvent event) 
    {
        //Enter button
        if (event.getSource() == enterButton)
        {
         //Create a software object from GradeCalc
         GradeCalc start;
         //Allocate memory for the object 
         start = new GradeCalc();
         
         //Close title frame
         welcomeFrame.dispose();
       }
    }
}
