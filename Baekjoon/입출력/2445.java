/*

-문제
예제를 보고 규칙을 유추한 뒤에 별을 찍어 보세요.

-입력
첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.

-출력
첫째 줄부터 2×N-1번째 줄까지 차례대로 별을 출력한다.

-예제 입력 1 
5

-예제 출력 1 
*        *
**      **
***    ***
****  ****
**********
****  ****
***    ***
**      **
*        *

*/

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int tmp = 1;
		
		for (int i = 1; i <= 2*n-1; i++) {
			for (int j = 1; j <= n; j++) {
				if (j <= tmp) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			for (int k = n; k >= 1; k--) {
				if (k <= tmp) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			
			if (i < n) {
				tmp++;
			} else {
				tmp--;
			}
			System.out.println();
		}
	}
}