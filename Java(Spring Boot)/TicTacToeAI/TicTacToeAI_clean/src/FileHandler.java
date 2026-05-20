/**
 * FileHandler.java
 * ============================================================
 * This class handles reading the initial board state from a file
 * and saving game results to an output file.
 *
 * INPUT FILE FORMAT (input.txt):
 * ---------------------------------
 * The file must contain exactly 3 lines, each with 3 characters.
 * Use:
 *   X = Human player's symbol
 *   O = AI player's symbol
 *   . = Empty cell
 *
 * Example input.txt:
 *   X..
 *   .O.
 *   ...
 *
 * This represents:
 *   X is at top-left
 *   O is at center
 *   All other cells are empty
 * ============================================================
 */

import java.io.*;
import java.util.Scanner;

public class FileHandler {

    // -------------------------------------------------------
    // loadBoard: Reads the board state from a given file path
    // Returns a Board object, or null if file is invalid
    // -------------------------------------------------------
    public static Board loadBoard(String filePath) {

        System.out.println("[FILE] Loading board from: " + filePath);

        // The 2D array we will fill in
        char[][] boardData = new char[3][3];

        try {
            // Open the file for reading
            File file = new File(filePath);

            // Check if the file actually exists
            if (!file.exists()) {
                System.out.println("[FILE] File not found: " + filePath);
                System.out.println("[FILE] Starting with empty board instead.");
                return new Board(); // Return a fresh empty board
            }

            Scanner scanner = new Scanner(file);
            int row = 0;

            // Read each line of the file
            while (scanner.hasNextLine() && row < 3) {
                String line = scanner.nextLine().trim();

                // Each line should have exactly 3 characters
                if (line.length() != 3) {
                    System.out.println("[FILE] ERROR: Line " + (row + 1)
                            + " must have exactly 3 characters. Got: '" + line + "'");
                    scanner.close();
                    return new Board(); // Return empty board on error
                }

                // Read each character in the line
                for (int col = 0; col < 3; col++) {
                    char c = line.charAt(col);

                    // Validate each character
                    if (c == 'X' || c == 'x') {
                        boardData[row][col] = Board.HUMAN; // 'X'
                    } else if (c == 'O' || c == 'o') {
                        boardData[row][col] = Board.AI;    // 'O'
                    } else if (c == '.' || c == ' ') {
                        boardData[row][col] = Board.EMPTY; // '.'
                    } else {
                        System.out.println("[FILE] ERROR: Invalid character '" + c
                                + "' at row " + row + ", col " + col);
                        scanner.close();
                        return new Board(); // Return empty board on error
                    }
                }
                row++;
            }

            scanner.close();

            // Make sure we read exactly 3 rows
            if (row < 3) {
                System.out.println("[FILE] ERROR: File has only " + row + " row(s). Need 3.");
                return new Board();
            }

            System.out.println("[FILE] Board loaded successfully!");
            return new Board(boardData); // Return the loaded board

        } catch (Exception e) {
            System.out.println("[FILE] ERROR reading file: " + e.getMessage());
            return new Board(); // Return empty board on any error
        }
    }

    // -------------------------------------------------------
    // saveResult: Saves the final game result to a file
    // -------------------------------------------------------
    public static void saveResult(Board board, String result, String filePath) {

        try {
            // Create or overwrite the output file
            FileWriter writer = new FileWriter(filePath);

            writer.write("=== Tic-Tac-Toe Game Result ===\n\n");
            writer.write("Final Board:\n");

            // Write the board row by row
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    writer.write(board.getCell(row, col));
                }
                writer.write("\n");
            }

            writer.write("\nResult: " + result + "\n");
            writer.close();

            System.out.println("[FILE] Game result saved to: " + filePath);

        } catch (Exception e) {
            System.out.println("[FILE] ERROR saving result: " + e.getMessage());
        }
    }

    // -------------------------------------------------------
    // printFileInstructions: Shows how to format the input file
    // -------------------------------------------------------
    public static void printFileInstructions() {
        System.out.println("  Input file format (3 lines, 3 chars each):");
        System.out.println("  Use X for Human, O for AI, . for empty");
        System.out.println("  Example:");
        System.out.println("    X..");
        System.out.println("    .O.");
        System.out.println("    ...");
    }
}
