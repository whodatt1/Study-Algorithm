package test;

/*
 
차이를 최대로
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	256 MB	25323	16413	12669	65.395%
문제
N개의 정수로 이루어진 배열 A가 주어진다. 이때, 배열에 들어있는 정수의 순서를 적절히 바꿔서 다음 식의 최댓값을 구하는 프로그램을 작성하시오.

|A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|

입력
첫째 줄에 N (3 ≤ N ≤ 8)이 주어진다. 둘째 줄에는 배열 A에 들어있는 정수가 주어진다. 배열에 들어있는 정수는 -100보다 크거나 같고, 100보다 작거나 같다.

출력
첫째 줄에 배열에 들어있는 수의 순서를 적절히 바꿔서 얻을 수 있는 식의 최댓값을 출력한다.

예제 입력 1 
6
20 1 15 8 4 10
예제 출력 1 
62

DFS를 이용하여 풀어야하는 문제다 재귀함수 개념이 부족하여 재귀함수에 대해 조금더 공부해봤다..
 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] arr;
	static int[] tmp;
	static boolean[] visited;
	static int result;
	
	public static void dfs(int num) {
		if (num == N) {
			int sum = 0;
			for (int i = 0; i < N - 1; i++) {
				sum += Math.abs(tmp[i] - tmp[i + 1]);
			}
			result = Math.max(result, sum);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				tmp[num] = arr[i];
				visited[i] = true;
				dfs(num + 1);
				visited[i] = false;
			}
		}
	}
	
    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());
    	arr = new int[N];
    	tmp = new int[N];
    	visited = new boolean[N];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
    	dfs(0);
    	System.out.println(result);
    }
}
