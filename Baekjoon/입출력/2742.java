/*

-문제
자연수 N이 주어졌을 때, N부터 1까지 한 줄에 하나씩 출력하는 프로그램을 작성하시오.

-입력
첫째 줄에 100,000보다 작거나 같은 자연수 N이 주어진다.

-출력
첫째 줄부터 N번째 줄 까지 차례대로 출력한다.

*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int time = Integer.parseInt(br.readLine());
		for (int i = time; i > 0; i--) {
			bw.write(i +"\n");
		}
		bw.close();
		}
}