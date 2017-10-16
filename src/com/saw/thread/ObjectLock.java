package com.saw.thread;

/**
 * 使用sync代码块加锁，比较灵活
 * @author lijia
 *
 */
public class ObjectLock {
	
	public void method1(){
		synchronized (this) {//对象锁
			try {
				System.out.println("do method01...");
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void method2(){
		synchronized (ObjectLock.class) {//类锁
			try {
				System.out.println("do method02...");
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private Object lock = new Object();
	public void method3(){// 任何对象锁
		synchronized (lock) {
			try {
				System.out.println("do method03...");
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		final ObjectLock objectLock = new ObjectLock();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				objectLock.method1();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				objectLock.method2();
			}
		});
		
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				objectLock.method3();
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
	}
}
