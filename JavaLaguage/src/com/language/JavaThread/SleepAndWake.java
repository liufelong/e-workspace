package com.language.JavaThread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SleepAndWake extends Thread {
	
	private DateFormat dateFormat = new SimpleDateFormat("ss:SS");
	
	public void incident() throws InterruptedException {
		Thread.currentThread().interrupt(); // 唤醒当前线程
		
		while (true) {
			// 判断当前线程是否被唤醒
			if (Thread.currentThread().isInterrupted()) {
				String timeString = dateFormat.format(new Date());
				System.out.println(timeString + "现在是否准备上场");
				System.out.println(Thread.currentThread().isInterrupted() ? "是" : "没有");
				
				try {
//					Thread.currentThread();
					Thread.sleep(30000);  // 线程休眠3秒
				} catch (InterruptedException e) {
					// TODO: handle exception
					System.out.println(dateFormat.format(new Date()) + " 收到命令，停止休息："
							+ e.getMessage());
				}
				System.out.print(dateFormat.format(new Date()) + "	比赛结束后是否参加下一轮比赛? ");
				System.out.println(Thread.currentThread().isInterrupted() ? "是"
						: "不参加");
				
			}
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		System.out.println("第一场比赛结束的时间为：" + dateFormat.format(new Date()));
		System.out.println("休息5小时");
		
		try {
			sleep(2000); 							// 线程休眠2秒 在程序假设1秒钟=1小时
		} catch (InterruptedException e) { 				// 捕获唤醒异常
			System.out.println(dateFormat.format(new Date()) + "收到命令，准备上场："
					+ e.getMessage());
		}
		System.out.print(dateFormat.format(new Date()) + "	在休息的过程中是否又参加其他的比赛? ");
		try {
			sleep(2000); 							// 线程休眠2秒
		} catch (InterruptedException e) { 				// 捕获唤醒异常
			System.out.println(dateFormat.format(new Date()) + "收到命令，准备上场："
					+ e.getMessage());
		}
		System.out.println(!isAlive() ? "参加比赛" : "没有参加其他的比赛"); // 线程是否激活,false表不是激活的
		interrupt();									// 唤醒线程
		System.out.print(dateFormat.format(new Date()) + " 休息中，替补队员受伤，是否参加比赛? ");
		System.out.println(isAlive() ? "参加比赛" : "不参加比赛"); // 线程是否激活
	}

}
