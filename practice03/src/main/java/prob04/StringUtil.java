package prob04;

public class StringUtil {
	public static String concatenate(String[] args){
		StringBuilder result = new StringBuilder();
        for (String s : args) {
            result.append(s);
        }
        return result.toString();
	}
}
