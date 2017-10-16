package com.saw.thread;
/**
 * sync代码块对字符串的锁，注意string常量池的缓存功能
 * @author lijia
 *
 */
public class StringLock {
	
	public void method(){
		synchronized (/*"new String"*/new String("new String")) {
			try {
				while(true){
					System.out.println("current thread : " + Thread.currentThread().getName() + "开始");
					Thread.sleep(1000);
					System.out.println("current thread : " + Thread.currentThread().getName() + "结束");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		final StringLock stringLock = new StringLock();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				stringLock.method();
			}
		}, "t1");
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				stringLock.method();
			}
		},"t2");
		
		t1.start();
		t2.start();
	}
}
