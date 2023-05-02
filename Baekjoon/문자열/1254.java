package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/*

팰린드롬 만들기
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	8582	3735	3110	45.177%
문제
동호와 규완이는 212호에서 문자열에 대해 공부하고 있다. 규완이는 팰린드롬을 엄청나게 좋아한다. 팰린드롬이란 앞에서부터 읽으나 뒤에서부터 읽으나 같게 읽히는 문자열을 말한다.

동호는 규완이를 위한 깜짝 선물을 준비했다. 동호는 규완이가 적어놓고 간 문자열 S에 0개 이상의 문자를 문자열 뒤에 추가해서 팰린드롬을 만들려고 한다. 동호는 가능하면 가장 짧은 문자열을 만들려고 한다.

동호가 만들 수 있는 가장 짧은 팰린드롬의 길이를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 문자열 S가 주어진다. S는 알파벳 소문자로만 이루어져 있고, 길이는 최대 50이다.

출력
첫째 줄에 동호가 만들 수 있는 가장 짧은 팰린드롬의 길이를 출력한다.

예제 입력 1
abab
예제 출력 1
5
예제 입력 2
abacaba
예제 출력 2
7
예제 입력 3
qwerty
예제 출력 3
11
예제 입력 4
abdfhdyrbdbsdfghjkllkjhgfds
예제 출력 4
38

 */

public class Main {

	public static boolean palindrome(String s) {

		for (int i = 0; i <= s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S = br.readLine();

		if (palindrome(S)) {
			System.out.println(S.length());
		} else {
			for (int i = 0; i < S.length(); i++) {
				if (palindrome(S.substring(i)) || i == S.length() - 1) {
					for (int j = i - 1; j >= 0; j--) {
						S += S.substring(j, j + 1);
					}
				}

				if (palindrome(S)) {
					System.out.println(S.length());
					break;
				}
			}
		}

    }
}
