package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*

물통 다국어
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	13640	6911	5113	51.028%
문제
각각 부피가 A, B, C(1≤A, B, C≤200) 리터인 세 개의 물통이 있다. 처음에는 앞의 두 물통은 비어 있고, 세 번째 물통은 가득(C 리터) 차 있다. 이제 어떤 물통에 들어있는 물을 다른 물통으로 쏟아 부을 수 있는데, 이때에는 한 물통이 비거나, 다른 한 물통이 가득 찰 때까지 물을 부을 수 있다. 이 과정에서 손실되는 물은 없다고 가정한다.

이와 같은 과정을 거치다보면 세 번째 물통(용량이 C인)에 담겨있는 물의 양이 변할 수도 있다. 첫 번째 물통(용량이 A인)이 비어 있을 때, 세 번째 물통(용량이 C인)에 담겨있을 수 있는 물의 양을 모두 구해내는 프로그램을 작성하시오.

입력
첫째 줄에 세 정수 A, B, C가 주어진다.

출력
첫째 줄에 공백으로 구분하여 답을 출력한다. 각 용량은 오름차순으로 정렬한다.

예제 입력 1
8 9 10
예제 출력 1
1 2 8 9 10

 */

public class Main {

	static int A, B, C;
	static boolean[][] visited = new boolean[201][201];
	static boolean[] res = new boolean[201];

	public static void dfs(int a, int b, int c) {
		if (visited[a][b]) { // a와 b의 물의양 고려됐을 경우 c도 정해지므로 2차원 배열로 방문 구분
			return;
		}

		if (a == 0) {
			res[c] = true;
		}

		visited[a][b] = true;

		// a 물통에서 b 물통으로 붓는 경우
		if (a + b > B) {
			dfs((a + b) - B, B, c);
		} else {
			dfs(0, a + b, c);
		}

		// b 물통에서 a 물통으로 붓는 경우
		if (b + a > A) {
			dfs(A, (b + a) - A, c);
		} else {
			dfs(b + a, 0, c);
		}

		// c 물통에서 a 물통으로 붓는 경우
		if (c + a > A) {
			dfs(A, b, (c + a) - A);
		} else {
			dfs(c + a, b, 0);
		}

		// c 물통에서 b 물통으로 붓는 경우
		if (c + b > B) {
			dfs(a, B, (c + b) - B);
		} else {
			dfs(a, c + b, 0);
		}

		// b 물통에서 c로 붓는 경우
		dfs(a, 0, b + c);
		// a 물통에서 c로 붓는 경우
		dfs(0, b, a + c);
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		dfs(0, 0, C);

		for (int i = 0; i < 201; i++) {
			if (res[i]) {
				System.out.printf(i + " ");
			}
		}
    }
}
