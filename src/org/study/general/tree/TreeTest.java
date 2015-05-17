package org.study.general.tree;

public class TreeTest {
	public static void main(String args[]){
		
//		bst2dllTest();
//		findTestBST();
		deleteTestBST();
	}
	
	
	public static void deleteTestBST(){
		Node root = bst();
		BST bst = new BST();
		bst.setRoot(root);
		System.out.println("old tree: "+root);

		bst.delete(7);
		System.out.println("New tree: "+root);
		
//		Node n1 = new Node(15);
//		System.out.println("Node: "+n1);
//		n1 = null;
//		System.out.println("Node: "+n1);
	}
	public static void findTestBST(){
		Node root = bst();
		BST bst = new BST();
		bst.setRoot(root);
		Node find = bst.find(15);
		System.out.println(find);
	}
	
	public static Node bst(){
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
		return root;
	}
	public static void bst2dllTest(){
		Node head = TreeUtil.convertBST2DLL(bst());
		TreeUtil.printList(head);
	}
}
