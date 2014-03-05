/*----------------------------------------------------------------
 *  Author:        Luiz Guilherme da Silva Junior
 *  login:luizguilherme00
 *  Written:       03/03/2014
 *  Last updated:  03/03/2014
 *
 *  Compilation:   javac HelloWorld.java
 *  Execution:     java PercolationStats N T
 *  
 *  Prints mean, standard deviation and 85% confidence interval for
 *  a NxN square and T experiments
 *
 *  % java HelloWorld
 *  Hello, World
 *
 *----------------------------------------------------------------*/
public class PercolationStats
{
    private double[] percolates;
    private int T;

    public PercolationStats(int N, int T)
    {
        if (N <= 0 || T <= 0)
            throw new IllegalArgumentException();
        this.T = T;
        percolates = new double[T];
        for (int i = 0; i < T; i++) {
            Percolation p = new Percolation(N);
            int count = 0;

            while (!p.percolates()) {
                int l = StdRandom.uniform(1, N + 1);
                int c = StdRandom.uniform(1, N + 1);
                if (!p.isOpen(l, c))
                    count++;
                p.open(l, c);
            }
            percolates[i] = (double) count / (N * N);
        }
        StdOut.println(mean());
        StdOut.println(stddev());
        StdOut.println(confidenceLo());
        StdOut.println(confidenceHi());
    }

    public double mean()
    {
        return StdStats.mean(percolates);
    }

    public double stddev()
    {
        return StdStats.stddev(percolates);
    }

    public double confidenceLo()
    {
        return mean() - (1.96 * stddev() / Math.sqrt(T));
    }

    public double confidenceHi()
    {
        return mean() + (1.96 * stddev() / Math.sqrt(T));
    }

    public static void main(String[] args) // test client, described below
    {
        new PercolationStats(Integer.parseInt(args[0]),
                Integer.parseInt(args[1]));
    }
}
