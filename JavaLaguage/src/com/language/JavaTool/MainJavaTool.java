package com.language.JavaTool;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

public class MainJavaTool {

	//Java常用的工具类
	public static void main(String[] args) {
		
//		roundOff129();
		
//		bigInteger130();
		
//		randomClass134();
		
//		randomCode135();
		
//		dateClass136_143();
		
//		systemClass143_144();
		
//		timeTest145();
		
		runtime_memory146();
	}
	
	//四舍五入算法
	public static void roundOff129() {
		/**
		 * 主要应用了Math类中四种函数
		 * public static double rint(double a) 返回a最近的整数；
		 * public static long round(double a) 返回a四舍五入后的整数；
		 * public static double floor(double a) 返回小于或等于a的最大整数；
		 * public static double ceil(double a) 返回不小于a的最小倍整数。
		 * 
		 * */
		double num;
		Scanner inScanner = new Scanner(System.in);
		System.out.println("请输入一个浮点数字");
		
		num = inScanner.nextDouble();//获取输入的浮点数字
		int rint = (int)Math.rint(num);// 调用Math类的rint方法
		System.out.println(num + "四舍五入得到整数：" + rint);
		
		long round = Math.round(num);				// 调用Math类的round方法
		System.out.println(num + "四舍五入得到长整数：" + round);
		
		int max = (int) Math.floor(num);				// 调用Math类的floor方法
		System.out.println("小于" + num + "的最大正整数：" + max);
		
		int min = (int) Math.ceil(num);				// 调用Math类的ceil方法
		System.out.println("大于" + num + "的最小正整数：" + min);
	}

	//高精度整数的运算
	public static void bigInteger130() {
		/**
		 * 高精度的 加减乘除
		 * add()、subtract()、multiply()和divide()方法实现了加、减、乘、除
		 * 
		 * BigDecimal 高精度浮点 功能一样
		 * 
		 * 虽然能大幅度提高运算的精度，但是这是建立在牺牲计算机性能的基础上的
		 * */
		BigInteger number1 = new BigInteger("123456");
		BigInteger number2 = new BigInteger("654321");
		
		BigInteger addition = number1.add(number2); //n1加n2
		BigInteger subtract = number1.subtract(number2); //n1减n2
		BigInteger multpation = number1.multiply(number2); //n1乘n2
		BigInteger divsion = number1.divide(number2);//n1除以n2
		System.out.println("numb1的值是" + number1);
		System.out.println("numb2的值是" + number2);
		
		System.out.println("高精度整数加法：" + addition);
        System.out.println("高精度整数减法：" + subtract);
        System.out.println("高精度整数乘法：" + multpation);
        System.out.println("高精度整数除法：" + divsion);
	}

	//随机数
	public static void randomClass134() {
		RandomClass.randomTypes();
		
		RandomClass.nextInt();
	}
	
	public static void randomCode135() {
		VerificationCode.numbCode();
		
		VerificationCode.charCode();
		
		VerificationCode.chineseCode();
		
		VerificationCode.mixCode();
	}
	
	public static void dateClass136_143() {
		DateClass.currnetTime136();
		
		System.out.println();
		DateClass.simpleDateFormat137();
		
		System.out.println();
		DateClass.calendar138();
		
		System.out.println();
		DateClass.gregorianCalendar139();
		
		System.out.println();
		DateClass.calendarShowTime140();
		
		System.out.println();
		DateClass.useFormatterOutTime142();
		
	}
	
	public static void systemClass143_144() {
		
		SystemClass.currentTimeMillis143();
		
		SystemClass.systemInfo144();
	}
	
	public static void timeTest145() {
		/**
		 * final 关键字
		 * 1、当变量被声明为`final`时，意味着该变量的值是不可更改的。
		 *    这有助于确保数据的完整性和安全性，避免意外的修改。
		 * 2、将方法声明为`final`表示该方法不能被子类重写。
		 *    这有助于保持方法的稳定性和安全性，确保父类中已经实现的逻辑不会被子类修改。
		 * 3、当一个类被声明为`final`时，表示该类不能被继承。
		 *    这有助于防止对类的修改和扩展，确保类的行为不会被修改。
		 * */
		final Timer timer = new Timer(); // 声明一个计时器 Timer
		final TimerTask task = new TimerTask() {
			int count = 3;
			// 声明一个计时器任务 TimerTask
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(1000);
					System.out.println("sleep.....");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if (--count <= 0) {
					System.out.println("time canceld.");
					this.cancel();// 取消该任务
					timer.cancel();// 取消定时器
				}
			}
		};
		// 设定计时器。100毫秒后启动计时器任务，每隔1000毫秒再启动一次
		timer.schedule(task, 100,1000);
	}
	
	public static void runtime_memory146() {
		try {
			// 获取与当前运行类相关联的runtime实例
			Runtime runtime = Runtime.getRuntime();
			
			System.out.println("内存可用空间：" + runtime.totalMemory());
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		/**
		 * 利用Runtime对象的totalMemory()来获取虚拟机的总内存。
		 * 利用Runtime对象的freeMemory()来获取虚拟机的空闲内存的大小。
		 * 利用Runtime对象的get()来启动垃圾收集线程。
		 * */
	}
	
	/**
	 * 正则表达式 暂时跳过
	 * */
	
}
