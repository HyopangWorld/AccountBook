package acSever;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class AcServer {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(5000);
		System.out.println("���� �����");
		
		Socket so = ss.accept();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(so.getInputStream()));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(so.getOutputStream()));
		
		while(true){
			System.out.println(">>>Ŭ���̾�Ʈ�� ��ٸ��� ��<<<");
			String get_msg = br.readLine();
			System.out.println("���� �ּ� : "+so.getInetAddress());
			System.out.println("���� ���� : "+get_msg);
		}
	}

}
