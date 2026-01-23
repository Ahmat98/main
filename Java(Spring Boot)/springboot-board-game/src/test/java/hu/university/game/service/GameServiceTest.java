package hu.university.game.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameServiceTest {

    private GameService gameService;
    private char[][] board;

    @BeforeEach
    void setUp() {
        gameService = new GameService();
        board = new char[][]{
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };
    }

    @Test
    void testValidMove() {
        boolean result = gameService.makeMove(board, 0, 0, 'X');
        assertTrue(result);
        assertEquals('X', board[0][0]);
    }

    @Test
    void testInvalidMove() {
        gameService.makeMove(board, 0, 0, 'X');
        boolean result = gameService.makeMove(board, 0, 0, 'O');
        assertFalse(result);
    }

    @Test
    void testWinRow() {
        board[0][0] = 'X';
        board[0][1] = 'X';
        board[0][2] = 'X';
        assertTrue(gameService.checkWin(board, 'X'));
    }

    @Test
    void testWinColumn() {
        board[0][0] = 'O';
        board[1][0] = 'O';
        board[2][0] = 'O';
        assertTrue(gameService.checkWin(board, 'O'));
    }

    @Test
    void testWinDiagonal() {
        board[0][0] = 'X';
        board[1][1] = 'X';
        board[2][2] = 'X';
        assertTrue(gameService.checkWin(board, 'X'));
    }

    @Test
    void testDraw() {
        char[][] drawBoard = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'O', 'X', 'O'}
        };
        assertTrue(gameService.isDraw(drawBoard));
        assertFalse(gameService.checkWin(drawBoard, 'X'));
        assertFalse(gameService.checkWin(drawBoard, 'O'));
    }

    @Test
    void testNotDraw() {
        assertFalse(gameService.isDraw(board)); // empty board not draw
        board[0][0] = 'X';
        assertFalse(gameService.isDraw(board));
    }
}
