import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MolkyPointSheet extends JFrame {
   private JLabel titleLabel, roundLabel, scoreLabel, playerLabel;
   private JTextField roundTextField, scoreTextField;
   private JComboBox<String> playerComboBox;
   private JButton addButton, clearButton, exitButton;
   private JTable scoreTable;
   private JScrollPane scrollPane;
   private DefaultTableModel tableModel;
   private Map<String, int[]> scores = new HashMap<>();
   private int currentRound = 1;
   private String[] players = {"Player 1", "Player 2", "Player 3", "Player 4"};
   
   public MolkyPointSheet() {
      setTitle("Mölkky Point Sheet");
      setLayout(new GridLayout(4, 1));

      // Create the title label
      titleLabel = new JLabel("Enter scores for each round of Mölkky:");
      add(titleLabel);

      // Create the score table
      tableModel = new DefaultTableModel(12, players.length + 1) {
         @Override
         public boolean isCellEditable(int row, int col) {
            return false;
         }
      };
      scoreTable = new JTable(tableModel);
      TableColumnModel columnModel = scoreTable.getColumnModel();
      columnModel.getColumn(0).setHeaderValue("Round");
      for (int i = 0; i < players.length; i++) {
         columnModel.getColumn(i+1).setHeaderValue(players[i]);
      }
      scrollPane = new JScrollPane(scoreTable);
      add(scrollPane);

      // Create the input fields and buttons
      roundLabel = new JLabel("Round:");
      roundTextField = new JTextField("1", 5);
      scoreLabel = new JLabel("Score:");
      scoreTextField = new JTextField("0", 5);
      playerLabel = new JLabel("Player:");
      playerComboBox = new JComboBox<>(players);
      addButton = new JButton("Add Score");
      clearButton = new JButton("Clear Scores");
      exitButton = new JButton("Exit");
      
      JPanel inputPanel = new JPanel(new FlowLayout());
      inputPanel.add(roundLabel);
      inputPanel.add(roundTextField);
      inputPanel.add(playerLabel);
      inputPanel.add(playerComboBox);
      inputPanel.add(scoreLabel);
      inputPanel.add(scoreTextField);
      inputPanel.add(addButton);
      inputPanel.add(clearButton);
      inputPanel.add(exitButton);
      add(inputPanel);

      // Add action listeners to the buttons
      addButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            addScore();
         }
      });

      clearButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            clearScores();
         }
      });

      exitButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            System.exit(0);
         }
      });

      setSize(500, 400);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   protected void clearScores() {
}

private void addScore() {
    try {
        int round = Integer.parseInt(roundTextField.getText());
        int score = Integer.parseInt(scoreTextField.getText());
        String player = (String) playerComboBox.getSelectedItem();

        if (round >= 1 && round <= 12 && score >= 0 && score <= 12) {
            int[] playerScores = scores.get(player);
            if (playerScores == null) {
                playerScores = new int[12];
                scores.put(player, playerScores);
            }
            playerScores[round - 1] = score;
            scoreTable.setValueAt(round, round - 1, 0);

            for (int i = 0; i < players.length; i++) {
                int[] scoresArray = scores.get(players[i]);
                for (int j = 0; j < 12; j++) {
                    scoreTable.setValueAt(scoresArray[j], j, i + 1);
                }
            }

            currentRound++;
            if (currentRound > 12) {
                addButton.setEnabled(false);
                roundTextField.setEditable(false);
                scoreTextField.setEditable(false);
                playerComboBox.setEnabled(false);
            } else {
                roundTextField.setText(Integer.toString(currentRound));
                scoreTextField.setText("0");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid round or score entered.");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Please enter valid numbers for round and score.");
    }
}
public static void main(String[] args) {
    new MolkyPointSheet();
 }
}
