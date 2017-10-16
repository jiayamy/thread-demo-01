package com.saw.thread;

/**
 * 锁对象的改变问题
 * @author lijia
 *
 */
public class ChangeLock {
	
	private String lock = "lock";
	
	private void method(){
		synchronized (lock) {
			try {
				System.out.println("current thread : " + Thread.currentThread().getName() + " start");
				lock = "change lock";
				Thread.sleep(2000);
				System.out.println("current thread : " + Thread.currentThread().getName() + " end");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		final ChangeLock changeLock = new ChangeLock();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				changeLock.method();
			}
		}, "t1");
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				changeLock.method();
			}
		}, "t2");
		
		t1.start();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		t2.start();
	}
}
