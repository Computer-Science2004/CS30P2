package Skillbuilders;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StatsPart2of2GUI {

	private JFrame frame;
	private JTextField FileName;
	private JTextField StudentField;
	StudentData inputDialog = new StudentData();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatsPart2of2GUI window = new StatsPart2of2GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StatsPart2of2GUI() {
		initialize();
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 606, 492);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		FileName = new JTextField();
		FileName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) 
			{
				if(FileName.getText().equals("Enter file name here:"))
				{
					FileName.setText("");
				}
			}
		});
		FileName.setFont(new Font("Tahoma", Font.BOLD, 15));
		FileName.setText("Enter file name here");
		FileName.setBounds(37, 31, 273, 35);
		panel.add(FileName);
		FileName.setColumns(10);
		
		StudentField = new JTextField();
		StudentField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) 
			{
				if(StudentField.getText().equals("Enter number of students here"))
				{
					StudentField.setText("");
				}
			}
		});
		StudentField.setFont(new Font("Tahoma", Font.BOLD, 15));
		StudentField.setText("Enter number of students here");
		StudentField.setColumns(10);
		StudentField.setBounds(37, 77, 273, 35);
		panel.add(StudentField);
		
		JTextArea ResultArea = new JTextArea();
		ResultArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		ResultArea.setBackground(new Color(240, 240, 240));
		ResultArea.setBounds(10, 123, 570, 319);
		panel.add(ResultArea);
		
		JButton CreateData = new JButton("Create data file");
		CreateData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				
				
				
				if(fileName.isEmpty() || numStudents.Text.isEmpty())
				{
					JOptionPane.showMessageDialog(null, 
							"Please enter both file name and number of students. ", 
							"input Error", JOptionPane.WARNING_MESSAGE);
				}
				
				
				try
				{
					int numStu = Integer.parseInt(numStudentsText);
					
					StringBuilder studentData = new StringBuilder();
					
					for(int i = 0; i < numStu; i++)
					{
						int result = JOptionPane.showConfirmDialog(null,
								inputDialog,"Enter data for student " + (i + 1),
								JOptionPane.OK_CANCEL_OPTION);
						
						if(result != JOptionPane.OK_OPTION)
						{
							break;
						}
						
						String stuName = inputDialog.getStudentName().getText().trim();
						String score = inputDialog.getStudentScore().getText().trim();
						
						if(stuName.isEmpty() || score.isEmpty())
						{
							JOptionPane.showMessageDialog(null, 
									"Please enter both name and score for student. " + (i + 1), 
									"input Error", JOptionPane.WARNING_MESSAGE);
							
							i--;
							continue;
						}
						
						try
						{
							Double.parseDouble(score);
						}
						catch(NumberFormatException er)
						{
							JOptionPane.showMessageDialog(null,
									"Please enter a valid number for the score.",
									"Input Error", JOptionPane.WARNING_MESSAGE);
							
							i--;
							continue;
						}
						
						studentData.append(stuName).append(": ").append(score).append("\n");
						
						//Write to file
						
						File dataFile = new File(fileName);
						FileWriter out = new FileWriter(dataFile, true);
						BufferedWriter writeFile = new BufferedWriter(out);
						
						writeFile.write(stuName);
						writeFile.newLine();
						writeFile.write(score);
						writeFile.newLine();
						
						writeFile.close();
						out.close();
					} // closes for loop
					 	
					ResultArea.setText("Data written to file: " + fileName + "\\n\n");
					ResultArea.append("STUDENTS ENTERED:\n");
					ResultArea.append("------------------");
					ResultArea.append(studentData.toString());
					ResultArea.append("\nFile created successfully!");
					
				}
				catch(IOException ex)
				{
					JOptionPane.showMessageDialog(null,
							"File could not be created: " + ex.getMessage(),
							"File Error",
							JOptionPane.ERROR_MESSAGE);
				}
				catch(NumberFormatException er)
				{
					JOptionPane.showMessageDialog(null,
							"Please enter a valid number for the score.",
							"Input Error", JOptionPane.ERROR_MESSAGE);
				}
			
			}
		});
		CreateData.setFont(new Font("Tahoma", Font.BOLD, 15));
		CreateData.setBounds(320, 31, 169, 35);
		panel.add(CreateData);
		
		JButton AnalyzeScores = new JButton("Analyze scores");
		AnalyzeScores.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) 
			{
				if(StudentField.getText().equals("Enter number of students here"))
				{
					StudentField.setText("");
				}
			}
		});
		AnalyzeScores.setFont(new Font("Tahoma", Font.BOLD, 15));
		AnalyzeScores.setBounds(320, 77, 169, 35);
		panel.add(AnalyzeScores);
		
		
	}
}
