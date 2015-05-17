package org.study.general.matrix;

public class MatrixRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int A[][] = new int[3][3];
		A[0][0] = 1;
		A[0][1] = 2;
		A[0][2] = 3;
		A[1][0] = 4;
		A[1][1] = 5;
		A[1][2] = 6;
		A[2][0] = 7;
		A[2][1] = 8;
		A[2][2] = 9;
		
		int [][] B = rotateMatrixBy90DClockW(A);
				
		System.out.println("Before rotation:");
		print2DMatrix(A,3,3);
		System.out.println("After rotation:");
		print2DMatrix(B,3,3);
		
		rotateRight(A);
		System.out.println("A after in place rotation:");
		print2DMatrix(A,3,3);
		
//		int C[][] = transposeMatrix(A, 3, 3);
//		System.out.println("Before transpose:");
//		print2DMatrix(A,3,3);
//		System.out.println("After transpose:");
//		print2DMatrix(C,3,3);
		
//		int D[][] = rotateMatrixBy90DClockW(A, 3, 3);
//		System.out.println("Before transpose:");
//		print2DMatrix(A,3,3);
//		System.out.println("After transpose:");
//		print2DMatrix(D,3,3);
		
		
//		int A[][] = new int[3][4];
//		A[0][0] = 1;
//		A[0][1] = 2;
//		A[0][2] = 3;
//		A[0][3] = 4;
//		A[1][0] = 5;
//		A[1][1] = 6;
//		A[1][2] = 7;
//		A[1][3] = 8;
//		A[2][0] = 9;
//		A[2][1] = 10;
//		A[2][2] = 11;
//		A[2][3] = 12;
		
//		int E[][] = rotateMatrixBy90DClockW(A, 3, 4);
//		System.out.println("Before rotation:");
//		print2DMatrix(A,3,4);
//		System.out.println("After rotation:");
//		print2DMatrix(E,4,3);
		
//		print2DMatrix(A);
		
	}
	
	
	static void rotateRight(int A[][]) {

		int m = A.length;		//rows
		int n = A[0].length;	//cols
		
	    for (int layer = 0; layer < n / 2; layer++) {

	        int first = layer;
	        int last = n - 1 - layer;

	        for (int i = first; i < last; ++i) {

	            int topline = A[first][i];
	            int rightcol = A[i][last];
	            int bottomline = A[last][n - layer - 1 - i];
	            int leftcol = A[n - layer - 1 - i][first];

	            A[first][i] = leftcol;
	            A[i][last] = topline;
	            A[last][n - layer - 1 - i] = rightcol;
	            A[n - layer - 1 - i][first] = bottomline;
	        }
	    }
	}
	
	
	static int[][] rotateMatrixBy90DClockW(int A[][], int m, int n){

		int B[][] = new int[n][m];
		
		for(int i = 0; i < n; i ++)
			for(int j = 0; j < m; j++){
				B[i][j] = A[m- j -1][i]; 
			}
		
		return B;
	}
	
	static int[][] rotateMatrixBy90DClockW(int A[][]){
		
		int m = A.length;
		int n = A[0].length;
		
		return rotateMatrixBy90DClockW(A,m,n);
	}
	static int[][] rotateMatrixBy90DAntiClockW(int A[][], int m, int n){
		
		int B[][] = new int[n][m];
		
		for(int i = 0; i < n; i ++)
			for(int j = 0; j < m; j++){
				B[i][j] = A[j][m-i-1]; 
			}
		
		return B;
	}
	
	static int[][] rotateMatrixBy90DAntiClockW(int A[][]){
		
		int m = A.length;
		int n = A[0].length;
		
		return rotateMatrixBy90DAntiClockW(A, m, n);
	}
	
	static int[][] transposeMatrix(int A[][], int m, int n){
		int B[][] = new int[n][m];
		for(int i = 0; i < m; i++)
			for(int j = 0; j < n; j++)
				B[i][j] = A[j][i];
		return B;
	}
	
	static int[][] transposeMatrix(int A[][]){
		int m = A.length;
		int n = A[0].length;
		
		return transposeMatrix(A, m, n);
	}
	static void print2DMatrix(int[][]A, int m, int n){
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				System.out.print(A[i][j]+"\t");
			}
			System.out.println();
		}
	}

	static void print2DMatrix(int[][]A){
		int m = A.length;
		int n = A[0].length;
		print2DMatrix(A, m, n);
	}
}
