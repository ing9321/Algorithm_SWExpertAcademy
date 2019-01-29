

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution3307 {
	static int N, A;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input3307.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt(); // 수열 길이

			int[] M = new int[N]; // 수열
			for(int i=0; i<N; i++) {
				M[i] = sc.nextInt();
			}

			for(int i=0; i<N; i++) {
				System.out.print(M[i] + " ");
			}
			
			System.out.println();
			
			int[] L = new int[N+1];
			int index = 1;
			
			for(int i=0; i<N-1; i++) {
//				if(M[i] < M[i+1]) {
//					L[index] = M[i];
//				} else {
//					L[index] = M[i+1];
//				}
//				
				if(M[i] < M[i+1] && M[i] > L[index-1]) {
					System.out.println(i + " i");
					L[index] = M[i];
				} else if(M[i] < M[i+1] && M[i+1] > L[index-1]) {
					System.out.println(i + " i+1");
					L[index] = M[i];
				} else if(M[i] > M[i+1] && M[i] > L[index-1]) {
					System.out.println(i + " i+1");
					L[index] = M[i+1];
				} else if(M[i] > M[i+1] && M[i+1] > L[index-1]) {
					System.out.println(i + " i+1");
					L[index] = M[i+1];
				}
				index++;
			}
			
			
			for(int i=0; i<N; i++) {
				System.out.print(L[i] + " ");
			}
			
			System.out.println("#"+test_case+" "+A);
		}
	}
}