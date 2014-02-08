package org.study.general.list;

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n1 = new Node(4);
		Node n2 = new Node(6);
		Node n3 = new Node(8);
		Node n4 = new Node(10);
		Node n5 = new Node(12);
		Node n6 = new Node(1);
		Node n7 = new Node(3);
		Node n8 = new Node(5);
		Node n9 = new Node(7);
		Node n10 = new Node(10);

		n1.next = n2;
		n2.next = (n3);
		n3.next = (n4);
		n4.next = (n5);
		n5.next = (n6);
		n6.next = (n7);
		n7.next = (n8);
		n8.next = (n9);
		n9.next = (n10);
		
		Node head = n1;
		
		System.out.println("Before merging:");
		ListUtil.printList(head);
		System.out.println("After merging:");
		Node merged = ListUtil.mergeSortedHalvesOfList(head);
		ListUtil.printList(merged);
		
	}

}
