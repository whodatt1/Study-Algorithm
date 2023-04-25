package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*

1, 2, 3 더하기 5
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초 (추가 시간 없음)	512 MB	23407	7940	5540	30.976%
문제
정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 3가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다. 단, 같은 수를 두 번 이상 연속해서 사용하면 안 된다.

1+2+1
1+3
3+1
정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 100,000보다 작거나 같다.

출력
각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 1,000,000,009로 나눈 나머지를 출력한다.

예제 입력 1
3
4
7
10
예제 출력 1
3
9
27

 */

public class Main {

	static int MOD = 1_000_000_009;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		long[][] dp = new long[100001][4];

		dp[1][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;

		for (int i = 4; i <= 100_000; i++) {
			dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
			dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
			dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD;
		}

		for (int i = 0; i < T; i++) {

			int x = Integer.parseInt(br.readLine());

			long result = (dp[x][1] + dp[x][2] + dp[x][3]) % MOD;

			sb.append(result).append("\n");
		}

		System.out.println(sb);
    }
}
