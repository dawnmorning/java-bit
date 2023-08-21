package tcppractice;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerPractice {
    private static ServerSocket serverSocket = null;
    public static void main(String[] args) {
        startServer();

        Scanner scanner = new Scanner(System.in);
        while (true){
            String line = scanner.next();
            if (line.equals("exit")){
                break;
            }
        }
        scanner.close();
        stopServer();
    }
    public static void startServer() {
        // 작업 스레드 정의
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    serverSocket = new ServerSocket(50001);
                    System.out.println("[Server] Start");

                    while (true){
                        System.out.println("[Server] 연결 요청 기다리는 중");
                        // 연결 수락
                        Socket socket = serverSocket.accept();

                        // 연결된 클라이언트 정보 얻기
                        InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
                        System.out.println("[Server]" + isa.getHostName() + "의 연결 요청을 수락함");

                        socket.close();
                        System.out.println("[Server]" + isa.getHostName() + " 연결 종료");
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        thread.start();
    }
    public static void stopServer() {
        try {
            try {
                serverSocket.close();
                System.out.println("[Server] 종료");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

}
