package comthinking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution6719 {
	static int N, K;
	static int[] M, C;
	static double MAX;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input6719.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int test_case=1; test_case<=T; test_case++) {
			String[] NK = br.readLine().split(" ");
			N = Integer.parseInt(NK[0]);
			K = Integer.parseInt(NK[1]);
			MAX = 0;
			
			String[] Ms = br.readLine().split(" ");
			int[] M = new int[N];
			for(int i=0; i<N; i++) {
				M[i] = Integer.parseInt(Ms[i]);
			}
			
			Arrays.sort(M);

			for(int i=N-K; i<N; i++) {
				MAX = (MAX+M[i]) / 2;
			}
			
			System.out.printf("#%d %.6f\n", test_case, MAX);
		}
	}
}
