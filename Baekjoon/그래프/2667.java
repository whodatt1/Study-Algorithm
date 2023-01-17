/*

단지번호붙이기
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	138343	60076	37953	41.263%
문제
<그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.



입력
첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.

출력
첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.

예제 입력 1 
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000
예제 출력 1 
3
7
8
9

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	public static int complexCnt;
	public static int cnt;
	public static boolean[][] visited;
	public static ArrayList<ArrayList<Integer>> graph;
	public static ArrayList<Integer> arr = new ArrayList<Integer>();
	
	public static void dfs(int firstRoot, int secondRoot) {
		
		cnt++;
		visited[firstRoot][secondRoot] = true;
		
		for (int i = firstRoot - 1; i <= firstRoot + 1; i++) {
			if (i <= 0) {
				continue;
			}
			
			if (i > graph.size() - 1) {
				continue;
			}
			
			int y = graph.get(i).get(secondRoot);
			
			if (y == 1 && !visited[i][secondRoot]) {
				dfs(i, secondRoot);
			}
		}
		
		for (int i = secondRoot - 1; i <= secondRoot + 1; i++) {
			if (i < 0) {
				continue;
			}
			
			if (i > graph.size() - 2) {
				continue;
			}
			
			int y = graph.get(firstRoot).get(i);
			
			if (y == 1 && !visited[firstRoot][i]) {
				dfs(firstRoot, i);
			}
		}
	};
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	int N = Integer.parseInt(br.readLine());
    	
    	visited = new boolean[N + 1][N + 1];
    	graph = new ArrayList<ArrayList<Integer>>();
    	
    	for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}
    	
    	
    	for (int i = 1; i <= N; i++) {
    		String data = br.readLine();
			for (int j = 0; j < N; j++) {
				graph.get(i).add(Integer.parseInt(String.valueOf(data.charAt(j))));
			}
		}
    	
    	for (int i = 1; i < graph.size(); i++) {
			for (int j = 0; j < graph.get(i).size(); j++) {
				if (graph.get(i).get(j) == 1) {
					if (!visited[i][j]) {
						dfs(i, j);
						complexCnt++;
						arr.add(cnt);
						cnt = 0;
					}
				}
			}
		}
    	
    	System.out.println(complexCnt);
    	
    	Collections.sort(arr);
    	
    	for (int x : arr) {
			System.out.println(x);
		}
    }
}