package com.language.Enum;

public enum Size {
	SMALL(18.8),  MEDIUM(26.8),  LARGE(32.8),  EXTRA_LARGE(40.8);
	
	private double value;
	
	private	Size() {
		this(0);
	}
	private Size(double value){										// 定义Size()方法
	     this.value = value;
	 }
	double getValue(){												// 定义getValue()方法
		return value;
	}
}
