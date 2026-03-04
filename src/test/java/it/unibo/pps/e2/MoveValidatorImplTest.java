package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoveValidatorImplTest {

    private MoveValidatorImpl validator;

    @BeforeEach
    void setUp() {
        this.validator = new MoveValidatorImpl();
    }

    @Test
    void validKnightMoves() {
        var from = new Pair<>(0, 0);

        assertTrue(this.validator.isValidMove(from, new Pair<>(1, 2)));
        assertTrue(this.validator.isValidMove(from, new Pair<>(2, 1)));
    }

    @Test
    void invalidKnightMoves() {
        var from = new Pair<>(0, 0);

        assertFalse(this.validator.isValidMove(from, new Pair<>(1, 1)));
        assertFalse(this.validator.isValidMove(from, new Pair<>(0, 2)));
    }
}
