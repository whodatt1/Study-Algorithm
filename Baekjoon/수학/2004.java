import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static long five(long num) {
		int count = 0;
		
		while(num >= 5) {
			count += (num / 5);
			num /= 5;
		}
		return count;
	}
	static long two(long num) {
		int count = 0;
		
		while(num >= 2) {
			count += (num / 2);
			num /= 2;
		}
		return count;
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	long N = Long.parseLong(st.nextToken());
    	long M = Long.parseLong(st.nextToken());
    	
    	// 승수 구하는 공식 (a1 - b1 - c1)
    	long count5 = five(N) - five(N - M) - five(M);
    	long count2 = two(N) - two(N - M) - two(M);
    	
    	System.out.println(Math.min(count5, count2));
    }
}