package org.study.general.tree;

public class OddEvenLevelDiff {

	public static void main(String[] args) {
		
//		Node root = testcase1();
		Node root = testcase2();
		
		int oddLevelSum = oddLevelSum(root);
		int evenLevelSum = evenLevelSum(root);
		int diff = oddLevelSum - evenLevelSum;
		System.out.println("odd sum: "+ oddLevelSum);
		System.out.println("even sum: "+ evenLevelSum);
		System.out.println("diff: "+diff);

	}
	static Node testcase2(){
		Node n1 = new Node(5);
		Node n2 = new Node(2);
		Node n3 = new Node(6);
		Node n4 = new Node(1);
		Node n5 = new Node(4);
		Node n6 = new Node(8);
		Node n7 = new Node(3);
		Node n8 = new Node(7);
		Node n9 = new Node(9);
		
		n1.setLeft(n2);
		n1.setRight(n3);
		n2.setLeft(n4);
		n2.setRight(n5);
		n3.setRight(n6);
		n5.setLeft(n7);
		n6.setLeft(n8);
		n6.setRight(n9);
		return n1;
	}
	static Node testcase1(){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		Node n9 = new Node(9);
		Node n10 = new Node(10);
		Node n11 = new Node(11);
		Node n12 = new Node(12);
		Node n13 = new Node(13);
		Node n14 = new Node(14);
		Node n15 = new Node(15);
		
		n1.setLeft(n2);
		n1.setRight(n3);
		n2.setLeft(n4);
		n2.setRight(n5);
		n3.setLeft(n6);
		n3.setRight(n7);
		n4.setLeft(n8);
		n4.setRight(n9);
		n5.setLeft(n10);
		n5.setRight(n11);
		n6.setLeft(n12);
		n6.setRight(n13);
		n7.setLeft(n14);
		n7.setRight(n15);
		return n1;
	}
	static int oddLevelSum(Node root){
		int sum = 0;
		
		if(root == null){
			return sum;
		}
		sum += root.getVal();
		
		Node l = root.getLeft();
		Node r = root.getRight();
		Node ll = null;
		Node lr = null;
		Node rl = null;
		Node rr = null;
		if(l != null){
			ll = l.getLeft();
			lr = l.getRight();
		}
		if(r != null){
			rl = r.getLeft();
			rr = r.getRight();
		}
		sum += oddLevelSum(ll) + oddLevelSum(lr) + oddLevelSum(rl) + oddLevelSum(rr);
		return sum;
	}
	
	static int evenLevelSum(Node root){
		int sum = 0;
		
		if(root == null){
			return sum;
		}
		Node l = root.getLeft();
		Node r = root.getRight();
		return oddLevelSum(l) + oddLevelSum(r);
	}

}
