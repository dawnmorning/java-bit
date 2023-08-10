package chapter03;

public class StudentTest02 {

	public static void main(String[] args) {
		Student s1 = new Student();
		Person p = s1; // upcasting(암시적 캐스팅, Implicity)
		
		Student s2 = (Student)p; // downcasting(명시적, Explicity)

	}

}
