package com.language.JavaCollection;

public class Employee implements Comparable<Employee> {
	
	private int id;
	private String name;
	private int age;
	
	public Employee(int id, String name, int age) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		//利用编号实现对象间的比较
		if (id > o.id) {
			return 1;
		} else if (id < o.id) {
			return -1;
		}
		return 0;
	}
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("员工编号：" + id + ",");
		buffer.append("员工姓名：" + name + ",");
		buffer.append("员工年龄：" + age + ",");
		
		return buffer.toString();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
