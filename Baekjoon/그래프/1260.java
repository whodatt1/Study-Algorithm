/*

DFS와 BFS
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	212150	78765	46783	36.078%
문제
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

입력
첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

출력
첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.

예제 입력 1 
4 5 1
1 2
1 3
1 4
2 4
3 4
예제 출력 1 
1 2 4 3
1 2 3 4
예제 입력 2 
5 5 3
5 4
5 2
1 2
3 4
3 1
예제 출력 2 
3 1 2 5 4
3 1 4 2 5
예제 입력 3 
1000 1 1000
999 1000
예제 출력 3 
1000 999
1000 999

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static boolean[] visited;
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
			
	public static void dfs(int root) {
		visited[root] = true;
		
		System.out.print(root + " ");
		
		for (int i = 0; i < graph.get(root).size(); i++) {
			int next = graph.get(root).get(i);
			
			if (!visited[next]) {
				dfs(next);
			}
		}
	}
	
	public static void bfs(int root) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(root);
		
		visited[root] = true;
		
		while (!q.isEmpty()) {
			int x = q.poll();
			
			System.out.print(x + " ");
			
			for (int i = 0; i < graph.get(x).size(); i++) {
				int next = graph.get(x).get(i);
				
				if (!visited[next]) {
					q.offer(next);
					visited[next] = true;
				}
			}
		}
	}
			
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	int root = Integer.parseInt(st.nextToken());
    	
    	visited = new boolean[N + 1];
    	
    	for (int i = 0; i < N + 1; i++) {
    		graph.add(new ArrayList<Integer>());
		}
    	
    	
    	for (int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		graph.get(x).add(y);
    		graph.get(y).add(x);
		}
    	
    	
    	for (int i = 0; i < graph.size(); i++) {
    		Collections.sort(graph.get(i));
		}
    	
    	dfs(root);
    	System.out.println();
    	for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
    	bfs(root);
    }
}