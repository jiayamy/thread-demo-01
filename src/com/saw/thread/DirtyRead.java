package com.saw.thread;
/**
 * 业务整体需要使用完整的sync,保持业务的原子性
 * 即为setValue/getValue同时加锁sync关键字，保证业务的原子性
 * @author lijia
 *
 */
public class DirtyRead {
	
	private String username = "mdzz";
	private String password = "123321";
	
	public synchronized void setValue(String username, String password){
		this.username = username;
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.password = password;
		
		System.out.println("setValue 结果为: username : "+username+" password : " + password);
	}
	
	public /*synchronized*/ void getValue(){
		System.out.println("getValue 结果为: username : " + username + " password : " + password);
	}
	
	public static void main(String[] args) throws InterruptedException {
		final DirtyRead dirtyRead = new DirtyRead();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				dirtyRead.setValue("test", "321");
			}
		});
		t1.start();
		Thread.sleep(1000);
		dirtyRead.getValue();
	}
}
