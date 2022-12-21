/*

문제
예제를 보고 규칙을 유추한 뒤에 별을 찍어 보세요.

입력
첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.

출력
첫째 줄부터 2×N-1번째 줄까지 차례대로 별을 출력한다.

예제 입력 1 
5

예제 출력 1 
*********
 *******
  *****
   ***
    *
   ***
  *****
 *******
*********

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		// 역삼각형
		for (int i = n; i > 0; i--) {
			int space = (n - i) * 2;
			// 공백
			for (int j = 0; j < space/2; j++) {
				sb.append(" ");
			}
			// 별
			for (int k = 0; k < (2*n-1)-space; k++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		// 삼각형
		for (int i = 2; i <= n; i++) {
			int space = (n - i) * 2;
			// 공백
			for (int j = 0; j < space/2; j++) {
				sb.append(" ");
			}
			// 별
			for (int k = 0; k < (2*n-1)-space; k++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
