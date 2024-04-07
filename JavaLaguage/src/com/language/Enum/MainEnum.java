package com.language.Enum;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class MainEnum {
	
	/**
	 * 知识点	  				难度指数	  占用时间
		枚举					2			2
		enum类				3			2
		EnumSet类			3			3
		EnumMap类			3			2
		泛型集合及泛型类		3			3
		泛型通配符			4			3
		泛型接口				5			3
		泛型类的强制类型转换	4			2
		Hashtable类			3			2
	 * */
	
	public static void main(String[] args) {
		
//		enumDemo150();
		
		showClothValue151();
	}
	
	public static void enumDemo150() {
		// 获得表示枚举类型的Class对象
		Class<Position> enumClass = Position.class;
		
		String modifier = Modifier.toString(enumClass.getModifiers());// 获得枚举类型修饰符
		System.out.println("enum 类型的修饰符:" + modifier);
		System.out.println("enum 类型的父类:" + enumClass.getSuperclass());
		System.out.println("enum 类型的自定义方法");
		//获得枚举类型的自定义方法
		Method[] methods = enumClass.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method); //输出方法名称
		}
		/**
		 * 枚举的定义
		 * enum 枚举名称 {枚举值列表}
		 * 
		 * */
	}

	public static void showClothValue151() {
		// 准备从键盘输入
		Scanner inScanner = new Scanner(System.in);
		
		String type;
		Size size;
		boolean goon = true;
		System.out.print("请输入衣服型号，包括：SMALL,MEDIUM,LARGE,EXTRA_LARGE。");
	    System.out.println("空行表示结束");
	    while (goon) {
			System.out.println("请输入型号：");
			type = inScanner.nextLine().toUpperCase();
			if (type.length() > 0) {
				size = (Size)Enum.valueOf(Size.class,type);// 获取相匹配的枚举类型值
				System.out.println(type + "的价格为：" + size.getValue());
			}else {
				goon = false;
			}
		}
	    inScanner.close();
	}
	
}
