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
		insert(this.root,node);
	}
	
	
	public void insert(Node root, Node node){
		Node curNode = null;
		if(node.getVal() < root.getVal()){
			curNode = root.getLeft();
			if(curNode == null){
				root.setLeft(node);
			}
		} else {
			curNode = root.getLeft();
			if(curNode == null){
				root.setRight(node);
			}
		}
		insert(curNode, node);
	}
	
public boolean delete(Node node){
	
	if(this.root == null){
		return false;
	}
	return delete(this.root, node);
}
	
public boolean delete(Node root, Node node){
	if(root == null){
		return false;
	}
	Node currNode = null;
	if(node.getVal() < root.getVal()){
		currNode = root.getLeft(); 
	} else if(node)
	
	return false;
}
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	
}
