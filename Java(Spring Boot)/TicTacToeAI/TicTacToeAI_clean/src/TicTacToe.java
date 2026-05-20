/**
 * TicTacToe.java
 * ============================================================
 * This class controls the overall flow of the Tic-Tac-Toe game.
 * It manages the game loop, turn switching, and win detection.
 *
 * This is the GAME CONTROLLER — it coordinates:
 *   - The Board (game state)
 *   - The Human player (keyboard input)
 *   - The AI player (Minimax decisions)
 * ============================================================
 */

import java.util.Scanner;

public class TicTacToe {

    // The game board (current state)
    private Board board;

    // The AI player object
    private AIPlayer aiPlayer;

    // Scanner for reading human input from the keyboard
    private Scanner scanner;

    // Track whose turn it is: true = AI's turn, false = Human's turn
    private boolean isAITurn;

    // Store the file path for saving results
    private String outputFilePath;

    // -------------------------------------------------------
    // Constructor: Sets up the game with a given board
    // -------------------------------------------------------
    public TicTacToe(Board initialBoard, String outputPath) {
        this.board = initialBoard;
        this.aiPlayer = new AIPlayer();
        this.scanner = new Scanner(System.in);
        this.outputFilePath = outputPath;

        // Determine who goes first based on loaded board state
        // Count X's and O's: if equal counts, X (Human) goes first
        this.isAITurn = shouldAIGoFirst();
    }

    // -------------------------------------------------------
    // shouldAIGoFirst: Determines turn order from initial state
    // Human (X) goes first in standard Tic-Tac-Toe.
    // If the board has equal X's and O's, Human goes first.
    // If X has more moves, it's AI's turn.
    // -------------------------------------------------------
    private boolean shouldAIGoFirst() {
        int xCount = 0, oCount = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                char cell = board.getCell(row, col);
                if (cell == Board.HUMAN) xCount++;
                else if (cell == Board.AI) oCount++;
            }
        }
        // If X has more or equal moves, it's O's (AI's) turn
        return (xCount > oCount);
    }

    // -------------------------------------------------------
    // start: The main game loop — runs until game ends
    // -------------------------------------------------------
    public void start() {

        printWelcome();

        System.out.println("\nInitial Board State:");
        board.printBoard();

        // Keep looping until the game is over
        while (!board.isGameOver()) {

            if (isAITurn) {
                // ---- AI's turn ----
                playAITurn();
            } else {
                // ---- Human's turn ----
                playHumanTurn();
            }

            // Show the board after each move
            System.out.println("Board after this move:");
            board.printBoard();

            // Switch turns
            isAITurn = !isAITurn;
        }

        // Game is over — show the result
        announceResult();
    }

    // -------------------------------------------------------
    // playHumanTurn: Asks the human player for input
    // -------------------------------------------------------
    private void playHumanTurn() {
        System.out.println("====================================================");
        System.out.println("  YOUR TURN (X) — Enter row and column (0, 1, or 2)");
        System.out.println("====================================================");

        int row = -1, col = -1;

        // Keep asking until we get a valid move
        while (true) {
            try {
                System.out.print("  Enter row (0-2): ");
                row = Integer.parseInt(scanner.nextLine().trim());

                System.out.print("  Enter col (0-2): ");
                col = Integer.parseInt(scanner.nextLine().trim());

                // Check if the move is valid
                if (board.isValidMove(row, col)) {
                    break; // Valid move — exit loop
                } else {
                    System.out.println("  That cell is already taken or out of range! Try again.");
                }

            } catch (NumberFormatException e) {
                System.out.println("  Please enter a number between 0 and 2.");
            }
        }

        // Apply the human's move to the board
        board.setCell(row, col, Board.HUMAN);
        System.out.println("  You placed X at Row " + row + ", Col " + col);
    }

    // -------------------------------------------------------
    // playAITurn: Lets the AI calculate and make its move
    // -------------------------------------------------------
    private void playAITurn() {
        aiPlayer.makeMove(board);
    }

    // -------------------------------------------------------
    // announceResult: Prints the final game outcome
    // -------------------------------------------------------
    private void announceResult() {
        System.out.println("====================================================");
        System.out.println("                  GAME OVER!");
        System.out.println("====================================================");

        String result;

        if (board.hasWinner(Board.HUMAN)) {
            result = "HUMAN WINS! (X wins)";
            System.out.println("  Congratulations! YOU WIN!");
        } else if (board.hasWinner(Board.AI)) {
            result = "AI WINS! (O wins)";
            System.out.println("  The AI wins! Better luck next time.");
        } else {
            result = "DRAW! (No winner)";
            System.out.println("  It's a DRAW! Well played!");
        }

        System.out.println("====================================================");
        System.out.println("\nFinal Board:");
        board.printBoard();

        // Save the result to an output file
        FileHandler.saveResult(board, result, outputFilePath);
    }

    // -------------------------------------------------------
    // printWelcome: Shows the welcome message at game start
    // -------------------------------------------------------
    private void printWelcome() {
        System.out.println("====================================================");
        System.out.println("        TIC-TAC-TOE with AI (Minimax + A-B)");
        System.out.println("====================================================");
        System.out.println("  Player: YOU (X)");
        System.out.println("  AI:     Computer (O)");
        System.out.println("  AI uses Minimax with Alpha-Beta Pruning");
        System.out.println("  Search depth: up to 9 half-steps (full game tree)");
        System.out.println("====================================================");
        System.out.println();
        System.out.println("  Board positions:");
        System.out.println("  (0,0) | (0,1) | (0,2)");
        System.out.println("  (1,0) | (1,1) | (1,2)");
        System.out.println("  (2,0) | (2,1) | (2,2)");
        System.out.println();
    }
}
