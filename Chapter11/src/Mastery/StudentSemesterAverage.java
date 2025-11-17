package Mastery;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class StudentSemesterAverage {

	private JFrame frame;
	private JTextField StuNameText;
	private JTextField GradeLevelText;
	private JTextField SemAvgText;
	private JTextField Gr1Text;
	private JTextField Gr2Text;
	private JTextField Gr3Text;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentSemesterAverage window = new StudentSemesterAverage();
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
	public StudentSemesterAverage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 540, 490);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel StuName = new JLabel("Student Name:");
		StuName.setFont(new Font("Tahoma", Font.BOLD, 14));
		StuName.setBounds(10, 0, 250, 26);
		panel.add(StuName);
		
		JLabel GradeLevel = new JLabel("Grade Level:");
		GradeLevel.setFont(new Font("Tahoma", Font.BOLD, 14));
		GradeLevel.setBounds(10, 25, 250, 26);
		panel.add(GradeLevel);
		
		JLabel SemNum = new JLabel("Semester Number");
		SemNum.setFont(new Font("Tahoma", Font.BOLD, 14));
		SemNum.setBounds(10, 51, 250, 26);
		panel.add(SemNum);
		
		JLabel Gr1 = new JLabel("Grade 1:");
		Gr1.setFont(new Font("Tahoma", Font.BOLD, 14));
		Gr1.setBounds(10, 76, 250, 26);
		panel.add(Gr1);
		
		JLabel Gr2 = new JLabel("Grade 2:");
		Gr2.setFont(new Font("Tahoma", Font.BOLD, 14));
		Gr2.setBounds(10, 102, 250, 26);
		panel.add(Gr2);
		
		JLabel Gr3 = new JLabel("Grade 3:");
		Gr3.setFont(new Font("Tahoma", Font.BOLD, 14));
		Gr3.setBounds(10, 128, 250, 26);
		panel.add(Gr3);
		
		JLabel Gr4 = new JLabel("Grade 4:");
		Gr4.setFont(new Font("Tahoma", Font.BOLD, 14));
		Gr4.setBounds(10, 154, 250, 26);
		panel.add(Gr4);
		
		JLabel Average = new JLabel("Average:");
		Average.setFont(new Font("Tahoma", Font.BOLD, 14));
		Average.setToolTipText("Average:");
		Average.setBounds(10, 180, 70, 26);
		panel.add(Average);
		
		StuNameText = new JTextField();
		StuNameText.setBounds(291, 5, 223, 23);
		panel.add(StuNameText);
		StuNameText.setColumns(10);
		
		GradeLevelText = new JTextField();
		GradeLevelText.setColumns(10);
		GradeLevelText.setBounds(291, 30, 223, 23);
		panel.add(GradeLevelText);
		
		SemAvgText = new JTextField();
		SemAvgText.setColumns(10);
		SemAvgText.setBounds(291, 56, 223, 23);
		panel.add(SemAvgText);
		
		Gr1Text = new JTextField();
		Gr1Text.setColumns(10);
		Gr1Text.setBounds(291, 81, 223, 23);
		panel.add(Gr1Text);
		
		Gr2Text = new JTextField();
		Gr2Text.setColumns(10);
		Gr2Text.setBounds(291, 107, 223, 23);
		panel.add(Gr2Text);
		
		Gr3Text = new JTextField();
		Gr3Text.setColumns(10);
		Gr3Text.setBounds(291, 133, 223, 23);
		panel.add(Gr3Text);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(291, 159, 223, 23);
		panel.add(textField_6);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 208, 504, 194);
		panel.add(textArea);
		
		JButton Save = new JButton("Save to File");
		Save.setFont(new Font("Tahoma", Font.BOLD, 11));
		Save.setBounds(114, 415, 139, 26);
		panel.add(Save);
		
		JButton Contents = new JButton("View File Contents");
		Contents.setFont(new Font("Tahoma", Font.BOLD, 11));
		Contents.setBounds(261, 415, 139, 26);
		panel.add(Contents);
		
		JLabel AvgDisplay = new JLabel("");
		AvgDisplay.setToolTipText("Average:");
		AvgDisplay.setFont(new Font("Tahoma", Font.BOLD, 14));
		AvgDisplay.setBounds(80, 180, 70, 26);
		panel.add(AvgDisplay);
	}
}
