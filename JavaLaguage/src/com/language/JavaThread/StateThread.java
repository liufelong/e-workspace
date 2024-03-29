package com.language.JavaThread;

public class StateThread implements Runnable {
	
	public synchronized void waitForASecond() throws InterruptedException {
		wait(500); // 使当前线程等待0.5秒或其他线程调用notify()或notifyAll()方法
	}

	public synchronized void waitForYears() throws InterruptedException {
		wait(); // 使当前线程永久等待，直到其他线程调用notify()或notifyAll()方法
	}
	
	public synchronized void notifyNow() {
		notify();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			waitForASecond();
			waitForYears();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
}
