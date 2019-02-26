package dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution1256 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1256.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc=1; tc<=T; tc++) {
			int K = Integer.parseInt(br.readLine().trim());
			String str = br.readLine().trim();
			int size = str.length();
			String[] strarr = new String[size];
			for(int i=0; i<size; i++) {
				strarr[i] = str.substring(i);
			}
			Arrays.sort(strarr);
			String result = "none";
			if(K < size) {
				result = strarr[K-1];
			}
			System.out.println("#" + tc + " " + result);
		}
	}
}
