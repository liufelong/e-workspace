package com.language.Enum;

import java.util.Hashtable;

public class HashtableGeneric<K,V> {
	
	public Hashtable<K, V> hashtable = new Hashtable<K, V>();// 创建Hashtable的泛型类对象
	
	// 创建put方法为key和value赋值
	public void put(K k, V v) {
		hashtable.put(k, v);
	}
	
	public V get(K k) {
		return hashtable.get(k);
	}
}
