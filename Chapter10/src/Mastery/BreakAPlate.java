package Mastery;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.Random;
import java.awt.Color;

public class BreakAPlate {

    private JFrame frame;
    private JLabel platesLabel;
    private JLabel prizeLabel;
    private JButton playButton;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BreakAPlate window = new BreakAPlate();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public BreakAPlate() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Break A Plate Game");
        frame.getContentPane().setBackground(new Color(255, 255, 255));
        frame.setBounds(100, 100, 600, 400); // bigger window so everything shows
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // images
        ImageIcon plates = new ImageIcon(getClass().getResource("/Images/plates.gif"));
        ImageIcon platesTwoBroken = new ImageIcon(getClass().getResource("/Images/plates_two_broken.gif"));
        ImageIcon platesAllBroken = new ImageIcon(getClass().getResource("/Images/plates_all_broken.gif"));
        ImageIcon sticker = new ImageIcon(getClass().getResource("/Images/sticker.gif"));
        ImageIcon tiger = new ImageIcon(getClass().getResource("/Images/tiger_plush.gif"));

        platesLabel = new JLabel(plates);
        platesLabel.setBounds(0, -45, 584, 227);
        prizeLabel = new JLabel();
        prizeLabel.setBounds(239, 217, 122, 111);

        // button
        playButton = new JButton("Play");
        playButton.setBounds(239, 159, 111, 23);
        playButton.addActionListener(e -> {
            Random rand = new Random();
            int result = rand.nextInt(2); // 0 or 1

            if (result == 0) {
                platesLabel.setIcon(platesTwoBroken);
                prizeLabel.setIcon(sticker);
            } else {
                platesLabel.setIcon(platesAllBroken);
                prizeLabel.setIcon(tiger);
            }
            playButton.setText("Play Again");
        });
        frame.getContentPane().setLayout(null);

        frame.getContentPane().add(playButton);
        frame.getContentPane().add(platesLabel);
        frame.getContentPane().add(prizeLabel);
    }
}
