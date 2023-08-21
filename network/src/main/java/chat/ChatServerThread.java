package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;

public class ChatServerThread extends Thread {
	private String nickname;
	private Socket socket;
	private List<ChatServerThread> list;

	public ChatServerThread(Socket socket, List<ChatServerThread> list) {
		this.socket = socket;
		this.list = list;
		list.add(this);
	}

	@Override
	public void run() {
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			pw.println("");
			pw.println("어서오세요.");
			pw.println("닉네임을 입력해주세요.");
			pw.println("");
			pw.println("================================");
			String msg = null;
			while ((msg = br.readLine()) != null) {
				String[] tokens = msg.split(":");
	            if (tokens[0].equals("입장")) {
	                join(tokens[1].trim());
	            } else if (tokens[0].equals("채팅")) {
	                message(tokens[1].trim());
	            } else if (tokens[0].equals("퇴장")) {
	                quit();
	                break;
	            }

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				notifyAllClients(nickname + "님이 채팅방을 나갔어요.", false);
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			list.remove(this);
		}
	}

	public void notifyAllClients(String message, boolean isMember) {
		if (isMember) {
			try {
				for (ChatServerThread client : list) {
					PrintWriter pw = new PrintWriter(new OutputStreamWriter(client.socket.getOutputStream()), true);
					pw.println(message);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	private void join(String nickname) {
		this.nickname = nickname;
		log(nickname + "님이 입장하였습니다.");
		notifyAllClients(nickname + "님이 입장 하였습니다.", true);
	}

	private void message(String message) {
		log("received : " + message);
		log(nickname + " : "+ message);
		notifyAllClients(nickname + ": " + message, true);
	}

	private void quit() {
		notifyAllClients(nickname + "님이 채팅방을 나갔어요.", false);
		log(nickname + "님이 퇴장하였음");
		list.remove(this);
	}

	private void log(String message) {
		System.out.println("[EchoServer#" + "] " + nickname + " " + message);
	}
}
