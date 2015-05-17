package com.hackerearth.paytm.codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WIFIRouters {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int t = 0;

		try {
			line = br.readLine();
			if(line != null){
				t = Integer.parseInt(line);
				for(int i = 0; i < t; i++){
					line = br.readLine();
					String[] split = line.split(" ");
					int N = Integer.parseInt(split[0]);
					int M = Integer.parseInt(split[1]);
					
					int [][]coordRouters = new int[N][2];
					int [][]coordUsers = new int[M][2];
					
					double[][]routerDistMatrix = new double[N][N];
					double maxDist = 0;
					for(int j = 0; j < N; j++){
						for(int k = 0; k < N; k++){
							double dist = distance(coordRouters[j], coordRouters[k]);
							routerDistMatrix[j][k] = dist;
							if(maxDist < dist){
								maxDist = dist;
							}
						}
					}
					
					int[]included = new int[N];
					
					for(int j = 0; j < N; j++){
						included[j] = 0;
					}
					
					double[][] spanningTree = new double[N][2];
					
					
					spanningTree[0][0] = 0;//first router
					spanningTree[0][1] = 0;
					included[0] = 1;
					
					
					for(int j = 0; j < N - 1; j++){
						
						double row = spanningTree[j][0];
						double minDist = Integer.MAX_VALUE;
						double col = 0;
						for(int k = 0; k < N && k != row &&  included[k]!= 1; k++){
							if(minDist > routerDistMatrix[(int)row][k]){
								col = k;
								minDist = routerDistMatrix[(int)row][k];
							}
						}
						
						spanningTree[j+1][0] = col;//next router
						spanningTree[j+1][1] = minDist;//distance
						included[(int)col] = 1; //next included router
					}
					
					double max = 0;
					
					for(int j = 0; j < N; j++){
						if(max < spanningTree[j][1]){
							max = spanningTree[j][1];
						}
					}
					
					System.out.println(max);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static double distance(int[] a, int [] b){
		return Math.sqrt( (a[0] - b[0])*(a[0] - b[0]) +( a[1] - b[1])*(a[1] - b[1]) );
	}

}
