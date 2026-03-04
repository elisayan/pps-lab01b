package it.unibo.pps.e2;

public interface Knight {
    Pair<Integer, Integer> getPosition();

    boolean moveTo(Pair<Integer, Integer> target);
}
