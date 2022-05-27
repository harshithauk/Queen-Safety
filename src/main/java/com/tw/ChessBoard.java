package com.tw;

import com.tw.exceptions.BoardLimitExceededException;

public class ChessBoard {
    final int numberOfRows;
    final int numberOfCols;
    final Cell[][] board;

    public ChessBoard(int numberOfRows) {
        this.numberOfRows = numberOfRows;
        this.numberOfCols = numberOfRows;
        this.board = new Cell[this.numberOfRows][this.numberOfCols];
        clearBoard();
    }

    private void clearBoard() {
        for (int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numberOfCols; col++) {
                board[row][col] = new Cell();
            }
        }
    }

    public void placeRandomQueens(int numQueensToPlace) throws BoardLimitExceededException {
        int numberOfCells = (int) Math.pow(board.length, 2);
        if (numQueensToPlace > numberOfCells) {
            throw new BoardLimitExceededException();
        }
        int maxBound = numberOfRows - 1;

        while (numQueensToPlace > 0) {
            Position position = Position.getRandomPosition(maxBound);
            if (!hasQueen(position)) {
                board[position.getX()][position.getY()].placeQueen();
                numQueensToPlace--;
            }
        }
    }


    boolean hasQueen(Position position) {
        if (inBounds(position)) {
            return board[position.getX()][position.getY()].getStatus();
        } else {
            return false;
        }

    }

    public boolean isSafe(Position currentPosition) {
        Direction[] setOfDirections = Direction.values();

        for (Direction direction : setOfDirections) {
            Position bufferPosition = direction.getBufferPosition();

            while (inBounds(currentPosition)) {
                if (hasQueen(currentPosition)) {
                    return false;
                }
                currentPosition = getNextPosition(currentPosition, bufferPosition);
            }
        }
        return true;
    }

    private Position getNextPosition(Position currentPosition, Position bufferPosition) {
        return new Position(currentPosition.getX() + bufferPosition.getX(),
                currentPosition.getY() + bufferPosition.getY());
    }

    public boolean inBounds(Position currentPosition) {
        Position origin = new Position(0, 0);
        Position maxPosition = new Position(numberOfRows-1, numberOfCols-1);

        return Position.compare(currentPosition, origin) && Position.compare(maxPosition, currentPosition);
    }

}

