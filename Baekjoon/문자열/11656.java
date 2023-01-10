/*

문제
접미사 배열은 문자열 S의 모든 접미사를 사전순으로 정렬해 놓은 배열이다.

baekjoon의 접미사는 baekjoon, aekjoon, ekjoon, kjoon, joon, oon, on, n 으로 총 8가지가 있고, 이를 사전순으로 정렬하면, aekjoon, baekjoon, ekjoon, joon, kjoon, n, on, oon이 된다.

문자열 S가 주어졌을 때, 모든 접미사를 사전순으로 정렬한 다음 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 문자열 S가 주어진다. S는 알파벳 소문자로만 이루어져 있고, 길이는 1,000보다 작거나 같다.

출력
첫째 줄부터 S의 접미사를 사전순으로 한 줄에 하나씩 출력한다.

예제 입력 1 
baekjoon
예제 출력 1 
aekjoon
baekjoon
ekjoon
joon
kjoon
n
on
oon

*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String S = br.readLine();
		
		String[] arr = new String[S.length()];
		
		for (int i = 0; i < S.length(); i++) {
			arr[i] = S.substring(i, S.length());
		}
		
		Arrays.sort(arr, (e1, e2) -> {
			return e1.compareTo(e2);
		});
		
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i] + "\n");
		}
		
		System.out.println(sb);
	}
};