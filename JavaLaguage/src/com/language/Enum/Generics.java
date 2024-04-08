package com.language.Enum;

public class Generics<T,V> {
//带两个类型参数的泛型的应用
	T t;
	V v;
	public Generics(T t1, V v1) {
		// TODO Auto-generated constructor stub
		t = t1;
		v = v1;
	}
	
	public void printTypes() {
		System.out.println("参数T的对象类型为:" + t.getClass().getName());
		System.out.println("参数V的对象类型为:" + v.getClass().getName());
	}
	
	public T getT() {
		return t;
	}
	
	public V getV() {
		return v;
	}
	
}
