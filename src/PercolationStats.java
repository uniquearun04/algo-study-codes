
public class PercolationStats {

    private double[] fractionOpenSites;

    // private int valN = 0;
    // double mean = 0;

    // perform T independent computational experiments on an N-by-N grid
    public PercolationStats(int N, int T) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException("Either N <= 0 or T <= 0");
        }

        fractionOpenSites = new double[T];
        // valN = N;
        
        int row = 0;
        int col = 0;
        int size = N * N;

        for (int i = 0; i < T; i++) {
            int countOpenSites = 0;
            Percolation percolation = new Percolation(N);

            while (!percolation.percolates()) {
                if(countOpenSites >= size){
                    break;
                }
//                row = (int)(Math.random() * N + 1);
//                col = (int)(Math.random() * N + 1);
                row = StdRandom.uniform(N) + 1;
                col = StdRandom.uniform(N) + 1;
                if(!percolation.isOpen(row, col)){
                    percolation.open(row, col);
                    countOpenSites++;
                }
            }
//            double elapsedTime = stopwatch.elapsedTime();
//            System.out.println("ElapsedTime: "+elapsedTime);
            fractionOpenSites[i] = ((double)countOpenSites)/size;
        }
//        for(int )
//        System.out.println();
    }

    // test client, described below
    public static void main(String[] args) {

        int N = 0;
        int T = 0;
        if (args.length != 2) {
            System.out.println("Invalid arguments");
            return;
        }
        try {
            N = Integer.parseInt(args[0]);
            T = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid argument.");
            e.printStackTrace();
            return;
        }
        
//        int N = StdIn.readInt();
//        int T = StdIn.readInt();

        PercolationStats percolationStats = new PercolationStats(N, T);
//        Random rand = new Random(System.nanoTime());

/*        int row = 0;
        int col = 0;
        int size = N * N;

        for (int i = 0; i < T; i++) {
            int countOpenSites = 0;
            Percolation percolation = new Percolation(N);

//            Stopwatch stopwatch = new Stopwatch();
            while (!percolation.percolates()) {
                if(countOpenSites >= size){
                    break;
                }
                Math.random();
                row = (int)(Math.random() * N + 1);
                col = (int)(Math.random() * N + 1);
                percolation.open(row, col);
                countOpenSites++;
            }
//            double elapsedTime = stopwatch.elapsedTime();
//            System.out.println("ElapsedTime: "+elapsedTime);
            percolationStats.fractionOpenSites[i] = ((double)countOpenSites)/size;
        }*/

        System.out.println("mean:\t\t\t\t= " + percolationStats.mean());
        System.out.println("stddev:\t\t\t\t= " + percolationStats.stddev());
        System.out.println("95% confidence interval:\t= "
                + percolationStats.confidenceLo() + ", "
                + percolationStats.confidenceHi());

    }

    // sample mean of percolation threshold
    public double mean() {
/*        double sum = 0;
        int len = fractionOpenSites.length;
        for (int i = 0; i < len; i++) {
            sum += fractionOpenSites[i];
        }

        return sum / len;*/
        return StdStats.mean(fractionOpenSites);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
  /*      double mean = mean();
        double sumofsquares = 0;
        int len = fractionOpenSites.length;

        for (int i = 0; i < len; i++) {
            sumofsquares += square(fractionOpenSites[i] - mean);
        }
        double sdSq = sumofsquares / (len - 1);
        return Math.sqrt(sdSq);*/
        
        return StdStats.stddev(fractionOpenSites);
    }

    // returns lower bound of the 95% confidence interval
    public double confidenceLo() {
        double mean = mean();
        double stddev = stddev();
        double confLo = mean - 1.96 * stddev
                / Math.sqrt(fractionOpenSites.length);
        return confLo;
    }

    // returns upper bound of the 95% confidence interval
    public double confidenceHi() {
        double mean = mean();
        double stddev = stddev();
        double confHo = mean + 1.96 * stddev
                / Math.sqrt(fractionOpenSites.length);
        return confHo;
    }

/*    private double square(double x) {
        return x * x;
    }*/
}
