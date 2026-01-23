package hu.university.game.runner;

import hu.university.game.service.AIService;
import hu.university.game.service.BoardService;
import hu.university.game.service.GameService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * Command-line runner for playing Tic-Tac-Toe.
 * Orchestrates the game loop: human moves, AI moves, win/draw detection, and board persistence.
 */
@Component
@RequiredArgsConstructor
public class GameRunner implements CommandLineRunner {

    private final GameService gameService;
    private final AIService aiService;
    private final BoardService boardService;

    private static final Logger log = LoggerFactory.getLogger(GameRunner.class);

    /**
     * Runs the Tic-Tac-Toe game in the console.
     * Handles user input, AI moves, and saves the final board to the database.
     *
     * @param args command line arguments (ignored)
     */
    @Override
    public void run(String... args) throws Exception {

        char[][] board = {
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };

        Scanner scanner = new Scanner(System.in);

        log.info("Game started");
        printBoard(board);

        while (true) {
            // --- Human move ---
            int row, col;
            while (true) {
                System.out.print("Enter row (0-2): ");
                row = scanner.nextInt();
                System.out.print("Enter column (0-2): ");
                col = scanner.nextInt();
                if (gameService.makeMove(board, row, col, 'X')) break;
                System.out.println("Invalid move! Try again.");
            }
            log.info("Human moved to ({},{})", row, col);
            printBoard(board);

            if (gameService.checkWin(board, 'X')) {
                System.out.println("You win! 🎉");
                log.info("Human won the game");
                break;
            }

            if (gameService.isDraw(board)) {
                System.out.println("Game is a draw! 🤝");
                log.info("Game ended in a draw");
                break;
            }

            // --- Machine move ---
            aiService.makeRandomMove(board);
            System.out.println("Machine played:");
            log.info("Machine made a move");
            printBoard(board);

            if (gameService.checkWin(board, 'O')) {
                System.out.println("Machine wins 🤖");
                log.info("Machine won the game");
                break;
            }

            if (gameService.isDraw(board)) {
                System.out.println("Game is a draw! 🤝");
                log.info("Game ended in a draw");
                break;
            }
        }

        // --- Save board to database ---
        String serializedBoard = serializeBoard(board);
        boardService.saveBoard(serializedBoard);
        System.out.println("Board saved to MySQL database.");
        log.info("Board saved to database");
    }

    /**
     * Prints the board to the console.
     */
    private void printBoard(char[][] board) {
        System.out.println("Current board:");
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    /**
     * Converts board to string for storage.
     */
    private String serializeBoard(char[][] board) {
        StringBuilder sb = new StringBuilder();
        for (char[] row : board) {
            for (char c : row) sb.append(c);
            sb.append("\n");
        }
        return sb.toString();

    }
}
