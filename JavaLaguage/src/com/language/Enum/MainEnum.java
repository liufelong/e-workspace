package com.language.Enum;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
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
		
//		showClothValue151();
		
//		enum_valus152();
		
//		enumSet153();
		
//		enumMap154();
		
//		genericityStack155();
		
//		genericsTwo156();
		
//		genericWildcard157();
		
//		genericMethods158();
		
//		genericInterface159();
		
//		genericClass160();
		
		hashtable161();
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
	
	public static void enum_valus152() {
		
		for (JDBCEnums jdbcEnums : JDBCEnums.values()) {
			System.out.println(jdbcEnums + ":" + JDBCEnums.getJDBCEnums(jdbcEnums));
		}
		/**
		 * enum类中方法摘要
		 * 方法名称				方法作用
			clone()			复制一份当前对象，并返回
			compareTo()		比较此枚举于指定对象的顺序
			equals()		当指定对象等于此枚举常量时，返回true
			hashCode()		返回枚举常量的哈希码
			name()			返回枚举常量的名称，在其枚举声明中对其进行声明
			ordinal()		返回枚举常量的系数
			toString()		返回枚举常量的名称，它包含在声明中
			valueOf()		返回带指定名称的指定枚举类型的枚举常量
			values()		返回当前对象取值范围
		 * */
	}
	
	public static void enumSet153() {
		EnumSet<Weeks> week = EnumSet.noneOf(Weeks.class);	// 创建一个Weeks类型的EnumSet
		
		week.add(Weeks.MONDAY);		// 向EnumSet中增加元素MONDAY
		System.out.println("EnumSet中的元素" + week);
		
		week.remove(Weeks.MONDAY);  // 删除EnumSet中的元素MONDAY
		System.out.println("EnumSet中的元素：" + week);
		
		//将week对象数组里的元素补满
		//EnumSet.complementOf(week) 返回一个EnumSet对象，元素是week的补集
		week.addAll(EnumSet.complementOf(week));// 向EnumSet中增加week中元素的补集
		System.out.println("EnumSet中的元素：" + week);
		
		// 删除EnumSet中从MONDAY到THURSDAY的元素
		week.removeAll(EnumSet.range(Weeks.MONDAY, Weeks.THURSDAY));
		System.out.println("EnumSet中的元素：" + week);
		
		/**
		 * 不能在EnumSet中增加Null元素，否则会出现空指针异常
		 * 
		 * 方法名								方法描述
		allOf(Class<E> elementType)		创建一个EnumSet，它包含了elementType中的所有枚举元素
		complementOf(EnumSet<E> s)		创建一个EnumSet，其中的元素是s的补集
		noneOf(Class<E> elementType)	创建一个EnumSet，其中元素类型是elementType，但是没有元素
		range(E from,E to)				创建一个EnumSet，其中的元素在from和to之间，包括端点
		add(E e)						向EnumSet对象中增加元素e
		remove(Object o)				从EnumSet对象中删除元素e
		addAll(Collection<?extends E> e)	向EnumSet对象中增加集合元素e
		removeAll(Collection<?> e)		从EnumSet对象中删除集合元素e
		 * 
		 * */
	}
	
	public static void enumMap154() {
		/**
		 * 当需要使用值时，可以根据键获得。这要求Map的键必须唯一，
		 * 而枚举类型的元素都是唯一的，因此可以用来做Map的键。
		 * */
		EnumMap<Weeks, String> weeksMap = new EnumMap<Weeks, String>(Weeks.class);
		weeksMap.put(Weeks.MONDAY, "星期一");// 增加键MONDAY，值为“星期一”
		weeksMap.put(Weeks.SUNDAY, "星期二");
		System.out.println("weeksMap中键值对个数：" + weeksMap.size());
		System.out.println("weeksMap中的键值对：" + weeksMap);
		
		System.out.println("weeksMap中是否包含键SATURADAY:" + weeksMap.containsKey(Weeks.SATURADAY));
		System.out.println("weeksMap中是否包含值星期日:" + weeksMap.containsValue("星期日"));
		
		weeksMap.remove(Weeks.MONDAY); //删除一个键值对
		System.out.println("weeksMap中的键值对：" + weeksMap);
		System.out.println("EnumMap中键MONDAY的值:" + weeksMap.get(Weeks.MONDAY));
		/**
		 * EnumMap会更加高效:
		 * 		它只能接收同一枚举类型的实例作为键值，并且由于枚举类型实例的数量相对固定并且有限，
		 * 		所以EnumMap使用数组来存放与枚举类型对应的值。
		 * 不能在EnumMap中增加Null元素，否则会出现空指针异常
		 * 
		 方法名							方法描述
		clear()						删除该map中的所有映射元素
		ContainsKey(Object Key)		如果包含值为key的键则返回true，否则返回false
		ContainsValue(Object value)	如果包含值为value的值则返回true，否则返回false
		put(K key,V value)			创建一个EnumMap中存入键为key，值为value的键值对
		get(Object key)				获得键key对应的值
		size()						查看EnumMap中键值对的个数
		remove (Object key)			从EnumMap中删除键为key的键值对
		 * */
	}
	
	public static void genericityStack155() {
		//泛型的目的就是定义的集合内所放的元素是统一的类型
		
		//使用泛型实现栈结构
		Stack<String> stack = new Stack<String>();
		System.out.println("向栈中添加字符串：");
		System.out.println("三国演义");
		System.out.println("西游记");
		System.out.println("红楼梦");
		System.out.println("水浒传");
		
		stack.push("三国演义");
		stack.push("西游记");
		stack.push("红楼梦");
		stack.push("水浒传");
		
		System.out.println("从栈中取出字符串："); 			// 从栈中取出字符串
		while(!stack.empty()) {
			System.out.println(stack.pop());
		}
	}
	
	public static void genericsTwo156() {
		//带有两个参数的泛型应用
		Generics<Integer, Double> generics = new Generics<Integer, Double>(100, 12.23);
		generics.printTypes();
		
		int num = generics.getT();
		System.out.println("num 变量中的值为：" + num);
		
		double dou = generics.getV();
		System.out.println("dou 变量中的值为：" + dou);
	}
	
	//使用通配符增强泛型
	public static Object getMiddle(List<? extends Number> list) {
		return list.get(list.size() / 2); // 返回列表的中间值
	}
	public static void genericWildcard157() {
		/**
		 * 泛型一个重要的特点是可以使用“？”作为通配符来匹配任何数据类型。
		 * 常用的泛型通配符主要有三种：无界通配符“？”、上限通配符extends和下限通配符super。
		 * */
		//使用通配符增强泛型
		List<Integer> ints = new ArrayList<Integer>();
		ints.add(1);
		ints.add(2);
		ints.add(3);
		ints.add(4);
		ints.add(5);
		System.out.println("整型列表元素：");
		System.out.println(Arrays.toString(ints.toArray()));
		System.out.println("整型列表的中间数: " + getMiddle(ints));
		
		List<Double> doubles = new ArrayList<Double>();
		doubles.add(1.1);
		doubles.add(2.2);
		doubles.add(3.3);
		System.out.println("\n浮点列表的元素：");
		System.out.println(Arrays.toString(doubles.toArray()));
		System.out.println("浮点列表的中间数：" + getMiddle(doubles));
	}
	
	// 定义泛型方法，有一个形式参数用类型参数T来定义
	public static <T> void genericMethods(T t, char n) {
		T t1 = t;// 局部变量也可以用类型参数T来定义
		System.out.println("[1]" + n + "的对象类型为" + t1.getClass().getName());
	}
	public static <T> void genericMethods(T t) {
		System.out.println("[1]" + t + "的对象类型为" + t.getClass().getName());
	}
	
	public static void genericMethods158() {
		Date date = new Date();
		Character k = new Character('A');
		// 用两种不同的方法调用泛型方法
		MainEnum.<Character> genericMethods(k, 'B');
		genericMethods(date);
		
		/**
		 * 声明泛型方法时，要注意以下几点：
			（1）使用<T>格式来表示泛型参数，参数的个数可以不是一个。
			（2）类型参数列表要放在访问权限修饰符、static和final之后。
			（3）类型参数列表要放在返回值类型、方法名称、方法参数之后。
		 * */
	}
	
	public static void genericInterface159() {
		Double doubleArrays[] = {35.8, 58.45, 96.34, 58.214,635.2, 1.124,
				510.89 };	// 创建一个Double类型的数组并初始化
		// 创建一个Character类型的数组并初始化
		Character charArrays[] = { 'A', 'B', 'b', 'Z', 'c', 'C', 'e' };	
		
		// 创建Double类型的泛型对象
		ComparableElement<Double> iob = new ComparableElement<Double>(doubleArrays);
		
		// 创建Character类型的泛型对象
		ComparableElement<Character> cob = new ComparableElement<Character>(charArrays);
		
		System.out.println("double数组中的最大值，max = " + iob.max());
		System.out.println("double数组中的最小值，min = " + iob.min());
		
		System.out.println("character数组中的最大值，max = " + cob.max());
		System.out.println("character数组中的最小值，min = " + cob.min());
		
		/**
		 * 在使用泛型接口时我们要注意以下几点，这也是使用所有泛型要注意的地方：
		 * （1）泛型的类型参数只能是类类型，包括自定义类，不能是简单类型。
		 * （2）同一种泛型可以对应多个版本，因为参数类型是不确定的，不同版本的泛型类实例是不兼容的。
		 * （3）泛型的类型参数可以有多个。
		 * （4）泛型的参数类型可以使用extends语句，例如<T extends superclass>。习惯上称为“有界类型”。
		 * （5）泛型的参数类型还可以是通配符类型，
		 * 		例如Class<?> classType = Class.forName("java.lang.String");。
		 * */
	}
	
	public static void genericClass160() {
		/**
		 * 泛型类的子类必须将泛型父类所需要的参数类型，沿着继承链向上传递。
		 * */
		System.out.println("以泛型类为父类的实现方法如下：");
		// 创建子类的对象，它需要传递两个参数，Date类型给父类，自己使用String类型
		Date date = new Date();
		GenericChild<Date, String> cdChild = new GenericChild<Date, String>(date, "当前系统的时间为：");
		System.out.print("\t" + cdChild.getDob());
		System.out.println(cdChild.getOb());
	}
	
	public static void hashtable161() {
		/**
		 * Hashtable是Dictionary类的具体体现，它封装了哈希表的数据结构和算法，功能上和HashMap相同。
		 * 由于Hashtable使用了同步机制以保护线程安全，所以它的运行效率要比HashMap低。
		 * 
		 * Hashtable的使用方法和HashMap类似
		 * Hashtable最好在多线程的情况下使用，否则就无法体现它的同步机制保护线程安全的优势了。
		 * */
		HashtableGeneric<String, String> tGeneric = new HashtableGeneric<String, String>();
		tGeneric.put("key", "I love Java");
		String string = tGeneric.get("key");
		System.out.println("根据key获取的value的内容：\n\t" + string);
	}
	
}
