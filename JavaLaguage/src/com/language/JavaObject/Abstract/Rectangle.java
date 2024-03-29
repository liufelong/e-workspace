package com.language.JavaObject.Abstract;


public class Rectangle extends Shape {

	private double length;
	private double width;
	
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	} 
	
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return length * width;
	}
}
