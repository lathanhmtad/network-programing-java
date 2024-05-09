package main;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhập địa chỉ website: ");
        String urlAddress = sc.nextLine();

        try {
            URL url = new URL(urlAddress);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            reader.close();

            System.out.println("Nội dung của trang web:");
            System.out.println(content.toString());

            
            connection.disconnect();
        } catch (MalformedURLException e) {
            System.out.println("URL không hợp lệ: " + e);
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc nội dung từ URL: " + e);
        } finally {
			sc.close();
		}
	}
}
