package org.study.general.tree;

public class TreeUtil {
	public static void main(String args[]){
		
		Node n1 = new Node(15);
		Node n2 = new Node(7);
		Node n3 = new Node(30);
		Node n4 = new Node(4);
		Node n5 = new Node(10);
		Node n6 = new Node(17);
		Node n7 = new Node(35);
		
		Node root = n1;
		root.setLeft(n2);
		root.setRight(n3);
		
		n2.setLeft(n4);
		n2.setRight(n5);
		n3.setLeft(n6);
		n3.setRight(n7);
		
		Node head = convertBST2DLL(root);
		printList(head);
	}
	
	//returns root of the list
	public static Node bst2dllUtil(Node root){
		if(root == null){
			return root;
		}
		if(root.getLeft() != null){
			Node left = bst2dllUtil(root.getLeft());
			for(;left.getRight() != null; left = left.getRight());
			left.setRight(root);
			root.setLeft(left);
		}
		if(root.getRight() != null){
			Node right = bst2dllUtil(root.getRight());
			for(;right.getLeft() != null; right = right.getLeft());
			right.setLeft(root);
			root.setRight(right);
		}
		return root;
	}
	
	// returns head of the list
	public static Node convertBST2DLL(Node root){
		if(root == null){
			return root;
		}
		root = bst2dllUtil(root);
		while(root.getLeft() != null){
			root = root.getLeft();
		}
		return root;
	}
	
	public static void printList(Node head){
		Node currNode = head;
		if(currNode != null)
			while(true){
				System.out.print(currNode.getVal());
				currNode = currNode.getRight();
				if(currNode != null){
					System.out.print("-->");
				} else {
					break;
				}
			}
	}
}
