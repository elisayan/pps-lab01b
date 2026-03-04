package it.unibo.pps.e2;

public class MoveValidatorImpl implements MoveValidator {
    @Override
    public boolean isValidMove(final Pair<Integer, Integer> from, final Pair<Integer, Integer> to) {
        int x = to.getX() - from.getX();
        int y = to.getY() - from.getY();
        return x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == 3;
    }
}
