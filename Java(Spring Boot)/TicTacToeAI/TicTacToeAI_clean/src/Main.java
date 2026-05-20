/**
 * Main.java
 * ============================================================
 * ENTRY POINT for the Tic-Tac-Toe AI Project
 *
 * PROJECT:  Tic-Tac-Toe AI using Minimax with Alpha-Beta Pruning
 * COURSE:   Artificial Intelligence
 * LANGUAGE: Java (Standard Library Only)
 *
 * HOW TO RUN:
 * -----------
 * 1. Compile:  javac src/*.java -d out/
 * 2. Run:      java -cp out Main
 * 3. Optional: java -cp out Main input/input.txt
 *
 * HOW TO USE:
 * -----------
 * - The AI plays as O, you play as X
 * - Enter row and column numbers (0, 1, or 2) when prompted
 * - The AI will show its search process before every move
 *
 * AI CONCEPTS DEMONSTRATED:
 * --------------------------
 * 1. State-space representation (board = state)
 * 2. Graph search (game tree exploration)
 * 3. Minimax algorithm (adversarial search)
 * 4. Alpha-Beta pruning (search optimization)
 * ============================================================
 */
public class Main {

    public static void main(String[] args) {

        // ---------------------------------------------------
        // STEP 1: Determine file paths
        // ---------------------------------------------------

        // Default input file path
        String inputFilePath = "input/input.txt";

        // Default output file path (where results are saved)
        String outputFilePath = "input/output.txt";

        // If the user provided a custom input file as argument, use it
        if (args.length > 0) {
            inputFilePath = args[0];
            System.out.println("[MAIN] Using custom input file: " + inputFilePath);
        }

        // ---------------------------------------------------
        // STEP 2: Load the initial board state from the file
        // ---------------------------------------------------
        System.out.println("[MAIN] Loading initial board state from file...");
        Board initialBoard = FileHandler.loadBoard(inputFilePath);

        // Validate: check that the loaded board isn't already finished
        if (initialBoard.isGameOver()) {
            System.out.println("[MAIN] WARNING: The loaded board is already in a finished state!");
            System.out.println("[MAIN] Please provide a board with moves remaining.");
            System.out.println("[MAIN] File format:");
            FileHandler.printFileInstructions();
            System.out.println("[MAIN] Starting with an empty board instead.");
            initialBoard = new Board(); // Fall back to empty board
        }

        // ---------------------------------------------------
        // STEP 3: Create and start the game
        // ---------------------------------------------------
        TicTacToe game = new TicTacToe(initialBoard, outputFilePath);
        game.start();

        // ---------------------------------------------------
        // STEP 4: Game finished — say goodbye
        // ---------------------------------------------------
        System.out.println("\n[MAIN] Game complete. Results saved to: " + outputFilePath);
        System.out.println("[MAIN] Thank you for playing!");
    }
}
