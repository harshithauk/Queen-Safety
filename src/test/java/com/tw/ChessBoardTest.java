package com.tw;


import com.tw.exceptions.BoardLimitExceededException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;


public class ChessBoardTest {
    @Test
    void shouldCheckIfChessBoardIsCreated() {
        ChessBoard chessBoard = new ChessBoard(8);
        assertThat(chessBoard.size).isEqualTo(8);
    }

    @Test
    void shouldCheckIfCorrectNumberOfGridsAreCreatedInTheBoard() {
        ChessBoard chessBoard = new ChessBoard(8);
        var numberOfCells = Math.pow(chessBoard.board.length, 2);
        assertThat(numberOfCells).isEqualTo(64);
    }

    @Test
    void shouldCheckIfACellHasQueen() {
        ChessBoard chessBoard = new ChessBoard(8);
        assertThat(chessBoard.hasQueen(new Position(0,1))).isEqualTo(false);
    }

    @Test
    void shouldCheckIfAllTheQueensArePlacedOnTheBoard() throws BoardLimitExceededException {
        ChessBoard chessBoard = new ChessBoard(8);
        chessBoard.placeRandomQueens(8);
        int numberOfQueens = 0;

        for (int row = 0; row < chessBoard.size; row++) {
            for (int col = 0; col < chessBoard.size; col++) {
                if (chessBoard.board[row][col].getStatus()) {
                    numberOfQueens++;
                }
            }
        }
        assertThat(numberOfQueens).isEqualTo(8);
    }

    @Test
    void shouldCheckIfACellIsSafeFromAttack() throws BoardLimitExceededException {
        ChessBoard chessBoard = new ChessBoard(8);
        chessBoard.placeRandomQueens(0);
        assertThat( chessBoard.isSafe(new Position(7, 4))).isEqualTo(true);
    }

    @Test
    void shouldNotPlaceQueensIfNumberOfQueensExceedTheBoardLimit() {
        ChessBoard chessBoard = new ChessBoard(8);
        Throwable thrown = catchThrowable(()-> chessBoard.placeRandomQueens(65));
        assertThat(thrown).isInstanceOf(Exception.class);
    }
}
