package main;

public class NumberUtils {
	public static boolean isPrime(double n) {
		if(isInt(n)) {
			for(int i = 2; i < n; i++) {
				if(n % i == 0) 
					return false;
			}
			return true;
		}
		return false;
	}
	
	public static boolean isSquare(double n) {
		int sr = (int) Math.sqrt(n);
		return (sr * sr) == n;
	}
	
	public static boolean isPerfect(double n) {
		int sum = 0;
		for(int i = 1; i < n; i++) {
			if(n % i == 0) {
				sum += i;
			}
		}
		return sum == n;
	}
	
	public static boolean isAmstrong(int n) {
		int count = countDigits(n);
		
		int sum = 0;
		int temp = n;
		
		while(temp != 0) {
			int r = temp % 10;
			sum += Math.pow(r, count);
			temp /= 10;
		}
		
		return sum == n;
	}
	
	public static int sumOfDigits(int n) {
		int sum = 0;
		while(n != 0) {
			sum += (n % 10);
			n /= 10;
		}
		return sum;
	}
	
	public static int accumulationOfDigits(int n) {
		int sum = 1;
		while(n != 0) {
			sum *= (n % 10);
			n /= 10;
		}
		return sum;
	}
	
	public static int gcd(int a, int b) {
        int min = Math.min(a, b);
        while (min > 0) {
            if (a % min == 0 && b % min == 0) {
                break;
            }
            min--;
        }
 
        return min;
	}
	
	public static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}
	
	private static boolean isInt(double x) {
		return x == (int) x;
	}
	
	private static int countDigits(int a) {
		int res = 0;
		
		while(a != 0) {
			res++;
			a /= 10;
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(lcm(15, 20));
	}
	
}
