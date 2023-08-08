package prob5;

public class Prob5 {

	public static void main(String[] args) {
		for (int i = 0; i <= 100; i++) {
			int ten = i / 10;
			int one = i % 10;
			int cnt = 0;
			
			if (ten == 3 || ten == 6 || ten == 9) {
				cnt ++;
			}
			if (one == 3 || one == 6 || one == 9) {
				cnt ++;
			}
			if (cnt == 2){
				System.out.println(i + " 짝짝");
			}else if (cnt == 1) {
				System.out.println(i + " 짝");
			}
			
		}
	}
}
