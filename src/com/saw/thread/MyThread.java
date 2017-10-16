package com.saw.thread;

public class MyThread extends Thread {
	
	private int count = 5;
	
	public synchronized void run(){
		count--;
		System.out.println(this.currentThread().getName() + "count: "+ count);
	}
	
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		Thread t1 = new Thread(myThread, "t1");
		Thread t2 = new Thread(myThread, "t2");
		Thread t3 = new Thread(myThread, "t3");
		t1.start();
		t2.start();
		t3.start();
	}
}
