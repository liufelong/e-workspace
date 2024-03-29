package com.language.JavaObject.Abstract;

public class Circle extends Shape {
	//圆形
	private double radius; //半径
	
	public  Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return Math.PI * Math.pow(radius, 2);
	}

	
}
