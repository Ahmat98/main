/**
 * AIPlayer.java
 * ============================================================
 * This class represents the AI player in the game.
 * It uses the Minimax algorithm (from Minimax.java) to decide
 * the best move.
 *
 * Think of this as the "brain" wrapper — it holds the AI's
 * identity (symbol 'O') and asks Minimax for move decisions.
 * ============================================================
 */
public class AIPlayer {

    // The symbol the AI uses on the board
    private char symbol;

    // The Minimax engine that calculates the best move
    private Minimax minimaxEngine;

    // -------------------------------------------------------
    // Constructor: Creates the AI player with symbol 'O'
    // -------------------------------------------------------
    public AIPlayer() {
        this.symbol = Board.AI; // 'O'
        this.minimaxEngine = new Minimax();
    }

    // -------------------------------------------------------
    // makeMove: Calculates and applies the best move
    // Returns the chosen [row, col] array
    // -------------------------------------------------------
    public int[] makeMove(Board board) {

        System.out.println("\n====================================================");
        System.out.println("  AI PLAYER (" + symbol + ") IS THINKING...");
        System.out.println("====================================================");

        // Ask the Minimax engine to find the best move
        int[] bestMove = minimaxEngine.getBestMove(board);

        // Apply the move to the actual board
        board.setCell(bestMove[0], bestMove[1], symbol);

        System.out.println("  AI chose position: Row " + bestMove[0] + ", Col " + bestMove[1]);

        return bestMove;
    }

    // -------------------------------------------------------
    // getSymbol: Returns the AI's symbol
    // -------------------------------------------------------
    public char getSymbol() {
        return symbol;
    }
}
