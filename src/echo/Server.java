package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {

		ServerSocket ServerSocket = new ServerSocket();

		// ServerSocket.bind(ip,port);
		// ServerSocket.bind(new InetSocketAddress(ip, port));
		// ip 검색 --> 명령 프롬프트 ipconfig --> IPv4 주소 체크 / mas :
		// ip는 .이 있어서 문자열이라서 " " 안에 작성
		ServerSocket.bind(new InetSocketAddress("127.0.0.1", 5000)); // port번호는 개인이 설정

		// accept() : 허락할꺼야
		System.out.println("<서버시작>");
		System.out.println("==============================");
		System.out.println("[연결을 기다리고 있습니다.]");

		Socket socket = ServerSocket.accept();
		System.out.println("[클라이언트가 연결되었습니다.]");

		// 메세지 받는용 스트림
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);

		// 메세지 보내기용 스트림
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);

		// 메세지 받기
		String msg = br.readLine();
		System.out.println("받은 메세지 : " + msg);

		while (true) {
			// 메세지 받기
			String str = br.readLine();

			if (msg == null) {
				break;
			}

			System.out.println("받은 메세지 : " + msg);

			// 메세지 보내기
			bw.write("message");
			bw.newLine();
			bw.flush();

		}

		// 메세지 보내기
		bw.write("message");
		bw.newLine();
		bw.flush(); // 쟁반이 다 꽉차지 않아도 보내라는 뜻

		System.out.println("==============================");
		System.out.println("<서버종료>");

		br.close();
		bw.close();
		socket.close();
		ServerSocket.close();

	}

}
