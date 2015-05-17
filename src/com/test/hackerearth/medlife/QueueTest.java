package com.test.hackerearth.medlife;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class QueueTest {

	List<String> queue = new ArrayList<String>();
	
	public void enqueue(String n){
		queue.add(n);
	}
	
	public void dequeue(){
		if(isEmpty()){
			try {
				throw new Exception("Queue is empty");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else{
			queue.remove(0);
		}
	}
	
	public boolean isEmpty(){
		return queue.size() == 0;
	}
	
	public void printQueue(){
		for(String i : queue){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] split = br.readLine().split(" ");
		
		QueueTest qt = new QueueTest();
		
		for(int i = 0; i < split.length; i++){
			qt.enqueue(split[i]);
		}
		
		int a = Integer.parseInt(br.readLine());
		String b = br.readLine();
		
		switch(a){
		case 0:	
			qt.dequeue();
			break;
		case 1:
			qt.enqueue(b);
			break;
		}
		
		qt.printQueue();
	}

}
