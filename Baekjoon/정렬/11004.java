/*

문제
수 N개 A1, A2, ..., AN이 주어진다. A를 오름차순 정렬했을 때, 앞에서부터 K번째 있는 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N(1 ≤ N ≤ 5,000,000)과 K (1 ≤ K ≤ N)이 주어진다.

둘째에는 A1, A2, ..., AN이 주어진다. (-109 ≤ Ai ≤ 109)

출력
A를 정렬했을 때, 앞에서부터 K번째 있는 수를 출력한다.

예제 입력 1 
5 2
4 1 2 3 5
예제 출력 1 
2

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	public static int partition(int[] arr, int start, int end) {
		
		int mid = (start + end) / 2;
		
		int pivot = arr[mid];
		int i = start;
		int j = end;
		
		while(i <= j) {
			while(arr[i] < pivot) {
				i++;
			}
			while(arr[j] > pivot) {
				j--;
			}
			
			if (i <= j) {
				swap(arr, i, j);
				i++;
				j--;
			}
		}
		
		return i;
	}
	
	public static void swap(int[] array, int a, int b) {
		int tmp = array[b];
		array[b] = array[a];
		array[a] = tmp;
	}
	
	public static void quickSort(int[] arr, int start, int end) {
		int i = partition(arr, start, end);
		
		if (start < i - 1) {
			quickSort(arr, start, i -1);
		}
		if (i < end) {
			quickSort(arr, i, end);
		}
	}
	
	public static void main(String[] args) throws Exception {
		// quickSort로 풀이
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		quickSort(arr, 0, N - 1);
		
		System.out.println(arr[K - 1]);
	}
}