package collection;

import java.util.Stack;
import java.util.Vector;

public class StackTest {

	public static void main(String[] args) {
		Stack<String> st = new Stack<>();

		st.push("둘리");
		st.push("마이콜");
		st.push("도우너");
		
		while(!st.isEmpty()) {
			String str = st.pop();
			System.out.println(str);
		}

		st.push("둘리");
		st.push("마이콜");
		st.push("도우너");
		System.out.println(st.pop());
		System.out.println(st.peek());
	}

}
