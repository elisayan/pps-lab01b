package it.unibo.pps.e2;

public class KnightImpl implements Knight {

    private Pair<Integer, Integer> position;
    private final MoveValidator validator;

    public KnightImpl(Pair<Integer, Integer> start,
                      MoveValidator validator) {
        this.position = start;
        this.validator = validator;
    }


    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }

    @Override
    public boolean moveTo(Pair<Integer, Integer> target) {
        if (this.validator.isValidMove(this.position, target)) {
            this.position = target;
            return true;
        }
        return false;
    }
}
