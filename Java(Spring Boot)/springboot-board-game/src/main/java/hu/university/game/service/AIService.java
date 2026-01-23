package hu.university.game.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Handles machine opponent moves.
 * Currently, the AI chooses a random empty cell for its move.
 */
@Service
@RequiredArgsConstructor
public class AIService {

    private final Random random = new Random();

    /**
     * Makes a random valid move on the board for the AI ('O').
     *
     * @param board 2D char array representing the game board
     */
    public void makeRandomMove(char[][] board) {
        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (board[row][col] != '-');

        board[row][col] = 'O';
    }
}
