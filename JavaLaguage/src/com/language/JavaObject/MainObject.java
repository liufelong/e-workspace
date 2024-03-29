package com.language.JavaObject;

import java.util.Random;

import com.language.JavaObject.Abstract.Circle;
import com.language.JavaObject.Abstract.Rectangle;
import com.language.JavaObject.Factory.FactorySaver;
import com.language.JavaObject.Factory.ImageSaver;

public class MainObject {
	
	public static void main(String[] args) {
		
		System.out.println("实例065  同名方法的使用");
		TempClass class1 = new TempClass();
		class1.info();
		class1.info(3);
		
		
		System.out.println();
		System.out.println("实例069  统计商品销售量");
		String[] titles = {"iphone5","ipad","iphone13"};
		for (int i = 0; i < 5; i++) {
			//创建一个小于3的随机数
			int a = new Random().nextInt(3);
			
			new TempClass(titles[a]);
		}
		System.out.println("总计销售了：" + TempClass.getCounter() + "件商品");
		
		//抽象类使用
		System.out.println();
		System.out.println("实例073  计算几何图形的面积");
		Circle yuanCircle = new Circle(1);
		System.out.println("图形的名称是：" + yuanCircle.getName());
		System.out.println("图形的面积是：" + yuanCircle.getArea());
		Rectangle rectangle = new Rectangle(2, 3);
		System.out.println("图形的名称是：" + rectangle.getName());
		System.out.println("图形的面积是：" + rectangle.getArea());
		/**
		 * 抽象类的定义规则
		 * 1、抽象类和抽象方法都必须用abstract关键字来修饰；否则系统就会发出错误信息
		 * 2、抽象类不能被实例化，即不能直接用new关键字去产生对象；
		 * 3、抽象方法只需声明，而不需实现；
		 * 4、含有抽象方法的类必须被称为抽象类，抽象类的子类必须覆盖所有的抽象方法后才能被实例化，
		 *    否则这个子类还是个抽象类
		 * 
		 * 抽象类不能直接实例化，如果要获得该类的实例可以使用静态方法创建其实现类对象。
		 * 
		 */
		
		
		//工厂模式（策略模式）使用 接口使用
		System.out.println();
		System.out.println("实例076  使用策略模式保存图片类型");
		
		ImageSaver saver = FactorySaver.getSaver("GIF");
		saver.save();
		
		saver = FactorySaver.getSaver("PNG");
		saver.save();
		
		saver = FactorySaver.getSaver("JPEG");
		saver.save();
		/**
		 * 接口与抽象类的区别
		 *  1、定义方式不同。接口使用关键字interface来定义，而抽象类使用关键字abstract来定义
		 *  2、子类数量不同。一个类只能继承一个抽象类，但可以实现多个接口。
		 *  3、访问控制不同。接口的成员变量默认为public static final，且所有方法默认为public abstract；
		 *     抽象类的成员变量默认为default，方法默认为abstract，且可以有非abstract的方法实现。
		 *  4、方法实现不同。接口中的方法默认是public abstract，不能有具体实现；抽象类中的方法可以是具体
		 *     或抽象的，可以有具体实现
		 *  5、静态代码块不同。接口不能使用静态代码块，而抽象类可以使用
		 *  6、设计理念不同。接口更偏向于定义一系列的规范或功能，而抽象类则可以包含实现细节，更偏向于定义
		 *     一种模板或结构
		 * 
		 */
		
	}

}
