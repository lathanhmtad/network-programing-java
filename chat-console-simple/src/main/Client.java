package main;
import java.net.*;
import java.io.*;

public class Client {

	public static void main(String[] args) {
		
		try (
				Socket socket = new Socket(AppConstants.SERVER_ADDRESS,AppConstants.PORT_NUMBER);
		) {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
			
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			String answer,response;
			while(true) {
				System.out.print("Client: ");
				answer = consoleInput.readLine();
				out.println(answer);
				
				response = in.readLine();
				System.out.println("server: "+ response);

			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}