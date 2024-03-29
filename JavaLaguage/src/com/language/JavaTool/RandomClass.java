package com.language.JavaTool;

import java.util.Random;

public class RandomClass {

	//public void setSeed(long seed)：该方法的作用是重新设置Random对象中的种子数。
	//设置完种子数以后的Random对象和相同种子数使用new关键字创建出的Random对象相同。
	
	// 获取各种数据类型的随机数
	public static void randomTypes() {
		System.out.println("1. 使用Random类的构造方法生成随机数的示例如下:");
		
		// 使用默认的构造方法创建一个Random对象
		Random random = new Random();
		
		int a = 0, b = 0, c = 0, d = 0, e = 0;
		while (true) {
			if (a < 5) {
				if (a == 0) {
					System.out.print("生成double类型随机数如下:");
				}
				System.out.print(random.nextDouble() + " "); // 按均匀分布产生[0, 1)范围的double
				a++;
			} else if (a == 5 && b < 5) {
				if (a == 5 && b == 0) {
					System.out.print("\n 生成float型随机数如下:");
				}
				System.out.print(random.nextFloat() + " "); // 按均匀分布产生大于等于0，小于1的float
				b++;
			} else if (b == 5 && c < 5) {
				if (b == 5 && c == 0) {
					System.out.print("\n生成long型随机数如下:"); // 按均匀分布产生长整数
				}
				System.out.print(random.nextLong() + " ");
				c++;
			} else if (c == 5 && d < 5) {
				if (c == 5 && d == 0) {
					System.out.print("\n生成int型随机数如下:"); // 按均匀分布产生整数
				}
				System.out.print(random.nextInt() + " ");
				d++;
			} else if (d == 5 && e < 5) {
				if (d == 5 && e == 0) {
					System.out.print("\n生成按正态分布产生的double型随机数列如下:");
				}
				System.out.print(random.nextGaussian() + " ");
				e++;
			} else if (e == 5) {
				break;
			}
		}
		
	}

	// 获取指定范围内的随机数
	public static void nextInt() {
		System.out.println("\n\n2. 在指定范围内产生随机序列：");
		System.out.print("在[0,8)的范围内产生的随机整数序列如下: ");
		
		Random random = new Random();
		for (int i = 0; i < 5; i++) {			
			// Random的nextInt(int n)方法返回一个[0, n]范围内的随机数
			System.out.print(random.nextInt(7) + " ");
		}
		
		System.out.println("");
		System.out.print("在[5,50)的范围内产生的随机整数序列如下:");
		for (int i = 0; i < 5; i++) {
			System.out.print(5 + random.nextInt(45) + "  ");
		}
		
		System.out.println();
		System.out.print("在[0,100)范围内生成float型的随机整数序列如下: ");
		for (int i = 0; i < 5; i++) {
			System.out.print((int) (random.nextFloat() * 100) + "  ");
		}
		System.out.println("\n");
		
	}
}
