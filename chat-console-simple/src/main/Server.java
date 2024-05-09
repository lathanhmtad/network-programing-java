package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try
		(
				ServerSocket server = new ServerSocket(AppConstants.PORT_NUMBER);
		)
		{
			System.out.println("Server started: " + server);
			System.out.println("Waiting for a client...");
			
			Socket socket = server.accept();
			System.out.println("Client accept: " + socket);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
			
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			
			while(true) {
				String text = in.readLine();
				System.out.println("Client: "+text);
				
				System.out.print("Server: ");
				String answer = consoleInput.readLine();
				out.println(answer);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}