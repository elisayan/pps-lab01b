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
        assertTrue(this.board.checkBounds(0, 0));
        assertTrue(this.board.checkBounds(4, 4));
        assertTrue(this.board.checkBounds(2, 3));
    }

    @Test
    void shouldThrowWhenOutside() {
        assertThrows(IndexOutOfBoundsException.class,
                () -> this.board.checkBounds(-1, 0));
        assertThrows(IndexOutOfBoundsException.class,
                () -> this.board.checkBounds(0, -1));
        assertThrows(IndexOutOfBoundsException.class,
                () -> this.board.checkBounds(5, 0));
        assertThrows(IndexOutOfBoundsException.class,
                () -> this.board.checkBounds(0, 5));
    }
}
