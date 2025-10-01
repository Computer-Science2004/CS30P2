import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Demo314 {

	private JFrame frame;
	private JTextField FN;
	private JTextField LN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demo314 window = new Demo314();
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
	public Demo314() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		ImageIcon Western = new ImageIcon("../Chapter10/src/Images/Western.png");
		
		frame = new JFrame();
		frame.setBounds(100, 100, 587, 513);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 571, 474);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		
		FN = new JTextField();
		FN.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(FN.getText().equals("First Name"))
					FN.setText("");
			}
		});
		FN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(FN.getText().equals("First Name"))
					FN.setText("");
			}
		});
	
		
		FN.setForeground(new Color(0, 0, 0));
		FN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		FN.setText("First Name");
		FN.setBounds(32, 11, 110, 22);
		panel_1.add(FN);
		FN.setColumns(10);
		
		LN = new JTextField();
		LN.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(LN.getText().equals("Last Name"))
					LN.setText("");
			}
		});
		LN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				if(LN.getText().equals("Last Name"))
					LN.setText("");
			}
		});
		
		LN.setForeground(new Color(0, 0, 0));
		LN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LN.setText("Last Name");
		LN.setColumns(10);
		LN.setBounds(32, 44, 110, 22);
		panel_1.add(LN);
		
		JLabel IMG = new JLabel("");
		IMG.setBackground(new Color(255, 255, 255));
		IMG.setBounds(32, 300, 275, 163);
		panel_1.add(IMG);
		
		JComboBox Grade = new JComboBox();
		Grade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Grade.setModel(new DefaultComboBoxModel(new String[] {"Select Grade", "10", "11", "12"}));
		Grade.setBounds(32, 77, 110, 22);
		panel_1.add(Grade);
		
		JComboBox School = new JComboBox();
		School.setModel(new DefaultComboBoxModel(new String[] {"Select School", "Crescent Heights", "LB Pierson", "James Fowler", "Western"}));
		School.setFont(new Font("Tahoma", Font.PLAIN, 14));
		School.setBounds(32, 110, 110, 22);
		panel_1.add(School);
		
		JTextArea Dis = new JTextArea();
		Dis.setBackground(new Color(255, 255, 255));
		Dis.setBounds(32, 177, 468, 112);
		panel_1.add(Dis);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String fn = FN.getText();
				String ln = LN.getText();
				String grade = "";
				String school = "";
				
				//Grades
				if(Grade.getSelectedItem().equals("12"))
				{
					grade = "12";
				}
				else if(Grade.getSelectedItem().equals("11"))
				{
					grade = "11";
				}
				else
				{
					grade = "10";
				}
				
				//Schools
				if(School.getSelectedItem().equals("Crescent Heights"))
				{
					school = "Crescent Heights";
				}
				else if(School.getSelectedItem().equals("LB Pierson"))
				{
					school = "LB Pierson";
				}
				else if(School.getSelectedItem().equals("James Fowler"))
				{
					school = "James Fowler";
				}
				else
				{
					school = "Western";
					IMG.setIcon(Western);
				}
				
				
				
				Dis.setText(fn + " " + ln
						+ " is in grade " + grade + " and goes to " + school + ".");
			}
		
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(32, 143, 110, 23);
		panel_1.add(btnNewButton);
		
	}
}
