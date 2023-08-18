package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class EchoClient {

	private static final String SERVER_IP = "127.0.0.1";

	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = null;
		try {
			// 1.소켓 생성
			socket = new Socket();

			// 2.서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP, EchoServer.PORT));
			log("connected");

			// 3. IO Stream 받아오기 (파이프라인)
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

			// 키보드에 연결 해야하니까
			scanner = new Scanner(System.in);
			// 4. 쓰기
			while (true) {
				System.out.println("보낼 메시지를 입력해보세요! >>");
				String line = scanner.nextLine();
				if ("exit".equals(line)) {
					break;
				}

				pw.println(line);
				String data = br.readLine();

				// 5. 읽기
				if (data == null) {
					// 서버가 정상적으로 closed()호출
					log("closed by server");
					break;
				}
				// decoding 필요 없음
				System.out.println("<< 메시지가 왔어요: " + data);
			}

		} catch (SocketException e) {
			log("suddenly closed by server");
		}

		catch (IOException e) {
			System.out.println("[client] error :" + e);
		} finally {
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}if (scanner != null) {
					socket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void log(String message) {
		System.out.println("[EchoClient] " + message);
	}
}
