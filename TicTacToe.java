// Class that creates the various methods and constructor for the tictactoe game in the arcade

import java.util.Scanner;

public class TicTacToe {
   
    private String[] board;
    private String turn;
   
    public TicTacToe() {
        board = new String[9];
        turn = "X";
        initializeBoard();
    }
   
    private void initializeBoard() {
        for (int i = 0; i < 9; i++) {
            board[i] = String.valueOf(i + 1);
        }
    }
   
    public String checkWinner() {
        for (int a = 0; a < 8; a++) {
            String line = null;
            switch (a) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            if (line.equals("XXX")) {
                return "X";
            }
            else if (line.equals("OOO")) {
                return "O";
            }
        }
       
        for (int a = 0; a < 9; a++) {
            if (!board[a].equals("X") && !board[a].equals("O")) {
                break;
            }
            else if (a == 8) {
                return "draw";
            }
        }
 
        return null;
    }
     
    public void printBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | "
                           + board[1] + " | " + board[2]
                           + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | "
                           + board[4] + " | " + board[5]
                           + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | "
                           + board[7] + " | " + board[8]
                           + " |");
        System.out.println("|---|---|---|");
    }
   
    public boolean playerMove(int slot) {
        if (slot < 0 || slot >= 9) {
            System.out.println("Invalid input. Slot number should be between 1 and 9.");
            return false;
        }
        if (!board[slot].equals(String.valueOf(slot + 1))) {
            System.out.println("Slot already taken. Please choose another slot.");
            return false;
        }
        board[slot] = turn;
        turn = (turn.equals("X")) ? "O" : "X";
        return true;
    }
   
    public String getCurrentTurn() {
        return turn;
    }

    public boolean isGameOver() {
        return checkWinner() != null;
    }
}