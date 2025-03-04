/**
 * An application that will find compatible blood types from a donor for a patient
 * 
 * Jack Reynolds
 * 09/03/2020
 */

import javax.swing.*;        //JFrame, JPanel, JButton, and so fourth...
import javax.swing.table.DefaultTableModel; //Table stuff
import javax.swing.border.*; //Border stuff
import java.awt.*;           //Font and color
import java.awt.event.*;     //Event-handling


public class BloodTypes implements ActionListener
{
    //Data item definitions
    JFrame mainFrame;
    
    JPanel mainPanel,
           headerPanel,
           middlePanel,
           bloodPanel,
           footerPanel;
           
    JLabel headerLabel,
           bloodLabel,
           typeLabel;
           
    JButton enterButton,
            tableButton,
            exitButton,
            undoButton;
            
    JComboBox bloodBox;
            
    Font myFont1,
         myFont2,
         myFont3;
    
    Border border1,
           border2,
           titledBorder;
    
    //Constructor method
    public BloodTypes() 
        {
        //Build frame
        mainFrame = new JFrame("Blood Type Compatibility");
        
        ////////////////////// PANELS ////////////////////////
        //Build panels
        mainPanel = new JPanel();
        headerPanel = new JPanel();
        middlePanel = new JPanel();
        bloodPanel = new JPanel();
        footerPanel = new JPanel();
        //Use absolute postioning on all panels
        mainPanel.setLayout(null);
        headerPanel.setLayout(null);
        middlePanel.setLayout(null);
        bloodPanel.setLayout(null);
        footerPanel.setLayout(null);
        
        //Put mainPanel onto frame
        mainFrame.add(mainPanel);
        
        //Pos and size of header panel
        headerPanel.setBounds(10, 20, 330, 50);
        //Put headerPanel onto mainPanel
        mainPanel.add(headerPanel);
        
        //Pos and size of middle panel
        middlePanel.setBounds(10, 90, 330, 170);
        //Put middlePanel onto mainPanel
        mainPanel.add(middlePanel);
        
        //Pos and size of blood panel
        bloodPanel.setBounds(10, 60, 310, 70);
        //Change background colour
        bloodPanel.setBackground(Color.white);
        //Put bloodPanel onto middlePanel
        middlePanel.add(bloodPanel);
        
        //Pos and size of footer panel
        footerPanel.setBounds(10, 270, 330, 50);
        //Put middlePanel onto mainPanel
        mainPanel.add(footerPanel);
        
        ///////////////////// LABELS //////////////////////////
        //Build labels
        headerLabel = new JLabel("Blood Type Compatibility");
        bloodLabel = new JLabel("");
        typeLabel = new JLabel("Patient blood type:");
        
        //Set bounds
        headerLabel.setBounds(10, 5, 400, 35);
        bloodLabel.setBounds(10, 20, 300, 30);
        typeLabel.setBounds(10, 20, 200, 30);
        
        //Add to panel
        headerPanel.add(headerLabel);
        bloodPanel.add(bloodLabel);
        middlePanel.add(typeLabel);
        
        ////////////////////////// BUTTONS /////////////////////////
        //Build buttons
        exitButton = new JButton("Exit");
        tableButton = new JButton("View compatibility table");
        
        //Pos and size of buttons
        exitButton.setBounds(210, 10, 110, 30);
        tableButton.setBounds(10, 10, 200, 30);
        
        //Add buttons to panels
        footerPanel.add(exitButton);
        footerPanel.add(tableButton);
        
        //Register buttons for an action event
        exitButton.addActionListener(this);
        tableButton.addActionListener(this);
        
        ////////////////////////// DROP DOWNS //////////////////////
        //Build
        bloodBox = new JComboBox();
             
        //Pos and size of input
        bloodBox.setBounds(200, 20, 120, 30);
        
        //Add items to list
        bloodBox.addItem("O-");
        bloodBox.addItem("O+");
        bloodBox.addItem("A-");
        bloodBox.addItem("A+");
        bloodBox.addItem("B-");
        bloodBox.addItem("B+");
        bloodBox.addItem("AB-");
        bloodBox.addItem("AB+");
        
        //Add actionlistener
        bloodBox.addActionListener(this);
        
        //Add to middle
        middlePanel.add(bloodBox);
        
        ////////////////////// FONTS //////////////////////////
        //Build fonts
        myFont1 = new Font("TimesRoman", Font.BOLD, 25);
        myFont2 = new Font("TimesRoman", Font.BOLD, 15);
        myFont3 = new Font("TimesRoman", Font.BOLD, 17);
        
        //Apply fonts
        //Font1
        headerLabel.setFont(myFont1);
        
        //Font2
        bloodBox.setFont(myFont2);
        typeLabel.setFont(myFont2);
        
        //Font3
        bloodLabel.setFont(myFont3);
        
        ////////////////////// BORDERS /////////////////////////
        //Build borders
        border1 = BorderFactory.createRaisedBevelBorder();
        border2 = BorderFactory.createLoweredBevelBorder();
        
        //Apply border1
        headerPanel.setBorder(border1);
        footerPanel.setBorder(border1);
        
        //Apply border2
        middlePanel.setBorder(border2);
        bloodPanel.setBorder(border2);
        
        //Create titled border
        titledBorder = BorderFactory.createTitledBorder("Compatible donor blood types");
        bloodPanel.setBorder(titledBorder);
        
        ////////////////////////////// FRAME ctnd. ////////////////
        //Pos and size of frame
        mainFrame.setBounds(100, 100, 365, 370);
        //Set visibility
        mainFrame.setVisible(true);
    }
    
    //Implement action performed method from action listener
    //This is called everytime we click on a button
    public void actionPerformed(ActionEvent event) 
    {
        //Initialise the selected combo box value
        String bloodType;
        
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
         
        //Show compatibility table in a new window
        if (event.getSource() == tableButton) 
        {
            //Build image
            ImageIcon table = new ImageIcon("table.png");
             
            //Build option pane
            JOptionPane.showMessageDialog(null,"√  = Possible match \nX = No match possible","Blood Type Compatibility Table", JOptionPane.INFORMATION_MESSAGE, table);
        }
        else
         
        //When a selection is made in the combo box
        if (event.getSource() == bloodBox)
        {
            //First make sure the label is empty 
            bloodLabel.setText("");
             
            //Get the selected string from the combo box
            bloodType = (String) bloodBox.getSelectedItem();
             
            //Check which item is selected and change the label to show the compatible blood types
            if (bloodType.equals("O-")) 
            {
                bloodLabel.setText("O-");
            }
            else
             
            if (bloodType.equals("O+")) 
            {
                bloodLabel.setText("O- and O+");
            }
            else
             
            if (bloodType.equals("A-")) 
            {
                bloodLabel.setText("O- and A-");
            }
            else
             
            if (bloodType.equals("A+")) 
            {
                bloodLabel.setText("O-, O+, A- and A+");
            }
            else
             
            if (bloodType.equals("B-")) 
            {
                bloodLabel.setText("O- and B-");
            }
            else
             
            if (bloodType.equals("B+")) 
            {
                bloodLabel.setText("O-, O+, B- and B+");
            }
            else
             
            if (bloodType.equals("AB-")) 
            {
                bloodLabel.setText("O-, A-, B- and AB-");
            }
            else
             
            if (bloodType.equals("AB+")) 
            {
                bloodLabel.setText("O-, O+, A-, A+, B-, B+, AB- and AB+");
            }
        }
    }
}

