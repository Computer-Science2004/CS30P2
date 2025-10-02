package Mastery;

import java.awt.EventQueue;
import javax.swing.*;

public class LocalBank extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField fNameField, lNameField, balanceField, acctIDField, amountField;
    private JTextArea outputArea;
    private Bank bank = new Bank(); // use your Bank logic class

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                LocalBank frame = new LocalBank();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public LocalBank() {
        setTitle("Local Bank");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblFirst = new JLabel("First Name:");
        lblFirst.setBounds(10, 20, 100, 20);
        contentPane.add(lblFirst);

        fNameField = new JTextField();
        fNameField.setBounds(120, 20, 100, 20);
        contentPane.add(fNameField);

        JLabel lblLast = new JLabel("Last Name:");
        lblLast.setBounds(10, 50, 100, 20);
        contentPane.add(lblLast);

        lNameField = new JTextField();
        lNameField.setBounds(120, 50, 100, 20);
        contentPane.add(lNameField);

        JLabel lblBalance = new JLabel("Start Balance:");
        lblBalance.setBounds(10, 80, 100, 20);
        contentPane.add(lblBalance);

        balanceField = new JTextField();
        balanceField.setBounds(120, 80, 100, 20);
        contentPane.add(balanceField);

        JButton addBtn = new JButton("Add Account");
        addBtn.setBounds(10, 110, 150, 25);
        addBtn.addActionListener(e -> {
            String id = bank.addAccount(fNameField.getText(), lNameField.getText(),
                    Double.parseDouble(balanceField.getText()));
            outputArea.setText("Account created with ID: " + id);
        });
        contentPane.add(addBtn);

        JLabel lblAcctID = new JLabel("Account ID:");
        lblAcctID.setBounds(10, 160, 100, 20);
        contentPane.add(lblAcctID);

        acctIDField = new JTextField();
        acctIDField.setBounds(120, 160, 100, 20);
        contentPane.add(acctIDField);

        JLabel lblAmt = new JLabel("Amount:");
        lblAmt.setBounds(10, 190, 100, 20);
        contentPane.add(lblAmt);

        amountField = new JTextField();
        amountField.setBounds(120, 190, 100, 20);
        contentPane.add(amountField);

        JButton depositBtn = new JButton("Deposit");
        depositBtn.setBounds(10, 220, 100, 25);
        depositBtn.addActionListener(e -> {
            String result = bank.transaction(1, acctIDField.getText(),
                    Double.parseDouble(amountField.getText()));
            outputArea.setText(result);
        });
        contentPane.add(depositBtn);

        JButton withdrawBtn = new JButton("Withdraw");
        withdrawBtn.setBounds(120, 220, 100, 25);
        withdrawBtn.addActionListener(e -> {
            String result = bank.transaction(2, acctIDField.getText(),
                    Double.parseDouble(amountField.getText()));
            outputArea.setText(result);
        });
        contentPane.add(withdrawBtn);

        JButton balanceBtn = new JButton("Check Balance");
        balanceBtn.setBounds(10, 260, 210, 25);
        balanceBtn.addActionListener(e -> {
            String result = bank.checkBalance(acctIDField.getText());
            outputArea.setText(result);
        });
        contentPane.add(balanceBtn);

        JButton deleteBtn = new JButton("Delete Account");
        deleteBtn.setBounds(10, 300, 210, 25);
        deleteBtn.addActionListener(e -> {
            String result = bank.deleteAccount(acctIDField.getText());
            outputArea.setText(result);
        });
        contentPane.add(deleteBtn);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBounds(250, 20, 220, 400);
        contentPane.add(scrollPane);
    }
}
