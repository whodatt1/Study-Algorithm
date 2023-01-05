import java.io.IOException;

// 범위 조건이 있는 경우에 한해 굉장히 빠른 알고리즘
// 시간 복잡도 무려 O(N)
// 크기를 기준으로 세는 알고리즘

public class Main{
	
    public static void main(String[] args) throws IOException{
    	int tmp;
    	int[] count = new int[5];
    	int[] array = {
    			1, 3, 2, 4, 3, 2, 5, 3, 1, 2,
    			3, 4, 4, 3, 5, 1, 2, 3, 5, 2,
    			3, 1, 4, 3, 5, 1, 2, 1, 1, 1
    	};
    	for (int i = 0; i < 5; i++) {
			count[i] = 0;
		}
    	for (int i = 0; i < 30; i++) {
			count[array[i] - 1]++;
		}
    	for (int i = 0; i < 5; i++) {
			if (count[i] != 0) {
				for (int j = 0; j < count[i]; j++) {
					System.out.println(i + 1);
				}
			}
		}
    }
}