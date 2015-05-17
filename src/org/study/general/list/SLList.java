package org.study.general.list;

public class SLList {
	
	Node head;
	Node tail;
	int size;
	
	
	public void insert(Node n){
		if(head == null){
			head = n;
			size++;
		} else{
			tail.setNext(n);
			tail = n;
			size++;
		}
	}
	
	
	public boolean delete(int val){
		if(head == null){
			return false;
		}
		Node cn = head;
		while(cn != null && cn.getVal() != val){
			cn = cn.getNext();
		}
		if(cn == null){
			return false;
		}
		if(cn.getVal() == val){
			if(cn.getNext() == null){
				cn = null;
			} else {
				Node t = cn.getNext();
				cn = cn.getNext();
				t = null;
			}
			size--;
			return true;
		}
		
		return false;
	}


	public Node getHead() {
		return head;
	}


	public void setHead(Node head) {
		this.head = head;
	}


	public Node getTail() {
		return tail;
	}


	public void setTail(Node tail) {
		this.tail = tail;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	@Override
	public String toString() {
		return "SLList [head=" + head + ", tail=" + tail + ", size=" + size
				+ "]";
	}
	
	

}
