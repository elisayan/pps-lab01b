package it.unibo.pps.e2;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

    private Board board;
    private Logics logic;
    private MoveValidatorImpl validator;
    private static final int SIZE = 5;

    @BeforeEach
    public void setUp() {
        this.board = new BoardImpl(SIZE);
        this.validator = new MoveValidatorImpl();
    }

    @Test
    void shouldHasKnightAndPawn() {
        var pawn = new Pair<>(2, 2);
        var knight = new Pair<>(0, 1);
        this.logic = new LogicsImpl(this.board, pawn, knight, this.validator);

        assertTrue(this.logic.hasKnight(0, 1));
        assertTrue(this.logic.hasPawn(2, 2));
    }

    @Test
    void shouldIgnoreInvalidMove() {
        var pawn = new Pair<>(4, 4);
        var knight = new Pair<>(0, 0);
        this.logic = new LogicsImpl(this.board, pawn, knight, this.validator);

        assertFalse(this.logic.hit(1, 1));
        assertTrue(this.logic.hasKnight(0, 0));
    }

    @Test
    void shouldCapturePawn() {
        var pawn = new Pair<>(1, 2);
        var knight = new Pair<>(0, 0);
        this.logic = new LogicsImpl(this.board, pawn, knight, this.validator);

        assertTrue(this.logic.hit(1, 2));
    }

    @Test
    void shouldThrowIfOutOfBounds() {
        var pawn = new Pair<>(2, 2);
        var knight = new Pair<>(0, 0);
        this.logic = new LogicsImpl(this.board, pawn, knight, this.validator);

        assertThrows(IndexOutOfBoundsException.class,
                () -> this.logic.hit(-1, 0));
    }
}
