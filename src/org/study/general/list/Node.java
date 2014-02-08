package org.study.general.list;

public class Node {
	int val;
	Node next;
	
	public Node(){}
	public Node(int data){
		this.val = data;
		this.next = null;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	@Override
	public String toString() {
		return "Node [val=" + val + ", next=" + next + "]";
	}
	
}
