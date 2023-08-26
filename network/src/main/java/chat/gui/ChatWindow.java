package chat.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.SocketException;

import javax.swing.JOptionPane;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	private Button buttonExit;

	private Socket socket;
	private String nickname;
	private PrintWriter pw;
	private BufferedReader br;

	public ChatWindow(String nickname, Socket socket) {
		frame = new Frame("PoscoDx's Java Chat Room");
		pannel = new Panel();
		buttonSend = new Button("send");
		buttonExit = new Button("exit");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.nickname = nickname;
		this.socket = socket;
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				sendMessage();
			}
		});
		buttonExit.setBackground(Color.RED); 
		buttonExit.setForeground(Color.WHITE);
		buttonExit.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				finish(); // "나가기" 버튼을 클릭하면 finish() 메서드 실행
			}
		});

		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if (keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});
		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		pannel.add(buttonExit);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// 닫았을 때 catch
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack();

		// IOStream 받아오기
		try {
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// ChatClientThread 생성하고 실행하는 코드
		new ChatClientThread().start();
	}

	private void finish() {
		try {
			if (socket != null && socket.isClosed()) {
				socket.close();
			}
			// 닫았을 때 quit 서버에 전달
			pw.println("quit");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void quit() {
		String message = textField.getText();
		if ("quit".equals(message)) {
			pw.println("quit");
		}
	}

	private void sendMessage() {
		String message = textField.getText();
		if (message.trim().isEmpty()) {
	        // 입력된 값이 없을 때 경고창 띄우기
	        JOptionPane.showMessageDialog(frame, "채팅을 입력해주세요!", "Warning", JOptionPane.WARNING_MESSAGE);
	        return;
	    }
		System.out.println(message);
		if ("quit".equals(message)) {
			quit();
		}
		pw.println("chat:" + message);
		textField.setText("");
		textField.requestFocus();
	}

	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}

	private class ChatClientThread extends Thread {
		@Override
		public void run() {
			pw.println("join: " + nickname);
			String msg = null;
			try {
				while ((msg = br.readLine()) != null) {
					if (!"입장: 확인".equals(msg)) {
						updateTextArea(msg);
					}
				}
			} catch (SocketException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				finish();
			}
		}
	}
}
