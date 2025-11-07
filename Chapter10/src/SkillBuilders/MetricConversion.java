package SkillBuilders;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.EmptyBorder;

public class MetricConversion extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MetricConversion frame = new MetricConversion();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MetricConversion() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 323, 236);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Select a conversion type:");
        lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        lblNewLabel.setBounds(10, 24, 200, 20);
        contentPane.add(lblNewLabel);

        JComboBox<String> conversionChoice = new JComboBox<>();
        conversionChoice.setFont(new Font("Tahoma", Font.BOLD, 14));
        conversionChoice.setModel(new DefaultComboBoxModel<>(
            new String[] {
                "Select conversion",
                "Inches to Centimeters",
                "Feet to Meters",
                "Gallons to Liters",
                "Pounds to Kilograms"
            }
        ));
        conversionChoice.setBounds(10, 55, 200, 25);
        contentPane.add(conversionChoice);

        JTextArea Dis = new JTextArea();
        Dis.setBackground(Color.WHITE);
        Dis.setBounds(10, 100, 287, 54);
        contentPane.add(Dis);

        // Show conversion immediately when selection changes
        conversionChoice.addActionListener(e -> {
            String choice = (String) conversionChoice.getSelectedItem();
            switch (choice) {
                case "Inches to Centimeters":
                    Dis.setText("1 inch = 2.54 centimeters");
                    break;
                case "Feet to Meters":
                    Dis.setText("1 foot = 0.3048 meters");
                    break;
                case "Gallons to Liters":
                    Dis.setText("1 Gallon = 4.5461 Liters");
                    break;
                case "Pounds to Kilograms":
                    Dis.setText("1 Pound = 0.4536 Kilograms");
                    break;
                default:
                    Dis.setText("");
            }
        });
    }
}
