package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*

대소문자 바꾸기 성공
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	18042	13793	12649	77.783%
문제
영어 소문자와 대문자로 이루어진 단어를 입력받은 뒤, 대문자는 소문자로, 소문자는 대문자로 바꾸어 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 영어 소문자와 대문자로만 이루어진 단어가 주어진다. 단어의 길이는 최대 100이다.

출력
첫째 줄에 입력으로 주어진 단어에서 대문자는 소문자로, 소문자는 대문자로 바꾼 단어를 출력한다.

예제 입력 1
WrongAnswer
예제 출력 1
wRONGaNSWER

 */

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		sb.append(br.readLine());

		for (int i = 0; i < sb.length(); i++) {
			char ch = sb.charAt(i);
			String str = sb.substring(i, i + 1);

			if (ch - '0' >= 49) {
				sb.replace(i, i + 1, str.toUpperCase());
			} else if (ch - '0' >= 17 && ch - '0' < 49) {
				sb.replace(i, i + 1, str.toLowerCase());
			}
		}

		System.out.println(sb);
    }
}
