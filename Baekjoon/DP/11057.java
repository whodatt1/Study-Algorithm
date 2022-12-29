/*

문제
오르막 수는 수의 자리가 오름차순을 이루는 수를 말한다. 이때, 인접한 수가 같아도 오름차순으로 친다.

예를 들어, 2234와 3678, 11119는 오르막 수이지만, 2232, 3676, 91111은 오르막 수가 아니다.

수의 길이 N이 주어졌을 때, 오르막 수의 개수를 구하는 프로그램을 작성하시오. 수는 0으로 시작할 수 있다.

입력
첫째 줄에 N (1 ≤ N ≤ 1,000)이 주어진다.

출력
첫째 줄에 길이가 N인 오르막 수의 개수를 10,007로 나눈 나머지를 출력한다.

예제 입력 1 
1
예제 출력 1 
10
예제 입력 2 
2
예제 출력 2 
55
예제 입력 3 
3
예제 출력 3 
220

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	// 0 ~ 9 까지의 각 숫자 (i) 의 오르막수 경우는 이전 자릿수 N-1 에서의 j 부터 마지막 9까지 경우의 수 합
	static int N;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		long[][] dp = new long[N+1][10];
		
		// 초기화
		for (int i = 0; i < 10; i++) {
			dp[1][i] = 1L;
		}
		
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				for (int j2 = j; j2 < 10; j2++) {
					dp[i][j] += dp[i-1][j2];
					dp[i][j] %= 10007;
				}
			}
		}
		
		int result = 0;
		
		for (int i = 0; i < 10; i++) {
			result += dp[N][i] % 10007;
		}
		
		System.out.println(result % 10007);
	}
}