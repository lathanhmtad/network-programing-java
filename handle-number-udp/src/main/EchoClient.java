package main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class EchoClient {
	private DatagramSocket socket;
	private InetAddress address;
	
	private byte[] buf;
	
	public EchoClient() {
		try {
			socket = new DatagramSocket();
			address = InetAddress.getLocalHost();
		} catch (SocketException | UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public void sendEcho(String msg) {
		try {
			buf = msg.getBytes();
			DatagramPacket packet = new DatagramPacket(buf, buf.length, address, AppConstants.PORT);
			socket.send(packet);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void printDataReceive() {
	    try {
	    	byte[] b = new byte[10000];
	    	DatagramPacket packet = new DatagramPacket(b, b.length);
			socket.receive(packet);
			String received = new String(
			          packet.getData(), 0, packet.getLength());
			 System.out.println(received);
		} catch (Exception e) {
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
