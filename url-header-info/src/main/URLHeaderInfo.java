package main;

import java.net.*;
import java.io.*;

public class URLHeaderInfo {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Nhập địa chỉ URL: ");
        try {
            String urlString = reader.readLine();

            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();

            System.out.println("Thông tin header của URL " + urlString + ":");
            for (int i = 1; ; i++) {
                String headerField = connection.getHeaderField(i);
                String headerKey = connection.getHeaderFieldKey(i);
                if (headerField == null && headerKey == null) break;
                if (headerKey != null)
                    System.out.println("Header " + i + ": " + headerKey + ": " + headerField);
                else
                    System.out.println("Header " + i + ": " + headerField);
            }
        } catch (MalformedURLException e) {
            System.out.println("URL không hợp lệ: " + e);
        } catch (IOException e) {
            System.out.println("Lỗi khi kết nối hoặc đọc thông tin header: " + e);
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
                System.out.println("Lỗi khi đóng luồng đầu vào: " + e);
            }
        }
    }
}
