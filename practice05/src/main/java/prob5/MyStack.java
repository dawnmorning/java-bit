package prob5;

import java.util.Arrays;

public class MyStack {
	private String[] buffer;
	private int top;

	public MyStack(int size) {
		buffer = new String[size];
		top = -1;
	}

	public void push(String value) {
		if (top == buffer.length - 1) {
			String[] newBuffer = new String[buffer.length * 2];

			for (int i = 0; i < buffer.length; i++) {
				newBuffer[i] = buffer[i];
			}

			buffer = newBuffer;
		}
		buffer[++top] = value;
	}

	public String pop() throws MyStackException {
		if (top == -1) {
			throw new MyStackException("stack is empty");
		}
		return buffer[top--];
	}

	public boolean isEmpty() {
		return top == -1;
	}

}