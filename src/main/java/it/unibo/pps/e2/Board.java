package it.unibo.pps.e2;

public interface Board {

    /**
     * Check if the position is inside the board
     *
     * @param row the row index
     * @param col the column index
     * @return true if the position is inside the board, false otherwise
     */
    boolean checkBounds(int row, int col);

    /**
     * @return the size of the board
     */
    int getSize();
}
