package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

팰린드롬?
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
0.5 초 (하단 참고)	256 MB	46851	13587	9294	29.537%
문제
명우는 홍준이와 함께 팰린드롬 놀이를 해보려고 한다.

먼저, 홍준이는 자연수 N개를 칠판에 적는다. 그 다음, 명우에게 질문을 총 M번 한다.

각 질문은 두 정수 S와 E(1 ≤ S ≤ E ≤ N)로 나타낼 수 있으며, S번째 수부터 E번째 까지 수가 팰린드롬을 이루는지를 물어보며, 명우는 각 질문에 대해 팰린드롬이다 또는 아니다를 말해야 한다.

예를 들어, 홍준이가 칠판에 적은 수가 1, 2, 1, 3, 1, 2, 1라고 하자.

S = 1, E = 3인 경우 1, 2, 1은 팰린드롬이다.
S = 2, E = 5인 경우 2, 1, 3, 1은 팰린드롬이 아니다.
S = 3, E = 3인 경우 1은 팰린드롬이다.
S = 5, E = 7인 경우 1, 2, 1은 팰린드롬이다.
자연수 N개와 질문 M개가 모두 주어졌을 때, 명우의 대답을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 수열의 크기 N (1 ≤ N ≤ 2,000)이 주어진다.

둘째 줄에는 홍준이가 칠판에 적은 수 N개가 순서대로 주어진다. 칠판에 적은 수는 100,000보다 작거나 같은 자연수이다.

셋째 줄에는 홍준이가 한 질문의 개수 M (1 ≤ M ≤ 1,000,000)이 주어진다.

넷째 줄부터 M개의 줄에는 홍준이가 명우에게 한 질문 S와 E가 한 줄에 하나씩 주어진다.

출력
총 M개의 줄에 걸쳐 홍준이의 질문에 대한 명우의 답을 입력으로 주어진 순서에 따라서 출력한다. 팰린드롬인 경우에는 1, 아닌 경우에는 0을 출력한다.

예제 입력 1
7
1 2 1 3 1 2 1
4
1 3
2 5
3 3
5 7
예제 출력 1
1
0
1
1

 */

public class Main {

	static boolean[][] dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N + 1];
		dp = new boolean[N + 1][N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		recur(arr, N);

		int M = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			if (dp[start][end]) {
				sb.append("1\n");
			} else {
				sb.append("0\n");
			}
		}

		System.out.println(sb);
    }

	public static void recur(int[] arr, int N) {
		for (int i = 1; i <= N; i++) {
			dp[i][i] = true;
		}

		for (int i = 0; i <= N - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				dp[i][i + 1] = true;
			}
		}

		for (int i = 2; i < N; i++) {
			for (int j = 1; j <= N - i; j++) {
				if (arr[j] == arr[j + i] && dp[j + 1][j + i - 1]) {
					dp[j][j + i] = true;
				}
			}
		}
	}
}
