package prob5;

public class MyStack03<T> {
	private T[] buffer;
	private int top;

	public MyStack03(int size) {
		buffer = (T[]) new Object[size];
		top = -1;
	}

	public void push(T value) {
		if (top == buffer.length - 1) {
			T[] newBuffer = (T[]) new Object[buffer.length * 2];

			for (int i = 0; i < buffer.length; i++) {
				newBuffer[i] = (T) buffer[i];
			}

			buffer = (T[]) newBuffer;
		}
		buffer[++top] = value;
	}

	public T pop() throws MyStackException {
		if (top == -1) {
			throw new MyStackException("stack is empty");
		}
		return buffer[top--];
	}

	public boolean isEmpty() {
		return top == -1;
	}

}