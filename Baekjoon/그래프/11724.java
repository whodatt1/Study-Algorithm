package test;



/*

연결 요소의 개수
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
3 초	512 MB	85396	38940	25662	42.623%
문제
방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.

출력
첫째 줄에 연결 요소의 개수를 출력한다.

예제 입력 1 
6 5
1 2
2 5
5 1
3 4
4 6
예제 출력 1 
2
예제 입력 2 
6 8
1 2
2 5
5 1
3 4
4 6
5 4
2 4
2 3
예제 출력 2 
1

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	public static boolean[] visited;
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	
	public static void bfs(int root) {
		
		visited[root] = true;
		
		for (int i = 0; i < graph.get(root).size(); i++) {
			int next = graph.get(root).get(i);
			
			if (!visited[next]) {
				bfs(next);
			}
		}
	}
			
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	visited = new boolean[N + 1];
    	
    	for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}
    	
    	for (int j = 0; j < M; j++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
    	
    	for (int j2 = 0; j2 < graph.size(); j2++) {
    		Collections.sort(graph.get(j2));
		}
    	
    	int cnt = 0;
    	for (int k = 1; k <= visited.length - 1; k++) {
			if (!visited[k]) {
				bfs(k);
				cnt++;
			}
		}
    	
    	System.out.println(cnt);
    }
}


