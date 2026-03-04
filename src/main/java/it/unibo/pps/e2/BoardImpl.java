package it.unibo.pps.e2;

public class BoardImpl implements Board {

    private final int size;

    public BoardImpl(final int size) {
        this.size = size;
    }

    private boolean isInside(final int row, final int col) {
        return row >= 0 && col >= 0
                && row < this.size && col < this.size;
    }

    @Override
    public boolean checkBounds(final int row, final int col) {
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
