package com.saw.thread;
/**
 * 同一对象的属性的修改，不会影响锁的情况　
 * @author lijia
 *
 */
public class ModifyLock {
	
	private String name;
	
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public synchronized void changeAttributte(String name, Integer age){
		try {
			System.out.println("current thread : " + Thread.currentThread().getName() + " start");
			this.setName(name);
			this.setAge(age);
			
			System.out.println("current thread : " + Thread.currentThread().getName() + " change attributte : "+ this.getName() + ", " + this.getAge());
			Thread.sleep(2000);
			System.out.println("current thread : " + Thread.currentThread().getName() + " end");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		final ModifyLock modifyLock = new ModifyLock();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				modifyLock.changeAttributte("test01", 01);
			}
		}, "t1");
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				modifyLock.changeAttributte("test02", 02);
			}
		}, "t2");
		
		t1.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
	}
}
