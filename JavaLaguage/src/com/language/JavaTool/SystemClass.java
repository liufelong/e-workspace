package com.language.JavaTool;

public class SystemClass {
	
	/**
	 * System类是系统中最常用的类，它有3个非常有用的静态成员：out、in和err，
	 * 分别表示标准的输出流、输入流和错误输出流。
	 * */
	
	public static void currentTimeMillis143() {
		System.out.println("本实例将演示如何利用currentTimeMillis()来计算程序的运行时间");
		//记录的是当前时间与1970年1月1日0时之间的时间差
		try {
			long start = System.currentTimeMillis();
			System.out.println("程序开始执行的时间是：" + start);
			Thread.sleep(3000);
			long end = System.currentTimeMillis();				// 记录程序结束执行时的时间
			System.out.println("结束执行的时间为: " + end);
			System.out.println("共执行了：" + (end - start) + "毫秒");
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}
	
	
	/**
	 * System类是一个抽象类，所有的字段和方法都是静态的。
	 * 
	 * System类提供的getPropertie()和set Propertie()方法可以获取和设置环境属性，
	 * 其中主要的用于获取和设置的环境属性
	 * 
	 * */
	public static void systemInfo144() {
		// 通过调用System类的getProperty方法来获取相应的属性值
		System.out.println("用户的账户名称：" + System.getProperty("user.name"));
		System.out.println("当前用户工作目录：" + System.getProperty("user.dir"));
		System.out.println("用户的home路径：" + System.getProperty("user.home"));
		System.out.println("类所在的路径：" + System.getProperty("java.class.path"));
		System.out.println("操作系统的名称:" + System.getProperty("os.name"));
		System.out.println("操作系统的版本：" + System.getProperty("os.version"));
		System.out.println("操作系统的架构：" + System.getProperty("os.arch"));
		System.out.println("虚拟机实现的版本：" + System.getProperty("java.vm.version"));
		System.out.println("虚拟机实现的生产商：" + System.getProperty("java.vm.vendor"));
		System.out.println("默认的临时文件路径：" + System.getProperty("java.io.tmpdir"));
		System.out.println("运行环境规范的名称:" + System.getProperty("java.specification.name"));
		System.out.println("Java类格式化的版本号：" + System.getProperty("java.class.version"));
		System.out.println("Java运行环境的版本:" + System.getProperty("java.version"));
		System.out.println("Java运行环境的生产商:" + System.getProperty("java.vendor"));
		System.out.println("Java的安装路径：" + System.getProperty("java.home"));
	}
}
