package Mastery;

import java.awt.*;
import javax.swing.*;

public class TicTacToe {

    private JFrame frame;
    private JButton[][] buttons = new JButton[3][3]; 
    private boolean xTurn = true; 

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                TicTacToe window = new TicTacToe();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public TicTacToe() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Tic Tac Toe");
        frame.setBounds(100, 100, 400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 3)); 

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new JButton("");
                buttons[row][col].setFont(new Font("Arial", Font.BOLD, 40));
                int r = row, c = col;
                buttons[row][col].addActionListener(e -> handleMove(r, c));
                frame.add(buttons[row][col]);
            }
        }
    }

    private void handleMove(int row, int col) {
        if (!buttons[row][col].getText().equals("")) {
            return; 
        }

        buttons[row][col].setText(xTurn ? "X" : "O");
        if (checkWin()) {
            JOptionPane.showMessageDialog(frame, "Winner is: " + (xTurn ? "X" : "O"));
            resetBoard();
            return;
        }

        if (isBoardFull()) {
            JOptionPane.showMessageDialog(frame, "It's a draw!");
            resetBoard();
            return;
        }

        xTurn = !xTurn; 
    }

    private boolean checkWin() {
        String player = xTurn ? "X" : "O";

        // Check rows & columns
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(player) &&
                buttons[i][1].getText().equals(player) &&
                buttons[i][2].getText().equals(player)) {
                return true;
            }
            if (buttons[0][i].getText().equals(player) &&
                buttons[1][i].getText().equals(player) &&
                buttons[2][i].getText().equals(player)) {
                return true;
            }
        }

        // Check diagonals
        if (buttons[0][0].getText().equals(player) &&
            buttons[1][1].getText().equals(player) &&
            buttons[2][2].getText().equals(player)) {
            return true;
        }
        if (buttons[0][2].getText().equals(player) &&
            buttons[1][1].getText().equals(player) &&
            buttons[2][0].getText().equals(player)) {
            return true;
        }

        return false;
    }

    private boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (buttons[row][col].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    private void resetBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setText("");
            }
        }
        xTurn = true; 
    }
}
