package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		InetAddress[] host = null;
		String[] returnStr = null;
		while (true) {
			System.out.println("찾아볼 주소를 입력해보세요.>> ");
			String line = scanner.nextLine();
			if ("exit".equals(line)) {
				break;
			}
			try {
				host = InetAddress.getAllByName(line);

				// System.out.println(host);
				for (int i = 0; i < host.length; i++) {
					System.out.println(line + " : " + host[i].getHostAddress());
				}
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
