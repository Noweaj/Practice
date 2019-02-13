package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	
	/**
	 * My Way
	 * @param s
	 * @return
	 */
	static int sherlockAndAnagrams(String s) {
		Map<Integer, List<String>> category = new HashMap<Integer, List<String>>();
		
		for(int i=0; i<s.length(); i++) {
			for(int j=i+1; j<s.length()+1; j++) {
				int charCnt = j-i;
				if(category.get(charCnt) == null) {
					List<String> l = new ArrayList<String>();
					l.add(s.substring(i, j));
					category.put(charCnt, l);
				} else {
					category.get(charCnt).add(s.substring(i, j));
				}
			}
		}
		
		int cnt = 0;
		for(Map.Entry<Integer, List<String>> e:category.entrySet()) {
			cnt += getNumOfAnagramPairs(e.getValue());
		}
		
		return cnt;
	}
	
	static int getNumOfAnagramPairs(List<String> l) {
		int cnt = 0;
		
		for(int i=0; i<l.size(); i++) {
			for(int j=i+1; j<l.size(); j++) {
				if(isAnagramPair(l.get(i), l.get(j))) {
					cnt++;
				}
			}
		}
		
		return cnt;
	}
	
	static boolean isAnagramPair(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		s1 = new String(c1);
		s2 = new String(c2);
		return s1.equals(s2);
	}
	
	/**
	 * WRONG answer from the internet
	 * URL : http://mashijie.blogspot.com/2016/06/sherlock-and-anagrams.html
	 * @param args
	 * @throws IOException
	 */
	/*
	static int sherlockAndAnagrams(String s) {
		
		Map<Integer, List<String>> stats = new HashMap<Integer, List<String>>();
		
		for(int i=0; i<s.length(); i++) {
			for(int j=i+1; j<s.length(); j++) {
				int statsCnt = j-i;
				if(stats.get(statsCnt) == null) {
					List<String> l = new ArrayList<String>();
					l.add(s.substring(i, j));
					stats.put(statsCnt, l);
				} else {
					stats.get(statsCnt).add(s.substring(i,j));
				}
			}
		}
		
		int ttl = 0;
		for(Map.Entry<Integer, List<String>> e:stats.entrySet()) {
			ttl += getNumOfAnagramPairs(e.getValue());
		}
		
		return ttl;
	}
	
	private static int getNumOfAnagramPairs(List<String> l) {
		int ttl = 0;
		for(int i=0; i<l.size(); i++) {
			for(int j=i+1; j<l.size(); j++) {
				if(isAnagramPair(l.get(i), l.get(j))) {
					ttl++;
				}
			}
		}
		return ttl;
	}
	
	private static boolean isAnagramPair(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		Arrays.sort(c1);
		char[] c2 = s2.toCharArray();
		Arrays.sort(c2);
		s1 = new String(c1);
		s2 = new String(c2);
		return s1.equals(s2);
	}
	*/
	
	public static void main(String[] args) throws IOException{
		
		String filename = "input.txt";
		
		BufferedReader br = new BufferedReader(new FileReader(filename));
		try {
			
			int n = Integer.parseInt(br.readLine());
			
			for(int i=0; i<n; i++) {
				String str = br.readLine();
				
				int result = sherlockAndAnagrams(str);
				
				System.out.println(result);
			}
			
			// input.txt check
			/*
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			
			while(line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			
			String everything = sb.toString();

			System.out.println(everything);
			*/
		} finally{
			br.close();
		}
		
		
	}

}
