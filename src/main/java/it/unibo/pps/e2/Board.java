package it.unibo.pps.e2;

public interface Board {
    boolean isInside(int i, int i1);

    void checkBounds(int row, int col);

    int getSize();
}
