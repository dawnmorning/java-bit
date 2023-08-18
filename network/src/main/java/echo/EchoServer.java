package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
	public static final int PORT = 8000;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {

			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT), 10);
			System.out.println("[server] starts [port: " + PORT + "]");

			Socket socket = serverSocket.accept(); // blocking, 왔다갔다 하면서 socket에 데이터가 담김 blocking을 풀기 위해서 client가 필요.
													// 연결요청을 기다리는 상태, 데이터 통신하는 소켓
			System.out.println("Connect Complete.");
			try {
				InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
				String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
				int remotePort = inetRemoteSocketAddress.getPort();
				log("connected by client " + remoteHostAddress + " " + "port " + remotePort);

				// 파이프라인 연결, true : flush하지 않아도 버퍼에 들어가면 바로 전송
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
				// byte로 바꾸는 것
				// pw.print("안녕");
				while (true) {
					// readline, 개행 붙여서 보내라.
					String data = br.readLine();
					if (data == null) {
						log("closed by client");
						break;
					}
					log("received : " + data);

					// echoing, 이미 byte로 바꿔주므로
					pw.println(data);
				}
			} catch (IOException e) {
				log("error : " + e);
			} finally {
				try {
					if (socket != null && !socket.isClosed()) {
						socket.close();
					}

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			// remote : 상대편 주소
		} catch (IOException e) {
			log("error : " + e);
		} finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void log(String message) {
		System.out.println("[EchoServer] " + message);
	}
}
