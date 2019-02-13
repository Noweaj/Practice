package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ASCIIEncodedStrings {
	
	private static void conversion(String input) {
		String tempInput = input;
		String num = "";
		
		for(int i=1; i<input.length(); i++) {
			num += tempInput.substring(tempInput.length()-1, tempInput.length());
			tempInput = tempInput.substring(0, tempInput.length()-1);
			
			if(Integer.parseInt(num)<32) {
				
			} else {
				System.out.print((char) Integer.parseInt(num));
				num = "";
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		String filename = "input.txt";
		
		BufferedReader br = new BufferedReader(new FileReader(filename));
		try {
			String input = br.readLine();
			
			conversion(input);
			
		} finally {
			br.close();
		}
	}

}
