package com.tw;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CellTest {
    @Test
    void shouldCheckIfCellIsEmpty() {
        Cell grid = new Cell();
        assertThat(grid.getStatus()).isEqualTo(false);
    }

    @Test
    void shouldCheckIfQueenHasBeenPlacesInAParticularCell() {
        Cell grid = new Cell();
        grid.placeQueen();
        assertThat(grid.getStatus()).isEqualTo(true);
    }
}
