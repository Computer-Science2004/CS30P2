package Skillbuilders;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import java.util.Random;

public class Roll {

    private JFrame frame;
    private JLabel Image;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Roll window = new Roll();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Roll() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 260, 368);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        Image = new JLabel();
        Image.setBounds(10, 11, 225, 225);
        frame.getContentPane().add(Image);

        JButton btnNewButton = new JButton("Roll Die");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnNewButton.setBounds(72, 247, 101, 32);
        frame.getContentPane().add(btnNewButton);

        // Get random number between 1-6
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                int newRoll = rand.nextInt(6) + 1; // 1–6

                // Build path string like your Demo314
                String path = "../Chapter10/src/Images/Dice_" + newRoll + ".png";
                Image.setIcon(new ImageIcon(path));
            }
        });
    }
}
