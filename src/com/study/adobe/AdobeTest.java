package com.study.adobe;

public class AdobeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	boolean hasSum(Node root, int sum){
		
		if(root != null){
			Node l = root.left;
			Node r = root.right;
			
			if(l == null && r == null){
				if(root.val == sum){
					return true;
				}
			} else if(l == null && r != null){
				return hasSum(r, sum - root.val);
			} else if(l != null && r == null){
				return hasSum(l, sum - root.val);
			} else{
				boolean leftHasSum = hasSum(l, sum - root.val);
				if(leftHasSum){
					return leftHasSum;
				} else {
					return hasSum(r,sum - root.val);
				}
			}
		}
		
		return false;
	}
	
	class Node {
		Node left;
		Node right;
		int val;
	}

}



