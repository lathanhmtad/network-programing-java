package main;

import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args){
    	try(
    		Scanner sc = new Scanner(System.in);
    	) {
    		EchoClient echoClient = new EchoClient();
    		
    		while(true) {
    			EchoClient.menu();
    			System.out.println("Nhập lựu chọn của bạn: ");
    			String choice = sc.nextLine();
    			
    			if(choice.equals("0")) {
    				break;
    			}
    			
    			echoClient.sendEcho(choice);
    			
    			System.out.println("Nhập đầu vào: ");
    			String input = sc.nextLine();
    			
    			echoClient.sendEcho(input);
    			
    			if(choice.equals("3")) {
    				System.out.println("Nhập số kế tiếp: ");
    				String b = sc.nextLine();
    				echoClient.sendEcho(b);
    			}
    			
    			echoClient.printDataReceive();
    		}
    		
    	}
    }
}
