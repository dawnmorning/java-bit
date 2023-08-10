package exception;

public class ExceotionTest {

	public static void main(String[] args) {
		int a = 10;
		int b = 10 - a;
		System.out.println("Some Code 1");
		try {
			System.out.println("Some Code 2");
			int result = (1 + 2 + 3) / b;
			System.out.println("Some Code 3");
		} catch (ArithmeticException e) {
			// 예외 처리 과정
			// 1. 로깅
			System.err.println("에러입니다: " + e);
			
			// 2. 사과
			System.out.println("미안합니다........");
			
			// 3. 정상 종료
			// 정상,0 실패,1
//			System.exit(1);
			 return;
//			e.printStackTrace();
		} finally {
			System.out.println("자원 정리: file close, socket close");
		}
		
		// 자원정리 이후 코드는 가급적 지양
		System.out.println("Some Code 4");
		// Exception in thread "main" java.lang.ArithmeticException: / by zero
		// at exception.ExceotionTest.main(ExceotionTest.java:8)

	}

}
