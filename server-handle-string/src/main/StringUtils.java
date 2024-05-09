package main;

public class StringUtils {
	public static String toReverse(String s) {
		StringBuilder stringBuilder = new StringBuilder();
		return stringBuilder.append(s).reverse().toString();
	}
	
	public static String toUpperCase(String s) {
		return s.toUpperCase();
	}
	
	public static String toLowerCase(String s) {
		return s.toLowerCase();
	}
	
	public static String toLowerCaseAndUpperCase(String s) {
//		String[] words = s.split("\\s+");
//		StringBuilder stringBuilder = new StringBuilder();
//		
//		for(int i = 0; i < words.length; i++) {
//			char ch = Character.toUpperCase(words[i].charAt(0));
//			stringBuilder.append(ch + words[i].substring(1) + ' ');
//		}
//		
//		return stringBuilder.toString();
		
		String newS = "";
		for (int i = 0; i < s.length(); i++) {
			if(i % 2 == 0) {
				newS += Character.toUpperCase(s.charAt(i));
			}
			else {
				newS += Character.toLowerCase(s.charAt(i));
			}
		}
		return newS;
	}
	
	public static int countWords(String s) {
		String[] words = s.split("\\s+");
		return words.length;
	}
}
