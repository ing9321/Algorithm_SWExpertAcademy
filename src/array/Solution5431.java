package array;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution5431 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input5431.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt(); // 수강생
			int K = sc.nextInt(); // 제출한 사람의 수
			
			int[] nk = new int[N+1];
			for(int i=1; i<=K; i++) {
				int n = sc.nextInt();
				nk[n] = 1;
			}

			System.out.print("#"+test_case+" ");
			for(int i=1; i<=N; i++) {
				if(nk[i] != 1) {
					System.out.print(i + " ");
				}
			}
			System.out.println();
		}
	}
}
