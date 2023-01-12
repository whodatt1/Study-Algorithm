/*

GCD 합 다국어
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	29712	11836	9676	40.722%
문제
양의 정수 n개가 주어졌을 때, 가능한 모든 쌍의 GCD의 합을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 t (1 ≤ t ≤ 100)이 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있다. 각 테스트 케이스는 수의 개수 n (1 < n ≤ 100)가 주어지고, 다음에는 n개의 수가 주어진다. 입력으로 주어지는 수는 1,000,000을 넘지 않는다.

출력
각 테스트 케이스마다 가능한 모든 쌍의 GCD의 합을 출력한다.

예제 입력 1 
3
4 10 20 30 40
3 7 5 12
3 125 15 25
예제 출력 1 
70
3
35

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main {
	
	static long gcd(long a, long b) {
		
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	int t = Integer.parseInt(br.readLine());
    	int[] arr;
    	
    	for (int i = 0; i < t; i++) {
    		long sum = 0;
    		
    		st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			arr = new int[n];
			
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			for (int j = 0; j < arr.length - 1; j++) {
				for (int j2 = j + 1; j2 < arr.length; j2++) {
					sum += gcd(arr[j], arr[j2]);
				}
			}
			
			sb.append(sum).append("\n");
		}
    	
    	System.out.println(sb);
    }
}