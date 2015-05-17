package com.study.algo.graph;

public interface Graph {

//	The two constructors which needs to be defined
//	public Graph(int V);
//	public Graph(In in);

	
	public void addEdge(int v, int w);
	
	public Iterable<Integer> adj(int v);
	
//	Returns number of vertices in the graph
	public int V();
	
//	Returns number of edges in the graph.
	public int E();
	
	public String toString();
	
	

}
