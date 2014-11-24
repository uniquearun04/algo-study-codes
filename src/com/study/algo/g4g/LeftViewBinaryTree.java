package com.study.algo.g4g;

public class LeftViewBinaryTree {

	public static void main(String[] args) {

		LeftViewBinaryTree lvbt = new LeftViewBinaryTree();
		TNode t0 = lvbt.new TNode(12);
		TNode t1 = lvbt.new TNode(10);
		TNode t2 = lvbt.new TNode(30);
		TNode t3 = lvbt.new TNode(25);
		TNode t4 = lvbt.new TNode(40);
		
		t0.left = t1;
		t0.right = t2;
		
		t2.left = t3;
		t2.right = t4;
		
		System.out.println("Left view:");
		lvbt.printLeftView(t0);
		
		System.out.println("Right view:");
		lvbt.printRightView(t0);

	}

	public void printRightView(TNode root){
		if(root != null){
			LNode curLevNodes = new LNode(root);
			while(curLevNodes != null){
				System.out.println(curLevNodes.val.val);
				LNode nextLevNodes = null;
				while(curLevNodes != null){
					TNode tn = curLevNodes.val;
					TNode l = tn.left;
					TNode r = tn.right;
					if(l != null){
						if(nextLevNodes == null){
							nextLevNodes = new LNode(l);
						} else {
							nextLevNodes.next = new LNode(l);
							nextLevNodes = nextLevNodes.next;
						}
					}
					if(r != null){
						if(nextLevNodes == null){
							nextLevNodes = new LNode(r);
						} else {
							nextLevNodes.next = new LNode(r);
							nextLevNodes = nextLevNodes.next;
						}
					}
					curLevNodes = curLevNodes.next;
				}
				curLevNodes = nextLevNodes;
			}
		}
	}
	
	public void printLeftView(TNode root){
		if(root != null){
			LNode curLevNodes = new LNode(root);
			while(curLevNodes != null){
				System.out.println(curLevNodes.val.val);
				LNode nextLevNodes = null;
				LNode nextLevNodesH = nextLevNodes;
				while(curLevNodes != null){
					TNode tn = curLevNodes.val;
					TNode l = tn.left;
					TNode r = tn.right;
					if(l != null){
						if(nextLevNodes == null){
							nextLevNodes = new LNode(l);
							nextLevNodesH = nextLevNodes;
						} else {
							nextLevNodes.next = new LNode(l);
							nextLevNodes = nextLevNodes.next;
						}
					}
					if(r != null){
						if(nextLevNodes == null){
							nextLevNodes = new LNode(r);
							nextLevNodesH = nextLevNodes;
						} else {
							nextLevNodes.next = new LNode(r);
							nextLevNodes = nextLevNodes.next;
						}
					}
					curLevNodes = curLevNodes.next;
				}
				curLevNodes = nextLevNodesH;
			}
		}
	}
	
	private class LNode{
		LNode next;
		TNode val;
		
		LNode(){}
		LNode(TNode val){
			this.val = val;
		}
		
	}
	
	
	private class TNode{
		TNode left;
		TNode right;
		int val;
		
		TNode(){}
		TNode(int val){
			this.val = val;
		}
	}
}
