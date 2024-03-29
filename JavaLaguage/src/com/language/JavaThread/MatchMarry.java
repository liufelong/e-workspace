package com.language.JavaThread;

public class MatchMarry extends Thread{

	private String nameString;
	private String otherNameString;
	private boolean isMarry = false;
	
	public MatchMarry(String name, String otherName) {
		// TODO Auto-generated constructor stub
		this.nameString = name;
		this.otherNameString = otherName;
	}
	
	@Override
	public void run() {
		try {
			int person = (int)Math.floor((Math.random() * 10 + 1)); //获取一个随机数
			System.out.println("获取的随机数:" +person);
			if (person % 2 == 0) {
				isMarry = true;
			} else {
				isMarry = false;
			}
			if (isMarry) {
				System.out.println(otherNameString + "已婚，红色警告：对待婚姻不要有二心");
			} else {
				System.out.println(nameString + "可以和" + otherNameString + "结婚，祝你们幸福");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
