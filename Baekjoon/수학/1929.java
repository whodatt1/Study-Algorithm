/*

소수 구하기 성공
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	256 MB	216733	61327	43180	26.562%
문제
M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.

출력
한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.

예제 입력 1 
3 16
예제 출력 1 
3
5
7
11
13

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	st = new StringTokenizer(br.readLine());
    	int start = Integer.parseInt(st.nextToken());
    	int end = Integer.parseInt(st.nextToken());
    	
    	int number = 1000000;
    	int a[] = new int[1000001];
    	
    	for (int i = 2; i <= number; i++) {
			a[i] = i;
		}
    	
    	for (int i = 2; i <= number; i++) {
			if (a[i] == 0) {
				continue;
			}
			
			for (int j = 2 * i; j < number; j+=i) {
				a[j] = 0;
			}
		}
    	
    	for (int i = start; i <= end; i++) {
    		if (a[i] != 0) {
    			sb.append(a[i]).append("\n");
    		}
    	}
    	
    	System.out.println(sb);
    }
}
