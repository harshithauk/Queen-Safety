package com.tw;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PositionTest {

    @Test
    void shouldCheckIfRandomPositionIsCreated() {
        assertThat(Position.getRandomPosition(6)).isInstanceOf(Position.class);
    }

    @Test
    void shouldCheckIfAPositionIsGreaterThanTheOther() {
        assertThat(Position.compare(new Position(5,4), new Position(0,2))).isEqualTo(true);
    }
}
