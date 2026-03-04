package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KnightImplTest {

    private KnightImpl knight;
    private Pair<Integer, Integer> start;

    @BeforeEach
    public void setUp() {
        MoveValidator validator = new MoveValidatorImpl();
        this.start = new Pair<>(0, 0);
        this.knight = new KnightImpl(this.start, validator);
    }

    @Test
    void shouldHaveInitialPosition() {
        assertEquals(this.start, this.knight.getPosition());
    }

    @Test
    void shouldMoveIfValid() {
        boolean moved = this.knight.moveTo(new Pair<>(1, 2));

        assertTrue(moved);
        assertEquals(new Pair<>(1, 2), this.knight.getPosition());
    }

    @Test
    void shouldNotMoveIfInvalid() {
        boolean moved = this.knight.moveTo(new Pair<>(1, 1));

        assertFalse(moved);
        assertEquals(this.start, this.knight.getPosition());
    }
}
