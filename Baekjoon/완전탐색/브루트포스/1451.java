package test;

/*
 
직사각형으로 나누기
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	3581	1414	1074	40.165%
문제
세준이는 N*M크기로 직사각형에 수를 N*M개 써놓았다.

세준이는 이 직사각형을 겹치지 않는 3개의 작은 직사각형으로 나누려고 한다. 각각의 칸은 단 하나의 작은 직사각형에 포함되어야 하고, 각각의 작은 직사각형은 적어도 하나의 숫자를 포함해야 한다.

어떤 작은 직사각형의 합은 그 속에 있는 수의 합이다. 입력으로 주어진 직사각형을 3개의 작은 직사각형으로 나누었을 때, 각각의 작은 직사각형의 합의 곱을 최대로 하는 프로그램을 작성하시오.

입력
첫째 줄에 직사각형의 세로 크기 N과 가로 크기 M이 주어진다. 둘째 줄부터 직사각형에 들어가는 수가 가장 윗 줄부터 한 줄에 하나씩 M개의 수가 주어진다. N과 M은 50보다 작거나 같은 자연수이고, 직사각형엔 적어도 3개의 수가 있다. 또, 직사각형에 들어가는 수는 한 자리의 숫자이다.

출력
세 개의 작은 직사각형의 합의 곱의 최댓값을 출력한다.

예제 입력 1 
1 8
11911103
예제 출력 1 
108
예제 입력 2 
3 3
123
456
789
예제 출력 2 
3264
예제 입력 3 
3 1
7
9
3
예제 출력 3 
189
 
나누는 방법 전부를 시도하여 합의 곱이 최대인 것을 하나씩 시도하여 구하여야 하는 문제 6가지 경우의 수가 나온다..
 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static long[][] sum;
	static long result;
	
    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	map = new int[N + 1][M + 1];
    	
    	for (int i = 1; i <= N; i++) {
    		String input = " " + br.readLine();
    		
    		for (int j = 1; j <= M; j++) {
    			map[i][j] = input.charAt(j) - '0';
			}
		}
    	
    	sum = new long[N + 1][M + 1];
    	
    	for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + (long) map[i][j];
			}
		}
    	
    	result =  0;
    	
    	// 첫번째 경우의 수 
    	for (int i = 1; i <= M-2 ; i++) {
    		for (int j = i+1; j <= M-1 ; j++) {
    			long r1 = sum(1,1,N,i);
    			long r2 = sum(1,i+1,N,j);
    			long r3 = sum(1,j+1,N,M);
    			if(result < r1*r2*r3){
    				result = r1*r2*r3;
    			}
    		}
    	}
    	
    	// 두번째 경우의 수
    	for (int i = 1; i <=N-2 ; i++) {
    		for (int j = i+1; j <=N-1 ; j++) {
    			long r1 = sum(1,1,i,M);
    			long r2 = sum(i+1,1,j,M);
    			long r3 = sum(j+1,1,N,M);
    			if(result < r1*r2*r3){
    				result = r1*r2*r3;
    			}
    		}
    	}
    	
    	// 나머지 네가지 경우의 수
    	for (int i=1; i<=N-1; i++) {
    		for (int j=1; j<=M-1; j++) {
    			long r1 = sum(1,1,N,j);
                long r2 = sum(1,j+1,i,M);
                long r3 = sum(i+1,j+1,N,M);
                if (result < r1*r2*r3) {
                	result = r1*r2*r3;
                }
                r1 = sum(1,1,i,j);
                r2 = sum(i+1,1,N,j);
                r3 = sum(1,j+1,N,M);
                if (result < r1*r2*r3) {
                	result = r1*r2*r3;
                }
                r1 = sum(1,1,i,M);
                r2 = sum(i+1,1,N,j);
                r3 = sum(i+1,j+1,N,M);
                if (result < r1*r2*r3) {
                	result = r1*r2*r3;
                }
                r1 = sum(1,1,i,j);
                r2 = sum(1,j+1,i,M);
                r3 = sum(i+1,1,N,M);
                if (result < r1*r2*r3) {
                	result = r1*r2*r3;
                }
            }
        }
        System.out.println(result);
      }
   
      private static long sum(int x1, int y1, int x2, int y2){
          return sum[x2][y2] -sum[x2][y1-1] - sum[x1-1][y2] + sum[x1-1][y1 -1] ;
      }
}
