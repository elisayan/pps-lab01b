package it.unibo.pps.e2;

public interface MoveValidator {

    /**
     * Checks if the knight can move from a position to another position using an L-shape
     *
     * @param from the starting position
     * @param to the target position
     * @return true if the move is a valid knight move
     */
    boolean isValidMove(Pair<Integer, Integer> from, Pair<Integer, Integer> to);
}
