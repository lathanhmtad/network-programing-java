package main;

import java.io.BufferedReader;
import java.io.IOException;
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
				
				int n = 0;
				try {
					n = Integer.parseInt(input);
				} catch (Exception e) {
					
				}
				
				switch(choice) {
				case 1:
					out.println("Là số nguyên tố: " + NumberUtils.isPrime(n));
					out.println("Là số chính phương: " + NumberUtils.isSquare(n));
					out.println("Là số hoàn hảo: " + NumberUtils.isPerfect(n));
					out.println("Là số amstrong: " + NumberUtils.isAmstrong(n));
					out.println("END");
					break;
				case 2: 
					out.println("Tổng các chữ số: " + NumberUtils.sumOfDigits(n));
					out.println("Tích các chữ số: " + NumberUtils.accumulationOfDigits(n));
					out.println("END");
					break;
				case 3: 
					int b = Integer.parseInt(in.readLine());
					out.println("Ước chung lớn nhất: " + NumberUtils.gcd(n, b));
					out.println("Bội chung nhỏ nhất: " + NumberUtils.lcm(n, b));
					out.println("END");
					break;
				case 4: 
					out.println("Chuỗi đảo của '" + input + "' là: " + StringUtils.toReverse(input));
					out.println("END");
					break;
				case 5: 
					out.println("Mỗi từ của chỗi '" + input + "' là: \n" + StringUtils.eachWordOfTheString(input));
					out.println("END");
					break;
				case 6: 
					out.println("Tần số xuất hiện của mỗi chữ cái của chuỗi '" + input + "' là: \n" + StringUtils.characterFrequency(input));
					out.println("END");
					break;
				default:
					System.out.println("Hẹn gặp lại");
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}