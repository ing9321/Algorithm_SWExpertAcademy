package dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution3307_DP {
	static int N;
	static int max;
	static int[] numbers;
	static int[] choice;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3307.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc=1; tc<=T; tc++) {
			max = Integer.MIN_VALUE;
			N = Integer.parseInt(br.readLine());
			numbers = new int[N];
			choice = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < N; i++) {
				choice[i] = 1;
				for (int j = 0; j <= i-1; j++) {
					if(numbers[j] < numbers[i] && 1 + choice[j] > choice[i]) {
						choice[i] = 1 + choice[j];
						max = Math.max(max, choice[i]);
					}
				}
			}
			
			System.out.println("#" + tc + " " + max);
		}
	}
}
