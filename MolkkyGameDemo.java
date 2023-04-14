import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MolkkyGameDemo extends JFrame implements ActionListener {
    
    private JLabel labelPlayerCount, labelPlayerNames, labelResult;
    private JTextField textFieldPlayerCount, textFieldPlayerNames;
    private JButton buttonStart, buttonThrow, buttonReset;
    private JTextArea textAreaScore;
    private int playerCount, currentPlayer, throwsLeft;
    private String[] playerNames;
    private int[] scores;
    
    public MolkkyGameDemo() {
        // Set up the main window
        setTitle("Mölkky Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new BorderLayout());
        
        // Set up the input panel
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        labelPlayerCount = new JLabel("Number of players:");
        inputPanel.add(labelPlayerCount);
        textFieldPlayerCount = new JTextField();
        inputPanel.add(textFieldPlayerCount);
        labelPlayerNames = new JLabel("Player names (comma separated):");
        inputPanel.add(labelPlayerNames);
        textFieldPlayerNames = new JTextField();
        inputPanel.add(textFieldPlayerNames);
        buttonStart = new JButton("Start game");
        buttonStart.addActionListener(this);
        inputPanel.add(buttonStart);
        add(inputPanel, BorderLayout.NORTH);
        
        // Set up the score panel
        JPanel scorePanel = new JPanel(new GridLayout(2, 1));
        textAreaScore = new JTextArea();
        textAreaScore.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textAreaScore);
        scorePanel.add(scrollPane);
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonThrow = new JButton("Throw");
        buttonThrow.addActionListener(this);
        buttonPanel.add(buttonThrow);
        buttonReset = new JButton("Reset");
        buttonReset.addActionListener(this);
        buttonPanel.add(buttonReset);
        scorePanel.add(buttonPanel);
        add(scorePanel, BorderLayout.CENTER);
        
        // Set up the result panel
        JPanel resultPanel = new JPanel(new GridLayout(1, 1));
        labelResult = new JLabel("");
        resultPanel.add(labelResult);
        add(resultPanel, BorderLayout.SOUTH);
        
        // Initialize the game variables
        playerCount = 0;
        currentPlayer = 0;
        throwsLeft = 1;
        playerNames = new String[0];
        scores = new int[0];
    }
    
    public static void main(String[] args) {
        MolkkyGameDemo game = new MolkkyGameDemo();
        game.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonStart) {
            startGame();
        } else if (e.getSource() == buttonThrow) {
            throwBall();
        } else if (e.getSource() == buttonReset) {
            resetGame();
        }
    }
    
    private void startGame() {
      try {
          // Parse the input
          playerCount = Integer.parseInt(textFieldPlayerCount.getText());
          playerNames = textFieldPlayerNames.getText().split(",");
          if (playerNames.length != playerCount) {
              throw new Exception("Number of player names does not match player count");
          }
          scores = new int[playerCount];
          
          // Display the player order
          String playerOrder = "";
          for (int i = 0; i < playerCount; i++) {
              playerOrder += playerNames[i] + " ";
          }
          textAreaScore.setText("Player order: " + playerOrder + "\n\n");
          
          // Initialize the game state
          currentPlayer = 0;
          throwsLeft = 1;
          updateScore();
          labelResult.setText("");
      } catch (Exception ex) {
          JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
      }
  }
  
  private void throwBall() {
      int score = (int) (Math.random() * 12) + 1;
      if (throwsLeft == 1) {
          // First throw
          textAreaScore.append(playerNames[currentPlayer] + " throws " + score + "\n");
          scores[currentPlayer] += score;
          throwsLeft = score == 12 ? 2 : 2 - score;
          updateScore();
          if (throwsLeft == 0) {
              endTurn();
          }
      } else {
          // Second throw
          textAreaScore.append(playerNames[currentPlayer] + " throws " + score + " (" + throwsLeft + " left)\n");
          scores[currentPlayer] += score;
          throwsLeft--;
          updateScore();
          if (throwsLeft == 0) {
              endTurn();
          }
      }
  }
  
  private void endTurn() {
      // Check for a winner
      int winnerIndex = -1;
      for (int i = 0; i < playerCount; i++) {
          if (scores[i] == 50) {
              winnerIndex = i;
              break;
          }
      }
      if (winnerIndex != -1) {
          labelResult.setText(playerNames[winnerIndex] + " wins!");
          buttonThrow.setEnabled(false);
      } else {
          // Advance to the next player
          currentPlayer = (currentPlayer + 1) % playerCount;
          throwsLeft = 1;
          updateScore();
      }
  }
  
  private void resetGame() {
      textFieldPlayerCount.setText("");
      textFieldPlayerNames.setText("");
      textAreaScore.setText("");
      labelResult.setText("");
      buttonThrow.setEnabled(true);
      playerCount = 0;
      currentPlayer = 0;
      throwsLeft = 1;
      playerNames = new String[0];
      scores = new int[0];
  }
  
  private void updateScore() {
      String scoreString = "";
      for (int i = 0; i < playerCount; i++) {
          scoreString += playerNames[i] + ": " + scores[i] + " points\n";
      }
      textAreaScore.append(scoreString);
  }
}

            
           

