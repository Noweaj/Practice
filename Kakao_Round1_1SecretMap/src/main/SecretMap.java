package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
�׿��� ��� ���ε��� ������ ���ܳ��� ��Ҹ� �˷��� ��������� �տ� �־���. �׷��� �� ���������
���ڷ� ��ȣȭ�Ǿ� �־� ��ġ�� Ȯ���ϱ� ���ؼ��� ��ȣ�� �ص��ؾ� �Ѵ�. ������ ���� ��ȣ�� �ص���
����� ������� �޸� �Բ� �߰��ߴ�.

1.������ �� ���� ���̰� n�� ���簢�� �迭 ���·�, �� ĭ�� "����"(" ") �Ǵ� "��"("#")
�� ������ �̷���� �ִ�.
2.��ü ������ �� ���� ������ ���ļ� ���� �� �ִ�. ���� "����1"�� "����2"��� ����.
����1 �Ǵ� ����2 �� ��� �ϳ��� ���� �κ��� ��ü ���������� ���̴�. ����1�� ����2���� ��� ������
�κ��� ��ü ���������� �����̴�.
3."����1"�� "����2"�� ���� ���� �迭�� ��ȣȭ�Ǿ� �ִ�.
4.��ȣȭ�� �迭�� ������ �� �����ٿ��� �� �κ��� 1, ����κ��� 0���� ��ȣȭ���� �� ������� ��������
�ش��ϴ� ���� �迭�̴�.

����
" #  #" 0b01001 = 9
"# #  " 0b10100 = 20
"###  " 0b11100 = 28
"#  # " 0b10010 = 18
" # ##" 0b01011 = 11

"#### " 0b11110 = 30
"    #" 0b00001 = 1
"# # #" 0b10101 = 21
"#   #" 0b10001 = 17
"###  " 0b11100 = 28

���
"#####"
"# # #"
"### #"
"#  ##"
"#####"

�׿��� ���ε��� ������ �տ� ���� �� �ֵ���, ��������� ��ȣ�� �ص��ϴ� �۾��� ������ ���α׷��� �ۼ��϶�

�Է�����
�Է����� ������ �� �� ũ�� n�� 2���� ���� �迭 arr1, arr2�� ���´�
* 1<=n<=16
* arr1, arr�� ���� n�� ���� �迭�� �־�����
* ���� �迭�� �� ���� x�� �������� ��ȯ���� ���� ���̴� n�����̴�. ��, 0<=x<=2^n-1�� �����Ѵ�

����¿���1
n = 5
arr1 [9, 20, 28, 18, 11]
arr2 [30, 1, 21, 17, 28]
��� ["#####", "# # #", "### #", "#  ##", "#####"]

����¿���2
n = 6
arr1 [46, 33, 33, 22, 31, 50]
arr2 [27, 56, 19, 14, 14, 10]
��� ["######", "###  #", "##  ##", " #### ", " #####", "### # "]
*/

public class SecretMap {
	
	public static void secretMap(int n, String[] array1, String[] array2) {
		
		String[] result = new String[n];
		
		for(int i=0; i<n; i++) {
			int temp = (Integer.parseInt(array1[i])) | (Integer.parseInt(array2[i]));
			String tempStr = Integer.toBinaryString(temp);
			
			// Fill up 0s at the front
			if(tempStr.length() < n) {
				for(int j=0; j<n-tempStr.length(); j++) {
					tempStr = "0" + tempStr;
				}
			}
			
			String tempResult = "";
			for(int j=0; j<tempStr.length(); j++) {
				if(tempStr.substring(j, j+1).equals("1")) {
					tempResult += "#";
				} else {
					tempResult += " ";
				}
			}
			result[i] = tempResult;
		}
		
		for(int i=0; i<n; i++) {
			System.out.println(result[i]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		String filename = "input2.txt";
		
		BufferedReader br = new BufferedReader(new FileReader(filename));
		try {
			
			int n = Integer.parseInt(br.readLine());
			
			String[] array1 = br.readLine().replaceAll("\\s+$", "").split(" ");
			String[] array2 = br.readLine().replaceAll("\\s+$", "").split(" ");
			
			secretMap(n, array1, array2);
			
		} finally {
			br.close();
		}
	}

}
