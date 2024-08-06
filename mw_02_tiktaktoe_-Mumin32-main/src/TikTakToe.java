/**
 * KLASSENHEADER
 *
 *
 *
 */

import javax.print.DocFlavor;
import java.util.Scanner;

public class TikTakToe {
    //--------------------------------------------------
    // Variablen und Konstanten Hier einfügen
    public static final int BOARD_SIZE=3;
    private final String board[][];
    public String Player_X = "X";
    public String Player_0 ="O";
    private static final String EMPTY=" ";
    public String currentPlayer ;

    //--------------------------------------------------

    // Constructor
    public TikTakToe() {
        board = new String[BOARD_SIZE][BOARD_SIZE]; //Board size is 3
        initBoard();
        currentPlayer = Player_X;

        // Add code here
    }

    /**
     * Initializes the board with the specified values.
     */
    void initBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;       //sets board empty
            }
        }
    }
    /**
     * Prints the whole board with all separation characters
     */
     void printBoard() {

         for (int i = 0; i < 3; i++) {
             for (int j = 0; j < 3; j++) {
                 System.out.print(" " + board[i][j] + " ");
                 if (j < 2)
                     System.out.print("|");
             }
             System.out.println();
             if (i < 2)
                 System.out.println("---+---+---");
         }
     }

    /**
     * Sets a position in the board array to the given player string.
     * @param r row index
     * @param c column index
     * @param player player string
     * @return true if and only if the position was set
     */
    boolean setPosition(int r, int c, String player) {

        if (!board[r][c].equals(EMPTY)) {                                                      //if place on board not empty is then print out error
            System.out.println("This position is already occupied. Please choose another.");
            return false;
        }

        board[r][c] = currentPlayer;
        return true;
    }


    /**
     * Checks if the game has been won by one of the users
     * @return
     */
    public boolean isGameOver() {
         for(int i = 0; i < 3; i++) {
             if(!board[i][0].equals(EMPTY) && board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2])){
                 /*if board on i position and position 0 not empty is and same input has as board on position 1 and 2  someone wins
                  same logik is for other if too */
             return true;

             }
            for (int j=0; j<3; j++){
                if(!board[0][j].equals(EMPTY) && board[0][j].equals(board[1][j]) && board[1][j].equals(board[2][j])) {
                    return true;
                }

            }
         }
        if (!board[1][1].equals(EMPTY) && board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])){    //checks diagonals
        return true;

        }
        if (!board[0][2].equals(EMPTY) && board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])){
            return true;
        }
        return false;
    }

    boolean draw() {
        for (int i = 0; i < BOARD_SIZE; i++) {                      //checks for draw
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j].equals(" ") && !isGameOver()){    //if board empty is and method gameover returns false then is draw
                    return false;
                }
            }
        }
        return true;
    }





    boolean isGameOverBonus() {

        return true;
    }



    }
