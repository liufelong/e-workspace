package com.language.JavaCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainCollection {

	public static void main(String[] args) {
		
		example81();
		
		example82();
		
		example83();
	}
	
	public static void example81() {
		System.out.println("实例081  不重复地进行随机数组排序");
		TreeSetClass.randomArray();
		/**
		 * Java集合框架提供了有效的数据结构和算法，因此程序员不需要自己编写代码实现这些功能。
		 * 而且结合框架对各个接口的实现是可以互换的，因此很容易转换接口。这样就提高了软件的复用性。
		 * Java平台提供了一个全新的集合框架。集合框架的核心接口为Collection、List（列表）、Set（集合）和Map
		 * */
	}
	
	public static void example82() {
		System.out.println("");
		System.out.println("实例082  实现List集合中数组的自动排序");
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(3, "Lester", 21));
		list.add(new Employee(2, "Jimmy", 22));
		list.add(new Employee(1, "Bobby", 23));
		System.out.println("排序前");
		for (Employee employee : list) {
			System.out.println(employee);
		}
		System.out.println("排序后");
		Collections.sort(list);
		for (Employee employee : list) {
			System.out.println(employee);
		}
		/**
		 * 保存在List集合中的数组是不进行排序的，不过可以通过使用Comparable接口自定义排序规则并自动排序.
		 * 
		 * 在Employee中必须实现接口中定义的compareTo()方法。实现该方法后，如果将该对象保存到列表中，
		 *  那么可以通过执行Collections.sort()方法进行自动排序；
		 *  如果保存到数组中，那么可以通过执行Arrays.sort()方法进行自动排序。
		 *  
		 * 如果不想实现在接口中定义的方法，则可以将类声明为抽象类，将接口中定义的方法声明为抽象方法。
		 *  
		 * */
	}
	
	public static void example83() {
		System.out.println("");
		System.out.println("实例083  使用动态数组保存用户名");
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("Lester");
		list.add("Jimmy");
		list.add("Bobby");
		list.add(1, "AA");
		for (String string : list) {
			System.out.print(string + "  ");
		}
		
		/**
		 * ArrayList类是对AbstractList类的扩展。
		 * ArrayList支持可随需要而增长的动态数组。
		 * 
		 * 方法	功能描述
public boolean add(E o)	将指定的元素追加到列表的最后
public void add(int index,E element)	将参数element表示的元素插入此列表中参数index表示指定位置中
public boolean addAll(Collection c)	将Collection中所有元素追加到此列表的尾部
public void clear()	删除列表中的所有元素
public boolean contains(Object elem)	判断此列表是否包含参数elem表示的指定元素
public get(int index)	返回列表中指定位置上的元素
public boolean isEmpty()	判断此列表中有没有元素
public remove(int index)	删除列表中指定位置上的元素
public set(int index, E element)	用参数element表示指定的元素代替列表中指定位置上的元素
public int size()	返回列表中的元素数
public Object[] toArray()	返回一个包含列表中所有元素的数组
public T[] toArray(T[] a)	返回一个包含列表中所有元素的数组
void trimToSize()	将容量调整为该列表的当前大小
		 * */		
	}
	
	//Iterater 循环
/**
 *  for(Iterator<Integer> it = list.iterator();it.hasNext();) {
            System.out.print(it.next()+" ");
        }
 * 
 * Java还提供了一个功能更加强大的ListIterator，它可以实现逆序遍历列表中的元素。
 * 
 * ListIterator<Integer> li = list.listIterator();			// 获得ListIterator对象
        for (li = list.listIterator(); li.hasNext();) {				// 将游标定位到列表结尾
            li.next();
        }
        for (; li.hasPrevious();) {						// 逆序输出列表中的元素
            System.out.print(li.previous() + " ");
        }
        
        List和Set都有iterator()来取得其迭代器。对List来说，
        你也可以通过listIterator()取得其迭代器，两种迭代器在有些时候是不能通用的
        ，Iterator和ListIterator主要区别在以下方面：
	ListIterator有add()方法，可以向List中添加对象，而Iterator不能。
	ListIterator和Iterator都有hasNext()和next()方法，可以实现顺序向后遍历，
		但是ListIterator有hasPrevious()和previous()方法，可以实现逆向（顺序向前）遍历。Iterator就不可以。
	ListIterator可以定位当前的索引位置，nextIndex()和previousIndex()可以实现。Iterator没有此功能。
	都可实现删除对象，但是ListIterator可以实现对象的修改，set()方法可以实现。Iterator仅能遍历，不能修改
 * */
	
	
	
}
