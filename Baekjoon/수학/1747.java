package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/*

소수&팰린드롬
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	256 MB	20705	6593	4877	30.262%
문제
어떤 수와 그 수의 숫자 순서를 뒤집은 수가 일치하는 수를 팰린드롬이라 부른다. 예를 들어 79,197과 324,423 등이 팰린드롬 수이다.

어떤 수 N (1 ≤ N ≤ 1,000,000)이 주어졌을 때, N보다 크거나 같고, 소수이면서 팰린드롬인 수 중에서, 가장 작은 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다.

출력
첫째 줄에 조건을 만족하는 수를 출력한다.

예제 입력 1
31
예제 출력 1
101

 */

public class Main {

	public static boolean palindrome(int x) {

		String a = String.valueOf(x);

		for (int i = 0; i <= a.length() / 2; i++) {
			if (a.charAt(i) != a.charAt(a.length() - i - 1)) {
				return false;
			}
		}
		return true;

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		boolean[] isPrime = new boolean[1005000];
		Arrays.fill(isPrime, true);

		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i < isPrime.length; i++) {
			if (!isPrime[i]) {
				continue;
			}
			for (int j = i + i; j < isPrime.length; j += i) {
				isPrime[j] = false;
			}
		}

		for (int i = N; i < isPrime.length; i++) {
			if (isPrime[i] && palindrome(i)) {
				System.out.println(i);
				break;
			}
		}
    }
}
