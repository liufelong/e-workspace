package com.language.JavaThread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class TestThreadYield {
	
	// Vector 向量数组，功能类似ArrayList 但是线程安全，效率低
	private Vector<String> vector = new Vector<String>();
	//创建时间格式
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");
	private boolean isFlag = false;
	
	//让步文件类
	private class Yield extends Thread {
		public Yield() {
			// TODO Auto-generated constructor stub
			this.setName("接受文件"); //设置线程名称
			this.setDaemon(true); // 如果SendFile线程结束，则该线程自动结束
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			while (!isFlag) {  //标识为真进行循环
				try {
					Thread.sleep(100);  // 休眠
				} catch (Exception e) { // 捕获唤醒异常
					// TODO: handle exception
					System.out.println("唤醒异常：" + e.getMessage());
				}
				
				if (vector.size() == 0) {
					System.out.println(dateFormat.format(new Date()) + "\t 向量集合中没有文件，执行yield操作");
					Thread.yield();
				} else {
					String ssString = vector.remove(0);
					System.out.println(dateFormat.format(new Date()) + "\t取到文件，文件名：" + ssString);
				}				
			}
		}
	}
	
	//发送文件类
	private class SendFile extends Thread {
		private String[] fileStrings = new String[] {"《红高粱》","《哇》","《丰臀肥乳》","《檀香刑》"};
		
		public SendFile() {
			// TODO Auto-generated constructor stub
			this.setName("发送文件");
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			try {
				for (int i = 0; i < fileStrings.length; i++) {// 循环使线程休眠
					Thread.sleep(201);// 线程休眠
					vector.add(fileStrings[i]);// 添加文件
				}
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("唤醒异常:"+e.getMessage());
			}
		}
	}
	
	public static void main(String[] args) {
		TestThreadYield testThreadYield = new TestThreadYield();
		testThreadYield.new Yield().start();
		testThreadYield.new SendFile().start();
	}
}
