package com.study.algo.graph.util;

import com.study.algo.graph.Graph;

public class GraphUtil {
	public static int degree(Graph G, int v){
		int degree = 0;
		for(int w : G.adj(v))
			degree++;
		return degree;
	}
	
	public static int maxDegree(Graph G){
		int maxD = 0;
		for(int v = 0; v < G.V(); v++){
			if(degree(G,v) > maxD){
				maxD = degree(G, v);
			}
		}
		return maxD;
	}
	
	public static double averageDegree(Graph G){
		return 2.0 * G.E() / G.V();
	}
	
	public static int numberOfSelfLoops(Graph G){
		int count = 0;
		for(int v = 0; v < G.V(); v++){
			for (int w : G.adj(v)){
				if(v == w){
					count++;
				}
			}
		}
		return count / 2;
	}

}
