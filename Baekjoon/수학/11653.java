/*

소인수분해
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	256 MB	78215	41894	32582	52.166%
문제
정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.

입력
첫째 줄에 정수 N (1 ≤ N ≤ 10,000,000)이 주어진다.

출력
N의 소인수분해 결과를 한 줄에 하나씩 오름차순으로 출력한다. N이 1인 경우 아무것도 출력하지 않는다.

예제 입력 1 
72
예제 출력 1 
2
2
2
3
3
예제 입력 2 
3
예제 출력 2 
3
예제 입력 3 
6
예제 출력 3 
2
3
예제 입력 4 
2
예제 출력 4 
2
예제 입력 5 
9991
예제 출력 5 
97
103

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	int N = Integer.parseInt(br.readLine());
    	
		// N이 두개 이상 곱셈(인수) 로 나타낼 수 있을때 인수중 한개 이상은 루트N 보다 작거나 같다!
    	for (int i = 2; i * i <= N; i++) {
			while (N % i == 0) {
				sb.append(i).append("\n");
				N = N / i;
			}
		}
        
        if (N != 1) {
			sb.append(N);
		}
    	
    	System.out.println(sb);
    }
}