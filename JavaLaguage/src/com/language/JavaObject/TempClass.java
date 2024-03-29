package com.language.JavaObject;

public class TempClass {
	
/**
 *  方法重载
 *  在Java中，可以通过重载（overloading）来减少方法名称的个数
 *  当对象在调用方法时，可以根据方法参数的不同来确定执行那个方法
 *     方法参数的不同包括参数类型不同、参数个数不同和参数顺序不同
 *  
 *  不能通过方法的返回值来区分方法，即不能有两个方法名称和参数相同但返回值不同的方法
 *  
 *  低精度的数值可以赋值给高精度的变量；而高精度的值却不能赋给低精度的变量
 * */
	//实例065  同名方法的使用
	public void info() {
		System.out.println("普通方法：小明今年1岁了");
	}
	public void info(int age) {
		System.out.println("重载方法：小明今年"+age+"岁了");
	}
	
	public TempClass() {
		
	}
	
	
	//实例069  统计商品销售量
	private static int count = 0; //定义一个计数器
	public TempClass(String title) {
		//带参数的构造方法
		System.out.println("出售的商品名称：" + title);
		count ++;
	}
	public static int getCounter() {
		return count;
	}
/**
 * 对于非static成员变量，不同的对象可以对其任意修改而不会对其他对象产生影响。
 * 对于static成员变量，则是所有对象所共享的。任何一个对象的修改都会影响到其他对象。
 * 
 * 静态方法与非静态方法的区别主要体现在以下两个方面：
 * 外部调用静态方法时，可以使用“类名.方法名”的方式，也可以使用“对象名.方法名”的方式。
 * 而非静态方法只有后面的这种形式。即调用静态方法无需创建对象。
 * 静态方法在访问本类的成员时，只允许访问静态方法，而不许访问非静态方法。非静态方法则无此限制
 * */	
	
}
