/*

문제
수열 A가 주어졌을 때, 가장 긴 감소하는 부분 수열을 구하는 프로그램을 작성하시오.

예를 들어, 수열 A = {10, 30, 10, 20, 20, 10} 인 경우에 가장 긴 감소하는 부분 수열은 A = {10, 30, 10, 20, 20, 10}  이고, 길이는 3이다.

입력
첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.

둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)

출력
첫째 줄에 수열 A의 가장 긴 감소하는 부분 수열의 길이를 출력한다.

예제 입력 1 
6
10 30 10 20 20 10
예제 출력 1 
3

*/

import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int[] arr;
    	int[] dp;
    	
    	int N = Integer.parseInt(br.readLine());
    	
    	arr = new int[N + 1];
    	dp = new int[N + 1];
    	
    	StringTokenizer st;
    	st = new StringTokenizer(br.readLine());
    	for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
    	
    	dp[1] = 1;
    	
    	int max = 1;
    	for (int i = 2; i <= N; i++) {
    		dp[i] = 1;
			for (int j = 1; j < i; j++) {
				if (arr[i] < arr[j]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
			max = Math.max(max, dp[i]);
		}
    	
    	System.out.println(max);
    }
}