/*

최대공약수와 최소공배수
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	82308	47538	38607	58.307%
문제
두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.

출력
첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.

예제 입력 1 
24 18
예제 출력 1 
6
72

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 제출 답안
public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String[] xy = br.readLine().split(" ");
    	
    	int max = Math.max(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]));
    	int maxdevi = 0;
    	
    	for (int i = 1; i <= max; i++) {
			if (Integer.parseInt(xy[0]) % i == 0 && Integer.parseInt(xy[1]) % i == 0) {
				maxdevi = Math.max(maxdevi, i);
			}
		}
    	
    	int x = Integer.parseInt(xy[0]);
    	int y = Integer.parseInt(xy[1]);
    	
    	while(x != y) {
    		if (x > y) {
    			y += Integer.parseInt(xy[1]);
    		} else {
    			x += Integer.parseInt(xy[0]);
    		}
    	}
    	
    	System.out.println(maxdevi);
    	System.out.println(x);
    }
}

// 모범 답안 유클리드 호제법 사용한것
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main {
//
//    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//    public static void main(String[] args) throws IOException {
//        String line = br.readLine();
//        StringTokenizer st = new StringTokenizer(line, " ");
//        
//        int a = Integer.parseInt(st.nextToken());
//        int b = Integer.parseInt(st.nextToken());
//		  
//        int gcd = gcd(a, b);
//        
//        System.out.println(gcd);
//        a * b를 곱한것에서 최대공약수를 나누면 최소공배수가 나온다
//        System.out.println(a * b / gcd);
//        br.close();
//    }
//    재귀함수 사용
//    private static int gcd(int a, int b) {
//    	if (b == 0) {
//    		return a;
//    	}
//    	return gcd(b, a % b);
//    }
//
//}