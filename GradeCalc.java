/**
 * A class to calculate the grade based on given exam results.
 * 
 * Rules : 0 - 39 = F (unless grade is exactly 39, in which case will be rounded up to 40)
 *         40 - 49 = C
 *         50 - 59 = B
 *         60 - 69 = B+
 *         70 - 100 = A
 *         
 *         If either component of the course if below 15, no matter the score of the other
 *         component, the total will default to 39 as a technical fail.
 *         
 * 
 *            
 * Author: Jack Reynolds
 * 
 * Date: 13/01/2020
 */

import javax.swing.*;        //JFrame, JPanel, JButton, and so fourth...
import javax.swing.border.*; //Border stuff
import java.awt.*;           //Font and color
import java.awt.event.*;     //Event-handling

public class GradeCalc implements ActionListener
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
           pointsLabel,
           welcomeLabel,
           dateLabel,
           instructionLabel,
           courseLabel,
           courseWorkLabel,
           gradeALabel,
           gradeBLabel,
           gradeBPlusLabel,
           gradeCLabel,
           gradeFLabel,
           techFLabel,
           techFLabel2,
           rulesLabel;
           
    JButton calcButton,
            refreshButton,
            printButton,
            exitButton;
            
    JTextField examInput,
               courseWorkInput,
               nameInput,
               courseInput;
               
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
    public GradeCalc() 
    {
        //Build frame
        mainFrame = new JFrame("Grade Calculator");
        
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
        headerLabel = new JLabel("Grade Calculator");
        pointsLabel = new JLabel("Exam Points :");
        nameLabel = new JLabel("Enter your name :");
        welcomeLabel = new JLabel ("");
        dateLabel = new JLabel("Date (DD/MM/YYY) :");
        courseLabel = new JLabel("Course :");
        courseWorkLabel = new JLabel("Courework Points :");
        
        //RULES LABELS
        gradeALabel = new JLabel("A = 70% - 100%");
        gradeBLabel = new JLabel("B = 60% - 69%");
        gradeBPlusLabel = new JLabel("B+ = 50% - 59%");
        gradeCLabel = new JLabel("C = 40% - 49%");
        gradeFLabel = new JLabel("F = 0% - 39%");
        techFLabel = new JLabel("Technical Fail = If at least one compenent");
        techFLabel2 = new JLabel("                            does not surpass 15 points.");
        rulesLabel = new JLabel("Rules:");
        instructionLabel = new JLabel("Please enter the required information.");
        
        //Bounds of RULES LABELS
        gradeALabel.setBounds(320, 145, 260, 25);
        gradeBLabel.setBounds(320, 170, 260, 25);
        gradeBPlusLabel.setBounds(320, 195, 260, 25);
        gradeCLabel.setBounds(320, 220, 260, 25);
        gradeFLabel.setBounds(320, 245, 260, 25);
        techFLabel.setBounds(320, 270, 260, 25);
        techFLabel2.setBounds(320, 285, 260, 25);
        rulesLabel.setBounds(320, 120, 260, 25);
        instructionLabel.setBounds(320, 80, 260, 50);
        
        //Add RULES LABELS to main panel
        mainPanel.add(gradeALabel);
        mainPanel.add(gradeBLabel);
        mainPanel.add(gradeBPlusLabel);
        mainPanel.add(gradeCLabel);
        mainPanel.add(gradeFLabel);
        mainPanel.add(rulesLabel);
        mainPanel.add(techFLabel);
        mainPanel.add(techFLabel2);
        mainPanel.add(instructionLabel);
        
        //Pos and size of header label
        headerLabel.setBounds(160, 7, 500, 30);
        //Add header label to header panel
        headerPanel.add(headerLabel);
        
        //Pos and size of point label
        pointsLabel.setBounds(10, 135, 150, 25);
        //Add sales label to middle panel
        middlePanel.add(pointsLabel);
        
        //Coursework label pos and size
        courseWorkLabel.setBounds(10, 170, 150, 25);
        //Add to middle panel
        middlePanel.add(courseWorkLabel);
        
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
        
        //Pos and size of course label
        courseLabel.setBounds(10, 100, 150, 25);
        //Add to middle panel
        middlePanel.add(courseLabel);
        
        ////////////////////////// BUTTONS /////////////////////////
        //Build buttons
        calcButton = new JButton("Calculate Grade");
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
        examInput = new JTextField("");
        //Name field
        nameInput = new JTextField("");
        //Course field
        courseInput = new JTextField("");
        //Coursework field
        courseWorkInput = new JTextField("");
             
        //Pos and size of input
        examInput.setBounds(135, 135, 135, 25);
        nameInput.setBounds(135, 30, 135, 25);
        courseInput.setBounds(135, 100, 135, 25);
        courseWorkInput.setBounds(135, 170, 135, 25);
        
        //Add to middle
        middlePanel.add(examInput);
        middlePanel.add(nameInput);
        middlePanel.add(courseInput);
        middlePanel.add(courseWorkInput);
        
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
        examInput.setFont(myFont2);
        courseWorkInput.setFont(myFont2);
        nameInput.setFont(myFont2);
        resultArea.setFont(myFont2);
        courseInput.setFont(myFont2);
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
        titledBorder = BorderFactory.createTitledBorder("Exam Results");
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
        String str;
        String str2;
        String course;
        //Date variables
        String day;
        int dayValue;
        String month;
        int monthValue;
        String year;
        int yearValue;
        //Grade variables
        double totalValue = 0;
        double examMark = 0;
        double courseWorkMark = 0;
        String grade;
        grade = null;
        
        //Result area to start as black text
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
            examInput.setText("");
            resultArea.setText("");
            nameInput.setText("");
            welcomeLabel.setText("");
            courseInput.setText("");
            courseWorkInput.setText("");

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
              
            //Read contents of course text field
            course = courseInput.getText();
               
            //Read the contents of the exam textfield
            str = examInput.getText();
            //Convert to a number
            examMark = Double.valueOf(str);
              
            //Read the contents of the coursework textfield
            str2 = courseWorkInput.getText();
            //Convert to a number
            courseWorkMark = Double.valueOf(str2);
              
            //Exam value is double the exam mark as there are 50 total points
            //Both exams can only go up to 50 marks so full marks on both would be 100% anyway
            //Therefore, it is only required to add the two values together
            totalValue = examMark + courseWorkMark;
              
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
              
            //Decide is exam mark is < 0
            if (examMark < 0)
            {
                //Alert the user that the exam points cannot be negative
                resultArea.setForeground(Color.red);
                resultArea.append("Exam points cannot be less \nthan 0.\nPlease enter a supported value.");
                  
                //Welcome label appears
                welcomeLabel.setText("Candidate: " + name);
                      
                //Set result and panel to visible
                resultArea.setVisible(true);
                middlePanel2.setVisible(true);
            }
            else
              
            //Decide if mark is above 50
            if (examMark > 50)
            {
                //Alert the user that the exam points cannot exceed 50 
                resultArea.setForeground(Color.red);
                resultArea.append("Exam points cannot exceed 50.\nPlease enter a supported value.");
                
                //Welcome label appears
                welcomeLabel.setText("Candidate: " + name);
                      
                //Set result and panel to visible
                resultArea.setVisible(true);
                middlePanel2.setVisible(true);
            }
              
            //Decide is coursework points are less than 0
            if (courseWorkMark < 0)
            {
                //Alert the user that the coursework points cannot be nagative
                resultArea.setForeground(Color.red);
                resultArea.append("Coursework points cannot be less \nthan 0.\nPlease enter a supported value.");
                  
                //Welcome label appears
                welcomeLabel.setText("Candidate: " + name);
                      
                //Set result and panel to visible
                resultArea.setVisible(true);
                middlePanel2.setVisible(true);
            }
            else
              
            //Decide if coursework points are more than 50
            if (courseWorkMark > 50)
            {
                //Alert the user that the coursework points cannot exceed 50
                resultArea.setForeground(Color.red);
                resultArea.append("Coursework points cannot \nexceed 50. \nPlease enter a supported value.");
                  
                //Welcome label appears
                welcomeLabel.setText("Candidate: " + name);
                      
                //Set result and panel to visible
                resultArea.setVisible(true);
                middlePanel2.setVisible(true);
            }
              
            //Check for fail or technical fail
            if (totalValue > 0)
            {
                //If total is 39, round up to 40
                if (totalValue == 39)
                {
                    totalValue = 40;
                }
                  
                //Check individual marks for exam and coursework
                if (totalValue >= 40 && courseWorkMark <= 14)
                {
                    totalValue = 39;
                    grade = "Technical Fail";
                }
                else
                  
                if (totalValue >= 40 && examMark <= 14)
                {
                    totalValue = 39;
                    grade = "Technical Fail";
                }
                else
                
                if (totalValue <= 39)
                {
                    grade = "F";  
                }
            }
              
            //Decide the grade     
            if (totalValue >= 40 && totalValue <= 49) 
            {
                grade = "C";
            }
            else 
                  
            if (totalValue >= 50 && totalValue <= 59) 
            {
                grade = "B";
            }
            else
              
            if (totalValue >= 60 && totalValue <= 69) 
            {
                grade = "B+";
            }
            else
                    
            if (totalValue >= 70 && totalValue <= 100)  
            {
                grade = "A";
            }
              
            //Check if a valid score has been given then give the grade
            if (examMark >= 0 && examMark <= 50 && courseWorkMark >= 0 && courseWorkMark <= 50)
            {
                //Welcome label appears
                welcomeLabel.setText("Candidate: " + name);
                      
                //Set result and panel to visible
                resultArea.setVisible(true);
                middlePanel2.setVisible(true);
                      
                //Output the applicable grade and the commission owing
                resultArea.append("Name: " + name + "\n" + 
                                  "Date: " + dayValue + "/" + monthValue + "/" + yearValue + "\n" +
                                  "Course: " + course + "\n" +
                                  "Exam Points: " + str + "\n" +
                                  "Coursework Points: " + str2 + "\n" +
                                  "Percentage: " + totalValue + "%\n"  + 
                                  "Grade Earned: " + grade);                   
            }
        }
    }
}
