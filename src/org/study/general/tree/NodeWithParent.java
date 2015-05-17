package org.study.general.tree;

public class NodeWithParent {
	private int val;
	private NodeWithParent left;
	private NodeWithParent right;
	private NodeWithParent parent;
	
	
	public NodeWithParent(){
		this.val = 0;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
	public NodeWithParent(int val){
		this.val = val;
		this.left = null;
		this.right = null;
		this.parent = null;
	}

	public NodeWithParent(int val, NodeWithParent left, NodeWithParent right, NodeWithParent parent){
		this.val = val;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public NodeWithParent getLeft() {
		return left;
	}
	public void setLeft(NodeWithParent left) {
		this.left = left;
	}
	public NodeWithParent getRight() {
		return right;
	}
	public void setRight(NodeWithParent right) {
		this.right = right;
	}
	public NodeWithParent getParent() {
		return parent;
	}
	public void setParent(NodeWithParent parent) {
		this.parent = parent;
	}
	@Override
	public String toString() {
		return "NodeWithParent [val=" + val + ", left=" + left + ", right="
				+ right + ", parent=" + parent + "]";
	}
	
	

}
