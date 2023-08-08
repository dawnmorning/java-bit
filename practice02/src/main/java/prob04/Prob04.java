package prob04;
public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse( "Hello World" );
		printCharArray( c1 );
		
		char[] c2 = reverse( "Java Programming!" );
		printCharArray( c2 );
	}
	
	public static char[] reverse(String str) {
		char[] reversed = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			reversed[i] = str.charAt(str.length() - 1 -i);
		}
		return reversed;
	}

	public static void printCharArray(char[] array){
		System.out.print("{");
		for (int i = 0; i < array.length; i++) {
			System.out.print("'" + array[i] + "'");
			if (i < array.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("}");
	}
}