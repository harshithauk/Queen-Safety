package com.tw;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ChessBoardTest {
    @Test
    void shouldCheckIfChessBoardIsCreated() {
        ChessBoard chessBoard = new ChessBoard();
        assertEquals(8, chessBoard.size);
    }

    @Test
    void shouldCheckIfCorrectNumberOfGridsAreCreatedInTheBoard() {
        ChessBoard chessBoard = new ChessBoard();
        assertEquals(64, Math.pow(chessBoard.board.length, 2));
    }

    @Test
    void shouldCheckIfAGridHasAQueenInIt() {
        ChessBoard chessBoard = new ChessBoard();
        assertEquals(false, chessBoard.board[0][1].getStatus());
    }

    @Test
    void shouldCheckIfAllTheQueensArePlacedOnTheBoard() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.placeRandomQueens(8);
        int numberOfQueens = 0;

        for (int row = 0; row < chessBoard.size; row++) {
            for (int col = 0; col < chessBoard.size; col++) {
                if (chessBoard.board[row][col].getStatus()) {
                    numberOfQueens++;
                }
            }
        }
        assertEquals(8, numberOfQueens);
    }

    @Test
    void shouldCheckIfACellIsSafeFromAttack() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.placeRandomQueens(8);
        assertEquals(true,chessBoard.identifySafeLocation(new Position(7,4)));
    }
}
