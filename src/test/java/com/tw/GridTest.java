package com.tw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridTest {
    @Test
    void shouldCheckIfGridIsEmpty() {
        Grid grid = new Grid();
        assertEquals(grid.getStatus(),false);
    }


}
