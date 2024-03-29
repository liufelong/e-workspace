package com.language.JavaString;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class ConvertMoney {

	private static final String STR_UNIT[] = {"","拾","佰","仟","万","拾","佰","仟","亿"};
    private static final String STR_NUMBER[] = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
	
	//金额转汉字
    //static修饰的方法是类方法，可以通过类名直接调用
    //static修饰的属性，所有的类对象共用，任意一处修改 都可以修改全量的属性值
	public static String converString(double d) {
		
		//通过这个格式器对象把金额数字格式化
		//DecimalFormat类可以指定格式化模板来格式化浮点数，如保留几位小数。
		//通过调用该类的format()方法可以使用指定模板来格式化任意浮点数字。
		DecimalFormat decimalFormat = new DecimalFormat("#0.###");
		String strNum = decimalFormat.format(d);
		
		String tempStr = strNum;
		String point = "元整";
		if (strNum.indexOf(".") != -1) { //是否包含小数点
			tempStr = strNum.substring(0, strNum.indexOf("."));
			point = "元";
		}
		
		if (tempStr.length() > 12) {
			System.out.println("整数部分大于12位，数字太大无法转换");
			return "";
		}
		String result = getInteger(strNum) + point + getDecimal(strNum);
		if (result.startsWith("元")) {
			result = result.substring(1, result.length());
		}
		return result;
	}
	
	public static String getInteger(String num) {
		if (num.indexOf(".") != -1) {
			num = num.substring(0,num.indexOf("."));
		}
		
		// 反转字符串
		num = new StringBuffer(num).reverse().toString();
		
		StringBuffer tempBuffer = new StringBuffer();
		for (int i = 0; i < num.length(); i++) {
			tempBuffer.append(STR_UNIT[i]);
			tempBuffer.append(STR_NUMBER[num.charAt(i) - 48]);
		}
		
		num = tempBuffer.reverse().toString();			// 反转字符串
        num = numReplace(num, "零拾", "零"); 				// 替换字符串的字符
        num = numReplace(num, "零佰", "零"); 				// 替换字符串的字符
        num = numReplace(num, "零仟", "零"); 				// 替换字符串的字符
        num = numReplace(num, "零万", "万"); 				// 替换字符串的字符
        num = numReplace(num, "零亿", "亿"); 				// 替换字符串的字符
        num = numReplace(num, "零零", "零"); 				// 替换字符串的字符
        num = numReplace(num, "亿万", "亿"); 				// 替换字符串的字符
		
        //如果最后一位是零 就截取一下
        if (num.indexOf("零") == num.length() - 1) {
			num = num.substring(0, num.length() - 1);
		}
		return num;
	}
	
	public static String numReplace(String num, String oldStr, String newStr) {
		
		while (true) {
			if (num.indexOf(oldStr) == -1) {
				break;
			}
			num.replace(oldStr, newStr);
		}
		return num;
	}
	
	public static String getDecimal(String num){
        if (num.indexOf(".") != -1){
            num = num.substring(num.indexOf(".")+1);
            StringBuffer temp = new StringBuffer();
            temp.append(STR_NUMBER[num.charAt(0)-48]);
            temp.append("角");
            if(num.length()!=1) {
                temp.append(STR_NUMBER[num.charAt(1) - 48]);
                temp.append("分");
            }
            return  temp.toString();
        }
        return "";
  	  }
	
	public static void currencyFormat(double d) {
		//用Locale类的以下常量作为格式化对象的构造参数，将获得不同的货币格式
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CHINA);
		
		System.out.println("Locale.CHINA:" + format.format(d));
		
		format = NumberFormat.getCurrencyInstance(Locale.ENGLISH);
		System.out.println("Locale.ENGLISH:" + format.format(d));
		
		format = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println("Locale.US:" + format.format(d));
		
	}
	
}
