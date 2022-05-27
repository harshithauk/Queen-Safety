package com.tw;

import java.util.Random;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static boolean compare(Object o1, Object o2) {
        Position position = (Position) o1;
        Position anotherPosition = (Position) o2;

        return position.getX() >= anotherPosition.getX() && position.getY() >= anotherPosition.getY();

    }

    public static Position getRandomPosition(int maxBound) {
        Random random = new Random();
        int xPosition = random.nextInt(maxBound);
        int yPosition = random.nextInt(maxBound);
        return new Position(xPosition, yPosition);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
