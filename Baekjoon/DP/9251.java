package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

LCS
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
0.1 초 (하단 참고)	256 MB	69435	28254	20714	40.220%
문제
LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.

예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.

입력
첫째 줄과 둘째 줄에 두 문자열이 주어진다. 문자열은 알파벳 대문자로만 이루어져 있으며, 최대 1000글자로 이루어져 있다.

출력
첫째 줄에 입력으로 주어진 두 문자열의 LCS의 길이를 출력한다.

예제 입력 1
ACAYKP
CAPCAK
예제 출력 1
4

 */

public class Main {

	static Integer[][] dp;
	static String str1, str2;

	public static int recur(int x, int y) {

    // 배열 벗어날 경우
		if (x == -1 || y == -1) {
			return 0;
		}

		if (dp[x][y] == null) {
			if (str1.charAt(x) == str2.charAt(y)) {
				dp[x][y] = recur(x - 1, y - 1) + 1;
			} else {
				dp[x][y] = Math.max(recur(x - 1, y), recur(x, y - 1));
			}
		}

		return dp[x][y];
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		str1 = br.readLine();
		str2 = br.readLine();

		dp = new Integer[str1.length()][str2.length()];

		System.out.println(recur(str1.length() - 1, str2.length() - 1));
    }

}
