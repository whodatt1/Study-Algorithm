/*

팩토리얼 0의 개수
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	53785	25892	21375	47.918%
문제
N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. (0 ≤ N ≤ 500)

출력
첫째 줄에 구한 0의 개수를 출력한다.

예제 입력 1 
10
예제 출력 1 
2
예제 입력 2 
3
예제 출력 2 
0

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	
    	int count_2 = 0;
    	int count_5 = 0;
    	
    	for (int i = 1; i <= N; i++) {
    		int num = i;
			
    		while (num % 2 == 0) {
				count_2++;
				num /= 2;
			}
    		
    		while (num % 5 == 0) {
    			count_5++;
    			num /= 5;
    		}
		}
    	
    	System.out.println(Math.min(count_2, count_5));
    }
}