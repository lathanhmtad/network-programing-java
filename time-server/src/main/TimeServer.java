package main;

import java.io.*;
import java.net.*;

public class TimeServer {
    public static void main(String[] args) {
    	ServerSocket serverSocket;
    	try {
    		serverSocket = new ServerSocket(9090);
            System.out.println("Server is running...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);
                OutputStreamWriter out = new OutputStreamWriter(clientSocket.getOutputStream());
                PrintWriter writer = new PrintWriter(out);
                writer.println(getCurrentDateTime());
                writer.flush();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        	
		}
    }

    private static String getCurrentDateTime() {
        java.util.Date date = new java.util.Date();
        return date.toString();
    }
}

