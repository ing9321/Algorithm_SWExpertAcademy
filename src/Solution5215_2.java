

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution5215_2 {
	static int N, L;
	static int[] Np, Nc;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input5215.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt(); // 재료 수
			L = sc.nextInt(); // 칼로리 제한

			Np = new int[N];
			Nc = new int[N];
			for(int i=0; i<N; i++) {
				Np[i] = sc.nextInt(); // 맛점수
				Nc[i] = sc.nextInt(); // 칼로리
			}
			
			int maxPoint = 0;
			
			boolean[] check = new boolean[N];
			
//			check 갯수
			for(int i=0; i<N; i++) {
				
			}
			
			System.out.println("#"+test_case+" "+maxPoint);
		}
	}
	
}
