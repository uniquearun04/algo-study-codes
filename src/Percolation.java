public class Percolation {

    private WeightedQuickUnionUF wquUF = null;
    private WeightedQuickUnionUF wquUF2 = null;
    private boolean[] state;
    private int valN = 0;
    
    private int gridLen = 0;
    
    // create N-by-N grid, with all sites blocked
    public Percolation(int N) {
        valN = N;
        gridLen = N * N + 2;
        wquUF = new WeightedQuickUnionUF(gridLen);
        wquUF2 = new WeightedQuickUnionUF(gridLen - 1);

        state = new boolean[gridLen];

        for (int i = 0; i < gridLen; i++) {
            state[i] = false;
        }
//        state[0] = state[valN - 1] = true;
    }

    // TODO open last element
    // open site (row i, column j) if it is not already
    public void open(int row, int col) {

        int i = row - 1;
        int j = col - 1;

        if (i < 0 || j < 0 || i >= valN || j >= valN) {
            throw new IndexOutOfBoundsException();
        }
//        if (isValidIndex(i, j, valN)) {
            int curIndex = oneDArrayIndex(i, j, valN);
            state[oneDArrayIndex(i, j, valN)] = true;

            // upper
            if (isValidIndex(i - 1, j, valN)) {
                int upperIndex = oneDArrayIndex(i - 1, j, valN);
                if (state[upperIndex]) {
                    wquUF.union(curIndex, upperIndex);
                    wquUF2.union(curIndex, upperIndex);
                }
            }
            // left
            if (isValidIndex(i, j - 1, valN)) {
                int leftIndex = oneDArrayIndex(i, j - 1, valN);
                if (state[leftIndex]) {
                    wquUF.union(curIndex, leftIndex);
                    wquUF2.union(curIndex, leftIndex);
                }
            }
            // lower
            if (isValidIndex(i + 1, j, valN)) {
                int lowerIndex = oneDArrayIndex(i + 1, j, valN);
                if (state[lowerIndex]) {
                    wquUF.union(curIndex, lowerIndex);
                    wquUF2.union(curIndex, lowerIndex);
                }
            }
            // right
            if (isValidIndex(i, j + 1, valN)) {
                int rightIndex = oneDArrayIndex(i, j + 1, valN);
                if (state[rightIndex]) {
                    wquUF.union(curIndex, rightIndex);
                    wquUF2.union(curIndex, rightIndex);
                }
            }
            if (i == 0) {
                wquUF.union(curIndex, 0);
                wquUF2.union(curIndex, 0);
            }

            if (i == valN - 1) {
                wquUF.union(curIndex, gridLen - 1);
            }
//        }

    }

    // is site (row i, column j) open?
    public boolean isOpen(int row, int col) {
        int i = row - 1;
        int j = col - 1;

        if (i < 0 || j < 0 || i >= valN || j >= valN) {
            throw new IndexOutOfBoundsException();
        }

        return state[oneDArrayIndex(i, j, valN)];
    }

    // is site (row i, column j) full?
    public boolean isFull(int row, int col) {
        int i = row - 1;
        int j = col - 1;

        if (i < 0 || j < 0 || i >= valN || j >= valN) {
            throw new IndexOutOfBoundsException();
        }
//        if (isValidIndex(i, j, valN)) {
            int currIndex = oneDArrayIndex(i, j, valN);
            return wquUF2.connected(0, currIndex);
//        }
//        return false;
    }

    // does the system percolate?
    public boolean percolates() {
        return wquUF.connected(0, gridLen - 1);
    }

    private int oneDArrayIndex(int i, int j, int square2DArrayLen) {
        return i * square2DArrayLen + j + 1;
    }

    private boolean isValidIndex(int i, int j, int N) {
        if (i < 0 || j < 0 || i >= N || j >= N) {
            return false;
        } else {
            return true;
        }
    }
}
