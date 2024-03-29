package com.language.JavaThread;

public class PriorityThread extends Thread {
	//线程优先级实例
	private int click = 0;
	
	/**
	 * volatile 关键字
	 * 1、可见性
	 * 当一个共享变量被volatile修饰时，它会保证修改的值会立即被更新到主存，
	 * 当有其他线程需要读取时，它会去内存中读取新值。
	 * 
	 * 2、保证有序性
	 *  单例中 可以保证实例化对象的步骤是有序的 1、分配内存；2、初始化对象；3、把地址赋给引用变量
	 * 3、保证原子性
	 * */
	private volatile boolean running = true;
	
	public int getClick() {
		return click;
	}
	
	@Override
	public void run() {
		while (running) {
			click = click + 1;
		}
	}
	
	public void normalStop() {
		running = false;
	}

}
