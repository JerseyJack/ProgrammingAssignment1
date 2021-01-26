/**
 * A class to calculate commission owing to a Sales person.
 * 
 * Rules : 
 * 
 * Sales of : 0-19999 - 0% commission
 *            20000-30999 - 5%
 *            31000-45999 - 10%
 *            46000-59999 - 12%
 *            above 60000 - 15%
 *            
 * Author: Jack Reynolds
 * 
 * Date: 06/01/2020
 */

import javax.swing.*;        //JFrame, JPanel, JButton, and so fourth...
import javax.swing.border.*; //Border stuff
import java.awt.*;           //Font and color
import java.awt.event.*;     //Event-handling

public class CommissionCalc implements ActionListener
{
    //Data item definitions
    JFrame mainFrame;
    
    JPanel mainPanel,
           headerPanel,
           middlePanel,
           middlePanel2,
           footerPanel;
           
    JLabel headerLabel,
           nameLabel,
           salesLabelPrompt,
           welcomeLabel,
           dateLabel,
           instructionLabel,
           carsLabel,
           rule1Label,
           rule2Label,
           rule3Label,
           rule4Label,
           rule5Label,
           rulesLabel;
           
    JButton calcButton,
            refreshButton,
            printButton,
            exitButton;
            
    JTextField salesInput,
               nameInput,
               carsInput;
               
    JTextArea resultArea;
    
    JComboBox yearsBox,
              monthsBox,
              daysBox;
            
    Font myFont1,
         myFont2;
    
    Border border1,
           border2,
           titledBorder;
           
    
    //Constructor method
    public CommissionCalc() 
    {
        //Build frame
        mainFrame = new JFrame("Weekly Sales Commission Calculator");
        
        ////////////////////// PANELS ////////////////////////
        //Build panels
        mainPanel = new JPanel();
        headerPanel = new JPanel();
        middlePanel = new JPanel();
        middlePanel2 = new JPanel();
        footerPanel = new JPanel();
        //Use absolute postioning on all panels
        mainPanel.setLayout(null);
        headerPanel.setLayout(null);
        middlePanel.setLayout(null);
        middlePanel2.setLayout(null);
        footerPanel.setLayout(null);
        
        //Put mainPanel onto frame
        mainFrame.add(mainPanel);
        
        //Pos and size of header panel
        headerPanel.setBounds(10, 20, 565, 50);
        //Put headerPanel onto mainPanel
        mainPanel.add(headerPanel);
        
        //Pos and size of middle panel
        middlePanel.setBounds(10, 90, 282, 350);
        //Put middlePanel onto mainPanel
        mainPanel.add(middlePanel);
        
        //Pos and size of middle panel 2
        middlePanel2.setBounds(292, 90, 282, 350);
        //Put middlePanel2 onto mainPanel
        mainPanel.add(middlePanel2);
        //Set to not visible
        middlePanel2.setVisible(false);
        
        //Pos and size of footer panel
        footerPanel.setBounds(10, 460, 565, 50);
        //Put middlePanel onto mainPanel
        mainPanel.add(footerPanel);
        
        ///////////////////// LABELS //////////////////////////
        //Build labels
        headerLabel = new JLabel("Commission Calculator");
        salesLabelPrompt = new JLabel("Weekly Sales Value:");
        nameLabel = new JLabel("Enter your name :");
        welcomeLabel = new JLabel ("");
        dateLabel = new JLabel("Date (DD/MM/YYY) :");
        carsLabel = new JLabel("Car sales :");
        
        //RULES LABELS
        rule1Label = new JLabel("£0 - £19,999 = 0%");
        rule2Label = new JLabel("£20,000 - £30,999 = 5%");
        rule3Label = new JLabel("£31,000 - £45,999 = 10%");
        rule4Label = new JLabel("£46,000 - £59,999 = 12%");
        rule5Label = new JLabel("£60,000+ = 15%");
        rulesLabel = new JLabel("Rules:");
        instructionLabel = new JLabel("Please enter the required information.");
        
        //Bounds of RULES LABELS
        rule1Label.setBounds(320, 145, 260, 25);
        rule2Label.setBounds(320, 170, 260, 25);
        rule3Label.setBounds(320, 195, 260, 25);
        rule4Label.setBounds(320, 220, 260, 25);
        rule5Label.setBounds(320, 245, 260, 25);
        rulesLabel.setBounds(320, 120, 260, 25);
        instructionLabel.setBounds(320, 80, 260, 50);
        
        //Add RULES LABELS to main panel
        mainPanel.add(rule1Label);
        mainPanel.add(rule2Label);
        mainPanel.add(rule3Label);
        mainPanel.add(rule4Label);
        mainPanel.add(rule5Label);
        mainPanel.add(rulesLabel);
        mainPanel.add(instructionLabel);
        
        //Pos and size of header label
        headerLabel.setBounds(100, 7, 500, 30);
        //Add header label to header panel
        headerPanel.add(headerLabel);
        
        //Pos and size of sales label
        salesLabelPrompt.setBounds(10, 135, 150, 25);
        //Add sales label to middle panel
        middlePanel.add(salesLabelPrompt);
        
        //Name label pos and size
        nameLabel.setBounds(10, 30, 150, 25);
        //Add name label
        middlePanel.add(nameLabel);
        
        //Date lable
        dateLabel.setBounds(10, 65, 150, 25);
        //Add to panel
        middlePanel.add(dateLabel);
        
        //welcomeLabel pos and size
        welcomeLabel.setBounds(10, 30, 260, 25);
        //Add to panel
        middlePanel2.add(welcomeLabel);
        
        //Car label pos and size
        carsLabel.setBounds(10, 100, 150, 25);
        //Add to middle panel
        middlePanel.add(carsLabel);
        
        ////////////////////////// BUTTONS /////////////////////////
        //Build buttons
        calcButton = new JButton("Calculate Commission");
        refreshButton = new JButton("Refresh");
        exitButton = new JButton("Exit");
        printButton = new JButton("Print");
        
        //Pos and size of buttons
        calcButton.setBounds(10, 10, 200, 30);
        refreshButton.setBounds(230, 10, 200, 30);
        exitButton.setBounds(450, 10, 100, 30);
        printButton.setBounds(10, 270, 260, 25);
        
        //Add buttons to footer panel
        footerPanel.add(calcButton);
        footerPanel.add(refreshButton);
        footerPanel.add(exitButton);
        middlePanel2.add(printButton);
        
        //Register buttons for an action event 
        calcButton.addActionListener(this);
        refreshButton.addActionListener(this);
        exitButton.addActionListener(this);
        printButton.addActionListener(this);
        
        ////////////////////////// INPUTS //////////////////////
        //Build text field
        salesInput = new JTextField("");
        //Name field
        nameInput = new JTextField("");
        //Cars field
        carsInput = new JTextField("");
             
        //Pos and size of input
        salesInput.setBounds(135, 135, 135, 25);
        nameInput.setBounds(135, 30, 135, 25);
        carsInput.setBounds(135, 100, 135, 25);
        //Add to middle
        middlePanel.add(salesInput);
        middlePanel.add(nameInput);
        middlePanel.add(carsInput);
        
        ////////////////////////// DATE PICKER //////////////////////
        // Create comboboxs
        yearsBox = new JComboBox();
        monthsBox = new JComboBox();
        daysBox = new JComboBox();
        
        // Put years into the combo box
          for (int year = 1970; year <= 2020; year ++ )
            {
                // Add year to combo box
                yearsBox.addItem (String.valueOf(year) );
            }
            
            // Put months into the combo box
          for (int month = 1; month <= 12; month ++ )
            {
                // Add year to combo box
                monthsBox.addItem (String.valueOf(month) );
            }
            
            // Put days into the combo box
          for (int day = 1; day <= 31; day ++ )
            {
                // Add year to combo box
                daysBox.addItem (String.valueOf(day) );
            }
            
         //Add combo boxes to panel
         middlePanel.add(yearsBox);
         middlePanel.add(monthsBox);
         middlePanel.add(daysBox);
         
         //Size and pos of combo boxes
         daysBox.setBounds(135, 65, 40, 25);
         monthsBox.setBounds(175, 65, 40, 25);
         yearsBox.setBounds(215, 65, 55, 25);
         
        
        //////////////////////// TEXT AREA /////////////////////////
        //Build text area
        resultArea = new JTextArea();
        
        //Make it non-editable
        resultArea.setEditable(false);
        
        //Result area pos and size
        resultArea.setBounds(10, 65, 260, 200);
        //Add result area
        middlePanel2.add(resultArea);
        
        //Set to non-visible
        resultArea.setVisible(false);
        ////////////////////// FONTS //////////////////////////
        //Build fonts
        myFont1 = new Font("TimesRoman", Font.BOLD, 30);
        myFont2 = new Font("TimesRoman", Font.BOLD, 15);
        
        //Apply fonts
        //Font 1
        headerLabel.setFont(myFont1);
        
        //Font 2
        calcButton.setFont(myFont2);
        refreshButton.setFont(myFont2);
        exitButton.setFont(myFont2);
        salesInput.setFont(myFont2);
        nameInput.setFont(myFont2);
        carsInput.setFont(myFont2);
        resultArea.setFont(myFont2);
        welcomeLabel.setFont(myFont2);
        
        ////////////////////// BORDERS /////////////////////////
        //Build borders
        border1 = BorderFactory.createRaisedBevelBorder();
        border2 = BorderFactory.createLoweredBevelBorder();
        
        //Border 1
        headerPanel.setBorder(border1);
        footerPanel.setBorder(border1);
        
        //Border 2
        middlePanel.setBorder(border2);
        middlePanel2.setBorder(border2);
        
        //Create titled border
        titledBorder = BorderFactory.createTitledBorder("Commission Slip");
        //Add to text area
        resultArea.setBorder(titledBorder);
        
        ////////////////////////////// FRAME ctnd. ////////////////
        //Pos and size of frame
        mainFrame.setBounds(100, 100, 600, 560);
        //Set visibility
        mainFrame.setVisible(true);
    }
    
    //Implement action performed method from action listener
    //This is called everytime we click on a button
    public void actionPerformed(ActionEvent event) 
    {
        //Define variables used here
        String name;
        String carsno;
        String str;
        String day;
        //Date variables
        int dayValue;
        String month;
        int monthValue;
        String year;
        int yearValue;
        //Sales variables
        int salesValue = 0;
        double rate = 0,
               commission = 0;
        resultArea.setForeground(Color.black);
        
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
        
        //Decide if refresh button is clicked
        if (event.getSource() == refreshButton)
        {
            //Clear inputs and labels
            salesInput.setText("");
            resultArea.setText("");
            nameInput.setText("");
            welcomeLabel.setText("");
            carsInput.setText("");
            
            //Dates back to default
            daysBox.setSelectedItem("1");
            monthsBox.setSelectedItem("1");
            yearsBox.setSelectedItem("1970");
            
            //Set result and panel back to not visible
            resultArea.setVisible(false);
            middlePanel2.setVisible(false);
            
            //Set foreground back to black in the case of error
            resultArea.setForeground(Color.black);
        }
    
        else 
        //Decide if calculation button is clicked
        if (event.getSource() == calcButton)
        { 
            
            //Read the contents of the name text field
            name = nameInput.getText();
            
            //Read contents of the car number
            carsno = carsInput.getText();
             
            //Read the contents of the sales textfield
            str = salesInput.getText();
            //Convert to a number
            salesValue = Integer.valueOf(str);
            
            //Read the contents of the date boxes
            day = (String) daysBox.getSelectedItem();
            //Convert to a number
            dayValue = Integer.valueOf(day);
            
            month = (String) monthsBox.getSelectedItem();
            //Convert to a number
            monthValue = Integer.valueOf(month);
            
            year = (String) yearsBox.getSelectedItem();
            //Convert to a number
            yearValue = Integer.valueOf(year);
             //Decide is sales values is < 0
            if (salesValue < 0)
            {
                //Alert user that values cannot be less than 0
                resultArea.setForeground(Color.red);
                resultArea.append("Sales value cannot be less than 0.\nPlease enter a supported value.");
                
                //Welcome label appears
                welcomeLabel.setText("Welcome, " + name + "!");
                    
                //Set result and panel to visible
                resultArea.setVisible(true);
                middlePanel2.setVisible(true);
            }
            
            else
                      
            //Decide the rate of commission
            if (salesValue > 0 && salesValue <= 19999)
            {
                rate = 0;
            }
            else 
               
            if (salesValue >= 20000 && salesValue <= 30999) 
            {
                rate = 5;
            }
            else 
                  
            if (salesValue >= 31000 && salesValue <= 45999) 
            {
                rate = 10;
            }
            else
              
            if (salesValue >= 46000 && salesValue <= 59999) 
            {
                rate = 12;
            }
            else
                    
            if (salesValue >= 60000)  
            {
                rate = 15;
            }
              
            if (salesValue >= 0)
            {
                //Calculate commission
                commission = salesValue * rate / 100;
                   
                //Welcome label appears
                welcomeLabel.setText("Welcome, " + name + "!");
                   
                //Set result and panel to visible
                resultArea.setVisible(true);
                middlePanel2.setVisible(true);
                   
                //Output the applicable rate and the commission owing
                resultArea.append("Name: " + name + "\n" + 
                                  "Date: " + dayValue + "/" + monthValue + "/" + yearValue + "\n" +
                                  "Sale: £" + str + "\n" +
                                  "No. of Cars: " + carsno + "\n" +
                                  "Rate: " + rate + "%\n"  + 
                                  "Commission: £" + commission);
            }
        }
    }
}
