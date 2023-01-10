/*

문제
요세푸스 문제는 다음과 같다.

1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.

N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 100,000)

출력
예제와 같이 요세푸스 순열을 출력한다.

예제 입력 1 
7 3
예제 출력 1 
<3, 6, 2, 7, 5, 1, 4>

-- 세그먼트 트리 요구.. 모르는 알고리즘이라 공부하며 참조하여 문제 해결하였다.. 쉽지 않다..
-- 이해가 완벽히 되지않아 추후 같은 유형의 문제를 풀어봐야겠다

*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main {
	
	static class SegmentTree {
		private long[] tree;
		
		// 배열길이 지정
		public SegmentTree(int n) {
			// 트리 높이
			int treeHeight = (int) Math.ceil(Math.log(n)/Math.log(2));
			// 트리의 노드 수
			int treeNodeCount = (int) Math.round(Math.pow(2, treeHeight + 1));
			tree = new long[treeNodeCount];
		}
		
		// 세그먼트 트리 초기화
		long init(int node, int start, int end) {
			// 리프 노드의 경우
			if (start == end) {
				return tree[node] = 1;
			} else {
				int mid = (start + end) / 2;
				return tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
			}
		}
		
		// 노드 업데이트
		int update(int node, int start, int end, int del) {
			tree[node]--;
			if (start == end) {
				return 0;
			} else {
				int mid = (start + end) / 2;
				if (del <= mid) {
					return update(2 * node, start , mid, del);
				} else {
					return update(2 * node + 1, mid + 1, end, del);
				}
			}
		}
		
		// order번째 숫자 가져오기
		int getNum(int node, int start, int end, int order) {
			if (start == end) {
				return start;
			}
			int mid = (start + end) / 2;
			
			if (order <= tree[2 * node]) {
				return getNum(2 * node, start , mid, order);
			} else {
				return getNum(2 * node + 1, mid + 1, end, (int) (order - tree[2 * node]));
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		SegmentTree stree = new SegmentTree(N);
		stree.init(1, 1, N);
		
		int index = 1;
		
		sb.append("<");
		for (int i = 0; i < N; i++) {
			int size = N - i;
			index += K - 1;
			
			if (index % size == 0) {
				index = size;
			} else if (index > size) {
				index %= size;
			}
			
			int num = stree.getNum(1, 1, N, index);
			stree.update(1, 1, N, num);
			
			sb.append(num);
			
			if (i != N - 1) {
				sb.append(", ");
			}
		}
		sb.append(">");
		
		System.out.println(sb);
	}
};