package main;

import java.util.HashMap;
import java.util.Map;

public class StringUtils {
	public static String toReverse(String s) {
		String newStr = "";
		for(int i = s.length() - 1; i >= 0; i--) {
			newStr += s.charAt(i);
		}
		return newStr;
	}
	
	public static String eachWordOfTheString(String s) {
		String[] words = s.split("\\s+");
		String res = "";
		for(int i = 0; i < words.length; i++) {
			res += words[i] + "\n";
		}
		return res;
	}
	
	 public static String characterFrequency(String input) {
		 StringBuilder res = new StringBuilder();
		 Map<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
		 for(char ch : input.toCharArray()) {
			 if(Character.isLetterOrDigit(ch)) {
				 frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
			 }
		 }
		
		 frequencyMap.forEach((key, value) -> res.append(key).append(" = ").append(value).append("\n"));
		 
		 return res.toString();
	 }
	
	
	public static void main(String[] args) {
		System.out.println(characterFrequency("Hello world		,Are you ok?"));
	}
}
