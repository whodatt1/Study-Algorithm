
/*
 
다리 만들기
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	192 MB	33807	12317	7663	33.402%
문제
여러 섬으로 이루어진 나라가 있다. 이 나라의 대통령은 섬을 잇는 다리를 만들겠다는 공약으로 인기몰이를 해 당선될 수 있었다. 하지만 막상 대통령에 취임하자, 다리를 놓는다는 것이 아깝다는 생각을 하게 되었다. 그래서 그는, 생색내는 식으로 한 섬과 다른 섬을 잇는 다리 하나만을 만들기로 하였고, 그 또한 다리를 가장 짧게 하여 돈을 아끼려 하였다.

이 나라는 N×N크기의 이차원 평면상에 존재한다. 이 나라는 여러 섬으로 이루어져 있으며, 섬이란 동서남북으로 육지가 붙어있는 덩어리를 말한다. 다음은 세 개의 섬으로 이루어진 나라의 지도이다.



위의 그림에서 색이 있는 부분이 육지이고, 색이 없는 부분이 바다이다. 이 바다에 가장 짧은 다리를 놓아 두 대륙을 연결하고자 한다. 가장 짧은 다리란, 다리가 격자에서 차지하는 칸의 수가 가장 작은 다리를 말한다. 다음 그림에서 두 대륙을 연결하는 다리를 볼 수 있다.



물론 위의 방법 외에도 다리를 놓는 방법이 여러 가지 있으나, 위의 경우가 놓는 다리의 길이가 3으로 가장 짧다(물론 길이가 3인 다른 다리를 놓을 수 있는 방법도 몇 가지 있다).

지도가 주어질 때, 가장 짧은 다리 하나를 놓아 두 대륙을 연결하는 방법을 찾으시오.

입력
첫 줄에는 지도의 크기 N(100이하의 자연수)가 주어진다. 그 다음 N줄에는 N개의 숫자가 빈칸을 사이에 두고 주어지며, 0은 바다, 1은 육지를 나타낸다. 항상 두 개 이상의 섬이 있는 데이터만 입력으로 주어진다.

출력
첫째 줄에 가장 짧은 다리의 길이를 출력한다.

예제 입력 1 
10
1 1 1 0 0 0 0 1 1 1
1 1 1 1 0 0 0 0 1 1
1 0 1 1 0 0 0 0 1 1
0 0 1 1 1 0 0 0 0 1
0 0 0 1 0 0 0 0 0 1
0 0 0 0 0 0 0 0 0 1
0 0 0 0 0 0 0 0 0 0
0 0 0 0 1 1 0 0 0 0
0 0 0 0 1 1 1 0 0 0
0 0 0 0 0 0 0 0 0 0
예제 출력 1 
3
 
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int N;
	public static int isLandNum = 2;
	public static int min = Integer.MAX_VALUE;
	public static int[] dirX = {0, -1, 1, 0};
	public static int[] dirY = {-1, 0, 0, 1};
	public static int[][] land;
	public static boolean[][] visited;
	
	static class Spot {
		int x;
		int y;
		int cnt;
		
		public Spot(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	static void Island_num(int a, int b) {
		Queue<Spot> q = new LinkedList<>();
		q.offer(new Spot(a, b, 0));
		visited[a][b] =true;
		land[a][b] = isLandNum;
		
		while (!q.isEmpty()) {
			Spot spot = q.poll();
			
			int x = spot.x;
			int y = spot.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = dirX[i] + x;
				int ny = dirY[i] + y;
				
				if (nx >= 0 && ny >= 0 && nx < N && ny < N && land[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					land[nx][ny] = isLandNum;
					q.offer(new Spot(nx, ny, 0));
				}
			}
		}
		isLandNum++;
	}
	
	static void bfs(int a, int b) {
		Queue<Spot> q = new LinkedList<>();
		q.offer(new Spot(a, b, 0));
        int currentLandNum = land[a][b];
        visited[a][b] = true;
        
		while (!q.isEmpty()) {
			Spot spot = q.poll();
			
			int x = spot.x; // 세로
			int y = spot.y; // 가로
			
			for (int i = 0; i < 4; i++) {
				int nx = dirX[i] + x;
				int ny = dirY[i] + y;
				
				if ((nx >= 0 && ny >= 0 && nx < N && ny < N ) && land[nx][ny] != currentLandNum && !visited[nx][ny]) {
					visited[nx][ny] = true;
					if (land[nx][ny] == 0) {
						q.offer(new Spot(nx, ny, spot.cnt + 1));
					} else {
						min = Math.min(min, spot.cnt);
					}
				}
			}
		}
	}
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	N = Integer.parseInt(br.readLine());
    	land = new int[N][N];
    	visited = new boolean[N][N];
    	
    	for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				land[i][j] = Integer.parseInt(st.nextToken());
			}
		}
    	
    	// 섬 구분
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (land[i][j] == 1) {
					Island_num(i, j);
				}
			}
		}
    	
    	
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (land[i][j] >= 1) {
					visited = new boolean[N][N];
					bfs(i, j);
				}
			}
		}
    	
    	System.out.println(min);
    }
}
