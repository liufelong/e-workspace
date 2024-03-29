package com.language.JavaString;

import java.util.Date;
import java.util.Locale;

public class StringManager {
//	字符串的常规操作
	public static void appendString() {
		String str1 = "hello" + "," + "word";
		System.out.println("使用+拼接的字符串:" + str1);
		
		//构建stringBuffer对象，并添加字符串
		StringBuffer sb2 = new StringBuffer();
		sb2.append("hello");
		sb2.append(",");
		sb2.append("word");
		
		String str2 = sb2.toString();
		System.out.println("使用append方法拼接的字符串:" + str2);
		
		//另一种写法
		StringBuffer sb3 = new StringBuffer().append("hello").append(" ").append("word");
		System.out.println("另一种写法的append:"+sb3.toString());
		
		sb3.insert(2, "ME");
		System.out.println("stringBuffer调用insert方法插入字符串：" + sb3.toString());
/**
 * append()方法用于向字符串中追加内容，这个方法有多种实现方式，它们可以接受任何类型的数据。
 * insert()方法的作用是在StringBuffer对象中插入内容，然后形成新的字符串。
 * 它和append()方法的区别就是insert()方法可以在任意特定的位置进行任意数据类型的值的插入
 * */		
	}
	
	//字符串大小写转换
	public static void stringUpAndLower() {
		String str = "ABcde";
		System.out.println("原来的字符串：" + str);
		System.out.println("转大写：" + str.toUpperCase());
		System.out.println("转小写：" + str.toLowerCase());
/**
 * String类中提供了两个专门用于转换字符串大小写的方法：toLowerCase()方法与toUpperCase()方法。
 * 
 * 字符串在创建后就成为不可变的对象，当调用字符串对象的方法操作字符串时，
 * 会产生新的字符串对象，而不是更改原来的字符串对象。
 * */		
	}
	
	public static void appearTimes() {
		String str1 = "ackfeabiofabxeabsjabsdesab";
		String str2 = "ab";
		
		int count = 0;
		int start = 0;
		while(str1.indexOf(str2,start) >= 0 && start < str1.length()) {
			count++;
			start = str1.indexOf(str2, start) + str2.length();
		}
		
		System.out.println(str2 + "在字符串" + str1 + "中出现了：" + count + "次");
		
		//str1.indexOf(int ch, int formindex) 
	}
	
	public static void dateFormat() {
		//使用java.util.Date包里面 Date类
		Date today = new Date();
		
		String aString = String.format(Locale.US, "%tb", today);
		System.out.println("格式化后的字符串为月份的英文缩写: " + aString);
		
		String bString = String.format(Locale.US, "%tB", today);
		System.out.println("格式化后的字符串为月份的英文全拼：" + bString);
		
		String cString = String.format("%ta", today);
		System.out.println("格式化后的字符串为周: " + cString);
		
		String dString = String.format("%tA", today);
		System.out.println("格式化后的字符串为星期: " + dString);
		
		String e = String.format("%tY", today);
        System.out.println("格式化后的字符串为4位的年份值: " + e);
        								// 格式化后的字符串为2位的年份值
        String f = String.format("%ty", today);
        System.out.println("格式化后的字符串为2位的年份值: " + f);
        								// 格式化后的字符串为2位的月份值
        String g = String.format("%tm", today);
        System.out.println("格式化后的字符串为2位的月份值: " + g);
        								// 格式化后的字符串为2位的日期值
        String h = String.format("%td", today);
        System.out.println("格式化后的字符串为2位的日期值: " + h);
		
/**
 * 在深入使用字符串之前，有一个概念一定要理解，字符串是不可变的对象。理解了这个概念，
 * 对后面熟练使用字符串有很大的帮助。字符串的不可变性，意味着每当对字符串进行操作时，
 * 都将产生一个新的字符串对象，如果频繁的操作字符串对象，会在托管堆中产生大量的无用字符串，
 * 增加垃圾回收器的压力，从而造成系统资源的浪费。
 * 
 * 使用String类中的startsWith()方法和endsWith()方法，
 * 可以判断某字符串是否以指定字符串开始或结束
 * */		
	}
	
	public static void checkNumber(String string) {
		//校验是否为纯数字
	}
	//string.matches(regex) 执行正则表达式进行校验
	//string.compareTo(temp); 比较字符串
	
/**
 * 在性能上：StringBuilder > StringBuffer > String
 * 
 * StringBuilder 单线程使用，不做同步所以快，多线程下不安全
 * 
 * StringBuffer 会做线程同步 所以稍慢，如果指定容量，性能会超过 不指定容量的 StringBuilder
 *     如果你操作的字符串长度不超过16个字符就不用 指定容量
 * 
 * */	
	
	
}
