package com.tw;

public enum Direction {
    N(new Position(-1, 0)),
    NE(new Position(-1, -1)),
    NW(new Position(-1, 1)),
    S(new Position(1, 0)),
    SE(new Position(1, -1)),
    SW(new Position(1, 1)),
    E(new Position(0, -1)),
    W(new Position(0, 1));

    private final Position position;

    Direction(Position bufferPosition) {
        this.position = bufferPosition;
    }

    public Position getBufferPosition() {
        return position;
    }
}
