
/*
 
트리 순회
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	40912	26634	20307	66.080%
문제
이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위 순회(postorder traversal)한 결과를 출력하는 프로그램을 작성하시오.



예를 들어 위와 같은 이진 트리가 입력되면,

전위 순회한 결과 : ABDCEFG // (루트) (왼쪽 자식) (오른쪽 자식)
중위 순회한 결과 : DBAECFG // (왼쪽 자식) (루트) (오른쪽 자식)
후위 순회한 결과 : DBEGFCA // (왼쪽 자식) (오른쪽 자식) (루트)
가 된다.

입력
첫째 줄에는 이진 트리의 노드의 개수 N(1 ≤ N ≤ 26)이 주어진다. 둘째 줄부터 N개의 줄에 걸쳐 각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드가 주어진다. 노드의 이름은 A부터 차례대로 알파벳 대문자로 매겨지며, 항상 A가 루트 노드가 된다. 자식 노드가 없는 경우에는 .으로 표현한다.

출력
첫째 줄에 전위 순회, 둘째 줄에 중위 순회, 셋째 줄에 후위 순회한 결과를 출력한다. 각 줄에 N개의 알파벳을 공백 없이 출력하면 된다.

예제 입력 1 
7
A B C
B D .
C E F
E . .
F . G
D . .
G . .
예제 출력 1 
ABDCEFG
DBAECFG
DBEGFCA
 
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static int tree[];
	
	public static void preOrder(int v) {
		int left = 2*v;
		int right = 2*v+1;
		sb.append(toAlpha(v));
		if(tree[left] >= 0) {
			preOrder(tree[left]);
		}
		if(tree[right] >= 0) {
			preOrder(tree[right]);
		}
	}
	public static void inOrder(int v) {
		int left = 2*v;
		int right = 2*v+1;
		if(tree[left] >= 0) {
			inOrder(tree[left]);
		}
		sb.append(toAlpha(v));
		if(tree[right] >= 0) {
			inOrder(tree[right]);
		}
	}
	public static void postOrder(int v) {
		int left = 2*v;
		int right = 2*v+1;
		if(tree[left] >= 0) {
			postOrder(tree[left]);	
		}
		if(tree[right] >= 0) {
			postOrder(tree[right]);
		}
		sb.append(toAlpha(v));
		
	}
	
	static int toIndex(char ch) {
		if (ch == '.') {
			return -1;
		} else {
			return ch - 'A';
		}
	}
	
	static char toAlpha(int idx) {
		return (char) (idx + 'A');
	}
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	tree = new int[2 * N];
    	sb = new StringBuilder();
    	
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		
    		char node = st.nextToken().charAt(0);
    		char left = st.nextToken().charAt(0);
    		char right = st.nextToken().charAt(0);
    		tree[2 * toIndex(node)] = toIndex(left);
    		tree[2 * toIndex(node) + 1] = toIndex(right);
		}
    	
    	preOrder(0);
		sb.append("\n");
		inOrder(0);
		sb.append("\n");
		postOrder(0);
		sb.append("\n");
		System.out.print(sb);
		br.close();
    }
}
