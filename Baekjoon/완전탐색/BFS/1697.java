package test;

/*
 
숨바꼭질 다국어
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	196686	56735	35677	25.293%
문제
수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

입력
첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

출력
수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.

예제 입력 1 
5 17
예제 출력 1 
4
 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int K;
	static int[] check = new int[100001];
	
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		check[start] = 1;
		
		while (!q.isEmpty()) {
			int tmp = q.poll();
			
			for (int i = 0; i < 3; i++) {
				int next;
				
				if (i == 0) {
					next = tmp + 1;
				} else if (i == 1) {
					next = tmp - 1;
				} else {
					next = tmp * 2;
				}
				
				if (next == K) {
					System.out.println(check[tmp]);
					return;
				}
				
				if (next >= 0 && next < check.length && check[next] == 0) {
					q.add(next);
					check[next] = check[tmp] + 1;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		
		K = Integer.parseInt(st.nextToken());
    	
		if (N == K) {
			System.out.println(0);
		} else {
			bfs(N);
		}
    }
}
