package com.study.algo.g4g;

public class SumTree {

	public static void main(String[] args) {

		SumTree st = new SumTree();
		Node t0 = st.new Node(10);
		Node t1 = st.new Node(-2);
		Node t2 = st.new Node(6);
		Node t3 = st.new Node(8);
		Node t4 = st.new Node(-4);
		Node t5 = st.new Node(7);
		Node t6 = st.new Node(5);
		
		t0.left = t1;
		t0.right = t2;
		t1.left = t3;
		t1.right = t4;
		t2.left = t5;
		t2.right = t6;
		
		System.out.println(t0);

		st.convertToSumTree(t0);
		
		System.out.println(t0);
	}

	public int convertToSumTree(Node root){
		if(root != null){
			Node l = root.left;
			Node r = root.right;
			int childrenSum = convertToSumTree(l) + convertToSumTree(r);
			int retVal = childrenSum + root.val;
			root.val = childrenSum;
			return retVal;
		} else{
			return 0;
		}
	}
	
	private class Node{
		Node left;
		Node right;
		int val;
		
		Node(){};
		Node(int val){
			this.val = val;
		}
		@Override
		public String toString() {
			return "Node [left=" + left + ", right=" + right + ", val=" + val
					+ "]";
		}
	}
}
