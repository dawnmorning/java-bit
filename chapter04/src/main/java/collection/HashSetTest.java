package collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Set<String> s = new HashSet<>();
		String s1 = new String("희동이");
		String s2 = new String("도우너");
		
		s.add("둘리");
		s.add("고길동");
		s.add("희동이");
		// s.add("희동이");
		s.add(s1);
		s.add(s2);
		
		System.out.println(s.size());
		System.out.println(s.contains(s2));
		// 순회
		for (String str : s) {
			System.out.println(str);
		}
		
	}

}
