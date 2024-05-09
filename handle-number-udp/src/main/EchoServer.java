package main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class EchoServer {
	private DatagramSocket datagramSocket;
	
	private InetAddress clientAddress;
	private int clientPort;
	
	private DatagramPacket datagramPacket;
	
	public EchoServer() {
		try {
//			byte[] b = new byte[1024];
//			datagramPacket = new DatagramPacket(b, b.length);
			this.datagramSocket = new DatagramSocket(AppConstants.PORT);
			this.clientAddress = InetAddress.getLocalHost();
			this.clientPort = AppConstants.PORT;
		} catch (SocketException | UnknownHostException e) {
			e.printStackTrace();
		} 
	}
	
	public String receiveData() {
		try {
			byte[] b = new byte[1024];
			datagramPacket = new DatagramPacket(b, b.length);
			datagramSocket.receive(datagramPacket);
			
			return new String(datagramPacket.getData(), 0, datagramPacket.getLength());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void sendData(String msg) {
		try {
			byte[] b = msg.getBytes();
			datagramPacket = new DatagramPacket(b, b.length, datagramPacket.getAddress(), datagramPacket.getPort());
			datagramSocket.send(datagramPacket);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
