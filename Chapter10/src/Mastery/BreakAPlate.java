/*
Program: BreakAPlate.
Java Last Date of this Revision: November 7, 2025
Purpose: This application simulates a game booth at a carnival specifically the BreakAPlate game booth
Author: Hielan Lee-Tremblay,
School: CHHS
Course: Computer Programming 30
*/


package Mastery;


//imports
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.Random;
import java.awt.Color;


public class BreakAPlate {

	//GUI interface and buttons
    private JFrame Breakaplate; 
    private JLabel platesLabel; 
    private JLabel prizeLabel; 
    private JButton playButton; 

    
    // main method
    public static void main(String[] args) { 
        EventQueue.invokeLater(new Runnable() { // starts the GUI
            public void run() {
                try {
                    BreakAPlate window = new BreakAPlate();
                    window.Breakaplate.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    
    // BreakAPlate method calls the initialize method to make the window
    public BreakAPlate() { 
        initialize();
    }

    // initialize method sets up the window, loads images, creates labels, and adds the logic for when the user clicks play
    private void initialize() {
        Breakaplate = new JFrame("BreakAPlateGame"); // crates a JFrame called BreakAPlateGame
        Breakaplate.setTitle("BreakAPlate"); 
        Breakaplate.getContentPane().setBackground(new Color(255, 255, 255)); 
        Breakaplate.setBounds(100, 100, 600, 400); 
        Breakaplate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Breakaplate.getContentPane().setLayout(null);

        
        // all the images for prizes and plates
        // use the image path so that anyone can see that images.
        ImageIcon plates = new ImageIcon("../Chapter10/src/Images/plates.gif");
        ImageIcon platesTwoBroken = new ImageIcon("../Chapter10/src/Images/plates_two_broken.gif");
        ImageIcon platesAllBroken = new ImageIcon("../Chapter10/src/Images/plates_all_broken.gif");
        ImageIcon sticker = new ImageIcon("../Chapter10/src/Images/sticker.gif");
        ImageIcon tiger = new ImageIcon("../Chapter10/src/Images/tiger_plush.gif");

        
        // for the plates (starts with full plates image)
        platesLabel = new JLabel(plates); 
        platesLabel.setBounds(0, -45, 584, 227); 

        
        // for the prizes (starts empty because they haven't won anything yet)
        prizeLabel = new JLabel(); 
        prizeLabel.setBounds(239, 217, 122, 111);

        
        // button with Play/Play Again logic
        playButton = new JButton("Play");
        playButton.setBounds(239, 152, 122, 30);
        playButton.addActionListener(e -> {
            String currentText = playButton.getText(); // checks if the button says play or play again
            Random rand = new Random(); // random number generator from GameBooth **

            
            // if-else statement to determine what the user wins
            if (currentText.equals("Play")) {
                int result = rand.nextInt(2); // (generates 0 or 1)
                if (result == 0) { // if 0 they get a sticker
                    platesLabel.setIcon(platesTwoBroken);
                    prizeLabel.setIcon(sticker);
                } else { // if 1 they get a tiger
                    platesLabel.setIcon(platesAllBroken);
                    prizeLabel.setIcon(tiger);
                }
                playButton.setText("Play Again"); // sets button back to play again
            } else { 
                platesLabel.setIcon(plates);   // reset plates
                prizeLabel.setIcon(null);      // clear prize
                playButton.setText("Play");    // back to Play
            }
        });

        
        // puts everything back so the user can play again
        Breakaplate.getContentPane().add(playButton);
        Breakaplate.getContentPane().add(platesLabel);
        Breakaplate.getContentPane().add(prizeLabel);
    }
}
