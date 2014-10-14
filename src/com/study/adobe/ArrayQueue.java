package com.study.adobe;

import java.util.concurrent.atomic.AtomicInteger;

public class ArrayQueue {

	private AtomicInteger size;
	private static int maxSize;
	private int[] arr;
	
	public ArrayQueue(int maxSize){
		this.maxSize = maxSize;
		this.size = new AtomicInteger(0);
		this.arr = new int[maxSize];
	}

	public void add(int n){
		
	}
	
	public void remove(int n){
		
	}
	
	
	public static void main(String[] args) {
	}
	
}
