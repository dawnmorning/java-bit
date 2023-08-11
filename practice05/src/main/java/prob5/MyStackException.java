package prob5;

public class MyStackException extends Exception {
	public MyStackException(String message) {
		super(message);
	}

	@Override
	public String toString() {
		return "Prob5.MyStackException: " + getMessage();
	}
}
