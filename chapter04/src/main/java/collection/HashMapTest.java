package collection;

import java.util.*;

public class HashMapTest {

	public static void main(String[] args) {
		Map<String, Integer> dict = new HashMap<>();
		
		dict.put("one", 1); // auto boxing
		dict.put("tow", 2); 
		dict.put("three", 3);
		
		int i = dict.get("one"); // auto unboxing
		System.out.println(i);
		int j = dict.get(new String("one"));
		System.out.println(i + ":" + j);
		
		dict.put("three", 33);
		System.out.println(dict);
		
		// 순회
		Set<String> s = dict.keySet();
		for (String k : s) {
			System.out.println(dict.get(k));
		}
	}

}
