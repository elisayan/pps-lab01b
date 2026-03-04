package it.unibo.pps.e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KnightImplTest {

    @Test
    void knightHasInitialPosition() {
        var start = new Pair<>(0, 0);
        MoveValidator validator = new MoveValidatorImpl();

        Knight knight = new KnightImpl(start, validator);

        assertEquals(start, knight.getPosition());
    }

    @Test
    void knightMovesIfMoveIsValid() {
        var start = new Pair<>(0, 0);
        MoveValidator validator = new MoveValidatorImpl();

        Knight knight = new KnightImpl(start, validator);

        boolean moved = knight.moveTo(new Pair<>(1, 2));

        assertTrue(moved);
        assertEquals(new Pair<>(1, 2), knight.getPosition());
    }

    @Test
    void knightDoesNotMoveIfMoveInvalid() {
        var start = new Pair<>(0, 0);
        MoveValidator validator = new MoveValidatorImpl();

        Knight knight = new KnightImpl(start, validator);

        boolean moved = knight.moveTo(new Pair<>(1, 1));

        assertFalse(moved);
        assertEquals(start, knight.getPosition());
    }
}
