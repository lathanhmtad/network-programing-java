package main;

import java.util.HashMap;
import java.util.Map;

public class stringHandle {
	private String str;

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public stringHandle(String str) {
		this.str = str;
	}
	public stringHandle() {}
	
	public String reverse() {
		String string = new StringBuilder(this.str).reverse().toString();
		return string;
	}
	
	public String upcase() {
		String string = this.str.toUpperCase();
		return string;
	}
	
	public String lowercase() {
		String string = this.str.toLowerCase();
		return string;
	}
	
	public String mixedCase() {
		String string = "";
        for (int i = 0; i < this.str.length(); i++) {
            if (i % 2 == 0) {
            	string += Character.toUpperCase(this.str.charAt(i));
            } else {
            	string += Character.toLowerCase(this.str.charAt(i));
            }
        }
		return string;
	}
	
	public int wordCount() {
		String[] words = this.str.split("\\s+");
		return words.length;
	}
	
	public boolean checkPrime() {
		int n = Integer.parseInt(this.str);
		if(n < 2){
	        return false;
	    }
		int count = 0;
	    for(int i = 2; i <= Math.sqrt(n); i++){
	        if(n % i == 0){
	            count++;
	        }
	    }
	    if(count == 0){
	        return true;
	    }else{
	        return false;
	    }
	}
	
	public boolean checkPerfectSquare() {
		int x = Integer.parseInt(this.str);
		double sq = Math.sqrt(x);
        return ((sq - Math.floor(sq)) == 0);
	}
	
	public boolean checkPerfectNumber() {
		int sum = 0;
		int n = Integer.parseInt(this.str);
		for(int i=1;i<=n/2;i++){
			if(n%i==0) 
			sum+=i;
		}
		if(sum==n) return true;
		return false;
	}
	
	public boolean checkAmstrong() {
		int n = Integer.parseInt(this.str);
		int count = 0;
		int t1 = n;
	    while (t1 > 0)
	    {
	    	++count;
	        t1 /= 10;
	    }
	    int t2 = n, sum = 0, last;
	    while (t2 > 0)
	    {
	        last = t2 % 10; // lấy chữ số cuối cùng
	        t2 /= 10;       // bỏ chữ số cuối cùng
	        sum += Math.pow(last, count);
	    }
	    if (sum == n)
	        return true;
	    return false;
	}
	
	public int sum() {
		int n = Integer.parseInt(this.str);
		int sum = 0;
	    while (n > 0)
	    {
	    	
	    	sum = sum + (n%10);  
	    	n /= 10;
	    }
	    return sum;
	}
	
	public int multiplication() {
		int n = Integer.parseInt(this.str);
		int mul = 1;
	    while (n > 0)
	    {

	    	mul = mul * (n%10);  
	    	n /= 10;   
	    }
	    return mul;
	}
	
	public int USCLN(int a, int b) {
        if (b == 0) return a;
        return USCLN(b, a % b);
    }
	
	public int BSCNN(int a, int b) {
        return (a * b) / USCLN(a, b);
    }
	
	public String[] splitWord() {
		String[] words = this.str.split("\\s+");
		return words;
	}
	
	public Map<Character, Integer> countAppearTimeCharacter(){
		Map<Character, Integer> frequencyMap = new HashMap<>();
        
        // Đếm tần suất xuất hiện của các ký tự trong chuỗi
        for (char c : this.str.toCharArray()) {
            if (Character.isLetterOrDigit(c)) { // Bỏ qua các ký tự không phải chữ cái hoặc chữ số
                frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
            }
        }
        return frequencyMap;
	}
}
