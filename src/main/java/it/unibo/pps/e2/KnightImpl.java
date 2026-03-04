package it.unibo.pps.e2;

public class KnightImpl implements Knight {

    private Pair<Integer, Integer> position;
    private final MoveValidator validator;

    public KnightImpl(final Pair<Integer, Integer> start,
                      final MoveValidator validator) {
        this.position = start;
        this.validator = validator;
    }


    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }

    @Override
    public boolean moveTo(final Pair<Integer, Integer> target) {
        if (this.validator.isValidMove(this.position, target)) {
            this.position = target;
            return true;
        }
        return false;
    }
}
