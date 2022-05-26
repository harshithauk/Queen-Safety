package com.tw;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {
    @Test
    void shouldCheckIfCorrectBufferPositionIsReceivedForParticularDirection() {
        assertThat(Direction.N.getBufferPosition().getX()).isEqualTo(-1);
        assertThat(Direction.N.getBufferPosition().getY()).isEqualTo(0);
    }
}
