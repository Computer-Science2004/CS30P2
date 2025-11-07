package SkillBuilders;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import java.util.Random;

public class Roll {

    private JFrame frame;
    private JLabel dice1Label;
    private JLabel dice2Label;

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
        frame = new JFrame("Roll Dice");
        frame.setBounds(100, 100, 500, 350); // wider to fit 2 dice
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // first die
        dice1Label = new JLabel();
        dice1Label.setBounds(20, 20, 225, 225); // 225x225 size
        frame.getContentPane().add(dice1Label);

        // second die
        dice2Label = new JLabel();
        dice2Label.setBounds(250, 20, 225, 225); // placed beside first die
        frame.getContentPane().add(dice2Label);

        JButton btnRoll = new JButton("Roll Dice");
        btnRoll.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnRoll.setBounds(180, 260, 140, 40); // centered under dice
        frame.getContentPane().add(btnRoll);

        btnRoll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();

                int roll1 = rand.nextInt(6) + 1; // 1–6
                int roll2 = rand.nextInt(6) + 1; // 1–6

                String path1 = "../Chapter10/src/Images/Dice_" + roll1 + ".png";
                String path2 = "../Chapter10/src/Images/Dice_" + roll2 + ".png";

                dice1Label.setIcon(new ImageIcon(path1));
                dice2Label.setIcon(new ImageIcon(path2));
            }
        });
    }
}
