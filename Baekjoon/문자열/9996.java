package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



/*

한국이 그리울 땐 서버에 접속하지 다국어
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	15126	4224	3139	26.829%
문제
선영이는 이번 학기에 오스트레일리아로 교환 학생을 가게 되었다.

호주에 도착하고 처음 며칠은 한국 생각을 잊으면서 즐겁게 지냈다. 몇 주가 지나니 한국이 그리워지기 시작했다.

선영이는 한국에 두고온 서버에 접속해서 디렉토리 안에 들어있는 파일 이름을 보면서 그리움을 잊기로 했다. 매일 밤, 파일 이름을 보면서 파일 하나하나에 얽힌 사연을 기억하면서 한국을 생각하고 있었다.

어느 날이었다. 한국에 있는 서버가 망가졌고, 그 결과 특정 패턴과 일치하는 파일 이름을 적절히 출력하지 못하는 버그가 생겼다.

패턴은 알파벳 소문자 여러 개와 별표(*) 하나로 이루어진 문자열이다.

파일 이름이 패턴에 일치하려면, 패턴에 있는 별표를 알파벳 소문자로 이루어진 임의의 문자열로 변환해 파일 이름과 같게 만들 수 있어야 한다. 별표는 빈 문자열로 바꿀 수도 있다. 예를 들어, "abcd", "ad", "anestonestod"는 모두 패턴 "a*d"와 일치한다. 하지만, "bcd"는 일치하지 않는다.

패턴과 파일 이름이 모두 주어졌을 때, 각각의 파일 이름이 패턴과 일치하는지 아닌지를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 파일의 개수 N이 주어진다. (1 ≤ N ≤ 100)

둘째 줄에는 패턴이 주어진다. 패턴은 알파벳 소문자와 별표(아스키값 42) 한 개로 이루어져 있다. 문자열의 길이는 100을 넘지 않으며, 별표는 문자열의 시작과 끝에 있지 않다.

다음 N개 줄에는 파일 이름이 주어진다. 파일 이름은 알파벳 소문자로만 이루어져 있고, 길이는 100을 넘지 않는다.

출력
총 N개의 줄에 걸쳐서, 입력으로 주어진 i번째 파일 이름이 패턴과 일치하면 "DA", 일치하지 않으면 "NE"를 출력한다.

참고로, "DA"는 크로아티어어로 "YES"를, "NE"는 "NO"를 의미한다.

예제 입력 1
3
a*d
abcd
anestonestod
facebook
예제 출력 1
DA
DA
NE
예제 입력 2
6
h*n
huhovdjestvarnomozedocisvastan
honijezakon
atila
je
bio
hun
예제 출력 2
DA
DA
NE
NE
NE
DA

 */

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		String pattern = br.readLine();

		int starIndex = pattern.indexOf("*");

		String before = pattern.substring(0, starIndex);
		String after = pattern.substring(starIndex + 1, pattern.length());

		for (int i = 0; i < N; i++) {
			String fileName = br.readLine();

			if (fileName.length() < pattern.length() - 1) {
				System.out.println("NE");
				continue;
			}

			if (fileName.substring(0, before.length()).equals(before) && fileName.substring(fileName.length() - after.length()).equals(after)) {
				System.out.println("DA");
			} else {
				System.out.println("NE");
			}
		}
    }

}
