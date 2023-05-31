package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 
숨바꼭질 3
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	512 MB	74342	21158	13685	24.976%
문제
수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

입력
첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

출력
수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.

예제 입력 1 
5 17
예제 출력 1 
2
힌트
수빈이가 5-10-9-18-17 순으로 가면 2초만에 동생을 찾을 수 있다.

 */

public class Main {
	
	static int min = Integer.MAX_VALUE;
	static int N, K;
	static boolean[] visited;
	
	public static class Node {
		int x;
		int time;
		
		public Node(int x, int time) {
			this.x = x;
			this.time = time;
		}
	}
	
	public static void bfs() {
		
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(N, 0));
		
		while (!q.isEmpty()) {
			Node node = q.poll();
			visited[node.x] = true;
			
			if (node.x == K) {
				min = Math.min(min, node.time);
			}
			
			if (node.x * 2 <= 100000 && !visited[node.x * 2]) {
				q.offer(new Node(node.x * 2, node.time));
			}
			
			if (node.x + 1 <= 100000 && !visited[node.x + 1]) {
				q.offer(new Node(node.x + 1, node.time + 1));
			}
			
			if (node.x - 1 >= 0 && !visited[node.x - 1]) {
				q.offer(new Node(node.x - 1, node.time + 1));
			}
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		K = Integer.parseInt(st.nextToken());
		
		visited = new boolean[100001];
		bfs();
		System.out.println(min);
		
	}
}
