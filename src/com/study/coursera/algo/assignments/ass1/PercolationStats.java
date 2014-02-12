package com.study.coursera.algo.assignments.ass1;

public class PercolationStats {

	double [] fractionOpenSites;
	int valN = 0;
	double mean = 0;
	
	// perform T independent computational experiments on an N-by-N grid
	public PercolationStats(int N, int T) {
		if(N <= 0 || T <= 0 ){
			throw new IllegalArgumentException("Either N <= 0 or T <= 0");
		}
		
		fractionOpenSites = new double[T];
		valN = N;
	}

	// test client, described below
	public static void main(String[] args) {

	}
	// sample mean of percolation threshold
	public double mean() {
		double sum = 0;
		int len = fractionOpenSites.length;
		for(int i = 0; i < len; i ++){
			sum += fractionOpenSites[i];
		}
		
		return sum/len;
	}

	// sample standard deviation of percolation threshold
	public double stddev() {
		double mean = mean();
		double sumofsquares = 0;
		int len = fractionOpenSites.length;
		
		for(int i = 0; i < len; i ++){
			sumofsquares += square(fractionOpenSites[i] - mean);
		}
		double sdSq = sumofsquares/(len -1);
		return Math.sqrt(sdSq);
	}

	// returns lower bound of the 95% confidence interval
	public double confidenceLo() {
		double mean = mean();
		double stddev = stddev();
		double confLo = mean - 1.96 * stddev / Math.sqrt(fractionOpenSites.length);
		return confLo;
	}

	// returns upper bound of the 95% confidence interval
	public double confidenceHi() {
		double mean = mean();
		double stddev = stddev();
		double confHo = mean + 1.96 * stddev / Math.sqrt(fractionOpenSites.length);
		return confHo;
	}
	
	
	private double square(double x){
		return x * x;
	}
}
