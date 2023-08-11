package chapter04;

public class ObjectTest03 {
//	두 객체가 할당된 메모리 주소가 같으면 동일하고, 두 객체의 내용이 같으면 동등하다고 말한다. 
//	동일성은 == 연산자를 통해 판별할 수 있고, 
//	동등성은 equals 연산자를 통해 판별할 수 있다.
//	equals 연산자는 재정의하지 않으면 내부적으로 == 연산자와 같은 로직을 수행하므로 차이가 없다. 
//	따라서 equals 연산자는 각 객체의 특성에 맞게 재정의를 해야 동등성의 기능을 수행한다.
	public static void main(String[] args) {
		String s1 = new String("Hello");
		String s2 = new String("Hello");

		// 동일성 비교, 메모리 주소가 같은가? false ( reference )
		System.out.println(s1 == s2);
		// 동질성 비교, true ()
		System.out.println(s1.equals(s2)); // true, 오버라이드 되어있는 상태
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(s2));
		System.out.println("===========================");

		String s3 = "hello";
		String s4 = "hello";

		// 동일성 비교, 메모리 주소가 같은가? true ( reference )
		System.out.println(s3 == s4);
		// 동질성 비교, true ()
		System.out.println(s3.equals(s4)); // true
		System.out.println(s3.hashCode());
		System.out.println(s4.hashCode());
		System.out.println(System.identityHashCode(s3));
		System.out.println(System.identityHashCode(s4));
	}

}
