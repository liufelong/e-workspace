package com.language.JavaThread;

import java.util.Date;

public class StartThread {
	public void startY() {
		ThreadY tY = new ThreadY();
		tY.startThreadY();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		tY.stopThreadY();
	}
	
	public void startX() {
		Runnable runnable = new ThreadX();  // 创建实例
		Thread threadX = new Thread(runnable); // 将实例放入线程中
		threadX.start();// start方法启动线程
	}
	
}

class ThreadY extends Thread {
	private boolean isRunState = false;
	
	@Override
	public void start() {
		this.isRunState = true;
		super.start();
	}
	
	@Override
	public void run() {
		int i = 0;
		try {
			while (isRunState) {
				this.setName("Thread-" + i++);
				System.out.println("线程Y：" + this.getName() + " 正在运行");
				Thread.sleep(200);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(this.getName() + "运行结束...");
	}
	
	public void startThreadY() { 					// 启动ThreadY线程
		System.out.println("启动线程Y...");
		this.start();
	}
	public void stopThreadY() { 					// 停止ThreadY线程
		System.out.println("结束线程Y...");
		this.setRunState(false);
	}
	
	public void setRunState(boolean isRunState) {
		this.isRunState = isRunState;
	}
}

class ThreadX implements Runnable {
	private Date runDate;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("线程X已启动");
		this.runDate = new Date();
		System.out.println("启动时间：" + runDate.toString());
	}
}
