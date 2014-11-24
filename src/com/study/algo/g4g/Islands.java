package com.study.algo.g4g;

public class Islands {

	public static void main(String[] args) {
		
		int M[][] = {
					{1, 1, 0, 0, 0},
					{0, 1, 0, 0, 1},
					{1, 0, 0, 1, 1},
					{0, 0, 0, 0, 0},
					{1, 0, 1, 0, 1}
					};
		
		Islands il = new Islands();
		
		int numIl = il.findNumIlands(M);
		
		System.out.println(numIl);
		
		int N[][] = {
					{1, 1, 0, 1, 0, 1, 0},
					{0, 1, 0, 0, 1, 0, 0},
					{1, 0, 0, 1, 1, 0, 1},
					{0, 0, 0, 0, 0, 0, 1},
					{1, 0, 1, 0, 1, 0, 0}
					};

		numIl = il.findNumIlands(N);
		
		System.out.println(numIl);
	}
	
	
	public int findNumIlands(int[][]M){
		int count = 0;
		
		int rows = M.length;
		int cols = M[0].length;
		
		boolean visited[][] = new boolean[rows][cols];
		
		for(int i = 0; i < rows; i ++)
			for(int j = 0; j < cols; j++){
				if(!visited[i][j] && M[i][j] == 1){
					doDFS(i,j,rows,cols, M,visited);
					count++;
				}
			}
		return count;
	}
	
	public void doDFS(int i, int j, int rows, int cols, int [][]M, boolean[][]V){
		
		V[i][j] = true;
		for(int k = i-1; k <= i+1; k++)
			for(int l = j-1; l <= j+1 ; l++){
				if(isSafe(k,l,rows,cols, M,V)){
					doDFS(k,l,rows,cols, M,V);
				}
			}
	}
	
	public boolean isSafe(int i, int j, int rows, int cols, int M[][], boolean [][] V){
		
		if(i >= 0 && i < rows && j >= 0 && j < cols && !V[i][j] && M[i][j] == 1){
			return true;
		}
		return false;
	}

}
