package com.language.JavaThread;

public class MainThread {
	public static void main(String[] args) throws InterruptedException {
		
		
//		startAndEndThread97();
		
//		checkThreadState98();
		
//		threadPriority99();
		
//		sleepAndWake100();
		
		useJoinMath102();
	}
	
	public static void startAndEndThread97() {
		System.out.println("实例097  线程的启动与结束");
		StartThread startThread = new StartThread();
		startThread.startY();
		startThread.startX();
		
		/**
		 * Java中创建多线程有2种方式：继承Thread类和实现Runnable接口
		 * 
		 * Thread
		 * run()方法是定义在Thread类里的一个方法，因此把线程的程序代码编写在run()方法内，
		 *  事实上就是覆盖的操作。
		 *  
		 *  如果自定义的线程类还要继承其他类，这时就不能采用第一种方式来创建。
		 * 
		 * */
	}
	
	public static void checkThreadState98() throws InterruptedException{
		System.out.println("实例098  查看线程的运行状态");
		StateThread stateThread = new StateThread(); // 创建State对象
		Thread thread = new Thread(stateThread); // 利用State对象创建Thread对象
		System.out.println("新建线程：" + thread.getState());
		
		thread.start();// 调用thread对象的start()方法，启动新线程
		System.out.println("线程启动：" + thread.getState());
		
		Thread.sleep(100); // 当前线程休眠0.1秒，使新线程运行waitForASecond()方法
		System.out.println("计时等待：" + thread.getState());
		
		Thread.sleep(1000); // 当前线程休眠1秒，使新线程运行waitForYears()方法
		System.out.println("等待线程：" + thread.getState());
		
		stateThread.notifyNow();  // 调用state的notifyNow()方法
		System.out.println("唤醒线程：" + thread.getState());
		
		Thread.sleep(1000);// 当前线程休眠1秒，使新线程结束
		System.out.println("终止线程：" + thread.getState());
		/**
		 * 1.创建状态
		 *    在线程类使用new关键字实例化之后且在调用start方法之前，线程处于创建状态。
		 * 处于创建状态的线程仅仅分配了内存空间，属于生命周期的初始状态。
		 * 
		 * 2.就绪状态
		 *    在线程调用了start方法后即处于就绪状态。处于就绪状态的线程具备了除CPU之外
		 * 所有运行所需资源。就绪状态线程排队等待CPU，由系统调度为其分配。
		 * 
		 * 3.运行状态
		 *    处于就绪状态的线程获得CPU之后即处于运行状态。处于运行状态的线程才开始真正
		 * 执行线程run方法的内容。
		 * 
		 * 4.阻塞/等待状态
		 *    处于运行状态的线程如果因为某种原因不能继续执行，则进入阻塞状态。阻塞状态与
		 *  就绪状态的不同是：就绪状态只是因为缺少CPU而不能执行，而阻塞状态是由于各种原因
		 *  引起线程不能执行，不仅仅是缺少CPU。引起阻塞的原因解除以后，线程再次转为就绪状态，
		 *  等待分配CPU运行。
		 * 
		 * 5.死亡状态
		 *   当线程执行完run ()方法的内容或被强制终止时，线程处于死亡状态，线程的整个生命周期结束。
		 * 
		 * 线程在整个生命周期中始终处于某种状态，从一种状态到另一种状态的转换由线程调度方法实现。
		 * 
		 * */
	}
	
	public static void threadPriority99() {
		System.out.println("实例099  设置线程优先级分配CPU运行时间");
		PriorityThread trHigh, trLow;
		// 创建两个线程对象
		trHigh = new PriorityThread();
		trLow = new PriorityThread();
		
		// 分别设置优先级
		trHigh.setPriority(Thread.NORM_PRIORITY + 2);
		trLow.setPriority(Thread.NORM_PRIORITY - 2);
		/**
		 * Thread类提供setPriority()方法为线程设置优先级。用1～10的数字表示，数字越大，优先级越高
		 * 
		 * Tread类提供了三个静态常量
		 *   最高优先级（MAX_PRIORITY）
		 *   最低优先级（MIN_PRIORITY）
		 *   默认优先级（NORM_PRIORITY）
		 * 
		 * */
		
	    trHigh.start();
	    trLow.start();
	    try{
	      Thread.sleep(1000); 						// 等待1秒钟
	    }catch(InterruptedException e){  }
	    											// 结束两个线程
	    trHigh.normalStop();
	    trLow.normalStop();
	    											// 等待它们真正结束
	    try{
	      trHigh.join();
	      trLow.join();
	    }catch(InterruptedException e){  }
	    											// 输出两个线程的循环次数
	    System.out.println("trHigh的循环次数为："+trHigh.getClick());
	    System.out.println("trLow的循环次数为："+trLow.getClick());
	}

	public static void sleepAndWake100() throws InterruptedException {
		SleepAndWake relay = new SleepAndWake();
		relay.start(); // 启动线程
		try {
			relay.join(); // 等待线程运行结束
		} catch (InterruptedException e) { // 捕获唤醒异常
			// TODO: handle exception
			System.out.println(" 收到命令，准备上场：" + e.getMessage());
		}
		relay.incident();// 调用方法判断是否唤醒
	}
	
	public static void waitAndNotify101() {
		/**
		 * wait()方法是作为基类Object类的一部分实现的
		 *   线程的实现可以通过继承Thread类和实现Runnable接口两种方式来实现。
		 *   当把wait()方法放到同步方法或者同步块中的时候，就不需要考虑实现多线程的类是用哪一种方法实现的了。
		 * 
		 * sleep方法和wait方法的区别
		 *  1、调用wait()方法的线程自动释放对象的锁标志，而调用sleep()方法时并没有释放对象锁标志。
		 *     也就是说，当调用wait()方法后，会挂起当前线程，同时线程会释放在对象上的同步锁，
		 *     这样就使得调用同一对象的其他同步方法可以执行。
		 *  2、wait()方法必须在同步方法或者同步代码块内调用。如果在非同步方法或者同步代码块内调用该方法，
		 *     虽然编译能通过，但是运行时会得到异常。而sleep()方法并没有这个限制，
		 *     所以sleep()方法可以在非同步方法或者同步代码块内被调用。
		 *  3、调用wait()方法后，可以通过notify()方法和notifyAll()方法唤醒等待的异常，
		 *     也可以在wait()方法中设定的时间到期后，恢复执行。
		 * 
		 * 
		 * 对于正在执行的线程，可以调用join()方法等待其结束，然后才执行其他程序。
		 * 
		 * 对于正在执行的线程，可以调用yield()方法使其重新排队，将CPU让给排在后面的线程，此线程转为就绪态。
		 * */
	}
	
	
	public static void useJoinMath102() {
		/**
		 * 对于正在执行的线程，可以调用join()方法等待其结束，然后才执行其他程序。
		 * join()方法有几种重载形式。其中，不带任何参数是等到执行结束为止，
		 * */
		MatchMarry group1 = new MatchMarry("Lester", "万冰");
		MatchMarry group2 = new MatchMarry("王颖", "默默");
		MatchMarry group3 = new MatchMarry("李建", "白兰地");
		MatchMarry group4 = new MatchMarry("丁雪峰", "凤兰");
		MatchMarry group5 = new MatchMarry("沈万腾", "多思安");
		System.out.println("非诚勿扰，情比金坚");
		
		group1.start();// 启动线程
		try {
			group1.join(); //等待线程运行结束
		} catch (Exception e) { //捕获异常
			// TODO: handle exception
		}
		
		group2.start();// 启动线程
		try {
			group2.join(); //等待线程运行结束
		} catch (Exception e) { //捕获异常
			// TODO: handle exception
		}
		group3.start();// 启动线程
		try {
			group3.join(); //等待线程运行结束
		} catch (Exception e) { //捕获异常
			// TODO: handle exception
		}
		group4.start();// 启动线程
		try {
			group4.join(); //等待线程运行结束
		} catch (Exception e) { //捕获异常
			// TODO: handle exception
		}
		group5.start();// 启动线程
		try {
			group5.join(); //等待线程运行结束
		} catch (Exception e) { //捕获异常
			// TODO: handle exception
		}
		System.out.println("速配结束。。。");
	}

	
	public static void textThreadYield103() {
		/**
		 * yield()方法会暂停当前正在执行的线程对象，并执行其他线程。
		 * yield()方法只让步给高优先级或同等优先级的线程，如果后面是低优先级线程，则继续执行此线程
		 * */
//		TestThreadYield
	}
	
}
