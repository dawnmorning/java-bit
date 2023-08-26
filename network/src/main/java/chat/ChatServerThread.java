package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

public class ChatServerThread extends Thread {
	private String nickname;
	private Socket socket;
	private List<ChatServerThread> userList;

	public ChatServerThread(Socket socket, List<ChatServerThread> list) {
		this.socket = socket;
		this.userList = list;
	}

	@Override
	public void run() {
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			String msg = null;
			while ((msg = br.readLine()) != null) {
				System.out.println(msg);
				String[] tokens = msg.split(":");
				if (tokens[0].equals("join")) {
					join(tokens[1].trim(), pw);
					System.out.println("현재 인원: " + userList.size());
				} else if (tokens[0].equals("chat")) {
					message(tokens[1].trim());
				} else if (tokens[0].equals("quit")) {
					quit();
					break;
				}
			}

		} catch (ConnectException e) {
			System.out.println("[ServerError] : " + e);
		} catch (SocketException e) {
			System.out.println("[ServerError] : " + e);
		} catch (IOException e) {
			System.out.println("[ServerError] : " + e);
		} finally {
			try {
				socket.close();
			}catch (ConnectException e) {
				System.out.println("[ServerError] : " + e);
			} catch (SocketException e) {
				System.out.println("[ServerError] : " + e);
			} 
			catch (IOException e) {
				System.out.println("[ServerError] : " + e);
			}
			userList.remove(this);
		}
	}

	public void notifyAllClients(String message) {
		try {
			for (ChatServerThread client : userList) {
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(client.socket.getOutputStream()), true);
				pw.println(message);
			}
		} catch (IOException e) {
			System.out.println("[ServerError] : " + e);

		}

	}

	private void join(String nickname, PrintWriter user) {
		this.nickname = nickname;
		userList.add(this);
		log(nickname + "님이 입장하였습니다");
		user.println("입장: 확인");
		notifyAllClients(nickname + "님이 입장 하였습니다.");
		notifyAllClients("현재 인원은 " + userList.size() + "명 입니다.");
	}

	private void message(String message) {
		log(nickname + " : " + message);
		System.out.println(nickname + " : " + message);
		notifyAllClients(nickname + ": " + message);
	}

	private void quit() {
		userList.remove(this);
		notifyAllClients(nickname + "님이 채팅방을 나갔어요.");
		log(nickname + "님이 퇴장하였음");
	}

	private void log(String message) {
		System.out.println("[EchoServer#" + nickname + "]" + " " + message);
	}
}
