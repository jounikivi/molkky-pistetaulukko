import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ScoreSheet extends JFrame implements ActionListener {
    JLabel team1Label, team2Label;
    JTextField team1Score, team2Score;
    JButton team1Add, team1Subtract, team2Add, team2Subtract, resetButton;

    public ScoreSheet() {
        setTitle("Score Sheet");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        // Team 1 controls
        team1Label = new JLabel("Team 1");
        team1Score = new JTextField("0", 5);
        team1Score.setEditable(false);
        team1Add = new JButton("+");
        team1Subtract = new JButton("-");
        team1Add.addActionListener(this);
        team1Subtract.addActionListener(this);

        // Team 2 controls
        team2Label = new JLabel("Team 2");
        team2Score = new JTextField("0", 5);
        team2Score.setEditable(false);
        team2Add = new JButton("+");
        team2Subtract = new JButton("-");
        team2Add.addActionListener(this);
        team2Subtract.addActionListener(this);

        // Reset button
        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);

        // Layout
        JPanel team1Panel = new JPanel();
        team1Panel.add(team1Label);
        team1Panel.add(team1Score);
        team1Panel.add(team1Add);
        team1Panel.add(team1Subtract);

        JPanel team2Panel = new JPanel();
        team2Panel.add(team2Label);
        team2Panel.add(team2Score);
        team2Panel.add(team2Add);
        team2Panel.add(team2Subtract);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(resetButton);

        setLayout(new BorderLayout());
        add(team1Panel, BorderLayout.NORTH);
        add(team2Panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        int team1CurrentScore = Integer.parseInt(team1Score.getText());
        int team2CurrentScore = Integer.parseInt(team2Score.getText());

        if (e.getSource() == team1Add) {
            team1CurrentScore++;
            team1Score.setText(Integer.toString(team1CurrentScore));
        } else if (e.getSource() == team1Subtract) {
            team1CurrentScore--;
            team1Score.setText(Integer.toString(team1CurrentScore));
        } else if (e.getSource() == team2Add) {
            team2CurrentScore++;
            team2Score.setText(Integer.toString(team2CurrentScore));
        } else if (e.getSource() == team2Subtract) {
            team2CurrentScore--;
            team2Score.setText(Integer.toString(team2CurrentScore));
        } else if (e.getSource() == resetButton) {
            team1Score.setText("0");
            team2Score.setText("0");
        }
    }

    public static void main(String[] args) {
        ScoreSheet scoreSheet = new ScoreSheet();
        scoreSheet.setVisible(true);
    }
}
