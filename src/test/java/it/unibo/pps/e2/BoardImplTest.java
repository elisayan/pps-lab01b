package it.unibo.pps.e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardImplTest {

    @Test
    void shouldAcceptValidPositions() {
        Board board = new BoardImpl(5);

        assertTrue(board.isInside(0, 0));
        assertTrue(board.isInside(4, 4));
        assertTrue(board.isInside(2, 3));
    }

    @Test
    void shouldRejectInvalidPositions() {
        Board board = new BoardImpl(5);

        assertFalse(board.isInside(-1, 0));
        assertFalse(board.isInside(0, -1));
        assertFalse(board.isInside(5, 0));
        assertFalse(board.isInside(0, 5));
    }

    @Test
    void shouldThrowWhenOutside() {
        Board board = new BoardImpl(5);

        assertThrows(IndexOutOfBoundsException.class,
                () -> board.checkBounds(-1, 0));
    }
}
