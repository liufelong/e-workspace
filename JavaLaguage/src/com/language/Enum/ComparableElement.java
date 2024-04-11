package com.language.Enum;

//泛型接口
//创建一个泛型接口
interface MaxOrMin<T extends Comparable<T>>{
	T max();
	T min();
}

//声明一个ComparableElement类继承于Comparable类并实现MaxOrMin接口
public class ComparableElement<T extends Comparable<T>> implements MaxOrMin<T>{
	T[] mmTs;
	
	public ComparableElement(T[] ob) {
		// TODO Auto-generated constructor stub
		mmTs = ob;
	}
	
	@Override
	public T max() {
		// TODO Auto-generated method stub
		T t = mmTs[0];
		for (int i = 1; i < mmTs.length; i++) {
			 if (mmTs[i].compareTo(t) > 0) {
				t = mmTs[i];
			}			
		}
		return t;
	}
	@Override
	public T min() {
		// TODO Auto-generated method stub
		T t = mmTs[0];
		for (int i = 1; i < mmTs.length; i++) {
			 if (mmTs[i].compareTo(t) < 0) {
				t = mmTs[i];
			}			
		}
		return t;
	}
}
