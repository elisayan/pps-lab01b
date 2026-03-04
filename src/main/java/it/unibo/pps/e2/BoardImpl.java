package it.unibo.pps.e2;

public class BoardImpl implements Board {

    private final int size;

    public BoardImpl(int size) {
        this.size = size;
    }

    private boolean isInside(int row, int col) {
        return row >= 0 && col >= 0
                && row < this.size && col < this.size;
    }

    @Override
    public boolean checkBounds(int row, int col) {
        if (!isInside(row, col)) {
            throw new IndexOutOfBoundsException();
        }
        return true;
    }

    @Override
    public int getSize() {
        return this.size;
    }
}
