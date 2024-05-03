/*
 * 
 * AP CSA Final Project - Arcade
 * Programmers: Landon Ehrhart and Kamron Gross
 * Date: 5/2/24
 * Description: An arcade simulation program that allows the user to play different mini-games
 * 
 */

 import javax.swing.JOptionPane;
 import java.util.*;

    public class Arcade {

        public static void main(String[] args) {                       
            
            // Instatiated Objects
            Scanner reader = new Scanner(System.in);
            boolean playAgain = true;


        while (playAgain) {
            String welcome = JOptionPane.showInputDialog("Welcome to the Arcade! Select a mini-game you would like to play: \n" +
                                                          "Tic-Tac-Toe (1)\n" +
                                                          "Hangman (2)\n" +
                                                          "Password Game (3)\n" +
                                                          "Game 4 (4)\n" +
                                                          "Game 5 (5)\n", "Enter Option Here:");

            int choice = Integer.parseInt(welcome);

            switch (choice)
            {
                // Tic-Tac-Toe Game
                case 1: 
                TicTacToe game = new TicTacToe();
                JOptionPane.showMessageDialog(null, "Welcome to Tic-Tac-Toe!");

                while (!game.isGameOver()) {
                    game.printBoard();
                    String playerTurn = game.getCurrentTurn();
                    int slot;
                    boolean validMove = false;
                    
                    while (!validMove) {
                        try {
                            slot = Integer.parseInt(JOptionPane.showInputDialog(playerTurn + "'s turn; enter a slot number to place " + playerTurn + " in:")) - 1;
                            validMove = game.playerMove(slot);
                            if (!validMove) {
                                JOptionPane.showMessageDialog(null, "Invalid input. Slot already taken or out of range. Please choose another slot.");
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                        }
                    }
                }

                game.printBoard();
                String winner = game.checkWinner();
                if (winner.equals("draw")) 
                    {
                        JOptionPane.showMessageDialog(null, "It's a draw!");
                    } 
                else 
                    {
                        JOptionPane.showMessageDialog(null, "Player " + winner + " wins!");
                        int playChoice = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again", JOptionPane.YES_NO_OPTION);
                        if (playChoice == JOptionPane.NO_OPTION) {
                            playAgain = false;
                        }
                    }
            }
        }
                        
    }
}
