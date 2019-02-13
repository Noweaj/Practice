package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LargeResponses {
	
	private static void lastResponses(List<String> input) {
		int cnt = 0;
		int maxBytes = 0;
		
		System.out.println(cnt);
		System.out.println(maxBytes);
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		
		File filename = new File("hosts_access_log_00.txt");
		
		Scanner sc = new Scanner(filename);
		
		List<String> input = new ArrayList<String>();
		
		while(sc.hasNextLine()) {
			input.add(sc.nextLine());
		}
		
		lastResponses(input);
		
		sc.close();
	}

}
