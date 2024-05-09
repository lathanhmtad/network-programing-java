package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		final String SERVER_ADDRESS = AppConstants.SERVER_ADDRESS;
		final int PORT_NUMBER = AppConstants.PORT_NUMBER;
		
		try
		(
			Socket socket = new Socket(SERVER_ADDRESS, PORT_NUMBER);
		)
		{
			System.out.println("Kết nối đến server thành công.");
			
			BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
			
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			while(true) {
				menu();
				System.out.println("Nhập lựa chọn của bạn: ");
				int choice = Integer.parseInt(consoleInput.readLine());
				
				if(choice == 0) {
					break;
				}
				
				System.out.println("Nhập chuỗi: ");
				String str = consoleInput.readLine();
				
				
				out.println(choice);
				out.println(str);
				
				System.out.println("Server response: " + in.readLine());
				
				clearScreen();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void menu() {
		System.out.println("==============Menu sử lý string==============");
		System.out.println("1. Chuỗi đảo của chuỗi đã cho");
		System.out.println("2. Chuỗi in hoa của chuỗi đã cho");
		System.out.println("3. Chuỗi thường của chuỗi đã cho");
		System.out.println("4. Chuỗi vừa hoa vừa thường của chuỗi đã cho");
		System.out.println("5. Đếm số từ có trong chuỗi");
		System.out.println("0. Kết thúc");
	}
	
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}  
}