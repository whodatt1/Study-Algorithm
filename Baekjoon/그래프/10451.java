

/*

순열 사이클 다국어
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	256 MB	16359	10314	7413	62.774%
문제


1부터 N까지 정수 N개로 이루어진 순열을 나타내는 방법은 여러 가지가 있다. 예를 들어, 8개의 수로 이루어진 순열 (3, 2, 7, 8, 1, 4, 5, 6)을 배열을 이용해 표현하면  
 \(\begin{pmatrix} 1 & 2 &3&4&5&6&7&8 \\  3& 2&7&8&1&4&5&6 \end{pmatrix}\) 와 같다. 또는, Figure 1과 같이 방향 그래프로 나타낼 수도 있다.

순열을 배열을 이용해  
 \(\begin{pmatrix} 1 & \dots & i & \dots &n \\  \pi_1& \dots& \pi_i & \dots & \pi_n \end{pmatrix}\) 로 나타냈다면, i에서 πi로 간선을 이어 그래프로 만들 수 있다.

Figure 1에 나와있는 것 처럼, 순열 그래프 (3, 2, 7, 8, 1, 4, 5, 6) 에는 총 3개의 사이클이 있다. 이러한 사이클을 "순열 사이클" 이라고 한다.

N개의 정수로 이루어진 순열이 주어졌을 때, 순열 사이클의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스의 첫째 줄에는 순열의 크기 N (2 ≤ N ≤ 1,000)이 주어진다. 둘째 줄에는 순열이 주어지며, 각 정수는 공백으로 구분되어 있다.

출력
각 테스트 케이스마다, 입력으로 주어진 순열에 존재하는 순열 사이클의 개수를 출력한다.

예제 입력 1 
2
8
3 2 7 8 1 4 5 6
10
2 1 3 4 5 6 7 9 10 8
예제 출력 1 
3
7

-- 너비우선탐색으로 풀이

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static boolean[] visited;
	public static ArrayList<ArrayList<Integer>> graph;
	
	public static void bfs(int root) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(root);
		visited[root] = true;
		
		while(!q.isEmpty()) {
			int x = q.poll();
			
			for (int i = 0; i < graph.get(x).size(); i++) {
				int y = graph.get(x).get(i);
				if (!visited[y]) {
					q.add(y);
					visited[y] = true;
				}
			}
		}
	}
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	int T = Integer.parseInt(br.readLine());
    	
    	for (int i = 0; i < T; i++) {
    		int N = Integer.parseInt(br.readLine());
    		
    		visited = new boolean[N + 1];
    		graph = new ArrayList<ArrayList<Integer>>();
    		
    		for (int j = 0; j < N + 1; j++) {
    			graph.add(new ArrayList<Integer>());
    		}
    		
    		st = new StringTokenizer(br.readLine());
    		for (int j = 1; j <= N; j++) {
    			int num = Integer.parseInt(st.nextToken());
				graph.get(j).add(num);
				graph.get(num).add(j);
			}
    		
    		int cnt = 0;
    		// 방문여부 확인하여 방문 안했을 경우 cnt
    		for (int j = 1; j < visited.length; j++) {
    			// 방문 안한경우 탐색 진행
				if (!visited[j]) {
					bfs(j);
					cnt++;
				}
			}
    		sb.append(cnt).append("\n");
		}
    	
    	System.out.println(sb);
    }
}


