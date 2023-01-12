/*

2진수 8진수
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	26631	10435	8557	40.909%
문제
2진수가 주어졌을 때, 8진수로 변환하는 프로그램을 작성하시오.

입력
첫째 줄에 2진수가 주어진다. 주어지는 수의 길이는 1,000,000을 넘지 않는다.

출력
첫째 줄에 주어진 수를 8진수로 변환하여 출력한다.

예제 입력 1 
11001100
예제 출력 1 
314

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	String N = br.readLine();
    	
    	if (N.length() % 3 == 1) {
    		sb.append(N.charAt(0) - '0');
    	}
    	
    	if (N.length() % 3 == 2) {
    		sb.append((N.charAt(0) - '0') * 2 + (N.charAt(1) - '0'));
    	}
    	
    	for (int i = N.length() % 3; i < N.length(); i+=3) {
			sb.append((N.charAt(i) - '0') * 4 + (N.charAt(i + 1) - '0') * 2 + (N.charAt(i + 2) - '0'));
		}
    	
    	System.out.println(sb);
    }
}