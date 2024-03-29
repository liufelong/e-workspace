package com.language.JavaThread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class WaitAndNotify {
	/**
	 * wait()方法是一个实现线程通信的方法。
	 * 
	 * 当线程正在使用一个同步方法时，调用wait()方法会使当前的线程处于等待状态，
	 * 直到其他线程调用此对象的notify()方法或notifyAll()方法为止。
	 * */
	
	private static boolean isStop = false; //表示线程是否停止
	private static List<String> taskList = new ArrayList<String>(); //创建集合列表对象
	private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private class SearchDownload extends Thread {
		
		private String[] fileStrings =  new String[] {"jdk-7u3-windows-x64.exe",
													  "eclipse-SDK-3.7.2-win32-x86_64.zip",
													  "mysql-installer-5.5.25.0.msi"};
		private String[] resouce = new String[] {"开始连接......","开始搜索候选资源......",
									"没搜索到候选资源，稍后重试搜索","原始资源连接成功，得到的文件长度： 7725816",
									"开始创建文件......","文件创建成功，开始下载数据......","用户取消下载"};
		
		int sum = 0;
		int time = 0;
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			for (int i = 0; i < fileStrings.length; i++) {
				System.out.println("开始下载第" + (i + 1) + "个文件");
				
				try {
					for (int j = 0; j < resouce.length; j++) {
						System.out.println(dateFormat.format(new Date()) + resouce[j]);
						
						time = new Random().nextInt(100);// 获得随机生成的秒数
						Thread.sleep(time);// 线程休眠等待
						sum = sum + time;
					}
					System.out.println(dateFormat.format(new Date()) + "文件下载" +
										fileStrings[i] + "用时"+ sum + "毫秒" );
					Thread.sleep(time); // 线程休眠等待					
					
				} catch (Exception e) {// 捕获异常
					// TODO: handle exception
					System.out.println("下载文件出错" + e.getMessage());
				}
				
				synchronized (taskList) { // 实现同步
					System.out.println(dateFormat.format(new Date()) + " "
							+ fileStrings[i] + "文件已下载完毕！");
					taskList.add(fileStrings[i]);					// 将文件添加到集合列表中
					taskList.notify();					// 通报所有等待的fileList的线程
				}
				sum = 0;
			}
			isStop = true;								// 重新设置标识
			System.out.println(dateFormat.format(new Date()) + " 下载线程退出");
			
		}
	}
	
	public static void main(String[] args) {
		WaitAndNotify test = new WaitAndNotify();
		test.new SearchDownload().start();
	}
}
