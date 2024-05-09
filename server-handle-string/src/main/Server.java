package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		final int PORT_NUMBER = AppConstants.PORT_NUMBER;
		
		try
		(
				ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);
			)
		{
			System.out.println("Server is running and waiting for connections...");
			Socket clientSocket = serverSocket.accept();
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			while(true) {
				int choice = Integer.parseInt(in.readLine());
				String input = in.readLine();
				
				switch(choice) {
				case 1:
					out.println("Chuỗi đảo của chuỗi '" + input + "' là: " + StringUtils.toReverse(input));
					break;
				case 2: 
					out.println("Chuỗi in hoa của chuỗi '" + input + "' là: " + StringUtils.toUpperCase(input));
					break;
				case 3: 
					out.println("Chuỗi thường của chuỗi '" + input + "' là: " + StringUtils.toLowerCase(input));
					break;
				case 4: 
					out.println("Chuỗi vừa hoa vừa thường của chuỗi '" + input + "' là: " + StringUtils.toLowerCaseAndUpperCase(input));
					break;
				case 5: 
					out.println("Số từ có trong chuỗi '" + input + "' là: " + StringUtils.countWords(input));
					break;
				default:
					System.out.println("Hẹn gặp lại");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}