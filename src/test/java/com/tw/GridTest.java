package com.tw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridTest {
    @Test
    void shouldCheckIfGridIsEmpty() {
        Cell grid = new Cell();
        assertEquals(grid.getStatus(),false);
    }

    @Test
    void shouldCheckIfQueenHasBeenPlacesInAParticularCell() {
        Cell grid = new Cell();
        grid.placeQueen();
        assertEquals(grid.getStatus(),true);
    }
}
