package com.tw;

import com.tw.exceptions.BoardLimitExceededException;

import java.util.Random;

public class ChessBoard {
    final int size;
    final Cell[][] board;

    public ChessBoard(int size) {
        this.size = size;
        this.board = new Cell[this.size][this.size];
        clearBoard();
    }

    private void clearBoard() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = new Cell();
            }
        }
    }

    public void placeRandomQueens(int numQueensToPlace) throws BoardLimitExceededException {
        int numberOfCells = (int) Math.pow(board.length, 2);
        if (numQueensToPlace > numberOfCells) {
            throw new BoardLimitExceededException();
        }
        int maxBound = size - 1;

        while (numQueensToPlace > 0) {
            Position position = getRandomPosition(maxBound);
            if (!hasQueen(position)) {
                board[position.getX()][position.getY()].placeQueen();
                numQueensToPlace--;
            }
        }
    }

    private Position getRandomPosition(int maxBound) {
        Random random = new Random();
        int xPosition = random.nextInt(maxBound);
        int yPosition = random.nextInt(maxBound);
        return new Position(xPosition, yPosition);
    }

    boolean hasQueen(Position position) {
        return board[position.getX()][position.getY()].getStatus();
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

    private boolean inBounds(Position position) {
        Position origin = new Position(0, 0);
        Position maxPosition = new Position(size, size);
        boolean lowerBounds = origin.getX() <= position.getX() && position.getX() < maxPosition.getX();
        boolean upperBounds = origin.getY() <= position.getY() && position.getY() < maxPosition.getY();

        return lowerBounds && upperBounds;
    }

}

