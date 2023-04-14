import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ScoreSheetGUI extends JFrame implements ActionListener {
    private JLabel playerLabel, scoreLabel;
    private JTextField playerField, scoreField;
    private JButton addButton, resetButton;
    private JTextArea scoreArea;
    private int totalScore;

    public ScoreSheetGUI() {
        super("Score Sheet");

        // Create GUI components
        playerLabel = new JLabel("Player Name:");
        scoreLabel = new JLabel("Score:");
        playerField = new JTextField(10);
        scoreField = new JTextField(5);
        addButton = new JButton("Add Score");
        resetButton = new JButton("Reset Scores");
        scoreArea = new JTextArea(10, 20);

        // Add components to the GUI
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2, 2));
        panel1.add(playerLabel);
        panel1.add(playerField);
        panel1.add(scoreLabel);
        panel1.add(scoreField);

        JPanel panel2 = new JPanel();
        panel2.add(addButton);
        panel2.add(resetButton);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(panel1, BorderLayout.NORTH);
        c.add(panel2, BorderLayout.CENTER);
        c.add(new JScrollPane(scoreArea), BorderLayout.SOUTH);

        // Add action listeners to buttons
        addButton.addActionListener(this);
        resetButton.addActionListener(this);

        // Initialize variables
        totalScore = 0;

        // Set GUI properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String player = playerField.getText();
            int score = Integer.parseInt(scoreField.getText());
            totalScore += score;
            scoreArea.append(player + ": " + score + "\n");
            scoreArea.append("Total Score: " + totalScore + "\n\n");
            playerField.setText("");
            scoreField.setText("");
        } else if (e.getSource() == resetButton) {
            totalScore = 0;
            scoreArea.setText("");
        }
    }

    public static void main(String[] args) {
        new ScoreSheetGUI();
    }
}
