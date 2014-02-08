package org.study.general;

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
	}
}

public class MergeList {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.next = new Node(2);
		root.next.next = new Node(3);
		root.next.next.next = new Node(4);
		root.next.next.next.next = new Node(5);
		root.next.next.next.next.next = new Node(1);
		root.next.next.next.next.next.next = new Node(2);
		// root.next.next.next.next.next.next.next = new Node(2);

		Node temp = findMax(root);
		// System.out.println(":::::" + temp.data);
		Node temp1 = temp.next;
		temp.next = null;

		Node head = MergeLists(root, temp1);

		while (head != null) {
			// System.out.println(" ");
			System.out.print(head.data);
			head = head.next;
		}
	}

	static Node MergeLists(Node list1, Node list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}

		Node head;
		if (list1.data <= list2.data) {
			head = list1;
		} else {
			head = list2;
			list2 = list1;
			list1 = head;
		}
		while (list1.next != null && list2 != null) {
			if (list1.next.data <= list2.data) {
				list1 = list1.next;
			} else {
				Node tmp = list1.next;
				list1.next = list2;
				list2 = tmp;
			}
		}
		if (list1.next == null) {
			list1.next = list2;
		}
		return head;
	}

	public static Node merge(Node h1, Node h2) {

		Node h3 = new Node(0);
		Node current = h3;

		boolean isH1Left = false;
		boolean isH2Left = false;

		while (h1 != null || h2 != null) {
			if (h1.data <= h2.data) {
				current.next = h1;
				h1 = h1.next;
			} else {
				current.next = h2;
				h2 = h2.next;
			}
			current = current.next;

			if (h2 == null && h1 != null) {
				isH1Left = true;
				break;
			}

			if (h1 == null && h2 != null) {
				isH2Left = true;
				break;
			}
		}

		if (isH1Left) {
			while (h1 != null) {
				current.next = h1;
				current = current.next;
				h1 = h1.next;
			}
		}

		if (isH2Left) {
			while (h2 != null) {
				current.next = h2;
				current = current.next;
				h2 = h2.next;
			}
		}

		h3 = h3.next;

		return h3;
	}

	public static Node findMax(Node max) {
		while (max.next != null) {
			if (max.data > max.next.data)
				break;
			max = max.next;
		}

		return max;
	}

	public static Node findMin(Node min) {

		Node max = findMax(min);
		if (max.next.data < min.data)
			return min;
		else
			return max.next;

	}
}
