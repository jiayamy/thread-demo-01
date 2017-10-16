package com.saw.thread;
/**
 * 对象锁的同步和异步问题
 * @author lijia
 *
 */
public class MyObject {
	
	public synchronized void method1(){
		try {
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public /*synchronized*/ void method2(){
		System.out.println(Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		
		final MyObject mo = new MyObject();
		/**
		 * t1线程先持有object对象的lock锁，t2线程可以以异步的方式调用对象中的非sync修饰的方法
		 * t1线程先持有object对象的lock锁，t2线程如果这个时候调用对象中的同步方法，则需等待，也就是同步
		 */
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				mo.method1();
			}
		}, "t1");
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				mo.method2();
			}
		}, "t2");
		
		t1.start();
		t2.start();
	}
}
