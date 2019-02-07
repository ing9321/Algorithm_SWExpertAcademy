package comthinking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution5607 {
	static long P;
	static long[] fac, inv;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input5607.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		P = 1234567891;
		fac = new long[1000001];
		inv = new long[1000001];
		fac[0] = 1;
		fac[1] = 1;
		for(int i=2; i<=1000000; i++) {
			fac[i] = fac[i-1] * i % P;
		}
		
		inv[1000000] = power(fac[1000000], P-2);
		for(int i=1000000-1; i>0; i--) {
			inv[i] = (inv[i+1] * (i+1)) % P;
		}
		
		for(int test_case=1; test_case<=T; test_case++) {
			String[] strarr = br.readLine().split(" ");
			int N = Integer.parseInt(strarr[0]);
			int R = Integer.parseInt(strarr[1]);
			
			long result = (fac[N] * inv[N-R]) % P;
			result = (result * inv[R]) % P;
			System.out.println("#" + test_case + " " + result);
		}
	}
	private static long power(long x, long y) {
		long ret = 1;
		while(y>0) {
			if(y%2 == 1) {
				ret *= x;
				ret %= P;
			}
			x *= x;
			x %= P;
			y /= 2;
		}
		return ret;
	}
}
