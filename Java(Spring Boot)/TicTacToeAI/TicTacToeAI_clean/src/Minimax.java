/**
 * Minimax.java
 * ============================================================
 * This class implements the MINIMAX algorithm with ALPHA-BETA PRUNING.
 *
 * MINIMAX EXPLAINED (Simple):
 * ---------------------------
 * Imagine you are playing chess and you want to think ahead.
 * - You look at all possible moves YOU can make.
 * - For each of your moves, you look at all moves your OPPONENT can make.
 * - You keep going until the game ends or you reach a depth limit.
 * - You MAXIMIZE your score, your opponent MINIMIZES your score.
 * - The AI picks the move that leads to the best guaranteed outcome.
 *
 * ALPHA-BETA PRUNING EXPLAINED (Simple):
 * ---------------------------------------
 * Alpha-Beta is an optimization that SKIPS branches in the game tree
 * that we KNOW will never be chosen. This makes the AI faster.
 * - Alpha: the best score the MAXIMIZER (AI) is guaranteed so far
 * - Beta:  the best score the MINIMIZER (Human) is guaranteed so far
 * - If beta <= alpha, we PRUNE (stop exploring) that branch
 *
 * SCORING:
 * --------
 *  +10 = AI wins
 *  -10 = Human wins
 *    0 = Draw
 * ============================================================
 */
public class Minimax {

    // Counter to track how many nodes (states) were explored
    // This is printed to show the search process
    private int nodesExplored;

    // Maximum search depth (number of half-moves / plies to look ahead)
    // For Tic-Tac-Toe, 9 is the full game depth (all 9 cells)
    // We use at least 8 as required by the assignment
    private static final int MAX_DEPTH = 9;

    // -------------------------------------------------------
    // Constructor
    // -------------------------------------------------------
    public Minimax() {
        this.nodesExplored = 0;
    }

    // -------------------------------------------------------
    // getBestMove: The main method called by AIPlayer
    // Returns the best [row, col] move for the AI
    // -------------------------------------------------------
    public int[] getBestMove(Board board) {
        nodesExplored = 0; // Reset counter for each AI turn

        int bestScore = Integer.MIN_VALUE; // Start with worst possible score
        int bestRow = -1;
        int bestCol = -1;

        System.out.println("\n  [AI SEARCH] Starting Minimax with Alpha-Beta Pruning...");
        System.out.println("  [AI SEARCH] Maximum depth: " + MAX_DEPTH + " half-steps");
        System.out.println("  --------------------------------------------------------");

        // Try every possible move on the board
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {

                // Only consider empty cells
                if (board.isValidMove(row, col)) {

                    // Simulate placing AI's symbol here
                    Board simulatedBoard = board.copyBoard();
                    simulatedBoard.setCell(row, col, Board.AI);

                    // Call minimax for this move (now it's the human's turn = minimizer)
                    // depth=1 (we already made one move), isMaximizing=false (human's turn)
                    // alpha = worst for AI (-infinity), beta = best for human (+infinity)
                    int score = minimax(simulatedBoard, 1, false,
                                        Integer.MIN_VALUE, Integer.MAX_VALUE,
                                        row, col);

                    System.out.println("  [AI SEARCH] Move (" + row + "," + col + ") -> Score: " + score);

                    // Keep track of the move with the best score
                    if (score > bestScore) {
                        bestScore = score;
                        bestRow = row;
                        bestCol = col;
                    }
                }
            }
        }

        System.out.println("  --------------------------------------------------------");
        System.out.println("  [AI SEARCH] Total nodes explored: " + nodesExplored);
        System.out.println("  [AI SEARCH] Best move: (" + bestRow + "," + bestCol + ") with score: " + bestScore);
        System.out.println();

        return new int[]{bestRow, bestCol};
    }

    // -------------------------------------------------------
    // minimax: The recursive Minimax algorithm
    //
    // Parameters:
    //   board         - the current board state (a NODE in the game tree)
    //   depth         - how many moves deep we are in the tree
    //   isMaximizing  - true = AI's turn (wants HIGH score)
    //                   false = Human's turn (wants LOW score)
    //   alpha         - best score AI has found so far (lower bound)
    //   beta          - best score Human has found so far (upper bound)
    //   lastRow, lastCol - where the last move was made (for printing)
    // -------------------------------------------------------
    private int minimax(Board board, int depth, boolean isMaximizing,
                        int alpha, int beta, int lastRow, int lastCol) {

        // Count this node as explored
        nodesExplored++;

        // Indentation for visual depth in output (shows tree structure)
        String indent = "  " + "    ".repeat(depth);

        // --------------------------------------------------
        // BASE CASES: Check if game is over or depth reached
        // --------------------------------------------------

        if (board.hasWinner(Board.AI)) {
            // AI won! Score is +10, subtract depth so shallower wins preferred
            int score = 10 - depth;
            System.out.println(indent + "[DEPTH " + depth + "] State: " + board.boardToString()
                    + " | AI WINS! Score=" + score);
            return score;
        }

        if (board.hasWinner(Board.HUMAN)) {
            // Human won! Score is -10, add depth so shallower losses avoided
            int score = depth - 10;
            System.out.println(indent + "[DEPTH " + depth + "] State: " + board.boardToString()
                    + " | HUMAN WINS! Score=" + score);
            return score;
        }

        if (board.isDraw()) {
            System.out.println(indent + "[DEPTH " + depth + "] State: " + board.boardToString()
                    + " | DRAW! Score=0");
            return 0;
        }

        if (depth >= MAX_DEPTH) {
            // Reached max depth limit — evaluate the board heuristically
            int score = evaluateBoard(board);
            System.out.println(indent + "[DEPTH " + depth + "] State: " + board.boardToString()
                    + " | MAX DEPTH Score=" + score);
            return score;
        }

        // --------------------------------------------------
        // RECURSIVE CASE
        // --------------------------------------------------

        if (isMaximizing) {
            // ---- AI's turn: try to MAXIMIZE the score ----
            int bestScore = Integer.MIN_VALUE;

            System.out.println(indent + "[DEPTH " + depth + "] MAXIMIZER (AI) evaluating state: "
                    + board.boardToString() + " | alpha=" + alpha + " beta=" + beta);

            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (board.isValidMove(row, col)) {

                        // Simulate AI placing at (row, col)
                        board.setCell(row, col, Board.AI);

                        // Recurse: now it's human's turn (minimizing)
                        int score = minimax(board, depth + 1, false, alpha, beta, row, col);

                        // Undo the move (backtrack)
                        board.setCell(row, col, Board.EMPTY);

                        // Update best score
                        if (score > bestScore) bestScore = score;

                        // Update alpha (best guaranteed score for AI)
                        if (score > alpha) alpha = score;

                        // ALPHA-BETA PRUNING:
                        // If alpha >= beta, the minimizer (human) will NEVER choose
                        // this branch because they already have a better option
                        if (alpha >= beta) {
                            System.out.println(indent + "  *** PRUNED! alpha(" + alpha
                                    + ") >= beta(" + beta + ") — skipping remaining branches ***");
                            return bestScore; // Prune remaining branches
                        }
                    }
                }
            }
            return bestScore;

        } else {
            // ---- Human's turn: try to MINIMIZE the score ----
            int bestScore = Integer.MAX_VALUE;

            System.out.println(indent + "[DEPTH " + depth + "] MINIMIZER (Human) evaluating state: "
                    + board.boardToString() + " | alpha=" + alpha + " beta=" + beta);

            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (board.isValidMove(row, col)) {

                        // Simulate human placing at (row, col)
                        board.setCell(row, col, Board.HUMAN);

                        // Recurse: now it's AI's turn (maximizing)
                        int score = minimax(board, depth + 1, true, alpha, beta, row, col);

                        // Undo the move (backtrack)
                        board.setCell(row, col, Board.EMPTY);

                        // Update best score
                        if (score < bestScore) bestScore = score;

                        // Update beta (best guaranteed score for Human)
                        if (score < beta) beta = score;

                        // ALPHA-BETA PRUNING:
                        // If beta <= alpha, the maximizer (AI) will NEVER choose
                        // this branch because they already have a better option
                        if (beta <= alpha) {
                            System.out.println(indent + "  *** PRUNED! beta(" + beta
                                    + ") <= alpha(" + alpha + ") — skipping remaining branches ***");
                            return bestScore; // Prune remaining branches
                        }
                    }
                }
            }
            return bestScore;
        }
    }

    // -------------------------------------------------------
    // evaluateBoard: Heuristic evaluation (used at max depth)
    // In standard Tic-Tac-Toe, games end before depth 9,
    // but this provides a safety net for partial evaluations
    // -------------------------------------------------------
    private int evaluateBoard(Board board) {
        // Check if AI or Human is one move away from winning
        // This gives a rough advantage score

        int aiScore = 0;
        int humanScore = 0;

        // Check rows
        for (int row = 0; row < 3; row++) {
            aiScore    += countLine(board, row, 0, 0, 1, Board.AI);
            humanScore += countLine(board, row, 0, 0, 1, Board.HUMAN);
        }

        // Check columns
        for (int col = 0; col < 3; col++) {
            aiScore    += countLine(board, 0, col, 1, 0, Board.AI);
            humanScore += countLine(board, 0, col, 1, 0, Board.HUMAN);
        }

        // Check main diagonal
        aiScore    += countLine(board, 0, 0, 1, 1, Board.AI);
        humanScore += countLine(board, 0, 0, 1, 1, Board.HUMAN);

        // Check anti-diagonal
        aiScore    += countLine(board, 0, 2, 1, -1, Board.AI);
        humanScore += countLine(board, 0, 2, 1, -1, Board.HUMAN);

        return aiScore - humanScore;
    }

    // -------------------------------------------------------
    // countLine: Counts how many of 'player' symbols are in
    // a line (row/col/diagonal) with no opponent blocking it
    // -------------------------------------------------------
    private int countLine(Board board, int startRow, int startCol,
                           int dRow, int dCol, char player) {
        int count = 0;
        char opponent = (player == Board.AI) ? Board.HUMAN : Board.AI;

        for (int i = 0; i < 3; i++) {
            char cell = board.getCell(startRow + i * dRow, startCol + i * dCol);
            if (cell == opponent) return 0; // Blocked by opponent
            if (cell == player) count++;
        }
        return count;
    }

    // -------------------------------------------------------
    // getNodesExplored: Returns the count of explored nodes
    // -------------------------------------------------------
    public int getNodesExplored() {
        return nodesExplored;
    }
}
