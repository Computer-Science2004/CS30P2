package SkillBuilders;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;   
import java.awt.event.ActionListener; 

public class SemesterAvg {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JLabel Dis; 

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SemesterAvg window = new SemesterAvg();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SemesterAvg() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1, 261);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Enter the first grade:");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel.setBounds(22, 44, 149, 33);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblEnterTheSecond = new JLabel("Enter the second grade:");
        lblEnterTheSecond.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblEnterTheSecond.setBounds(22, 88, 162, 33);
        frame.getContentPane().add(lblEnterTheSecond);

        JLabel lblNewLabel_1_1 = new JLabel("Enter the third grade:");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_1_1.setBounds(22, 132, 149, 33);
        frame.getContentPane().add(lblNewLabel_1_1);

        textField = new JTextField();
        textField.setBounds(218, 44, 176, 33);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(218, 89, 176, 33);
        frame.getContentPane().add(textField_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(218, 132, 176, 33);
        frame.getContentPane().add(textField_2);

        JButton btnNewButton = new JButton("Average");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnNewButton.setBounds(22, 192, 162, 40);
        frame.getContentPane().add(btnNewButton);

        Dis = new JLabel(""); 
        Dis.setBounds(218, 192, 176, 40);
        frame.getContentPane().add(Dis);

        // Part that calculates the average
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double g1 = Double.parseDouble(textField.getText());
                    double g2 = Double.parseDouble(textField_1.getText());
                    double g3 = Double.parseDouble(textField_2.getText());
                    double avg = (g1 + g2 + g3) / 3.0;
                    Dis.setText(String.format("Average: %.2f", avg));
                } catch (NumberFormatException ex) {
                    Dis.setText("Enter valid numbers!");
                }
            }
        });
    }
}
