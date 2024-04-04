package com.language.JavaTool;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class DateClass {
	//日期相关的
	
	//获取当前时间 Date 类
	public static void currnetTime136() {
		// 创建一个Date对象
		Date date = new Date();
		
		/**
		 * 常用方法	描述
			public long getTime()	返回自1970年1月1日00:00:00GMT以来此Date对象表示的毫秒数
			public void setTime(long time)	设置此Date对象，以表示1970年1月1日00:00:00GMT以后time毫秒的时间点
			public boolean before(Date when)	测试此日期是否在指定日期之前。
									当且仅当此Date对象表示的瞬间比when表示的瞬间早，才返回true；否则返回false
			public boolean after(Date when)	测试此日期是否在指定日期之后。
								当且仅当此Date对象表示的瞬间比when表示的瞬间晚，才返回true；否则返回false
			public int compareTo(Date anotherDate)	比较两个日期的顺序。
								如果参数Date等于此Date，则返回值0；如果此Date在Date参数之前，则返回小于0的值；
								如果此Date在Date参数之后，则返回大于0的值
			public String toString()	把此Date对象转换为以下形式的String：dowmonddhh:mm:sszzzyyyy
		 * 
		 * */
		
		// 调用Date类的getTime方法
		System.out.println("距1970年1月1日00:00:00时间已经过了" + date.getTime() + "毫秒");
		// 调用Date类的toGMTString方法，不过此方法已过时
		System.out.println("当前的时间：" + date.toGMTString());
	}

	//simpleDateFormat 格式化输出时间
	public static void simpleDateFormat137() {
		System.out.println("SimpleDateFormat 获取系统当前时间如下:");
		// 创建一个日期格式化，日期的形式为EEEE-MMMM-dd-yyyy
		SimpleDateFormat barDateFormat = new SimpleDateFormat("EEEE-MMMM-dd-yyyy");
		SimpleDateFormat b = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
		SimpleDateFormat b1 = new SimpleDateFormat("h:mm a");
		Date date = new Date();
		
		System.out.println("时间格式为EEEE-MMMM-dd-yyyy：" + barDateFormat.format(date));
		System.out.println("时间格式为yyyy.MM.dd G 'at' HH:mm:ss z：" + b.format(date));
		System.out.println("时间格式为h:mm a：" + b1.format(date));
		/**
		 *  G：公元前/后
		 *  y：年
		 *  w：一年中第几个星期
		 *  W：一月中第几个星期
		 *  D：一年中的第几天
		 *  d：一月中的第几天
		 *  F：这一天位于本月的第几个星期
		 *  E：星期几
		 *  a：上午、下午
		 *  H：24小时制
		 *  h：12小时制
		 *  m：分钟
		 *  M：月
		 * 
		 * */
	}

	//日历类Calendar
	public static void calendar138() {
		 String days[] = {" ","日","一","二","三","四","五","六"};
		 
		 //调用 getInstance() 方法 获取日历对象
		 Calendar calendar = Calendar.getInstance();
		 
		 int year = calendar.get(Calendar.YEAR);
		 int month = calendar.get(Calendar.MONTH) + 1; // 获取月份，它是以0为第一个月，所以要加1
		 int date = calendar.get(Calendar.DATE); //获取日期
		 
		 int day = calendar.get(Calendar.DAY_OF_WEEK);// 获取星期几，它是以1为第1天，要用数组days[]来换算
		 
		 int hour = calendar.get(Calendar.HOUR_OF_DAY);
		 int min = calendar.get(Calendar.MINUTE);
		 int sec = calendar.get(Calendar.SECOND);
		 
		 System.out.println("今天是："+year+"年"+month+"月"+date+"号"+"  星期"+days[day]); 
		 System.out.println("现在的时间是： "+hour+":"+min+":"+sec);
		 
		 System.out.println("DAY_OF_MONTH:" + calendar.get(Calendar.DAY_OF_MONTH));
		 System.out.println("DAY_OF_WEEK:" + calendar.get(Calendar.DAY_OF_WEEK));
		 System.out.println("DAY_OF_YEAR:" + calendar.get(Calendar.DAY_OF_YEAR));
		 
		 /**
		  * 可以通过调用set()方法来设置日历字段值。在该类中提供了几种设置日历字段的方法。
public void set(int field, int value) //将给定的日历字段field设置为给定值value
public final void set(int year, int month, int date) //设置日历时间的年月日
public final void set(int year, int month, int date, int h, int m) //设置日历时间的年月日小时分钟
public final void set(int year, int month, int date, int h, int m, int s) //设置日历时间的年月日时分秒
		  * */
		 
	}

	//公历日历 GregorianCalendar, Calendar的子类，多定义了两个属性AD和BC，分别表示公元前和公元后。
	public static void gregorianCalendar139() {
		String headString[] = {"星期日 ","星期一 ","星期二 ","星期三 ","星期四 ","星期五 ","星期六 "};
		
//		Scanner inScanner = new Scanner(System.in);
//		System.out.println("请输入年份：");
//		int year = inScanner.nextInt();
//		
//		System.out.println("请输入月份：");
//		int month = inScanner.nextInt() - 1;// GregorianCalendar的第一个月是0，
//		inScanner.close();
		
		System.out.println("指定2024年3月1日创建日历对象");
		//以指定的年月日创建对象
		GregorianCalendar gregorianCalendar = new GregorianCalendar(2024, 3-1, 1);
		
		//获取这个月有几天
		int totalDays = gregorianCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 获取这个月的第一天是星期几
		int startDay = gregorianCalendar.get(Calendar.DAY_OF_WEEK) - 1;
				
		//输出日历头部 每一个输出项占8个字符宽度
		for (int i = 0; i < headString.length; i++) {
			System.out.print(headString[i] + "  ");
		}
		System.out.println();
		
		int i;
		// 输出第一天之前的空格
		for(i=0;i<startDay;i++) {
			System.out.print("        ");
		}
		      
		for(int day=1; day<=totalDays;day++){
		     System.out.printf("   %2d   ",day);
		     i++;
		     if (i==7){ 						// 每个星期输出完，换行
		      System.out.println();
		      i=0;
	       }  
 	    }
		/**
		 * 在GregorianCalendar类中可以使用setTime和getTime()方法来设置和取得Calendar的时间。
		 * public final void setTime(Date date)	 // 给定Date设置Calendar的时间
		 * public final Date getTime()		 // 返回一个表示此Calendar时间值
		 * 
		 * 比较常用的方法是add()方法
		 * public void add(int field,int amount)  amount的值可以是负值,实现日历的计算
		 * calendar.add(Calendar. MONTH, 1);
		 * 
		 * */
	}

    
	public static void calendarShowTime140 () {
		Calendar calendar = Calendar.getInstance();
		//设置时间为2024年4月2号
		calendar.set(Calendar.YEAR, 2024);
		calendar.set(Calendar.MONTH, 4-1);
		calendar.set(Calendar.DATE, 2);
		
		System.out.println("2024年4月2号一周内的日历如下：");
		System.out.println("星期日\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六");
		int count = 0;
		while (count < 7) {
			// 设置添加日历的周期为1
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			// 获取日历的星期几表示数，例如：0：表示星期日
			int day = calendar.getTime().getDay();
			// 根据星期几来决定输入几个tab
			if (count == 0) {
				for (int i = 0; i < day; i++) {
					System.out.print("\t");
				}
			}
			if (day == 0) {
				//如果是周日则换行
				System.out.println();
			}
			// 获取日历中日期数
			System.out.print(calendar.getTime().getDate() + "\t");
			count++;
		}
		
	}
	
	public static void formatterOut141() {
		/**
		 * 相信大家对System.out.printlu()方法都很熟悉，这是一种可以控制输出格式的方法。
		 * 而在JDK 1.4之后，如果需要格式化输出，还可以使用Formatter类。
		 * Formatter类比print()方法功能更强，不仅可以用于控制台的输出，也可以用于GUI窗口程序的输出。
		 * */
	}
	
	public static void useFormatterOutTime142() {
		System.out.println("使用Formatter.format输出日期");
		Formatter formatter = new Formatter(System.out);
		
		Date date = new Date();
		formatter.format("现在的日期和时间（以默认的完整格式）：%tc\n", date);
		formatter.format("今天的日期(按照中国人的习惯)：%1$tY-%1$tm-%1$td", date);
		formatter.format("今天是：%tA\n", date);
		formatter.format("现在的时间（24小时制）:%tT\n",date);
		formatter.format("现在的时间（12小时制）:%tr\n",date);
		formatter.format("现在是：%tH点%1$tM分%1$tS秒",date);

	}
	
	
	
}
