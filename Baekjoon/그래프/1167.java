
/*
 
트리의 지름
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	256 MB	36181	13144	9428	33.845%
문제
트리의 지름이란, 트리에서 임의의 두 점 사이의 거리 중 가장 긴 것을 말한다. 트리의 지름을 구하는 프로그램을 작성하시오.

입력
트리가 입력으로 주어진다. 먼저 첫 번째 줄에서는 트리의 정점의 개수 V가 주어지고 (2 ≤ V ≤ 100,000)둘째 줄부터 V개의 줄에 걸쳐 간선의 정보가 다음과 같이 주어진다. 정점 번호는 1부터 V까지 매겨져 있다.

먼저 정점 번호가 주어지고, 이어서 연결된 간선의 정보를 의미하는 정수가 두 개씩 주어지는데, 하나는 정점번호, 다른 하나는 그 정점까지의 거리이다. 예를 들어 네 번째 줄의 경우 정점 3은 정점 1과 거리가 2인 간선으로 연결되어 있고, 정점 4와는 거리가 3인 간선으로 연결되어 있는 것을 보여준다. 각 줄의 마지막에는 -1이 입력으로 주어진다. 주어지는 거리는 모두 10,000 이하의 자연수이다.

출력
첫째 줄에 트리의 지름을 출력한다.

예제 입력 1 
5
1 3 2 -1
2 4 4 -1
3 1 2 4 3 -1
4 2 4 3 3 5 6 -1
5 4 6 -1
예제 출력 1 
11

1. dfs를 통해 임의의 정점 하나에서 가장 먼 정점을 구한다. (임의의 정점은 아무거나 상관없다.)

2. dfs를 통해 구한 정점으로 부터 가장 먼 정점까지의 거리를 구한다.
 
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Node>[] graph;
	static boolean[] visited;
	static int max = 0;
	static int node;
	
	public static class Node {
		int el;
		int length;
		
		public Node(int el, int length) {
			this.el = el;
			this.length = length;
		}
	}
	
	public static void dfs(int x, int len) {
		if (len > max) {
			max = len;
			node = x;
		}
		visited[x] = true;
		
		for (int i = 0; i < graph[x].size(); i++) {
			Node node = graph[x].get(i);
			
			if (!visited[node.el]) {
				dfs(node.el, node.length + len);
				visited[node.el] = true;
			}
		}
	}
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	int N = Integer.parseInt(br.readLine());
    	graph = new ArrayList[N + 1];
    	for (int i = 1; i < N + 1; i++) {
    		graph[i] = new ArrayList<>();
		}
    	
    	for (int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		int idx = Integer.parseInt(st.nextToken());
    		while (true) {
				int el = Integer.parseInt(st.nextToken());
				if (el == -1) {
					break;
				}
				int length = Integer.parseInt(st.nextToken());
				graph[idx].add(new Node(el, length));
			}
		}
    	
    	visited = new boolean[N + 1];
    	dfs(1, 0);
    	
    	visited = new boolean[N + 1];
    	dfs(node, 0);
    	
    	System.out.println(max);
    }
}
