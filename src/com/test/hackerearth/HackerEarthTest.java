package com.test.hackerearth;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class HackerEarthTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
//		newCachedThreadPool.execute(paramRunnable);
		
		BlockingQueue<String> abq = new ArrayBlockingQueue<String>(10, false) ;

		
		BlockingQueue<String> llbq = new LinkedBlockingQueue<String>() ;
		
		ConcurrentHashMap<String, String> cmap = new  ConcurrentHashMap<String, String>();
//		
//		for(int i = 0; i < 15; i++){
//			abq.add("test"+i);
//		}
		
//		for(int i =0; ;i++ ){
//			String str = abq.
//		}
		
		for(int i = 0; i < 15; i++){
			llbq.add("test"+i);
		}
		System.out.println(llbq);

	}

}
