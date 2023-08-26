package chat.gui;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientApp {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int PORT = 9999;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Socket socket = null;
		String nickname = null;
		try {
			while (true) {
				System.out.println("대화명을 입력하세요.");
				System.out.print(">>> ");
				nickname = scanner.nextLine();

				if (nickname.isEmpty() == false) {
					break;
				}
				System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
			}

			scanner.close();

			socket = new Socket();

			socket.connect(new InetSocketAddress(SERVER_IP, PORT));
			new ChatWindow(nickname, socket).show();

		} catch (ConnectException e) {
			System.out.println("[Connection Error] : " + e);
		} catch (IOException e) {
			System.out.println("[IO Error] : " + e);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}

	}

}
