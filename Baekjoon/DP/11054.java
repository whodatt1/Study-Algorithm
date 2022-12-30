/*

문제
수열 S가 어떤 수 Sk를 기준으로 S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN을 만족한다면, 그 수열을 바이토닉 수열이라고 한다.

예를 들어, {10, 20, 30, 25, 20}과 {10, 20, 30, 40}, {50, 40, 25, 10} 은 바이토닉 수열이지만,  {1, 2, 3, 2, 1, 2, 3, 2, 1}과 {10, 20, 30, 40, 20, 30} 은 바이토닉 수열이 아니다.

수열 A가 주어졌을 때, 그 수열의 부분 수열 중 바이토닉 수열이면서 가장 긴 수열의 길이를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 수열 A의 크기 N이 주어지고, 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ N ≤ 1,000, 1 ≤ Ai ≤ 1,000)

출력
첫째 줄에 수열 A의 부분 수열 중에서 가장 긴 바이토닉 수열의 길이를 출력한다.

예제 입력 1 
10
1 5 2 1 4 3 4 5 2 1
예제 출력 1 
7

*/

import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int[] arr;
    	int[] dp1;
    	int[] dp2;
    	
    	int N = Integer.parseInt(br.readLine());
    	
    	arr = new int[N + 1];
    	dp1 = new int[N + 1];
    	dp2 = new int[N + 1];
    	
    	StringTokenizer st;
    	st = new StringTokenizer(br.readLine());
    	for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
    	
    	// LIS 최장 증가 수열
    	for (int i = 1; i <= N; i++) {
    		dp1[i] = 1;
			for (int j = 1; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp1[i] = Math.max(dp1[j] + 1, dp1[i]);
				}
			}
		}
    	
    	// LDS 최장 감소 수열
    	for (int i = N; i > 0; i--) {
    		dp2[i] = 1;
    		for (int j = N; j > i; j--) {
    			if (arr[i] > arr[j]) {
    				dp2[i] = Math.max(dp2[j] + 1, dp2[i]);
    			}
    		}
    	}
    	
    	int max = 0;
    	for (int i = 1; i <= N; i++) {
			max = Math.max(max, dp1[i] + dp2[i]);
		}
    	
    	// 중복된 숫자이므로 1을 빼줌
    	System.out.println(max - 1);
    }
}