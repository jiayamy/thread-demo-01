package com.saw.volati;

public class RunThread extends Thread {
	
	private /*volatile*/ boolean isRunning = true;
	
	private void setRunning(boolean isRunning){
		this.isRunning = isRunning;
	}
	
	public void run(){
		System.out.println("enter run method ...");
		while(isRunning){
			
		}
		System.out.println("thread stop...");
	}
	
	public static void main(String[] args) throws InterruptedException {
		RunThread runThread = new RunThread();
		runThread.start();
		Thread.sleep(3000);
		runThread.setRunning(false);
		System.out.println("isRunning has been setted to false...");
		Thread.sleep(1000);
		System.out.println(runThread.isRunning);
	}
}
