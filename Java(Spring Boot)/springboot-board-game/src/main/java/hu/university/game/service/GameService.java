package hu.university.game.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * Handles the core game logic for Tic-Tac-Toe.
 * This includes move validation, win detection, and draw detection.
 */
@Service
@RequiredArgsConstructor
public class GameService {

    /**
     * Places a symbol on the board at the specified row and column.
     *
     * @param board 2D char array representing the game board
     * @param row   row index (0-2)
     * @param col   column index (0-2)
     * @param symbol player symbol ('X' or 'O')
     * @return true if the move is valid and placed; false if the cell is already occupied
     */
    public boolean makeMove(char[][] board, int row, int col, char symbol) {
        if (board[row][col] == '-') {
            board[row][col] = symbol;
            return true;
        }
        return false;
    }


    /**
     * Checks if a given symbol has won the game.
     *
     * @param board 2D char array representing the game board
     * @param symbol player symbol to check
     * @return true if the symbol has a complete row, column, or diagonal
     */
    public boolean checkWin(char[][] board, char symbol) {
        for (int i = 0; i < 3; i++) {
            // check rows
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol)
                return true;
            // check columns
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)
                return true;
        }

        // check diagonals
        return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    /**
     * Checks if the board is full and no moves are possible (draw).
     *
     * @param board 2D char array representing the game board
     * @return true if the board is full and no player has won
     */
    public boolean isDraw(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == '-') return false;
            }
        }
        return true;
    }
}
