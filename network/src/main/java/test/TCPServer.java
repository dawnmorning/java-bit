package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			// 1. Server Socket 생성
			serverSocket = new ServerSocket();
			// 1-1. FIN-WAIT -> TIME_WAIT 상태에서도 소켓 포트 할당이 가능하도록 하기 위함
			serverSocket.setReuseAddress(true);
			// 2. binding
			// Socket에 InetSocketAddress(IPAddress + port)를 바인딩
			// IPAddress: 0.0.0.0 : 특정 호스트 IP에 바인딩 하지 않는다.
			// InetSocketAddress("IP", port, option)
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 5000), 10);

			// 3.accept
			Socket socket = serverSocket.accept(); // blocking, 왔다갔다 하면서 socket에 데이터가 담김 blocking을 풀기 위해서 client가 필요.
													// 연결요청을 기다리는 상태, 데이터 통신하는 소켓
			// telnet 127.0.0.1 5000
			System.out.println("Connect Complete.");
			try {
				InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
				String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
				int remotePort = inetRemoteSocketAddress.getPort();
				System.out.println("[server] connected by client " + remoteHostAddress + " " + "port " + remotePort);

				// 4. IO Stream 받아오기
				OutputStream os = socket.getOutputStream();
				InputStream is = socket.getInputStream();

				while (true) {
					// 5. 데이터 읽기
					byte[] buffer = new byte[256];
					int readByteCount = is.read(buffer); // 256개 채워서 보내는 것. blocking. client가 아직 보내지 않았으니까 관문 역할
					// -1이면 서버 꺼짐
					if (readByteCount == -1) {
						// 클라이언트가 정상적으로 종료(Close() 호출)
						System.out.println("[server] closed by client");
						break;
					}
					// buffer를 0부터 readBytecount까지 encoding
					String data = new String(buffer, 0, readByteCount, "utf-8");
					System.out.println("[server] received : " + data);
					
					// SO_TIMEOUT 옵션 테스트용
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					// 6. 데이터 쓰기
					os.write(data.getBytes("utf-8"));
				}
			} catch (IOException e) {
				System.out.println("[socket] error : " + e);
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
			System.out.println("[server] error : " + e);
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

}
