package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * KAKAO VX �ʱ���� 3��° ����
n���� ���ڷ� �̷���� ���ڿ� A�� B�� ������ ���Ͽ� ������ TRUE, �ٸ��� FALSE�� ǥ���Ͻÿ�.
��#1)
str1 = aabbp
str2 = abapb
result = TRUE

��#2)
str1 = idontlikeyou
str2 = idontyouliko
result = FALSE

��#3)
str1 = tobeornottobe
str2 = nottobeortobe
result = TRUE
*/

public class StringComparison {
	
	public static boolean strCompare(int n, String str1, String str2) {
		
		ArrayList<String> al = new ArrayList<>();
		for(int i=0; i<n; i++) {
			al.add(str1.substring(i, i+1));
		}
		
		boolean flag = true;
		for(int i=0; i<n; i++) {
			if(!al.contains(str2.substring(i, i+1))) {
				flag = false;
			} else {
				al.remove(str2.substring(i, i+1));
			}
		}
		
		return flag;
	}
	
	public static void main(String[] args) throws IOException {
		
		String filename = "input1.txt";
		
		BufferedReader br = new BufferedReader(new FileReader(filename));
		try {
			
			int n = Integer.parseInt(br.readLine());
			
			String str1 = br.readLine();
			String str2 = br.readLine();
			
			boolean ret = strCompare(n, str1, str2);
			
			if(ret) {
				System.out.println("TRUE");
			} else {
				System.out.println("FALSE");
			}
		} finally {
			br.close();
		}
	}

}
