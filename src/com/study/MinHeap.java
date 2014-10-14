package com.study;

import java.util.HashMap;

public class MinHeap {

	Node root;
	int size = 0;
	
	HashMap<Integer, Node> map = new HashMap<>();
	
	public void insert(Node n){
		size++;
		if(root== null){
			root = n;
			root.index = 1;
		} else{
			int nextPointer = (size)/2;
			Node cp = map.get(nextPointer);
			if(cp.left == null){
				cp.left = n;
				cp.left.index = size;
			} else{
				cp.right = n;
				cp.right.index = size;
			}
			map.put(size, n);
		}
		heapify(map.get(size));
	}

	public void delete(){
		Node lastNode = map.get(size);
		this.root.val = lastNode.val;
		map.remove(size);
		lastNode = null;
		size--;
		heapify(this.root);	
	}
	
	public void heapify(Node n){
//		if()
	}
}



class Node{
	Node left;
	Node right;
	int index;
	int val;
	
	public Node(){}
	
	public Node(int index, int val){
		this.index = index;
		this.val = val;
	}
	
	public Node(int index){
		this.index = index;
	}
}