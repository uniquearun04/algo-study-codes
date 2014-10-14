package com.study.adobe;

public class ExecuteLongJob {
	
	private static boolean interruptTask = false;
	
	
	private static class MyTask extends Thread{
		
		public void run(){
			
			while(!interruptTask){
				System.out.println("running");
			}
		}
	}
	
	
	public static void main(String args[]) throws Exception{
		
		Thread task = new MyTask();
		
		task.start();
		
		Thread.sleep(5000L);
		interruptTask = true;
		task.join();
	
		
		System.out.println("exited");
	}
}
