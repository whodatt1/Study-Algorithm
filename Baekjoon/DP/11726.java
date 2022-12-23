/*

문제
2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.

아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.

입력
첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)

출력
첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.

예제 입력 1 
2
예제 출력 1 
2
예제 입력 2 
9
예제 출력 2 
55

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static Integer[] dp;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		dp = new Integer[1001];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		
		System.out.println(topDown(N));
	}
	
	// TopDown 방식
	public static int topDown(int N) {
		
		if (dp[N] == null) {
			// 문제 의도를 파악하고 점화식을 잘 세우는 것이 관건
			dp[N] = (topDown(N - 1) + topDown(N - 2)) % 10007;
		}
		
		return dp[N];
	}
}