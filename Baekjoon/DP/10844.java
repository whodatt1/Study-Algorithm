/*

문제
45656이란 수를 보자.

이 수는 인접한 모든 자리의 차이가 1이다. 이런 수를 계단 수라고 한다.

N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구해보자. 0으로 시작하는 수는 계단수가 아니다.

입력
첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 100보다 작거나 같은 자연수이다.

출력
첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력한다.

예제 입력 1 
1
예제 출력 1 
9
예제 입력 2 
2
예제 출력 2 
17

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static final long MOD = 1_000_000_000L;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		long[][] dp = new long[N+1][10];
		
		// 초기화
		dp[1][0] = 0L;
		for (int i = 1; i < 10; i++) {
			dp[1][i] = 1L;
		}
		
		for (int i = 2; i <= N; i++) {
			// 0으로 시작하는 수의 개수
			dp[i][0] = dp[i-1][1];
			for (int j = 1; j <= 9; j++) {
				// 9일 경우 이전 자릿수의 8로 시작하는 수의 개수와 동일
				if (j == 9) {
					dp[i][9] = dp[i-1][8] % MOD;
				}
				// 나머지 수들은 이전 숫자의 j-1로 시작하는 수의 개수와 j+1로 시작하는 수의 개수 더한값
				else {
					dp[i][j] = (dp[i-1][j-1] % MOD + dp[i-1][j+1] % MOD) % MOD;
				}
			}
		}
		
		long result = 0;
		for (int i = 0; i < 10; i++) {
			result = (result + dp[N][i]) % MOD;
		}
		System.out.print(result);
	}
}