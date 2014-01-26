package org.study.general.tree;

public class BST {
	private Node root;

	public BST(){
		this.root = null;
	}

	public Node find(int val){
		if(this.root == null){
			return root;
		}
		return find(this.root, val);
	}
	
	public Node find(Node root, int val){
		if(this.root == null){
			return root;
		}
		Node currNode = null;
		if(val < root.getVal()){
			currNode = root.getLeft();
		} else if(val > root.getVal()){
			currNode = root.getRight();
		} else{
			currNode = root;
		}
		if(currNode == null){
			return currNode;
		}
		if(val == currNode.getVal()){
			return currNode;
		}
		
		return find(currNode, val);
		
	}
	public void insert(Node node){
		if(this.root == null){
			this.root = node;
			return;
		}
		insert(this.root,node);
	}
	
	public void insert(Node root, Node node){
		if(root == null){
			root = node;
			return;
		}
		Node curNode = null;
		if(node.getVal() < root.getVal()){
			curNode = root.getLeft();
			if(curNode == null){
				root.setLeft(node);
			}
		} else {
			curNode = root.getRight();
			if(curNode == null){
				root.setRight(node);
			}
		}
		insert(curNode, node);
	}
	
	
	
	public boolean delete(int val){
		if(this.root == null){
			return false;
		}
		return delete(this.root, val);
	}
	
	public boolean delete(Node root, int val){
		if(root == null){
			return false;
		}
		Node left = null;
		Node right = null;
		if(val < root.getVal()){
			left = root.getLeft();
			if(left != null){
				return delete(left, val);
			} else {
				return false;
			}
		} else if(val > root.getVal()){
			right = root.getRight();
			if(right != null){
				return delete(right, val);
			} else {
				return false;
			}
		} else {
			left = root.getLeft();
			right = root.getRight();
			
			if(left != null && right != null){
				Node predecessor = findPredecessor(root);
				int newVal = predecessor.getVal();
				root.setVal(newVal);
				delete(left, newVal);
			} else if(left != null){
				Node trash = root;
				root = root.getLeft();
				trash = null;
			} else if(right != null){
				Node trash = root;
				root = root.getRight();
				trash = null;
			} else {
				root = null;
			}
			return true;
		}
		
	}
	
	public Node findSuccessor(Node n){
		if(n == null){
			return n;
		}
		Node right = n.getRight();
		if(right == null){
			return right;
		}
		while(right.getLeft() != null){
			right = right.getLeft();
		}
		return right;
	}
	
	public Node findPredecessor(Node n){
		if(n == null){
			return n;
		}
		Node left = n.getLeft();
		if(left == null){
			return left;
		}
		while(left.getRight() != null){
			left = left.getRight();
		}
		return left;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	
}
