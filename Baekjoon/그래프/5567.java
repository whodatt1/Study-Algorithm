package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 
결혼식 다국어
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	16178	7105	5790	43.731%
문제
상근이는 자신의 결혼식에 학교 동기 중 자신의 친구와 친구의 친구를 초대하기로 했다. 상근이의 동기는 모두 N명이고, 이 학생들의 학번은 모두 1부터 N까지이다. 상근이의 학번은 1이다.

상근이는 동기들의 친구 관계를 모두 조사한 리스트를 가지고 있다. 이 리스트를 바탕으로 결혼식에 초대할 사람의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 상근이의 동기의 수 n (2 ≤ n ≤ 500)이 주어진다. 둘째 줄에는 리스트의 길이 m (1 ≤ m ≤ 10000)이 주어진다. 다음 줄부터 m개 줄에는 친구 관계 ai bi가 주어진다. (1 ≤ ai < bi ≤ n) ai와 bi가 친구라는 뜻이며, bi와 ai도 친구관계이다. 

출력
첫째 줄에 상근이의 결혼식에 초대하는 동기의 수를 출력한다.

예제 입력 1 
6
5
1 2
1 3
3 4
2 3
4 5
예제 출력 1 
3
예제 입력 2 
6
5
2 3
3 4
4 5
5 6
2 5
예제 출력 2 
0
힌트
예제 1의 경우 2와 3은 상근이의 친구이다. 또, 3과 4는 친구이기 때문에, 4는 상근이의 친구의 친구이다. 5와 6은 친구도 아니고, 친구의 친구도 아니다. 따라서 2, 3, 4 3명의 친구를 결혼식에 초대한다.

 */

public class Main {
	
	static int n, m, result;
	public static ArrayList<Integer>[] arr;
	static boolean[] visited;
	
	public static void dfs(int start, int cnt) {
		
		if (cnt == 2) {
			return;
		}
		
		for (int i = 0; i < arr[start].size(); i++) {
			int a = arr[start].get(i);
			visited[a] = true;
			dfs(a, cnt + 1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		m = Integer.parseInt(br.readLine());
		
		arr = new ArrayList[n + 1];
		
		for (int i = 0; i <= n; i++) {
			arr[i] = new ArrayList<>();
		}
		visited = new boolean[n + 1];
		visited[1] = true;
		
		for (int i = 1; i <= m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a].add(b);
			arr[b].add(a);
		}
		
		dfs(1, 0);
		
		int result = 0;
		
		for (int i = 2; i <= n; i++) {
			if(visited[i]) {
				result++;
			}
		}
		
		System.out.println(result);
		
	}
}
