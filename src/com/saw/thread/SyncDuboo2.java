package com.saw.thread;
/**
 * 在使用syn时，当一个线程获得一个对象的锁后，再次请求此对象时是可以再次得到该对象的锁，出现异常，锁自动释放
 * @author lijia
 *
 */
public class SyncDuboo2 {
	
	static class Main{
		public int i = 10;
		public synchronized void operationSup(){
			try {
				i--;
				System.out.println("Main print i = :" + i);
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	static class Sub extends Main{
		public synchronized void operationSub(){
			try {
				while(i > 0){
					i--;
					System.out.println("Sub print i = " + i);
					Thread.sleep(100);
					this.operationSup();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				Sub sub = new Sub();
				sub.operationSub();
			}
		});
		t1.start();
	}
}
