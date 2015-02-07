package com.test.hackerearth.ul;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ShortestPath {
	
	public static final int INFINITY = 9999;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String split[] = br.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);
		
		String stationNames[] = br.readLine().split(" ");
		
		
		String[][] entries = new String[M][3];
		
		String splitLine [] = null;
		for(int i = 0; i < M; i++){
			splitLine = br.readLine().split(" ");
			for(int j = 0; j < 3; j++){
				entries[i][j] = splitLine[j];
			}
		}
		
		int Q = Integer.parseInt(br.readLine());
		
		String[][] queries = new String[Q][2];
		for(int i = 0; i < Q; i++){
			splitLine = br.readLine().split(" ");
			for(int j = 0; j < 2; j++){
				queries[i][j] = splitLine[j];
			}
		}
		
		findShortestPath(entries, queries, stationNames);
		
	}
	
	private static void findShortestPath(String[][] entries, String [][] queries, String stationNames[]){
		Map<String,Integer> map = new HashMap<String,Integer>();
		int N = stationNames.length;
		for(int i = 1; i <= N; i++){
			map.put(stationNames[i-1], i);
		}
		
		int weightMatrix [][] = new int[N+1][N+1];
		for(int i = 0; i < entries.length; i++){
			String entry[] = entries[i];
			int m = map.get(entry[0]);
			int n = map.get(entry[1]);
			int val = Integer.parseInt(entry[2]);
			weightMatrix[m][n] = val;
			weightMatrix[n][m] = val;
		}
		
		for(int i = 1; i <= N; i++)
			for(int j = 1; j <= N; j++){
				if(weightMatrix[i][j] == 0){
					if(i != j)
						weightMatrix[i][j] = INFINITY;
				}
			}
		
		allPairShortestPath(weightMatrix, N, queries, map);
	}
	
    private static void allPairShortestPath(int distancematrix[][], int numberofvertices, String [][] queries, Map<String,Integer> map)
    {
 
        for (int intermediate = 1; intermediate <= numberofvertices; intermediate++)
        {
            for (int source = 1; source <= numberofvertices; source++)
            {
                for (int destination = 1; destination <= numberofvertices; destination++)
                {
                    if (distancematrix[source][intermediate] + distancematrix[intermediate][destination]
                                         < distancematrix[source][destination])
                        distancematrix[source][destination] = distancematrix[source][intermediate] 
                                         + distancematrix[intermediate][destination];
                }
            }
        }
 
        for(int i = 0; i < queries.length; i++){
        	String [] query = queries[i];
        	int m = map.get(query[0]);
        	int n = map.get(query[1]);
        	System.out.println(distancematrix[m][n]);
        }
    }

}
