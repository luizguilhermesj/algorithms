public class Percolation
{
    private boolean[][] sites;
    private WeightedQuickUnionUF uf;
    private WeightedQuickUnionUF ufClean;
    private int N;

    public Percolation(int N)
    {
        this.N = N;
        sites = new boolean[N][N];
        uf = new WeightedQuickUnionUF(N * N + 2);
        ufClean = new WeightedQuickUnionUF(N * N + 1);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sites[i][j] = false;
            }
        }
    }

    public void open(int i, int j)
    {
        if (!isOpen(i, j)) {
            sites[i - 1][j - 1] = true;

            if (i == 1) {
                uf.union(0, getSiteIndex(i, j));
                ufClean.union(0, getSiteIndex(i, j));
            }
            if (i == N) {
                uf.union(N * N + 1, getSiteIndex(i, j));
            }
            unionAdjacentsIfIsOpen(i, j);
        }
    }

    public boolean isOpen(int i, int j)
    {
        checkMatrixIndex(i);
        checkMatrixIndex(j);
        return sites[i - 1][j - 1];
    }

    public boolean isFull(int i, int j)
    {
        return ufClean.connected(0, getSiteIndex(i, j));
    }

    public boolean percolates()
    {
        return uf.connected(0, (N * N) + 1);
    }

    private void unionAdjacentsIfIsOpen(int i, int j)
    {
        if (i > 1 && isOpen(i - 1, j)) {
            ufClean.union(getSiteIndex(i, j), getSiteIndex(i - 1, j));
            uf.union(getSiteIndex(i, j), getSiteIndex(i - 1, j));
        }
        if (i < N && isOpen(i + 1, j)) {
            ufClean.union(getSiteIndex(i, j), getSiteIndex(i + 1, j));
            uf.union(getSiteIndex(i, j), getSiteIndex(i + 1, j));
        }
        if (j > 1 && isOpen(i, j - 1)) {
            ufClean.union(getSiteIndex(i, j), getSiteIndex(i, j - 1));
            uf.union(getSiteIndex(i, j), getSiteIndex(i, j - 1));
        }
        if (j < N && isOpen(i, j + 1)) {
            ufClean.union(getSiteIndex(i, j), getSiteIndex(i, j + 1));
            uf.union(getSiteIndex(i, j), getSiteIndex(i, j + 1));
        }
    }

    private int getSiteIndex(int i, int j)
    {
        checkMatrixIndex(i);
        checkMatrixIndex(j);
        return (((i - 1) * N) + (j - 1)) + 1;
    }

    private void checkMatrixIndex(int i)
    {
        if (i <= 0 || i > N) {
            throw new IndexOutOfBoundsException();
        }
    }

}