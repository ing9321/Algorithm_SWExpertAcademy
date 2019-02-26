package divcon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// 격자판의 숫자 이어붙이기
public class Solution2819 {
	static int[][] map;
	static Set<Integer> result;
	static int[][] pos = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2819.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int test_case=1; test_case<=T; test_case++) {
			map = new int[4][4];
			int max = 0;
			for(int r=0; r<4; r++) {
				String[] strarr = br.readLine().split(" ");
				for(int c=0; c<4; c++) {
					int n = Integer.parseInt(strarr[c]);
					map[r][c] = n;
					max = Math.max(max, n);
				}
			}

			result = new HashSet<Integer>();
			for(int r=0; r<4; r++) {
				for(int c=0; c<4; c++) {
					dfs(r, c, 0, 0);
				}
			}
			
			System.out.println("#" + test_case + " " + result.size());
		}
	}

	private static void dfs(int r, int c, int len, int num) {
		if(len == 7) {
			result.add(num);
			return;
		}
		
		num *= 10;
		num += map[r][c];
		len++;
		for(int p=0; p<4; p++) {
			int nr = r + pos[p][0];
			int nc = c + pos[p][1];
			if(nr >= 0 && nr < 4 && nc >= 0 && nc < 4) {
				dfs(nr, nc, len, num);
			}
		}
		num /= 10;
		len--;
	}
}
