package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in  );
		System.out.print("금액 : " );
		int coin = scanner.nextInt();
		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };
		
		int 오만원 = coin / 50000;
		coin %= 50000;
		
		int 일만원 = coin / 10000;
		coin %= 10000;
		
		int 오천원 = coin / 5000;
		coin %= 5000;
		
		int 일천원 = coin / 1000;
		coin %= 1000;
		
		int 오백원 = coin / 500;
		coin %= 500;
		
		int 백원 = coin / 100;
		coin %= 100;
		
		int 오십원 = coin / 50;
		coin %= 50;
		
		
		int 십원 = coin / 10;
		coin %= 10;
		
		int 오원 = coin / 5;
		coin %= 5;
		
		int 일원 = coin;
		
		System.out.println("50000원 : " + 오만원 + "개");
		System.out.println("10000원 : " + 일만원 + "개");
		System.out.println("5000원 : " + 오천원 + "개");
		System.out.println("1000원 : " + 일천원 + "개");
		System.out.println("500원 : " + 오백원 + "개");
		System.out.println("100원 : " + 백원 + "개");
		System.out.println("50원 : " + 오십원 + "개");
		System.out.println("10원 : " + 십원 + "개");
		System.out.println("5원 : " + 오원 + "개");
		System.out.println("1원 : " + 일원 + "개");
		
		
		scanner.close();
 	}
}