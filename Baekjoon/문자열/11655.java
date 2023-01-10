
/*

문제
알파벳으로만 이루어진 단어를 입력받아, 그 길이를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 영어 소문자와 대문자로만 이루어진 단어가 주어진다. 단어의 길이는 최대 100이다.

출력
첫째 줄에 입력으로 주어진 단어의 길이를 출력한다.

예제 입력 1 
pulljima
예제 출력 1 
8

*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		
		for (int i = 0; i < str.length(); i++) {
			int strnum = 0;
			if (str.charAt(i) >= 97 && str.charAt(i) <= 122) { // 소문자
				strnum = str.charAt(i);
				if (strnum + 13 > 122) {
					sb.append(Character.valueOf((char) (strnum - 13)));
				} else {
					sb.append(Character.valueOf((char) (strnum + 13)));
				}
			} else if (str.charAt(i) >= 65 && str.charAt(i) <= 90) { // 대문자 
				strnum = str.charAt(i);
				if (strnum + 13 > 90) {
					sb.append(Character.valueOf((char) (strnum - 13)));
				} else {
					sb.append(Character.valueOf((char) (strnum + 13)));
				}
			} else {
				sb.append(str.charAt(i));
			}
		}
		
		System.out.println(sb);
	}
};


