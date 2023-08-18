package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoRequestHandler extends Thread {
	private Socket socket;
	ServerSocket serverSocket = null;

	public EchoRequestHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
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
			} catch(SocketException e) {
				log("suddenly closed by client");
			} catch (IOException e) {
				log("error:" + e);
			} finally {
				try {
					if(socket != null && !socket.isClosed()) {
						socket.close();
					}
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}

		private void log(String message) {
			System.out.println("[EchoServer#" + getId() +"] " + message);
		}	
	}