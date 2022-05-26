package com.tw;

import java.util.Random;

public class ChessBoard {
    final int size;
    final Cell[][] board;

    public ChessBoard() {
        this.size = 8;
        this.board = new Cell[size][size];
        clearBoard();
    }

    private void clearBoard() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = new Cell();
            }
        }
    }

    public void placeRandomQueens(int numQueensToPlace) {
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
        return new Position(xPosition,yPosition);
    }

    private boolean hasQueen(Position position) {
        return board[position.getX()][position.getY()].getStatus();
    }

    public boolean identifySafeLocation(Position position) {
        if (!hasQueen(position)) {
            return isSafe(position);
        }
        return false;
    }

    public boolean isSafe(Position currentPosition) {
        Direction[] setOfDirections = Direction.values();

        for (Direction direction : setOfDirections) {
            Position bufferPosition = direction.getBufferPosition();
            Position newPosition = getNextPosition(currentPosition, bufferPosition);

            while (inBounds(newPosition)) {
                if (hasQueen(newPosition)) {
                    return false;
                }
                newPosition = getNextPosition(newPosition, bufferPosition);
            }

        }
        return true;
    }

    private Position getNextPosition(Position currentPosition, Position bufferPosition) {
        return new Position(currentPosition.getX() + bufferPosition.getX(),
                currentPosition.getY() + bufferPosition.getY());
    }
    private boolean inBounds(Position position) {
        Position origin = new Position(0,0);
        Position maxPosition = new Position(size,size);
        return (origin.getX() <= position.getX() && position.getX() < maxPosition.getX())
                && (origin.getY() <= position.getY() && position.getY() < maxPosition.getY());

    }

}

