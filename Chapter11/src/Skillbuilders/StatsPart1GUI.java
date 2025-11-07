package Skillbuilders;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
public class StatsPart1GUI {
	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatsPart1GUI window = new StatsPart1GUI();
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
	public StatsPart1GUI() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 398);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel titleLabel = new JLabel("Student Test Scores");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 20));
		titleLabel.setBounds(10, 0, 414, 55);
		panel.add(titleLabel);
		
		JTextArea resultArea = new JTextArea();
		resultArea.setBackground(new Color(240, 240, 240));
		resultArea.setRows(15);
		resultArea.setColumns(40);
		resultArea.setEditable(false);
		resultArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		resultArea.setForeground(new Color(240, 240, 240));
		resultArea.setBounds(10, 59, 414, 209);
		panel.add(resultArea);
		
		JButton analyzeButton = new JButton("Analyze Scores");
		analyzeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
			
				// Clear previous results
				resultArea.setText("");
				
				File dataFile = new File("..\\Chapter11/src/Skillbuilders/test.txt");
				FileReader in;
				BufferedReader readFile;
				
				String stuName, score;
				double scoreValue;
				
				double lowscore = 100;
				double highScore = 0;
				double avgScore;
				double totalScore = 0;
				int numScores = 0;
			
				NumberFormat percent = NumberFormat.getPercentInstance();
				
				StringBuilder output = new StringBuilder();
				
				try
				{
				in = new FileReader(dataFile);
			    readFile = new BufferedReader(in);
			    
			    output.append("STUDENT SCORES: \n");
			    output.append("----------------------");
			    
			    while((stuName = readFile.readLine()) != null)
		        {
			          score = readFile.readLine();
			          numScores += 1;
			          scoreValue = Double.parseDouble(score);
			          
			          output.append(stuName + " " + percent.format(scoreValue/100) + "\n");
			          totalScore += scoreValue;
			          
			          if(scoreValue < lowscore)
			          {
			        	  lowscore = scoreValue;
			          }
			          if(scoreValue > highScore)
			          {
			        	  highScore = scoreValue;
			          }
			     
			          
		        }
					
					
			    avgScore = totalScore / numScores;
			    
			    output.append("\n STATISTICS:\n");
			    output.append("--------------------");
			    
			    output.append("Low Score: " + percent.format(lowscore/100) + "\n");
			    output.append("High Score: " + percent.format(highScore/100) + "\n");
			    output.append("Average Score: " + percent.format(avgScore/100) + "\n");
			    output.append("Total Score: " + numScores + "\n");
			    
			    resultArea.setText(output.toString());
			    
			    readFile.close();
			    in.close();
			    
				}
				catch(FileNotFoundException ex)
				{
					System.out.println("File could not be found.");
					System.err.println("FileNotFoundException: " + ex.getMessage());
				}
				catch(IOException ex)
				{
					System.out.println("Problem reading the file.");
					System.err.println("IOException: " + ex.getMessage());
				}
			
			}
		});
		analyzeButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		analyzeButton.setBounds(67, 279, 299, 69);
		panel.add(analyzeButton);
	}
}

