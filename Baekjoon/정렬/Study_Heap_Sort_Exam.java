import java.io.IOException;

// 완전 이진 트리 이용
// 최대 힙은 부모노드가 자식노드보다 큰 힙
// 기본적으로 힙 구조를 가지도록 만들자
// 힙 정렬을 수행하기 위해 힙 생성 알고리즘을 사용한다
// 시간 복잡도는 O(log N)

public class Main{
	static int number = 9;
	static int[] heap =  {7, 6, 5, 8, 3, 5, 9, 1, 6};
	
	
    public static void main(String[] args) throws IOException{
    	// 먼저 전체 트리 구조를 힙 구조로 바꿉니다.
    	for (int i = 1; i < number; i++) {
			int c = i;
			do {
				int root = (c - 1) / 2;
				if (heap[root] < heap[c]) {
					int tmp = heap[root];
					heap[root] = heap[c];
					heap[c] = tmp;
				}
				c = root;
			} while (c != 0);
		}
    	// 크기를 줄여가며 반복적으로 힙을 구성
    	for (int i = number - 1; i >= 0; i--) {
			int tmp = heap[0];
			heap[0] = heap[i];
			heap[i] = tmp;
			int root = 0;
			int c = 1;
			do {
				c = 2 * root + 1;
				// 자식 중에 더 큰 값을 찾기
				if (c < i - 1 && heap[c] < heap[c + 1]) {
					c++;
				}
				// 루트보다 자식이 더 크다면 교환
				if (c < i && heap[root] < heap[c]) {
					int tmp2 = heap[root];
					heap[root] = heap[c];
					heap[c] = tmp2;
				}
				root = c;
			} while (c < i);
		}
    	
    	for (int i = 0; i < heap.length; i++) {
			System.out.println(heap[i]);
		}
    }
}