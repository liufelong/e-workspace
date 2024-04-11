package com.language.Enum;

//泛型类的继承
public class GenericChild<T,U> extends Father<T> {
	U u;
	public GenericChild(T t, U u) {
		// TODO Auto-generated constructor stub
		super(t);
		this.u = u;
	}
	
	public U getDob() {
		return u;
	}
}

class Father<T> {
	T t;
	
	public Father() {
		// TODO Auto-generated constructor stub
		this.t = null;
	}
	
	public Father(T t) {
		// TODO Auto-generated constructor stub
		this.t = t;
	}
	
	public T getOb() {
		return t;
	}
	
}
