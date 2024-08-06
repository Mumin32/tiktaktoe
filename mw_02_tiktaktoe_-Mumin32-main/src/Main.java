import java.util.Scanner;

/**
 * KLASSENHEADER
 *
 *
 *
 */
public class Main {

    public static void main(String[] args) {


        Scanner s = new Scanner(System.in);
        TikTakToe game = new TikTakToe(); //object erstellung , damit man auf klasse tiktaktoe zugehen kann


        System.out.println("Welcome to Tik-Tak-Codersbay!");
        game.printBoard();                                              //print board out

        while (true) {
            int row = getRow(s) - 1;
            int col = getColumn(s) - 1;
            if (game.setPosition(row, col, game.currentPlayer)) {
                // Change player
                game.currentPlayer = getNextPlayer(game.currentPlayer);        //switch player

            } else {
                                                                          //Same player countinue to play if Position not right is.
                continue;
            }
            game.printBoard();                                             //methode von tiktaktoe klasse

                                                                            // Check If Game Is Over
            if (game.isGameOver()) {
                System.out.println("Player : " + getNextPlayer(game.currentPlayer) + " Hat gewonnen");
                break;

            }
            if (game.draw()){                                                           //check for draw
                System.out.println("Draw");
                break;
            }

        }
    }

    /**
     * @return a valid row if the input was entered correctly
     */
    private static int getRow(Scanner s) {
        return readIntegerInput("Row: ",                                                                    //tree pharamethers from methode ReadIntegerInput
                "Invalid Input! Please enter a valid integer for the row you want to select!\n",
                s);
    }

    /**
     * @return a valid column if the input was entered correctly
     */
    private static int getColumn(Scanner s) {

        return readIntegerInput("Col: ",
                                "Invalid Input! Please enter a valid integer for the column you want to select!\n", //Same as getRow
                                s);
    }


    /**
     * Asks for an input and checks if it can be converted into an integer.
     * If the input can't be converted, the input prompt is printed again.
     * @param prompt is the prompt to the user
     * @return the integer value of the input if possible
     */
    private static int readIntegerInput(String prompt, String error_message, Scanner input) {
        int user_input;
        while(true){
            try{
                System.out.println(prompt);           //Print "Col" or "Row"
                user_input = Integer.parseInt(input.nextLine());    //try to convert user input into INT
                if(user_input > 3 || user_input < 1)
                    System.out.println(error_message);            //when user input not from 1-3 is then print out error message
                else
                    return user_input;                          //when user input ok is then return user input
            } catch (NumberFormatException nfe) {                       //try to convert string to number
                System.out.println(error_message);                //when not possible is then print out error message
            }
        }
    }

    /**
     * Switches the player.
     *
     * @return the next Player
     */
    private static String getNextPlayer(String currentPlayer) {        //switch player

        return currentPlayer.equals("X") ? "O" : "X";

    }

}