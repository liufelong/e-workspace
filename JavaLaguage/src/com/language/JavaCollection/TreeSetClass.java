package com.language.JavaCollection;

import java.util.Random;
import java.util.TreeSet;

public class TreeSetClass {

	public TreeSetClass() {
		// TODO Auto-generated constructor stub
	}
	
	public static void randomArray() {
		//实例081  不重复地进行随机数组排序
		TreeSet<Integer> set = new TreeSet<Integer>();
		Random random = new Random();
		
		int count = 0;
		while (count < 10) {
			boolean succesed = set.add(random.nextInt(100));
			if (succesed) {
				count ++;
			}
		}
		int size = set.size();
		Integer array[] = new Integer[size];
		set.toArray(array);
		System.out.println("以下是生成的随机数");
		for (int value : array) {
			System.out.print(value + "   ");
		}
	}
}
