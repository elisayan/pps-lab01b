package it.unibo.pps.e2;

public interface Knight {

    /**
     * @return the current position of the knight.
     */
    Pair<Integer, Integer> getPosition();

    /**
     * Moves the knight to the target if the move is valid
     *
     * @param target the destination position.
     * @return true if the move was successful, false otherwise.
     */
    boolean moveTo(Pair<Integer, Integer> target);
}
