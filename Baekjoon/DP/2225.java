/*

문제
0부터 N까지의 정수 K개를 더해서 그 합이 N이 되는 경우의 수를 구하는 프로그램을 작성하시오.

덧셈의 순서가 바뀐 경우는 다른 경우로 센다(1+2와 2+1은 서로 다른 경우). 또한 한 개의 수를 여러 번 쓸 수도 있다.

입력
첫째 줄에 두 정수 N(1 ≤ N ≤ 200), K(1 ≤ K ≤ 200)가 주어진다.

출력
첫째 줄에 답을 1,000,000,000으로 나눈 나머지를 출력한다.

예제 입력 1 
20 2
예제 출력 1 
21
예제 입력 2 
6 4
예제 출력 2 
84

*/
import java.io.IOException;
import java.util.Scanner;

public class Main{
	
    public static void main(String[] args) throws IOException {
    	
    	Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
    	
    	int[][] dp = new int[N+1][K+1];
    	
    	// 초기화
    	for (int i = 1; i <= N; i++) {
    		dp[i][1] = 1;
		}
    	
    	// 초기화
    	for(int i=1;i<=K;i++) {
			dp[1][i]=i;
		}
    	
    	for (int i = 2; i <= N; i++) {
    		for (int j = 2; j <= K; j++) {
    			// 점화식 표를 그려서 분석 해보는 습관도 기르자..
    			dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1000000000;
			}
		}
    	
    	System.out.println(dp[N][K]);
    }
}