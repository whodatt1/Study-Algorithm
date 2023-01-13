/*

이분 그래프
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	256 MB	73848	19513	11737	23.535%
문제
그래프의 정점의 집합을 둘로 분할하여, 각 집합에 속한 정점끼리는 서로 인접하지 않도록 분할할 수 있을 때, 그러한 그래프를 특별히 이분 그래프 (Bipartite Graph) 라 부른다.

그래프가 입력으로 주어졌을 때, 이 그래프가 이분 그래프인지 아닌지 판별하는 프로그램을 작성하시오.

입력
입력은 여러 개의 테스트 케이스로 구성되어 있는데, 첫째 줄에 테스트 케이스의 개수 K가 주어진다. 각 테스트 케이스의 첫째 줄에는 그래프의 정점의 개수 V와 간선의 개수 E가 빈 칸을 사이에 두고 순서대로 주어진다. 각 정점에는 1부터 V까지 차례로 번호가 붙어 있다. 이어서 둘째 줄부터 E개의 줄에 걸쳐 간선에 대한 정보가 주어지는데, 각 줄에 인접한 두 정점의 번호 u, v (u ≠ v)가 빈 칸을 사이에 두고 주어진다. 

출력
K개의 줄에 걸쳐 입력으로 주어진 그래프가 이분 그래프이면 YES, 아니면 NO를 순서대로 출력한다.

제한
2 ≤ K ≤ 5
1 ≤ V ≤ 20,000
1 ≤ E ≤ 200,000
예제 입력 1 
2
3 2
1 3
2 3
4 4
1 2
2 3
3 4
4 2
예제 출력 1 
YES
NO

-- 이분 그래프를 사용하여 푸는 문제였다

-- 방문배열을 boolean이 아닌 연결되어있는 그룹을 두 그룹으로 나누어 색깔(1, 2)을 칠한다
-- 연결된 선 비교하여 같은 그룹이면 false 다른 그룹이면 true를 반환
-- 추후에 유사 문제를 더 풀어봐야겠다..

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	
	public static int[] color;
	public static ArrayList<ArrayList<Integer>> graph;
	public static int V, E;
	
	public static void group() {
		Queue<Integer> q = new LinkedList<Integer>();
		
		for (int i = 1; i <= V; i++) {
			if (color[i] == 0) {
				q.add(i);
				color[i] = 1;
			}
			
			while (!q.isEmpty()) {
				int now = q.poll();
				
				for (int j = 0; j < graph.get(now).size(); j++) {
					if (color[graph.get(now).get(j)] == 0) {
						q.add(graph.get(now).get(j));
					}
					
					// 인접한 수가 같은 색깔이면
					if (color[graph.get(now).get(j)] == color[now]) {
						System.out.println("NO");
						return;
					}
					
					// 연결된 수는 다른색으로 칠한다
					if (color[now] == 1 && color[graph.get(now).get(j)] == 0) {
						color[graph.get(now).get(j)] = 2;
					} else if (color[now] == 2 && color[graph.get(now).get(j)] == 0) {
						color[graph.get(now).get(j)] = 1;
					}
				}
			}
		}
		
		System.out.println("YES");
	}
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int testCase = Integer.parseInt(br.readLine());
    	
    	for (int i = 0; i < testCase; i++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			color = new int[V + 1];
			graph = new ArrayList<ArrayList<Integer>>();
			
			for (int j = 0; j <= V; j++) {
				graph.add(new ArrayList<Integer>());
			}
			
			for (int j = 0; j < E; j++) {
				st= new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				
				graph.get(u).add(v);
				graph.get(v).add(u);
			}
			
			group();
		}
    }
}