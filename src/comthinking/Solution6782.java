package comthinking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution6782 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input6782.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int test_case=1; test_case<=T; test_case++) {
			long N = Long.parseLong(br.readLine().trim());
			int cnt = 0;
			while(true) {
				if(N == 2) {
					break;
				}
				
				long K = (long) Math.sqrt(N);
				if(K*K == N) {
					N = K;
					cnt++;
				} else {
					long tmp = (K+1)*(K+1);
					cnt += tmp - N;
					N = tmp;
				}
			}
			System.out.println("#" + test_case + " " + cnt);
		}
	}
}
