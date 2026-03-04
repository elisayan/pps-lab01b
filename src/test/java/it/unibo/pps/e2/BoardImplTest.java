package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardImplTest {

    private BoardImpl board;
    private static final int SIZE = 5;

    @BeforeEach
    public void setUp() {
        this.board = new BoardImpl(SIZE);
    }

    @Test
    void shouldAcceptValidPositions() {
        assertTrue(this.board.isInside(0, 0));
        assertTrue(this.board.isInside(4, 4));
        assertTrue(this.board.isInside(2, 3));
    }

    @Test
    void shouldRejectInvalidPositions() {
        assertFalse(this.board.isInside(-1, 0));
        assertFalse(this.board.isInside(0, -1));
        assertFalse(this.board.isInside(5, 0));
        assertFalse(this.board.isInside(0, 5));
    }

    @Test
    void shouldThrowWhenOutside() {
        assertThrows(IndexOutOfBoundsException.class,
                () -> this.board.checkBounds(-1, 0));
    }
}
