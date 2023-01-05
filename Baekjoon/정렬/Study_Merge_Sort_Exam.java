
// 병합정렬 예제 공부
// 시간 복잡도 O(N * logN)
// 일단 반으로 나누고 나중에 합쳐서 정렬
// 항시 시간 복잡도 0(N * logN)을 보장

import java.io.IOException;

public class Main{
	static int number = 8;
	static int[] sorted = new int[8]; // 정렬 배열은 반드시 전역 변수로 선언
	
	static void merge(int[] a, int m, int middle, int n) {
		int i = m;
		int j = middle + 1;
		int k = m;
		// 작은 순서대로 배열에 삽입
		while(i <= middle && j <= n) {
			if (a[i] <= a[j]) {
				sorted[k] = a[i];
				i++;
			} else {
				sorted[k] = a[j];
				j++;
			}
			k++;
		}
		// 남은 데이터도 삽입
		if (i > middle) {
			for (int k2 = j; k2 <= n; k2++) {
				sorted[k] = a[k2];
			}
		} else {
			for (int k2 = i; k2 <= middle; k2++) {
				sorted[k] = a[k2];
				k++;
			}
		}
		// 정렬된 데이터를 삽입
		for (int k2 = m; k2 <= n; k2++) {
			a[k2] = sorted[k2];
		}
	}
	
	static void mergeSort(int a[], int m, int n) {
		// 크기가 1보다 큰 경우
		if (m < n) {
			int middle = (m + n) / 2;
			mergeSort(a, m, middle);
			mergeSort(a, middle + 1, n);
			merge(a, m, middle, n);
		}
	}
	
    public static void main(String[] args) throws IOException{
    	int[] array = {7, 6, 5, 8, 3, 5, 9, 1};
    	mergeSort(array, 0, number - 1);
    	
    	for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
    }
}