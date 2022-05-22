package com.tw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChessBoardTest {
    @Test
    void shouldCheckIfChessBoardIsCreated() {
        ChessBoard chessBoard = new ChessBoard();
        Assertions.assertEquals(chessBoard.getSize(),8);
    }

    @Test
    void shouldCheckIfCorrectNumberOfGridsAreCreatedInTheBoard() {
        ChessBoard chessBoard = new ChessBoard();
        Assertions.assertEquals(chessBoard.getNumberOfCells(),64);
    }


}
