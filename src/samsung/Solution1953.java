package samsung;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * SWEA 1953 탈주범 검거
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PpLlKAQ4DFAUq
 */
public class Solution1953 {
	static int N, M, R, C, L;
	static int[][] map;
	static boolean[][] visit;
	static int[][] pos = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	static ArrayList<ArrayList<Integer>> pipe;
	static HashMap<Integer, boolean[]> hash;
	public static void main(String[] args) throws Exception {
		init();
		System.setIn(new FileInputStream("res/input1953_탈주범검거.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			sb.append('#').append(tc).append(' ');
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visit = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			LinkedList<int[]> queue = new LinkedList<int[]>();
			queue.offer(new int[] {R, C});
			visit[R][C] = true;
			L--;
			int cnt = 1;
			while(L > 0) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					int[] cur = queue.poll();
					boolean[] value = hash.get(map[cur[0]][cur[1]]);
					for (int j = 0; j < 4; j++) {
						if(value[j]) {
							int nx = cur[0] + pos[j][0];
							int ny = cur[1] + pos[j][1];
							if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
							if(pipe.get(j).contains(map[nx][ny])) {
								if(!visit[nx][ny]) {
									cnt++;
									queue.offer(new int[] {nx,ny});
									visit[nx][ny] = true;
								}
							}
						}
						
					}
				}
				L--;
			}
			sb.append(cnt).append('\n');
		}
		System.out.println(sb);
	}
	private static void init() {
		pipe = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < 4; i++) {
			pipe.add(new ArrayList<Integer>());
		}
		pipe.get(0).add(1);
		pipe.get(0).add(3);
		pipe.get(0).add(6);
		pipe.get(0).add(7);
		pipe.get(1).add(1);
		pipe.get(1).add(2);
		pipe.get(1).add(4);
		pipe.get(1).add(7);
		pipe.get(2).add(1);
		pipe.get(2).add(3);
		pipe.get(2).add(4);
		pipe.get(2).add(5);
		pipe.get(3).add(1);
		pipe.get(3).add(2);
		pipe.get(3).add(5);
		pipe.get(3).add(6);
		
		hash = new HashMap<Integer, boolean[]>();
		hash.put(1, new boolean[] {true, true, true, true});
		hash.put(2, new boolean[] {false, true, false, true});
		hash.put(3, new boolean[] {true, false, true, false});
		hash.put(4, new boolean[] {true, false, false, true});
		hash.put(5, new boolean[] {true, true, false, false});
		hash.put(6, new boolean[] {false, true, true, false});
		hash.put(7, new boolean[] {false, false, true, true});
	}
}
