package it.unibo.pps.e2;

import java.util.Random;

public class LogicsImpl implements Logics {

    private final Pair<Integer, Integer> pawn;
    private final Knight knight;
    private final Board board;
    private final Random random = new Random();

    public LogicsImpl(int size) {
        MoveValidator validator = new MoveValidatorImpl();
        this.board = new BoardImpl(size);
        this.pawn = randomEmptyPosition();
        this.knight = new KnightImpl(randomEmptyPosition(), validator);
    }

    public LogicsImpl(Board board,
                      Pair<Integer, Integer> pawn,
                      Pair<Integer, Integer> knightPos,
                      MoveValidator validator) {
        this.board = board;
        this.pawn = pawn;
        this.knight = new KnightImpl(knightPos, validator);
    }

    private Pair<Integer, Integer> randomEmptyPosition() {
        Pair<Integer, Integer> pos =
                new Pair<>(this.random.nextInt(this.board.getSize()), this.random.nextInt(this.board.getSize()));
        return this.pawn != null && this.pawn.equals(pos)
                ? randomEmptyPosition()
                : pos;
    }

    @Override
    public boolean hit(int row, int col) {
        this.board.checkBounds(row, col);

        if (this.knight.moveTo(new Pair<>(row, col))) {
            return this.pawn.equals(this.knight.getPosition());
        }
        return false;
    }

    @Override
    public boolean hasKnight(int row, int col) {
        return this.knight.getPosition().equals(new Pair<>(row, col));
    }

    @Override
    public boolean hasPawn(int row, int col) {
        return this.pawn.equals(new Pair<>(row, col));
    }
}