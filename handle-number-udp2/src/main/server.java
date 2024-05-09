package main;

import java.io.*;
import java.net.*;
import java.util.Map;

public class server {
	private static final int PORT = 12345;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            // Tạo một DatagramSocket để nhận dữ liệu từ client
            DatagramSocket serverSocket = new DatagramSocket(PORT);

            System.out.println("Server is running...");
            
            while (true) {
                // Tạo một DatagramPacket để nhận dữ liệu từ client
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                // Lấy thông tin từ DatagramPacket nhận được
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                // nhan lua chon
                int choice = Integer.parseInt(new String(receivePacket.getData(), 0, receivePacket.getLength()));
                if (choice == 0) {
                	break;
                }
                // nhan du lieu
                serverSocket.receive(receivePacket);
                String message =  new String(receivePacket.getData(), 0, receivePacket.getLength());
                switch(choice) {
	                case 1:{
	            		stringHandle answer = new stringHandle(message);
	            		String a = "";
	            		if (answer.checkPrime())
	            			a = a + "la so nguyen to\n";          			
	            		else
	            			a = a + "khong phai so nguyen to\n";
	            		
	            		if (answer.checkPerfectSquare())
	            			a = a + "la so chinh phuong\n";
	            		else
	            			a = a + "khong phai so chinh phuong\n";
	            		
	            		if (answer.checkPerfectNumber())
	            			a = a + "la so hoan hao\n";
	            		else
	            			a = a + "khong phai so hoan hao\n";
	            		
	            		if (answer.checkAmstrong())
	            			a = a + "la so amstrong\n";
	            		else
	            			a = a + "khong phai so amstrong\n";
	            		
	            		sendmessage(a, serverSocket, clientAddress, clientPort); 
	            		break;
	            	}
	                case 2:{
                		stringHandle answer = new stringHandle(message);
                		String a = "";
                		a = a + "Tong la: "+answer.sum()+"\n";
                		a = a + "Tich la "+answer.multiplication()+"\n";
                		sendmessage(a, serverSocket, clientAddress, clientPort); 
                		break;
                	}
                	case 3:{
                		stringHandle answer = new stringHandle(message);
                		serverSocket.receive(receivePacket);
                        String message2 =  new String(receivePacket.getData(), 0, receivePacket.getLength());
                        String a = "";
                        a = a + "USCLN la "+answer.USCLN(Integer.parseInt(message), Integer.parseInt(message2))+"\n";
                        a = a + "BSCNN la "+answer.BSCNN(Integer.parseInt(message), Integer.parseInt(message2))+"\n";
                		sendmessage(a, serverSocket, clientAddress, clientPort);
                		break;
                	}
                	case 4:{
                		stringHandle answer = new stringHandle(message);
                		String[] listWord = answer.splitWord();
                		String a = "";
                		for (int i=0; i<listWord.length;i++) {
                			a = a + listWord[i]+"\n";
                		}
                		Map<Character, Integer> frequencyMap = answer.countAppearTimeCharacter();
                		for (Map.Entry<Character, Integer> item : frequencyMap.entrySet()) {
                			a = a + "Ky tu '" + item.getKey() + "' xuat hien " + item.getValue()+"\n";
                        }
                		sendmessage(a, serverSocket, clientAddress, clientPort);
                		break;
                	}
                	case 5:{
                		stringHandle answer = new stringHandle(message);
                		String a = answer.reverse();
                		sendmessage(a, serverSocket, clientAddress, clientPort);
                	}
                	default:
                		sendmessage("Invalid choice.", serverSocket, clientAddress, clientPort);
                        break;
                }
                
               
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	private static void sendmessage(String message, DatagramSocket serverSocket, InetAddress clientAddress, int clientPort) {
		try {
			byte[] sendData = message.getBytes();               
	        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
	        serverSocket.send(sendPacket);
		}catch (IOException e) {
            e.printStackTrace();
        }
	}
}
