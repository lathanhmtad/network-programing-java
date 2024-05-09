package main;


public class UDPServer {
	public static void main(String[] args) {
			EchoServer echoServer = new EchoServer();
			 System.out.println("Server is running...");
			
			 while(true) {
				 StringBuilder result = new StringBuilder();
				 
				 String choice = echoServer.receiveData();
				 
				 String data = echoServer.receiveData();
				 
				
				 
				int n = 0;
				try {
					n = Integer.parseInt(data);
				} catch (Exception e) {
					
				}
				 
				 switch(choice) {
					case "1":
						result.append("Là số nguyên tố: " + NumberUtils.isPrime(n) + "\n");
						result.append("Là số chính phương: " + NumberUtils.isSquare(n) + "\n");
						result.append("Là số hoàn hảo: " + NumberUtils.isPerfect(n) + "\n");
						result.append("Là số amstrong: " + NumberUtils.isAmstrong((int)n));
						break;
					case "2": 
						result.append("Tổng các chữ số: " + NumberUtils.sumOfDigits(n) + "\n");
						result.append("Tích các chữ số: " + NumberUtils.accumulationOfDigits(n));
						break;
					case "3": 
						int b = Integer.parseInt(echoServer.receiveData());
						result.append("Ước chung lớn nhất: " + NumberUtils.gcd(n, b) + "\n");
						result.append("Bội chung nhỏ nhất: " + NumberUtils.lcm(n, b));
						break;
					case "4": 
						result.append("Chuỗi đảo của '" + data + "' là: " + StringUtils.toReverse(data));
						break;
					case "5": 
						result.append("Mỗi từ của chỗi '" + data + "' là: \n" + StringUtils.eachWordOfTheString(data));
						break;
					case "6": 
						result.append("Tần số xuất hiện của mỗi chữ cái của chuỗi '" + data + "' là: \n" + StringUtils.characterFrequency(data));
						break;
					default:
						result.append("Hẹn gặp lại");
					}
				 	System.out.println(result.toString());
				 	echoServer.sendData(result.toString());
			 
			 
			 }
	}
}