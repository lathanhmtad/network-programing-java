package main;


import java.io.*;
import java.net.*;

public class client {
	private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            // Tạo một DatagramSocket để gửi và nhận dữ liệu
            DatagramSocket clientSocket = new DatagramSocket();

            // Đọc dữ liệu từ bàn phím
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String message;
            while (true) {
                System.out.println("1. Kiểm tra số nguyên tố, chính phương, hoàn hảo, amstrong");
                System.out.println("2. Tổng và tích của các chữ số");
                System.out.println("3. UCLN & BCNN");
                System.out.println("4. Mỗi từ trên từng dòng và tần số xuất hiện");
                System.out.println("5. Chuỗi đảo");
 
                // Gửi dữ liệu đến server
                System.out.println("Chọn 1-5:");
                String choice = reader.readLine();
                sendmessage(choice, clientSocket);
                System.out.println("Nhập: ");
                sendmessage(reader.readLine(), clientSocket);
                if(choice.equals("3")) {
                	System.out.println("Nhập tiếp: ");
                    sendmessage(reader.readLine(), clientSocket);
                }

                // Nhận dữ liệu từ server và in ra màn hình
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);
                String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Server:\n" + receivedMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	private static void sendmessage(String message, DatagramSocket clientSocket) {
		try {
			byte[] sendData = message.getBytes();
            InetAddress serverAddress = InetAddress.getByName(SERVER_ADDRESS);
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, SERVER_PORT);
            clientSocket.send(sendPacket);
		}catch (IOException e) {
            e.printStackTrace();
        }
	}
}
