/*

문제
예제를 보고 규칙을 유추한 뒤에 별을 찍어 보세요.

입력
첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.

출력
첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.

예제 입력 1 
1
예제 출력 1 
*
예제 입력 2 
2
예제 출력 2 
 *
* *
예제 입력 3 
3
예제 출력 3 
  *
 * *
* * *
예제 입력 4 
4
예제 출력 4 
   *
  * *
 * * *
* * * *

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= n; i++) {
			int space = n - i;
			// 첫 공백
			for (int j = 0; j < space; j++) {
				sb.append(" ");
			}
			// 별 찍기
			for (int j = 0; j < i; j++) {
				// 첫별 제외 공백 하나씩
				if (j == 0) {
					sb.append("*");
				} else {
					sb.append(" ");
					sb.append("*");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}