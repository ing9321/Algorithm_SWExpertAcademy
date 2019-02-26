package dfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3307_DFS {
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
			dfs(0, 0, 0);
			System.out.println("#" + tc + " " + max);
		}
	}
	/*
	 * @param idx 숫자 index
	 * @param cnt 수열 개수
	 * @param pre 이전 숫자
	 */
	public static void dfs(int idx, int cnt, int pre) {
		if(idx == N) {
			max = Math.max(max, cnt);
			return;
		}
		if(numbers[idx] > pre) {
			dfs(idx+1, cnt+1, numbers[idx]);
		}
		dfs(idx+1, cnt, pre);
	}
}
