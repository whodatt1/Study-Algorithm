import java.io.IOException;
// 퀵정렬 예제 공부
// 시간 복잡도 O(N * logN)
// 특정한 값을 기준(피벗)으로 큰숫자와 작은 숫자를 나눔
// 항시 시간 복잡도 0(N * logN)을 보장하지 못함
// ex ) 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 일 경우
public class Main{
	static int number = 10;
	static int[] data = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
	
	static void quickSort(int[] data, int start, int end) {
		if (start >= end) { // 원소가 한개인 경우
			return;
		}
		
		int key = start; // 키는 첫번째 원소
		int i = start + 1;
		int j = end;
		int tmp = 0;
		
		while (i <= j) { // 엇갈릴 때까지 반복
			while(i <= end && data[i] <= data[key]) { // 키 값보다 큰 값을 만날때 까지
				i++;
			}
			while(j > start && data[j] >= data[key]) { // 키 값보다 작은 값을 만날때 까지
				j--;
			}
			if (i > j) { // 현재 엇갈린 상태면 키값과 교체
				tmp = data[j];
				data[j] = data[key];
				data[key] = tmp;
			} else {
				tmp = data[j];
				data[j] = data[i];
				data[i] = tmp;
			}
		}
		
		// 엇갈려서 빠져나왔을때 재귀
		quickSort(data, start, j - 1);
		quickSort(data, j + 1, end);
	}
	
    public static void main(String[] args) throws IOException{
    	quickSort(data, 0, number - 1);
    	for (int i = 0; i < number; i++) {
			System.out.println(data[i]);
		}
    }
}