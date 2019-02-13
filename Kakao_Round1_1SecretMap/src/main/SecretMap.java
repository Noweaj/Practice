package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
네오는 평소 프로도가 비상금을 숨겨놓는 장소를 알려줄 비밀지도를 손에 넣었다. 그런데 이 비밀지도는
숫자로 암호화되어 있어 위치를 확인하기 위해서는 암호를 해독해야 한다. 다행히 지도 암호를 해독할
방법을 적어놓은 메모도 함께 발견했다.

1.지도는 한 변의 길이가 n인 정사각형 배열 형태로, 각 칸은 "공백"(" ") 또는 "벽"("#")
두 종류로 이루어져 있다.
2.전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다. 각각 "지도1"과 "지도2"라고 하자.
지도1 또는 지도2 중 어느 하나라도 벽인 부부은 전체 지도에서도 벽이다. 지도1과 지도2에서 모두 공백인
부분은 전체 지도에서도 공백이다.
3."지도1"과 "지도2"는 각각 정수 배열로 암호화되어 있다.
4.암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백부분을 0으로 부호화했을 때 얻어지는 이진수에
해당하는 값의 배열이다.

예시
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

결과
"#####"
"# # #"
"### #"
"#  ##"
"#####"

네오가 프로도의 비상금을 손에 넣을 수 있도록, 비밀지도의 암호를 해독하는 작업을 도와줄 프로그램을 작성하라

입력형식
입력으로 지도의 한 변 크기 n과 2개의 정수 배열 arr1, arr2가 들어온다
* 1<=n<=16
* arr1, arr는 길이 n인 정수 배열로 주어진다
* 정수 배열의 각 원소 x를 이진수로 변환했을 때의 길이는 n이하이다. 즉, 0<=x<=2^n-1을 만족한다

입출력예제1
n = 5
arr1 [9, 20, 28, 18, 11]
arr2 [30, 1, 21, 17, 28]
출력 ["#####", "# # #", "### #", "#  ##", "#####"]

입출력예제2
n = 6
arr1 [46, 33, 33, 22, 31, 50]
arr2 [27, 56, 19, 14, 14, 10]
출력 ["######", "###  #", "##  ##", " #### ", " #####", "### # "]
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
