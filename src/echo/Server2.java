package echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
	public static void main(String[] args) throws IOException {

		try {
			ServerSocket ServerSocket = new ServerSocket();

			ServerSocket.bind(new InetSocketAddress("127.0.0.1", 10001));

			// accept() : 허락할꺼야
			System.out.println("<서버시작>");
			System.out.println("==============================");
			System.out.println("[연결을 기다리고 있습니다.]");
			// 반복 시작////////////
			while (true) {
				// 쓰레드 사용
				Socket socket = ServerSocket.accept();

				// 쓰레드 - 출장보내기(출장나가서 스트림봅강하고 대화해라)
				Thread thread = new ServerThread(socket);
				thread.start();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		// 쓰레드

		// 반복 종료 ///////////////////////////////////
		/*
		 * System.out.println("==============================");
		 * System.out.println("<서버종료>");
		 * 
		 * br.close(); bw.close(); socket.close(); ServerSocket.close();
		 */

	}

}
