

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution5215 {
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
			
			for(int i=0; i<N-1; i++) {
				System.out.println("/////" + i);
				for(int j=i+1; j<N; j++) {
					int point = Np[i];
					int cal = Nc[i];
					
					point = checkCal(j, cal, point);
					
					if(maxPoint < point) {
						maxPoint = point;
					}
				}
			}
			
			System.out.println("#"+test_case+" "+maxPoint);
		}
	}
	
	public static int checkCal(int j, int cal, int point) {
		System.out.println("j : " + j + " cal : " + cal + " point : " + point);
		int i = j;
		int c = cal;
		int p = point;
		
		if(i < N) {			
			if(c + Nc[i] <= L) {
				c += Nc[i];
				p += Np[i];
			}
			i++;
			return checkCal(i, c, p);
		} else {
			return p;
		}
	}
}
