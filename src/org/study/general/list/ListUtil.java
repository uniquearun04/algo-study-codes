package org.study.general.list;

public class ListUtil {
	
	
	public static Node mergeSortedHalvesOfList(Node head){
		Node hl1 = head;
		int sizeL1 = 0;
		if(head == null){
			return head;
		}
		while(hl1.val <= hl1.next.val){
			hl1 = hl1.next;
			sizeL1++;
		}
		sizeL1++;
		
		Node hl2 = hl1.next;
		hl1 = head;
		
		Node h1 = hl1;
		Node h2 = hl2;
		Node t = null;
		
		for(int i = 0; i < sizeL1; i++){
			h1 = hl1;
			if(h1.val <= h2.val){
				if(t == null){
					hl1 = h1.next;
					h1.next = h2;
					hl2 = h1;
				} else {
					hl1 = h1.next;
					t.next = h1;
					h1.next = h2;
				}
				
			} else {
				t = h2;
				while(h2 != null && h1.val > h2.val){
					t = h2;
					h2 = h2.next;
				}
				if(h2 == null){
					hl1 = h1.next;
					t.next = h1;
					h1.next = null;
					h2 = h1;
				} else {
					hl1 = h1.next;
					t.next = h1;
					h1.next = h2;
					t = h1;
					
				}
			}
		}
		
		return hl2;
	}
	
	public static void printList(Node head){
		Node t = head;
		while(t != null){
			System.out.print(t.val+"-->");
			t = t.next;
		}
		System.out.println();
	}

}
