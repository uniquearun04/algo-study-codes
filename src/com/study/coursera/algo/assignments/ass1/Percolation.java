package com.study.coursera.algo.assignments.ass1;

public class Percolation {

	WeightedQuickUnionUF wquUF = null;
	boolean[] state;
	int valN = 0;
	
	
	
	// create N-by-N grid, with all sites blocked
	public Percolation(int N) {
		valN = N;
		int gridLen = N * N + 2;
		wquUF = new WeightedQuickUnionUF(gridLen);
		state = new boolean[gridLen];
		
		for(int i = 0; i < gridLen; i++){
				state[i] = false;
		}
		state[0] = true;
	}

	//TODO open last element
	// open site (row i, column j) if it is not already
	public void open(int i, int j) {
		if(i < 0 || j < 0 || i >= valN || j >= valN){
			throw new IndexOutOfBoundsException();
		}
		if(isValidIndex(i, j, valN)){
			int curIndex = oneDArrayIndex(i, j, valN);
			state[oneDArrayIndex(i,j,valN)] = true;

			//upper
			if(isValidIndex(i - 1, j, valN)){
				int upperIndex = oneDArrayIndex(i - 1, j, valN);
				if(state[upperIndex]){
					wquUF.union(curIndex, upperIndex);
				}
			}
			//left
			if(isValidIndex(i, j - 1, valN)){
				int leftIndex = oneDArrayIndex(i, j - 1, valN);
				if(state[leftIndex]){
					wquUF.union(curIndex, leftIndex);
				}
			}
			//lower
			if(isValidIndex(i + 1, j, valN)){
				int lowerIndex = oneDArrayIndex(i + 1, j, valN);
				if(state[lowerIndex]){
					wquUF.union(curIndex, lowerIndex);
				}
			}
			//right
			if(isValidIndex(i, j + 1, valN)){
				int rightIndex = oneDArrayIndex(i, j + 1, valN);
				if(state[rightIndex]){
					wquUF.union(curIndex, rightIndex);
				}
			}
			if(i == 0 && j >= 0 && j < valN){
				
			}
			
			if( i == valN - 1 && j >= 0 && j < valN){
				//TODO last row
			}
		}
		
		
	}

	// is site (row i, column j) open?
	public boolean isOpen(int i, int j) {
		if(i < 0 || j < 0 || i >= valN || j >= valN){
			throw new IndexOutOfBoundsException();
		}
		return state[oneDArrayIndex(i,j,valN)];
	}

	// is site (row i, column j) full?
	public boolean isFull(int i, int j) {
		if(i < 0 || j < 0 || i >= valN || j >= valN){
			throw new IndexOutOfBoundsException();
		}
		return false;
	}

	// does the system percolate?
	public boolean percolates() {
		return false;
	}
	
	private int oneDArrayIndex(int i, int j, int square2DArrayLen){
		return i * square2DArrayLen + j + 1;
	}
	
	private boolean isValidIndex(int i, int j, int N){
		if(i < 0 || j < 0 || i >= N || j >= N){
			return false;
		} else{
			return true;
		}
	}
}
