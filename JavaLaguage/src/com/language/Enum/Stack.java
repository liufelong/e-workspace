package com.language.Enum;

import java.util.LinkedList;

public class Stack<T> { // 定义参数类型为T的类
	private LinkedList<T> container = new LinkedList<T>(); // 使用T类型的链表保存存入栈的数据 
	
	public void push(T t) {
		container.add(t);
	}
	
	public T pop() {
		return container.removeFirst();// 实现从栈中删除元素的方法
	}
	
	public boolean empty() {
		return container.isEmpty();// 判断链表中的元素是否为空
	}
}
