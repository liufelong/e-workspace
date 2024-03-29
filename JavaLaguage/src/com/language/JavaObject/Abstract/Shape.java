package com.language.JavaObject.Abstract;

public abstract class Shape {

	public String getName() {
		//获得图形名称
		return this.getClass().getSimpleName();
	}
	
	public abstract double getArea();
}
/**
 * 抽象类的定义规则
 * 1、抽象类和抽象方法都必须用abstract关键字来修饰；否则系统就会发出错误信息
 * 2、抽象类不能被实例化，即不能直接用new关键字去产生对象；
 * 3、抽象方法只需声明，而不需实现；
 * 4、含有抽象方法的类必须被称为抽象类，抽象类的子类必须覆盖所有的抽象方法后才能被实例化，
 * 否则这个子类还是个抽象类
 * 
 * 
 * 抽象类不能直接实例化，如果要获得该类的实例可以使用静态方法创建其实现类对象。
 * 
 */