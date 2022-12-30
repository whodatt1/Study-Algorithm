/*

문제
3×N 크기의 벽을 2×1, 1×2 크기의 타일로 채우는 경우의 수를 구해보자.

입력
첫째 줄에 N(1 ≤ N ≤ 30)이 주어진다.

출력
첫째 줄에 경우의 수를 출력한다.

예제 입력 1 
2
예제 출력 1 
3
힌트
아래 그림은 3×12 벽을 타일로 채운 예시이다.

*/

import java.io.*;


public class Main{
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int[] dp;
    	    	
    	int N = Integer.parseInt(br.readLine());
    	
    	dp = new int[N + 1];
    	
    	dp[1] = 0;
    	if (N > 1) {
    		dp[2] = 3;
    	}
    	
    	// n = 6 일 경우 예외처리
    	// n = 4 일때의 예외가 우측에 붙은경우.. 좌측에 붙은 경우만 고려됨
    	int tmp = 0;
    	for (int i = 3; i <= N; i++) {
    		if (i % 2 != 0) {
    			dp[i] = 0;
    		} else {
    			dp[i] = dp[i-2] * 3 + 2 + (tmp += dp[i-4] * 2);
    		}
		}
    	
    	System.out.println(dp[N]);
    }
}