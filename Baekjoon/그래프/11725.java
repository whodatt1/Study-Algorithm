
/*
 
트리의 부모 찾기
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	256 MB	52215	22848	16307	42.169%
문제
루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.

출력
첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.

예제 입력 1 
7
1 6
6 3
3 5
4 1
2 4
4 7
예제 출력 1 
4
6
1
3
1
4
예제 입력 2 
12
1 2
1 3
2 4
3 5
3 6
4 7
4 8
5 9
5 10
6 11
6 12
예제 출력 2 
1
1
2
3
3
4
4
5
5
6
6
 
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited; // 방문 여부 확인용
	static int[] parentNode; // 부모 노드 저장
	static Queue<Integer> q = new LinkedList<>();
	
	static void bfs() {
		while (!q.isEmpty()) {
			int v = q.poll();
			
			for (int node : graph.get(v)) {
				if (!visited[node]) {
					visited[node] = true;
					q.add(node);
					parentNode[node] = v;
				}
			}
		}
	}
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int N = Integer.parseInt(br.readLine());
    	
    	graph = new ArrayList<ArrayList<Integer>>();
    	for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}
    	
    	
    	for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph.get(x).add(y);
			graph.get(y).add(x);
		}
    	
    	visited = new boolean[N + 1];
    	parentNode = new int[N + 1];
    	
    	q.add(1);
    	visited[1] = true;
    	bfs();
    	
    	for (int i = 2; i <= N; i++) {
			System.out.println(parentNode[i]);
		}
    }
}
