package samsung;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * SWEA 1949 등산로 조성
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PoOKKAPIDFAUq
 * DFS, Back tracking
 */
public class Solution1949 {
	static int N, K, MAX;
	static int[][] map;
	static boolean[][] visit;
	static int[][] pos = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	static LinkedList<int[]> highest;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1949_등산로조성.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			sb.append('#').append(tc).append(' ');
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			MAX = Integer.MIN_VALUE;

			map = new int[N][N];
			visit = new boolean[N][N];
			highest = new LinkedList<int[]>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(highest.isEmpty()) {
						highest.offer(new int[] {i, j, map[i][j]});
					} else {
						if(highest.peek()[2] > map[i][j]) continue;
						if(highest.peek()[2] < map[i][j]) highest.clear();
						highest.offer(new int[] {i, j, map[i][j]});
					}
				}
			}
			
			while(!highest.isEmpty()) {
				int[] start = highest.poll();
				dfs(start[0], start[1], 0, 1);
			}
			
			sb.append(MAX).append('\n');
		}
		System.out.println(sb);
	}

	private static void dfs(int x, int y, int k, int cnt) {
		MAX = Math.max(MAX, cnt);
		
		visit[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + pos[i][0];
			int ny = y + pos[i][1];
			if(nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny]) continue;
			if(k == 0) {
				for (int j = 0; j <= K; j++) {
					if(map[nx][ny] - j < map[x][y]) {
						map[nx][ny] = map[nx][ny] - j;
						dfs(nx, ny, j, cnt+1);
						map[nx][ny] = map[nx][ny] + j;
					}
				}
			} else {
				if(map[nx][ny] < map[x][y]) {
					dfs(nx, ny, k, cnt+1);
				}
			}
		}
		visit[x][y] = false;
	}
}
