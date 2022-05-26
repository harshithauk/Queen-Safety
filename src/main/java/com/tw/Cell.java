package com.tw;

public class Cell {
    private boolean status;

    public Cell() {
        this.status = false;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void placeQueen() {
        this.status = true;
    }
}
