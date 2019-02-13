package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProgrammerString {
	
	private static int programmerString(String s) {
		
		//List<Integer> indices = new ArrayList<>();
		int indices = 0;
		List<String> programmer = initList();
		
		for(int i=0; i<s.length(); i++) {
			/*
			String temp = s.substring(i, i+1);
			if(programmer != null) {
				if(programmer.contains(temp)) {
					programmer.remove(temp);
				} else {
					
				}
			} else {
				indices++;
				programmer = initList();
			}
			*/
		}
		
	}
	
	private static List<String> initList(){
		List<String> list = new ArrayList<>();
		String[] programmer = {"p", "r", "o", "g", "r", "a", "m", "m", "e", "r"};
		for(int i=0; i<10; i++) {
			list.add(programmer[i]);
		}
		
		return list;
	}
	
	public static void main(String[] args) throws IOException {
		String filename = "input1.txt";
		
		BufferedReader br = new BufferedReader(new FileReader(filename));
		try {
			String input = br.readLine();
			
			int ret = programmerString(input);
			
			System.out.println(ret);
			
		} finally {
			br.close();
		}
	}

}
