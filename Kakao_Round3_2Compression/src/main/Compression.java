package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Compression {
	
	public static void lzwCompression(String[] input) {
		/*
		char aaa = 'Z';
		System.out.println("A" + ":65 " + "Z:" + (int)aaa);
		
		output : A:65 Z:90
		*/
		
		ArrayList dic = new ArrayList();
		for(int i=0; i<26; i++) {
			dic.add((char)(i+65));
		}
		
		for(int z=0; z<input.length; z++) {
			ArrayList ret = new ArrayList();
			String curStr = input[z];
			int cnt=1;
			int cursor=1;
			while(curStr.length()>0) {
				if(dic.contains(curStr.substring(0, cursor))) {
					ret.add(dic.indexOf(curStr.substring(0, cursor)));
					curStr = curStr.substring(cursor, curStr.length());
					cursor++;
				} else {
					dic.add(curStr.substring(0, cursor));
					cursor = 1;
				}
			}
			System.out.println(ret);
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		String filename = "input1.txt";
		
		BufferedReader br = new BufferedReader(new FileReader(filename));
		try {
			
			String[] array = br.readLine().replaceAll("\\s+$", "").split(" ");
			
			lzwCompression(array);
			
		} finally {
			br.close();
		}
	}

}
