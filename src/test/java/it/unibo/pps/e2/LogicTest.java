package it.unibo.pps.e2;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

    @Test
    public void test() {
        assert (true);
        // TODO: Add your test logic here
        // You can generate random inputs and assert the expected output
        // For example:
        //int result = LogicsImpl.someMethod(5, 10);
        //assertEquals(expectedResult, result);
    }

    @Test
    void shouldHasKnight() {
        var pawn = new Pair<>(2, 2);
        var knight = new Pair<>(0, 1);
        Logics logic = new LogicsImpl(5, pawn, knight);

        assertTrue(logic.hasKnight(0, 1));
        assertTrue(logic.hasPawn(2, 2));
    }

    @Test
    void knightShouldMoveCorrectly() {
        var pawn = new Pair<>(4, 4);
        var knight = new Pair<>(0, 0);
        Logics logic = new LogicsImpl(5, pawn, knight);

        boolean result = logic.hit(1, 2);

        assertFalse(result);
        assertTrue(logic.hasKnight(1, 2));
    }

    @Test
    void invalidMoveShouldDoesNothing() {
        var pawn = new Pair<>(4, 4);
        var knight = new Pair<>(0, 0);
        Logics logic = new LogicsImpl(5, pawn, knight);

        boolean result = logic.hit(1, 1);

        assertFalse(result);
        assertTrue(logic.hasKnight(0, 0));
    }

    @Test
    void hitReturnsTrueIfPawnCaptured() {
        var pawn = new Pair<>(1, 2);
        var knight = new Pair<>(0, 0);
        Logics logic = new LogicsImpl(5, pawn, knight);

        boolean result = logic.hit(1, 2);

        assertTrue(result);
    }

    @Test
    void outOfBoundsThrows() {
        var pawn = new Pair<>(2, 2);
        var knight = new Pair<>(0, 0);
        Logics logic = new LogicsImpl(5, pawn, knight);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            logic.hit(-1, 0);
        });
    }

    @Test
    void validKnightMoves() {
        MoveValidator validator = new MoveValidatorImpl();
        var from = new Pair<>(0, 0);

        assertTrue(validator.isValidMove(from, new Pair<>(1, 2)));
        assertTrue(validator.isValidMove(from, new Pair<>(2, 1)));
    }

    @Test
    void invalidKnightMoves() {
        MoveValidator validator = new MoveValidatorImpl();
        var from = new Pair<>(0, 0);

        assertFalse(validator.isValidMove(from, new Pair<>(1, 1)));
        assertFalse(validator.isValidMove(from, new Pair<>(0, 2)));
    }

}
