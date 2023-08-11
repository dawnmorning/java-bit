package exception;

import java.io.IOException;

public class MyClass {
						// 여기서 오류 해결
	public void danger() throws IOException, MyException {
		System.out.println("some code1....");
		System.out.println("some code2....");

		// 예외 객체를 던지는 것
		// Unhandled exception type IOException
		if (3 - 3 == 0) {
			throw new MyException();
		}
		if (1 - 1 == 0) {
			throw new IOException();
		}
		

		System.out.println("somec code3..");
		System.out.println("somec code4..");
	}
}
