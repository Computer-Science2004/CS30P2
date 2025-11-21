/*
Program: StudentSemesterAverage GUI
Java Last Date of this Revision: November 20, 2025
Purpose: This application allows a person to enter four grades, calculate the average,
and save the results to a text file. The user may also view the saved file.
Author: Hielan Lee-Tremblay
School: CHHS
Course: Computer Programming 30
*/

package Mastery;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.io.FileWriter;
import java.io.File;
import java.util.Scanner;


// Class
public class StudentSemesterAverage
{

    // Constant. File name used for saving student data in (private so it is only in this class)

    private static final String FILE_NAME = "studentData.txt";


    // GUI fields (Components that make the GUI)
    
    private JFrame frame;
    private JTextField studentNameText;
    private JTextField gradeLevelText;
    private JTextField semesterNumberText;
    private JTextField grade1Text;
    private JTextField grade2Text;
    private JTextField grade3Text;
    private JTextField grade4Text;
    private JLabel averageDisplay;
    private JTextArea textArea;

  
    // Main method (public)
    
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    StudentSemesterAverage window = new StudentSemesterAverage();
                    window.frame.setVisible(true);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    
    // StudentSemesterAverage method calls the initialize method to make the window
    
    public StudentSemesterAverage()
    {
        initialize();
    }

    // Builds GUI components
    
    private void initialize()
    {
        frame = new JFrame();
        frame.setBounds(100, 100, 580, 491);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        
        // ------------------ LABELS ------------------
        JLabel studentName = new JLabel("Student Name:");
        studentName.setFont(new Font("Tahoma", Font.BOLD, 14));
        studentName.setBounds(10, 0, 250, 26);
        panel.add(studentName);

        JLabel gradeLevel = new JLabel("Grade Level:");
        gradeLevel.setFont(new Font("Tahoma", Font.BOLD, 14));
        gradeLevel.setBounds(10, 25, 250, 26);
        panel.add(gradeLevel);

        JLabel semesterNumber = new JLabel("Semester Number:");
        semesterNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
        semesterNumber.setBounds(10, 51, 250, 26);
        panel.add(semesterNumber);

        JLabel grade1 = new JLabel("Grade 1:");
        grade1.setFont(new Font("Tahoma", Font.BOLD, 14));
        grade1.setBounds(10, 76, 250, 26);
        panel.add(grade1);

        JLabel grade2 = new JLabel("Grade 2:");
        grade2.setFont(new Font("Tahoma", Font.BOLD, 14));
        grade2.setBounds(10, 102, 250, 26);
        panel.add(grade2);

        JLabel grade3 = new JLabel("Grade 3:");
        grade3.setFont(new Font("Tahoma", Font.BOLD, 14));
        grade3.setBounds(10, 128, 250, 26);
        panel.add(grade3);

        JLabel grade4 = new JLabel("Grade 4:");
        grade4.setFont(new Font("Tahoma", Font.BOLD, 14));
        grade4.setBounds(10, 154, 250, 26);
        panel.add(grade4);

        JLabel averageLabel = new JLabel("Average:");
        averageLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        averageLabel.setBounds(10, 180, 70, 26);
        panel.add(averageLabel);

        
        // ------------------ TEXT FIELDS ------------------
        studentNameText = new JTextField();
        studentNameText.setBounds(234, 3, 320, 23);
        panel.add(studentNameText);

        gradeLevelText = new JTextField();
        gradeLevelText.setBounds(234, 28, 320, 23);
        panel.add(gradeLevelText);

        semesterNumberText = new JTextField();
        semesterNumberText.setBounds(234, 54, 320, 23);
        panel.add(semesterNumberText);

        grade1Text = new JTextField();
        grade1Text.setBounds(234, 79, 320, 23);
        panel.add(grade1Text);

        grade2Text = new JTextField();
        grade2Text.setBounds(234, 105, 320, 23);
        panel.add(grade2Text);

        grade3Text = new JTextField();
        grade3Text.setBounds(234, 131, 320, 23);
        panel.add(grade3Text);

        grade4Text = new JTextField();
        grade4Text.setBounds(234, 157, 320, 23);
        panel.add(grade4Text);

        textArea = new JTextArea();
        textArea.setBounds(10, 208, 544, 194);
        panel.add(textArea);

        averageDisplay = new JLabel("");
        averageDisplay.setFont(new Font("Tahoma", Font.BOLD, 14));
        averageDisplay.setBounds(80, 180, 200, 26);
        panel.add(averageDisplay);

        
        // ------------------ BUTTONS ------------------
        JButton saveButton = new JButton("Save to File");
        saveButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        saveButton.setBounds(114, 415, 139, 26);
        panel.add(saveButton);

        JButton viewButton = new JButton("View File Contents");
        viewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        viewButton.setBounds(261, 415, 139, 26);
        panel.add(viewButton);

        // ------------------ SAVE BUTTON ACTION ------------------
        saveButton.addActionListener(e -> // Action listener on the save button for when it is clicked
        {
        	// try runs code catch is for the errors
            try
            {
                // Information entered by the user
                String name = studentNameText.getText();
                String grade = gradeLevelText.getText();
                String sem = semesterNumberText.getText();

                // Converting the entered text (Strings) into numbers
                double g1 = Double.parseDouble(grade1Text.getText());
                double g2 = Double.parseDouble(grade2Text.getText());
                double g3 = Double.parseDouble(grade3Text.getText());
                double g4 = Double.parseDouble(grade4Text.getText());

                // Calculating average
                double avg = (g1 + g2 + g3 + g4) / 4.0;

                // Displays the average rounded to 2 decimal places
                averageDisplay.setText(String.format("%.2f", avg));

                /* Creates the studentData.txt file (true so that old data is not deleted)
                FileWriter is a class that writes text to a file */
                FileWriter writer = new FileWriter(FILE_NAME, true);

                /* writer.write takes Strings and writes it to a file.
                All of the information given by the user is displayed with \n at the end to create a new                         
                Line for each entry */
                writer.write("Name: " + name + ", Grade: " + grade +
                             ", Semester: " + sem +
                             ", Grades: " + g1 + ", " + g2 + ", " + g3 + ", " + g4 +
                             ", Average: " + avg + "\n");

                // Saves everything and closes the file
                writer.close(); 

                // Message telling the user there data was saved
                JOptionPane.showMessageDialog(frame, "Data saved successfully!");
            }
            // A message for any errors (Ex. entering letters in grades)
            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(frame, "Error: enter numbers for grades.");
            }
        });

        // ------------------ VIEW FILE BUTTON ACTION ------------------
        viewButton.addActionListener(e -> // Action listener on the view file contents button for when it is clicked
        {
            textArea.setText("");

            // try runs code catch is for the errors
            try
            {
            	// Reads the file studentData.txt line by line
                File file = new File(FILE_NAME);
                Scanner reader = new Scanner(file);

                while (reader.hasNextLine()) // Checks if there is another line in the file
                {
                    textArea.append(reader.nextLine() + "\n"); // Reads next line of text and displays them. \n puts each one on a new line.
                }

                // Closes the file
                reader.close(); 
            }
            // An error message for if the file doesn't exist
            catch (Exception ex)
            {
                textArea.setText("No data found yet.");
            }
        });
    }
}

