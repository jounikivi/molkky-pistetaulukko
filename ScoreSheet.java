import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ScoreSheet extends JFrame implements ActionListener {
    private JLabel scoreLabel;
    private JButton[] scoreButtons;
    private int[] scores;
    private int totalScore;

    public ScoreSheet() {
        super("Score Sheet");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        scores = new int[13];
        totalScore = 0;

        scoreLabel = new JLabel("Total Score: 0");

        scoreButtons = new JButton[13];
        for (int i = 0; i < 13; i++) {
            scoreButtons[i] = new JButton(Integer.toString(i));
            scoreButtons[i].addActionListener(this);
        }

        JPanel buttonPanel = new JPanel(new GridLayout(0, 1));
        for (int i = 0; i < 13; i++) {
            buttonPanel.add(scoreButtons[i]);
        }

        JPanel scorePanel = new JPanel(new BorderLayout());
        scorePanel.add(scoreLabel, BorderLayout.NORTH);
        scorePanel.add(buttonPanel, BorderLayout.CENTER);

        setContentPane(scorePanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton)e.getSource();
        int score = Integer.parseInt(source.getText());
        scores[score] = score;
        totalScore += score;
        scoreLabel.setText("Total Score: " + totalScore);
        source.setEnabled(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ScoreSheet();
            }
        });
    }
}

