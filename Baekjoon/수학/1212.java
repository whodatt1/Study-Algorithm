/*

8진수 2진수
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	256 MB	38201	12679	10488	35.434%
문제
8진수가 주어졌을 때, 2진수로 변환하는 프로그램을 작성하시오.

입력
첫째 줄에 8진수가 주어진다. 주어지는 수의 길이는 333,334을 넘지 않는다.

출력
첫째 줄에 주어진 수를 2진수로 변환하여 출력한다. 수가 0인 경우를 제외하고는 반드시 1로 시작해야 한다.

예제 입력 1 
314
예제 출력 1 
11001100

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	String N = br.readLine();
    	
    	for (int i = 0; i < N.length(); i++) {
			String a = Integer.toBinaryString(N.charAt(i) - '0');
			if (a.length() == 2 && i != 0) {
				a = "0" + a;
			} else if (a.length() == 1 && i != 0) {
				a = "00" + a;
			}
			sb.append(a);
		}
    	
    	System.out.println(sb);
    }
}