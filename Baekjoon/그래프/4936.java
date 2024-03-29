/*

섬의 개수 다국어
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	52534	26500	19029	49.275%
문제
정사각형으로 이루어져 있는 섬과 바다 지도가 주어진다. 섬의 개수를 세는 프로그램을 작성하시오.



한 정사각형과 가로, 세로 또는 대각선으로 연결되어 있는 사각형은 걸어갈 수 있는 사각형이다. 

두 정사각형이 같은 섬에 있으려면, 한 정사각형에서 다른 정사각형으로 걸어서 갈 수 있는 경로가 있어야 한다. 지도는 바다로 둘러싸여 있으며, 지도 밖으로 나갈 수 없다.

입력
입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스의 첫째 줄에는 지도의 너비 w와 높이 h가 주어진다. w와 h는 50보다 작거나 같은 양의 정수이다.

둘째 줄부터 h개 줄에는 지도가 주어진다. 1은 땅, 0은 바다이다.

입력의 마지막 줄에는 0이 두 개 주어진다.

출력
각 테스트 케이스에 대해서, 섬의 개수를 출력한다.

예제 입력 1 
1 1
0
2 2
0 1
1 0
3 2
1 1 1
1 1 1
5 4
1 0 1 0 0
1 0 0 0 0
1 0 1 0 1
1 0 0 1 0
5 4
1 1 1 0 1
1 0 1 0 1
1 0 1 0 1
1 0 1 1 1
5 5
1 0 1 0 1
0 0 0 0 0
1 0 1 0 1
0 0 0 0 0
1 0 1 0 1
0 0
예제 출력 1 
0
1
1
3
1
9

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int islandCnt, w, h;
	public static int[] dirX = {-1, 0, 1, -1, 1, -1, 0, 1};
	public static int[] dirY = {-1, -1, -1, 0, 0, 1, 1, 1};
	public static boolean[][] visited;
	public static int[][] map;
	public static Queue<Node> q = new LinkedList<>();
	
	// 큐에 넣기 위한 노드 클래스
	static class Node {
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	};
	
	static void bfs() {
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for (int i = 0; i < 8; i++) {
				int x = node.x + dirX[i];
				int y = node.y + dirY[i];
				
				// 범위에 포함되지 않으면 패스
				if (x < 0 || x >= h || y < 0 || y >= w || map[x][y] == 0 || visited[x][y]) {
					continue;
				} else {
					visited[x][y] = true;
					q.offer(new Node(x, y));
				}
			}
		}
		islandCnt++;
	};
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();
    	
    	st = new StringTokenizer(br.readLine());
    	w = Integer.parseInt(st.nextToken());
    	h = Integer.parseInt(st.nextToken());
    	
    	while(w != 0 && h != 0) {
    		
    		visited = new boolean[h][w];
    		map = new int[h][w];
    		islandCnt = 0;
    		
    		for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
    		
    		for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						visited[i][j] = true;
						q.offer(new Node(i, j));
						bfs();
					}
				}
			}
    		System.out.println(islandCnt);
    		q.clear();
    		
    		st = new StringTokenizer(br.readLine());
        	w = Integer.parseInt(st.nextToken());
        	h = Integer.parseInt(st.nextToken());
    	}
    }
}
