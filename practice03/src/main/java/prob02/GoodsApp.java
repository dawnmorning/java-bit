package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력
		for (int i = 0; i < COUNT_GOODS; i++) {
			String line = scanner.nextLine();
			String[] infos = line.split(" ");
			String name= infos[0];
			int price = Integer.parseInt(infos[1]);
			int count = Integer.parseInt(infos[2]);
			goods[i] = new Goods(name, price, count);
		}
		// 상품 출고
		for (Goods good : goods) {
			System.out.println(good.name + "(가격: " + good.price + "원)이 " + + good.count + 
					"개 입고 되었습니다.");
		}
		// 상품 출고
//				for (int i = 0; i < COUNT_GOODS; i++) {
//					System.out.println(names[i] + "(가격: " + prices[i] + "원)이 " + quantities[i] + "개 입고 되었습니다.");
//				}
		// 자원정리
		scanner.close();
	}
	static class Goods{
		String name;
		int price;
		int count;
		
		public Goods(String name, int price, int count) {
			this.name = name;
			this.price = price;
			this.count = count;
		}
	}
}
