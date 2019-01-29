

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution1289 {
	static String N;

	public static void main(String[] args) throws Exception{
//		System.setIn(InputStream) : System.in을 통해 데이터 읽을 대상을 설정
		System.setIn(new FileInputStream("input1289.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.next();
			int count = 0;
			char x='0';
			for(int i=0; i<N.length(); i++) {
				if(N.charAt(i) != x) {
					x = N.charAt(i);
					count++;
				}
			}

			System.out.println("#"+test_case+" "+count);
		}
	}
}
























