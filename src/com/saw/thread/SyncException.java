package com.saw.thread;
/**
 * sync异常
 * @author lijia
 *
 */
public class SyncException {
	
	private int i = 0;
	public synchronized void operation(){
		while(true){
			try {
				i++;
				Thread.sleep(200);
				System.out.println(Thread.currentThread().getName() + ", i = "+ i);
				if(i == 10){
					throw new RuntimeException("test");
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(" log info i = "+i);
//				throw new RuntimeException();
			}
		}
	}
	
	public static void main(String[] args) {
		final SyncException syncException = new SyncException();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				syncException.operation();
			}
		},"t1");
		
		t1.start();
	}
}
