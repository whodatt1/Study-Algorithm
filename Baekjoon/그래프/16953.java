package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*

A → B
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	512 MB	35821	14832	11825	39.929%
문제
정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같은 두 가지이다.

2를 곱한다.
1을 수의 가장 오른쪽에 추가한다.
A를 B로 바꾸는데 필요한 연산의 최솟값을 구해보자.

입력
첫째 줄에 A, B (1 ≤ A < B ≤ 109)가 주어진다.

출력
A를 B로 바꾸는데 필요한 연산의 최솟값에 1을 더한 값을 출력한다. 만들 수 없는 경우에는 -1을 출력한다.

예제 입력 1
2 162
예제 출력 1
5
2 → 4 → 8 → 81 → 162

예제 입력 2
4 42
예제 출력 2
-1
예제 입력 3
100 40021
예제 출력 3
5
100 → 200 → 2001 → 4002 → 40021

 */

public class Main {

	static long A, B;
	static int cnt;

	public static int bfs(long x) {
		Queue<Long> q = new LinkedList<Long>();
		q.offer(x);

		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				long tmp = q.poll();

				if (tmp == B) {
					return cnt + 1;
				}

				if (tmp * 2 <= B) {
					q.offer(tmp * 2);
				}
				if (tmp * 10 + 1 <= B) {
					q.offer(tmp * 10 + 1);
				}
			}
			cnt++;
		}

		return -1;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		System.out.println(bfs(A));
    }
}
