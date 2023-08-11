package chapter04;

public class StringTest04 {

	public static void main(String[] args) {
		// String s1 = "Hello" + "World" + "Java" + 17;
		StringBuffer sb = new StringBuffer("Hello");
		sb.append("World");
		sb.append("Java");
		sb.append(17);
		String s1 = sb.toString();
		System.out.println(s1);
		String s2 = new StringBuffer("Hello").append("World").append("Java").append(17).toString();

		String s3 = "";
		for (int i = 0; i < 1000000; i++) {
			// s2 += i;
			// new StringBuffer(s2).append(i).toString();
		}
		StringBuffer sb2 = new StringBuffer("");
		for (int i = 0; i < 100000; i++) {
			sb2.append(i);
		}
		String s4 = sb2.toString();

		// String method
		String s5 = "aBcABCabcAbc";
		System.out.println(s5.length());
		System.out.println(s5.charAt(0));
		System.out.println(s5.indexOf("abc")); // 없으면 -1
		System.out.println(s5.substring(0, 3)); // 0 ~ 2까지

		String s6 = "   ab   cd   ";
		String s7 = "efg,hij,klm,nop,qrs";
		String s8 = s6.concat(s7);
		System.out.println(s8.trim()); // 양쪽 공백 없애기
		System.out.println(s8.replaceAll(" ", "")); // A를 B로 대체

		String[] tokenStrings = s7.split(",");
		for (String s : tokenStrings) {
			System.out.println(s);
		}

		String[] tokens2 = s7.split(" ");
		for (String s : tokens2) {
			System.out.println(s); // 원본 결과
		}
	}

}
