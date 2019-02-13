package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
īī���� ���Ӻ��� �Ϲݱ� �ű� ���񽺷� ��Ʈ ������ ����ϱ�� �ߴ�.
��Ʈ ������ ��Ʈ�ǿ� ��Ʈ�� �� ���� ���� �� ������ �հ�� �Ƿ��� �ܷ�� ��������,
��ΰ� ������ ��� �� �ִ�.
�� �Ի��� ������ �ڵ� �Ƿ��� �����޾� ������ �ٽ� �κ��� ���� ��� ������ �ð� �Ǿ���.
��Ʈ ������ ���� ��� ������ �Ʒ��� ����.

1.��Ʈ ������ �� 3���� ��ȸ�� �����ȴ�.
2.�� ��ȸ���� ���� �� �ִ� ������ 0������ 10�������̴�.
3.������ �Բ� Single(S), Double(D), Triple(T) ������ �����ϰ� �� ���� ��÷ ��
�������� 1����, 2����, 3���� (����^1 , ����^2 , ����^3 )���� ���ȴ�.
4.�ɼ����� ��Ÿ��(*) , ������(#)�� �����ϸ� ��Ÿ��(*) ��÷ �� �ش� ������ �ٷ� ����
���� ������ �� 2��� �����. ������(#) ��÷ �� �ش� ������ ���̳ʽ��ȴ�.
5.��Ÿ��(*)�� ù ��° ��ȸ������ ���� �� �ִ�.
�� ��� ù ��° ��Ÿ��(*)�� ������ 2�谡 �ȴ�. (���� 4�� ����)
6.��Ÿ��(*)�� ȿ���� �ٸ� ��Ÿ��(*)�� ȿ���� ��ø�� �� �ִ�.
�� ��� ��ø�� ��Ÿ��(*) ������ 4�谡 �ȴ�. (���� 4�� ����)
7.��Ÿ��(*)�� ȿ���� ������(#)�� ȿ���� ��ø�� �� �ִ�.
�� ��� ��ø�� ������(#)�� ������ -2�谡 �ȴ�. (���� 5�� ����)
8.Single(S), Double(D), Triple(T)�� �������� �ϳ��� �����Ѵ�.
9.��Ÿ��(*), ������(#)�� �������� �� �� �ϳ��� ������ �� ������, �������� ���� ���� �ִ�.

0~10�� ������ ���� S, D, T, *, #�� ������ ���ڿ��� �Էµ� �� �������� ��ȯ�ϴ� �Լ��� �ۼ��϶�.

�Է�����
"����|���ʽ�|[�ɼ�]"���� �̷���� ���ڿ�3��Ʈ
��) 1S2D*3T
* ������ 0���� 10������ �����̴�
* ���ʽ��� S,D,T �� �ϳ��̴�
* �ɼ��� *�̳�#�� �ϳ��̸�, ���������ִ�

�������
3���� ��ȸ���� ���� ���� �հ迡 �ش��ϴ� ���� ���� ����Ѵ�
��37

����¿���
����	dartResult	answer	����
1	1S2D*3T		37		1^1 * 2 + 2^2 * 2 + 3^3
2	1D2S#10S	9		1^2 + 2^1 * (-1) + 10^1
3	1D2S0T		3		1^2 + 2^1 + 0^3
4	1S*2T*3S	23		1^1 * 2 * 2 + 2^3 * 2 + 3^1
5	1D#2S*3S	5		1^2 * (-1) * 2 + 2^1 * 2 + 3^1
6	1T2D3D#		-4		1^3 + 2^2 + 3^2 * (-1)
7	1D2S3T*		59		1^2 + 2^1 * 2 + 3^3 * 2
*/

public class DartGame {
	
	public static void dartGame(int n, String[] input) {
		
		for(int i=0; i<n; i++) {
			int ret = 0;
			
			int value = 0;
			String bonus = "";
			String tempValue = "";
			for(int j=0; j<input[i].length(); j++) {
				if(Character.isDigit(input[i].charAt(j))) {
					// if integer
					tempValue += input[i].charAt(j);
				} else {
					if(!tempValue.equals("")) {
						value = Integer.parseInt(tempValue);
						tempValue = "";
					}
					if(input[i].charAt(j) == 'S') {
						
					} else if(input[i].charAt(j) == 'D') {
						
					} else if(input[i].charAt(j) == 'T') {
						
					} else if(input[i].charAt(j) == '*') {
						
					} else if(input[i].charAt(j) == '#') {
						
					}
				}
			}
			
			System.out.println(ret);
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		String filename = "input1.txt";
		
		BufferedReader br = new BufferedReader(new FileReader(filename));
		try {
			int n = Integer.parseInt(br.readLine());

			String[] input = new String[n];
			for(int i=0; i<n; i++) {
				input[i] = br.readLine();
			}			
			
			dartGame(n, input);
		} finally {
			br.close();
		}
		
	}

}
