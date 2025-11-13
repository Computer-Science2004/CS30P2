package Skillbuilders;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class StatsPart2of2GUI {

	private JFrame frame;
	private JTextField txtEnterFileName;
	private JTextField txtEnterNumberOf;

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
		
		txtEnterFileName = new JTextField();
		txtEnterFileName.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtEnterFileName.setText("Enter file name here");
		txtEnterFileName.setBounds(37, 31, 273, 35);
		panel.add(txtEnterFileName);
		txtEnterFileName.setColumns(10);
		
		txtEnterNumberOf = new JTextField();
		txtEnterNumberOf.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtEnterNumberOf.setText("Enter number of students here");
		txtEnterNumberOf.setColumns(10);
		txtEnterNumberOf.setBounds(37, 77, 273, 35);
		panel.add(txtEnterNumberOf);
		
		JButton btnNewButton = new JButton("Create data file");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(320, 31, 169, 35);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Analyze scores");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(320, 77, 169, 35);
		panel.add(btnNewButton_1);
	}
}
