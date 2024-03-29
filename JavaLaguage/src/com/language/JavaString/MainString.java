package com.language.JavaString;

public class MainString {
	public static void main(String[] args) {
		
		//实例043  将数字货币金额转换为大写格式
		System.out.println("实例043  将数字货币金额转换为大写格式");
		System.out.println(ConvertMoney.converString(12345.12));
		
		//实例044  将数字格式化为货币字符串
		System.out.println("");
		System.out.println("实例044  将数字格式化为货币字符串");
		ConvertMoney.currencyFormat(1234);
		
		//实例045  实现不同字符串的连接
		System.out.println();
		System.out.println("实例045  实现不同字符串的连接");
		StringManager.appendString();
		
		System.out.println();
		System.out.println("实例046  字符串大小写转换");
		StringManager.stringUpAndLower();
		
		System.out.println();
		System.out.println("实例047  计算字符串中子串出现的次数");
		StringManager.appearTimes();
		
		System.out.println();
		System.out.println("实例048  当前日期的格式化");
		StringManager.dateFormat();
		
	}

}
