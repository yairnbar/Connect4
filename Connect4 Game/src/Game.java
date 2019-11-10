//Yair Bar 111928259
import java.util.InputMismatchException;
import java.util.Scanner;
public class Game {
    String[][] board = new String[6][7];

    public void setBoard() {
        //Sort through array and set to blank elements
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ("| |");
            }
        }
    }

    public String startBoard() {
        //Print out the start board
        for (String[] x : board) {
            for (String y : x) {
                System.out.print(y + "      ");
            }
            System.out.println();
            System.out.println();
        }
        return "Begin!!";
    }

    private int checkRows(String[][] z) {
        //Sort through array
        for (int i = 0; i < z.length; i++) {
            for (int j = 0; j < z[i].length - 3; j++) {
                //Check if "|Y|" has row win condition
                if (z[i][j] == "|Y|") {
                    String element = z[i][j];
                    if (element == z[i][j + 1] && element == z[i][j + 2] && element == z[i][j + 3]) {
                        return 1;
                    }
                }
                //Check if "|R|" has row win condition
                if (z[i][j] == "|R|") {
                    String element = z[i][j];
                    if (element == z[i][j + 1] && element == z[i][j + 2] && element == z[i][j + 3]) {
                        return 2;
                    }
                }
            }
        }
        return 0;
    }

    private int checkColumns(String[][] z) {
        //Sort through array
        for (int i = 0; i < z.length - 3; i++) {
            for (int j = 0; j < z[i].length; j++) {
                //Check if "|Y|" has column win condition
                if (z[i][j] == "|Y|") {
                    String element = z[i][j];
                    if (element == z[i + 1][j] && element == z[i + 2][j] && element == z[i + 3][j]) {
                        return 1;
                    }
                }
                //Check if "|R|" has column win condition
                if (z[i][j] == "|R|") {
                    String element = z[i][j];
                    if (element == z[i + 1][j] && element == z[i + 2][j] && element == z[i + 3][j]) {
                        return 2;
                    }
                }
            }
        }
        return 0;
    }

    private int checkMainDiagonal(String[][] z) {
        //Sort through array
        for (int i = 0; i < z.length - 3; i++) {
            for (int j = 0; j < z[i].length - 3; j++) {
                //Check if "|Y|" has diagonal win condition
                if (z[i][j] == "|Y|") {
                    String element = z[i][j];
                    if (element == z[i + 1][j + 1] && element == z[i + 2][j + 2] && element == z[i + 3][j + 3]) {
                        return 1;
                    }
                }
                //Check if "|R|" has diagonal win condition
                if (z[i][j] == "|R|") {
                    String element = z[i][j];
                    if (element == z[i + 1][j + 1] && element == z[i + 2][j + 2] && element == z[i + 3][j + 3]) {
                        return 2;
                    }
                }
            }
        }
        return 0;
    }

    private int checkCounterDiagonal(String[][] z) {
        //Sort through array
        for (int i = 0; i < z.length - 3; i++) {
            for (int j = 3; j < z[i].length; j++) {
                //Check if "|Y|" has reverse diagonal win condition
                if (z[i][j] == "|Y|") {
                    String element = z[i][j];
                    if (element == z[i + 1][j - 1] && element == z[i + 2][j - 2] && element == z[i + 3][j - 3]) {
                        return 1;
                    }
                }
                //Check if "|R|" has reverse diagonal win condition
                if (z[i][j] == "|R|") {
                    String element = z[i][j];
                    if (element == z[i + 1][j - 1] && element == z[i + 2][j - 2] && element == z[i + 3][j - 3]) {
                        return 2;
                    }
                }
            }
        }
        return 0;
    }

    public int checkForIdenticalFour(String[][] z) {
        int yellow = 0;
        int red = 0;
        //Check if win condition is either "|Y|" = 1, "|R|" = 2
        if (checkRows(z) == 1 || checkColumns(z) == 1 || checkMainDiagonal(z) == 1 || checkCounterDiagonal(z) == 1) {
            yellow++;
        }
        if (checkRows(z) == 2 || checkColumns(z) == 2 || checkMainDiagonal(z) == 2 || checkCounterDiagonal(z) == 2) {
            red++;
        }
        if (yellow > 0) {
            return 1;
        }
        if (red > 0) {
            return 2;
        }
        return 0;
    }

    public boolean yellowTurn(int z) {
        //Validate input
        if (!dropYellowDisk(z)) {
            return false;
        }
        //Print board with new input
        for (String[] x : board) {
            for (String y : x) {
                System.out.print(y + "      ");
            }
            System.out.println();
            System.out.println();
        }
        return true;
    }

    public boolean dropYellowDisk(int z) {
        //Check valid input
        if (z < 0 || z > 6) {
            System.out.println("Input must be a positive number, and between 0 and 6. Try again!");
            return false;
        }
        //Check if column is full
        if (board[0][z] != "| |") {
            System.out.println("Column is full. Try again!");
            return false;
        }
        //Set next open slot to "|Y|"
        else {
            for (int i = 5; i >= 0; i--) {
                if (board[i][z] == "| |") {
                    board[i][z] = "|Y|";
                    break;
                }
            }
        }

        return true;
    }

    public boolean redTurn(int z) {
        //Validate input
        if (!dropRedDisk(z)) {
            return false;
        }
        //print board with new input
        for (String[] x : board) {
            for (String y : x) {
                System.out.print(y + "      ");
            }
            System.out.println();
            System.out.println();
        }
        return true;
    }

    public boolean dropRedDisk(int z) {
        //Check valid input
        if (z < 0 || z > 6) {
            System.out.println("Input must be a positive number, and between 0 and 6. Try again!");
            return false;
        }
        //Check if column is full
        if (board[0][z] != "| |") {
            System.out.println("Column is full. Try again!");
            return false;
        }

        //Set next open slot to "|R|"
        else {
            for (int i = 5; i >= 0; i--) {
                if (board[i][z] == "| |") {
                    board[i][z] = "|R|";
                    break;
                }
            }
        }
        return true;
    }

    private boolean isBoardFull() {
        //Check if any elements are empty (if there is an empty element the board isn't full)
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (board[i][j] == "| |") {
                    return false;
                }
            }
        }
        //If there is no empty elements - return true = DRAW
        return true;
    }

    public static void main(String[] args) {
        //Create game object and set it
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Connect 4! \nYellow player starts.");
        Game board = new Game();
        board.setBoard();
        System.out.println(board.startBoard());
        boolean continueInput = false, continueInput2= false;
        //While nobody has won
        while (board.checkForIdenticalFour(board.board) != 1 || board.checkForIdenticalFour(board.board) != 2) {
            //Yellow's turn
            do {
                try {
                    System.out.println("Yellow's turn, drop disk in column (0-6)");
                    //Put input through validation and updating the board
                    //Loop until input works
                    while (!board.yellowTurn(input.nextInt())) {
                    }
                    //Check if draw
                    if (board.isBoardFull()) {
                        System.out.println("Board is full! Game ends in a draw!");
                        System.exit(1);
                    }
                    //Check for yellow winner
                    if (board.checkForIdenticalFour(board.board) == 1) {
                        System.out.println("Yellow wins!");
                        System.exit(1);
                    }
                    continueInput = true;
                } catch (InputMismatchException e) {
                    System.out.print("Input must be a number!! It is ");
                    input.nextLine();//Clear input
                }
                catch (Exception e){
                    System.out.print("Something went wrong. It is ");
                    input.nextLine();//Clear input
                }
            } while (!continueInput);
            //Set default
            continueInput=false;
            //Red's turn
            do {
                try {
                    System.out.println("Red's turn, drop disk in column (0-6)");
                    //Put input through validation and updating the board
                    //Loop until input works
                    while (!board.redTurn(input.nextInt())) {
                    }
                    //check if draw
                    if (board.isBoardFull()) {
                        System.out.println("Board is full! Game ends in a draw!");
                        System.exit(1);
                    }
                    //check for red winner
                    if (board.checkForIdenticalFour(board.board) == 2) {
                        System.out.println("Red wins!");
                        System.exit(1);
                    }
                    continueInput2 = true;
                } catch (InputMismatchException e) {
                    System.out.print("Input must be a number!! It is ");
                    input.nextLine();//Clear input
                }
                catch(Exception e){
                    System.out.print("Something went wrong. It is ");
                    input.nextLine();//Clear input
                }
            } while (!continueInput2);
            //Set default
            continueInput2=false;
        }
    }
}