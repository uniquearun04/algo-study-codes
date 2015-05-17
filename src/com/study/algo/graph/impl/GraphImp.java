package com.study.algo.graph.impl;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;

import com.study.algo.graph.Graph;

public class GraphImp implements Graph {
	
	private final int V;
	private Bag<Integer>[] adj;
	
	
	public GraphImp(int V){
		this.V = V;
		adj = (Bag<Integer>[]) new Bag[V];
		for(int v = 0; v < V; v++){
			adj[v] = new HashBag<Integer>();
		}
	}
/*	public GraphImp(In in){
		
	}*/

	@Override
	public void addEdge(int v, int w) {
		// TODO Auto-generated method stub	
		adj[v].add(w);
		adj[w].add(v);

	}

	@Override
	public Iterable<Integer> adj(int v) {
		// TODO Auto-generated method stub
		return adj[v];
	}

	@Override
	public int V() {
		// TODO Auto-generated method stub
		return V;
	}

	@Override
	public int E() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(int v= 0; v < this.V(); v++){
			for(int w : this.adj(v)){
				sb.append(v + "-" + w + "\n");
			}
		}
		return sb.toString();
	}

}
