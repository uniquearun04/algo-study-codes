package org.study.general.tree;

public class BST {
	private Node root;

	public BST(){
		this.root = null;
	}

	public void insert(Node node){
		if(this.root == null){
			this.root = null;
			return;
		}
		
	}
	
	
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	
}
