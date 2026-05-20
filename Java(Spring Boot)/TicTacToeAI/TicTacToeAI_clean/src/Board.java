/**
 * Board.java
 * ============================================================
 * This class represents the Tic-Tac-Toe game board.
 * It stores the current state of the board and provides
 * methods to check for wins, draws, and valid moves.
 *
 * In AI terms, this is our "STATE" in the state-space representation.
 * Each unique arrangement of X's and O's on the board = one state.
 * ============================================================
 */
public class Board {

    // -------------------------------------------------------
    // Constants: These never change during the game
    // -------------------------------------------------------
    public static final char HUMAN = 'X';   // Human player uses X
    public static final char AI    = 'O';   // AI player uses O
    public static final char EMPTY = '.';   // Empty cell shown as dot

    // The board is a 3x3 grid stored as a 2D array
    // board[row][col] — row 0 is top, row 2 is bottom
    private char[][] board;

    // -------------------------------------------------------
    // Constructor: Creates a fresh empty board
    // -------------------------------------------------------
    public Board() {
        board = new char[3][3];
        // Fill every cell with the EMPTY character
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = EMPTY;
            }
        }
    }

    // -------------------------------------------------------
    // Constructor: Creates a board from an existing 2D array
    // Used when loading a board state from a file
    // -------------------------------------------------------
    public Board(char[][] initialState) {
        board = new char[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = initialState[row][col];
            }
        }
    }

    // -------------------------------------------------------
    // getCell: Returns the character at a specific position
    // -------------------------------------------------------
    public char getCell(int row, int col) {
        return board[row][col];
    }

    // -------------------------------------------------------
    // setCell: Places a player's symbol at a position
    // -------------------------------------------------------
    public void setCell(int row, int col, char player) {
        board[row][col] = player;
    }

    // -------------------------------------------------------
    // isValidMove: Checks if a cell is empty (available)
    // -------------------------------------------------------
    public boolean isValidMove(int row, int col) {
        // Must be within bounds AND the cell must be empty
        return (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == EMPTY);
    }

    // -------------------------------------------------------
    // hasWinner: Checks if a specific player has won
    // A player wins by filling a row, column, or diagonal
    // -------------------------------------------------------
    public boolean hasWinner(char player) {

        // Check all 3 rows
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        // Check all 3 columns
        for (int col = 0; col < 3; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        // Check main diagonal (top-left to bottom-right)
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        // Check anti-diagonal (top-right to bottom-left)
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false; // No winning line found
    }

    // -------------------------------------------------------
    // isDraw: Checks if the board is full with no winner
    // -------------------------------------------------------
    public boolean isDraw() {
        // If someone won, it's not a draw
        if (hasWinner(HUMAN) || hasWinner(AI)) {
            return false;
        }
        // Check if any empty cell remains
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == EMPTY) {
                    return false; // Still moves available
                }
            }
        }
        return true; // Board full, no winner = draw
    }

    // -------------------------------------------------------
    // isGameOver: Returns true if game has ended (win or draw)
    // -------------------------------------------------------
    public boolean isGameOver() {
        return hasWinner(HUMAN) || hasWinner(AI) || isDraw();
    }

    // -------------------------------------------------------
    // countEmpty: Returns how many empty cells remain
    // Used to determine how deep we are in the game tree
    // -------------------------------------------------------
    public int countEmpty() {
        int count = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == EMPTY) count++;
            }
        }
        return count;
    }

    // -------------------------------------------------------
    // copyBoard: Creates a deep copy of this board
    // The AI uses this to simulate moves without changing
    // the real board — essential for the Minimax algorithm
    // -------------------------------------------------------
    public Board copyBoard() {
        Board copy = new Board();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                copy.board[row][col] = this.board[row][col];
            }
        }
        return copy;
    }

    // -------------------------------------------------------
    // printBoard: Displays the board nicely in the console
    // Includes row and column numbers for human player input
    // -------------------------------------------------------
    public void printBoard() {
        System.out.println();
        System.out.println("    Col 0   Col 1   Col 2");
        System.out.println("  +-------+-------+-------+");
        for (int row = 0; row < 3; row++) {
            System.out.print("Row " + row + " |");
            for (int col = 0; col < 3; col++) {
                System.out.print("   " + board[row][col] + "   |");
            }
            System.out.println();
            System.out.println("  +-------+-------+-------+");
        }
        System.out.println();
    }

    // -------------------------------------------------------
    // boardToString: Converts the board to a single string
    // Useful for printing state IDs during search steps
    // -------------------------------------------------------
    public String boardToString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                sb.append(board[row][col]);
            }
        }
        return sb.toString(); // e.g., "XO.X..O.."
    }
}
