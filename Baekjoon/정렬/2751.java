/*

문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

예제 입력 1 
5
5
4
3
2
1
예제 출력 1 
1
2
3
4
5

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	
	static boolean[] count;
	
    public static void main(String[] args) throws IOException{
	// Arrays.sort 이용하면 시간초과 발생
	// Collenctions.sort 사용하여도 됨
	// Collections.sort는 Timsort로 합병 및 삽입정렬 사용
    	// 계수 정렬을 사용
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	int N = Integer.parseInt(br.readLine());
    	count = new boolean[2000001];
    	
    	for (int i = 0; i < N; i++) {
    		// true 혹은 false로 판단함
			count[Integer.parseInt(br.readLine()) + 1000000] = true;
		}
    	
    	for (int i = 0; i < count.length; i++) {
    		if (count[i]) {
    			// true일때 해당 값 반환
    			sb.append(i - 1000000 + "\n");
    		}
		}
    	
    	System.out.println(sb);
    }
}