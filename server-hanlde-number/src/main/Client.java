package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		final String SERVER_ADDRESS = AppConstants.SERVER_ADDRESS;
		final int PORT_NUMBER = AppConstants.PORT_NUMBER;
		
		try
		(
			Socket socket = new Socket(SERVER_ADDRESS, PORT_NUMBER);
			Scanner sc = new Scanner(System.in)
		)
		{
			System.out.println("Kết nối đến server thành công.");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			
			while(true) {
				menu();
				System.out.println("Nhập lựu chọn của bạn: ");
				int choice = Integer.parseInt(sc.nextLine());
				
				if(choice == 0) {
					break;
				}
				else if(choice == 3) {
					System.out.println("Nhập lần lượt a và b: ");
					int a = sc.nextInt();
					int b = sc.nextInt();
					sc.nextLine();
					
					out.println(choice);
					out.println(a);
					out.println(b);
				} 
				else {
					System.out.println("Nhập đầu vào: ");
					String str = sc.nextLine();
					out.println(choice);
					out.println(str);
				}
			
				String line = "";
				while(!(line = in.readLine()).equals("END")) {
					System.out.println(line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void menu() {
		System.out.println("==============Menu sử lý số==============");
		System.out.println("1. Kiểm tra số nguyên tố, chính phương, hoàn hảo, amstrong");
		System.out.println("2. Tổng và tích của các chữ số");
		System.out.println("3. UCLN & BCNN");
		System.out.println("4. Chuỗi đảo");
		System.out.println("5. In từ của chuỗi");
		System.out.println("6. Tần số xuất hiện các ký tự");
		System.out.println("0. Kết thúc");
	}
	
}