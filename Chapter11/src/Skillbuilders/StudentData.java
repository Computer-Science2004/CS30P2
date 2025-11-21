package Skillbuilders;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class StudentData extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField nameField;
    private JTextField scoreField;

    public StudentData() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{40, 199, 0};
        gridBagLayout.rowHeights = new int[]{31, 31, 47, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        // Name label
        JLabel lblName = new JLabel("Name:");
        GridBagConstraints gbc_lblName = new GridBagConstraints();
        gbc_lblName.insets = new Insets(0, 0, 5, 5);
        gbc_lblName.gridx = 0;
        gbc_lblName.gridy = 0;
        add(lblName, gbc_lblName);

        // Name field
        nameField = new JTextField();
        GridBagConstraints gbc_nameField = new GridBagConstraints();
        gbc_nameField.fill = GridBagConstraints.HORIZONTAL;
        gbc_nameField.insets = new Insets(0, 0, 5, 0);
        gbc_nameField.gridx = 1;
        gbc_nameField.gridy = 0;
        add(nameField, gbc_nameField);
        nameField.setColumns(10);

        // Score label
        JLabel lblScore = new JLabel("Score:");
        GridBagConstraints gbc_lblScore = new GridBagConstraints();
        gbc_lblScore.insets = new Insets(0, 0, 5, 5);
        gbc_lblScore.gridx = 0;
        gbc_lblScore.gridy = 1;
        add(lblScore, gbc_lblScore);

        // Score field
        scoreField = new JTextField();
        GridBagConstraints gbc_scoreField = new GridBagConstraints();
        gbc_scoreField.fill = GridBagConstraints.HORIZONTAL;
        gbc_scoreField.insets = new Insets(0, 0, 5, 0);
        gbc_scoreField.gridx = 1;
        gbc_scoreField.gridy = 1;
        add(scoreField, gbc_scoreField);
        scoreField.setColumns(10);
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getScoreField() {
        return scoreField;
    }
}
