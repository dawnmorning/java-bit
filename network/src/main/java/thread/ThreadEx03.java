package thread;

public class ThreadEx03 {

	public static void main(String[] args) {
		Thread thread01 = new DigitalThread();
		Thread thread02 = new AlphabetThread();
		// runnable interface를 구현한 객체를 넣어야 함
		Thread thread03 = new Thread(new UpperCaseAlphabetRunnableImpl());
		thread01.start();
		thread02.start();
		thread03.start();
	}

}
