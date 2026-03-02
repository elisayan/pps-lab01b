package it.unibo.pps.e2;

import java.util.*;

public class LogicsImpl implements Logics {

    private final Pair<Integer, Integer> pawn;
    private Pair<Integer, Integer> knight;
    private final Random random = new Random();
    private final int size;
    private final MoveValidator moveValidator;

    public LogicsImpl(int size) {
        this(size, new MoveValidatorImpl());
    }

    public LogicsImpl(int size,
                      Pair<Integer, Integer> pawn,
                      Pair<Integer, Integer> knight) {
        this(size, pawn, knight, new MoveValidatorImpl());
    }

    public LogicsImpl(int size, MoveValidator moveValidator) {
        this.size = size;
        this.moveValidator = moveValidator;
        this.pawn = this.randomEmptyPosition();
        this.knight = this.randomEmptyPosition();
    }

    public LogicsImpl(int size, Pair<Integer, Integer> pawn, Pair<Integer, Integer> knight, MoveValidator moveValidator) {
        this.size = size;
        this.pawn = pawn;
        this.knight = knight;
        this.moveValidator = moveValidator;
    }

    private final Pair<Integer, Integer> randomEmptyPosition() {
        Pair<Integer, Integer> pos = new Pair<>(this.random.nextInt(size), this.random.nextInt(size));
        // the recursive call below prevents clash with an existing pawn
        return this.pawn != null && this.pawn.equals(pos) ? randomEmptyPosition() : pos;
    }

    @Override
    public boolean hit(int row, int col) {
        if (row < 0 || col < 0 || row >= this.size || col >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        // Below a compact way to express allowed moves for the knight
        if (moveValidator.isValidMove(this.knight, new Pair<>(row, col))) {
            this.knight = new Pair<>(row, col);
            return this.pawn.equals(this.knight);
        }
        return false;
    }

    @Override
    public boolean hasKnight(int row, int col) {
        return this.knight.equals(new Pair<>(row, col));
    }

    @Override
    public boolean hasPawn(int row, int col) {
        return this.pawn.equals(new Pair<>(row, col));
    }
}
