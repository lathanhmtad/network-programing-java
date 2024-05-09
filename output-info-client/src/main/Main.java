package main;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		try {
			String localHostName = InetAddress.getLocalHost().getHostName();
			String localHostAddress = InetAddress.getLocalHost().getHostAddress();
			
			String nullHostName = InetAddress.getByName(null).getHostName();
			String nullHostAddress = InetAddress.getByName(null).getHostAddress();
			
			System.out.println("Nhập một địa chỉ trên internet: ");
			String iNetHostName = scanner.nextLine();
			String iNetHostAddress = InetAddress.getByName(iNetHostName).getHostAddress();
			
			
			System.out.println("The localhost is: " + localHostName + "/" + localHostAddress);
			System.out.println("The Null host is: " + nullHostName + "/" + nullHostAddress);
			
			System.out.println("The host address is: " + iNetHostName + "/" + iNetHostAddress);
			
		} catch (UnknownHostException e) {
			System.out.println("Vui lòng kết nối mạng và phải nhập một địa chỉ tồn tại trên internet!");
		}
		
		scanner.close();
	}
}
