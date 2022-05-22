package com.tw;

public class ChessBoard {
    private final int size;
    private final Grid[][] board;

    public ChessBoard() {
        this.size = 8;
        this.board = new Grid[size][size];
        createGrid();
    }

    private void createGrid() {
        for (int row = 0; row < size ; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = new Grid();
            }
        }
    }

    public int getSize() {
        return size;
    }

    public int getNumberOfCells() {
        return size * size;
    }


}

