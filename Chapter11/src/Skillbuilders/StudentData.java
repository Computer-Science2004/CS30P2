package Skillbuilders;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class StudentData extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField StudentName;
	private JTextField StudentScore;

	/**
	 * Create the panel.
	 */
	public StudentData() {
		setLayout(null);
		
		StudentName = new JTextField();
		StudentName.setBounds(0, 0, 400, 35);
		StudentName.setFont(new Font("Tahoma", Font.BOLD, 15));
		StudentName.setText("Enter student name");
		add(StudentName);
		StudentName.setColumns(10);
		
		StudentScore = new JTextField();
		StudentScore.setBounds(0, 40, 400, 40);
		StudentScore.setFont(new Font("Tahoma", Font.BOLD, 15));
		StudentScore.setText("Enter student score");
		StudentScore.setColumns(10);
		add(StudentScore);

	}

	public JTextField getStudentName() {
		return StudentName;
	}
	public JTextField getStudentScore() {
		return StudentScore;
	}
}
