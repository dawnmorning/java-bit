package chapter04;

import java.util.Calendar;
import java.util.concurrent.Callable;


// 상속 금지
//public final class CalendarTest
public class CalendarTest {
	
	// 오버라이드 금지
	// public final void m()
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		// 더이상 변하지 않는 값
		// final int i = 10;
//		i = 10 + 9;
		PrintDate(cal);
		
		 cal.set(Calendar.YEAR, 2023);
		 cal.set(Calendar.MONTH, 11); // 12월, 12-1
		 cal.set(Calendar.DATE, 25);
		 PrintDate(cal);
		 
		 cal.set(2021, 5, 12);
		 cal.add(Calendar.DATE, 1000);
		 PrintDate(cal);
	}

	private static void PrintDate(Calendar cal) {
		final String[] DAYS = {"일", "월", "화", "수", "목", "금", "토"};
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH); // 0 ~ 11 + 1
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.DAY_OF_WEEK); // 1(일) ~ 7(토)
		
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		System.out.println(year + "/" + (month + 1) + "/" + date + " " + DAYS[day-1] + "요일 " + hour + ":" + minute + ":" + second);
		
	}

}
