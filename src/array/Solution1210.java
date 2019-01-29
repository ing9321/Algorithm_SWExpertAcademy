package array;

import java.io.*;
import java.util.StringTokenizer;

public class Solution1210 {
	static int T, N;
	static int[][] map;
	static int[] pos = {-1, 1};
	static int destination;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/input1210.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int test_case = 1; test_case <= 10; test_case++) {
			T = Integer.parseInt(br.readLine());
			map = new int[100][100];
			int x = 99;
			int y = 0;
			for(int i=0; i<100; i++) {
				String str = br.readLine();
				StringTokenizer st = new StringTokenizer(str);
				for(int j=0; j<100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken().trim());
					if(map[i][j] == 2) {
						y = j;
					}
				}
			}
			
			toUp(x, y);
			ladder(x, y, 0);
			
			System.out.println("#" + test_case + " " + destination);
		}
	}
	public static void ladder(int x, int y, int dir) {
		if(x == 0) {
			destination = y;
			return;
		}
		
		if(dir < 0) { // 좌
			if(map[x-1][y] != 1) { // 계속 전진 
				
			} else { // 좌로 전진
				
			}
		} else if (dir > 0) { // 우
			if(map[x-1][y] != 1) { // 계속 전진 
				
			} else { // 우로 전진
				
			}
		} else { // 상
			// 위로 전진
		}
	}
	
	public static void toUp(int x, int y) {
		int left = y+pos[0];
		int right = y+pos[1];
		if(left >= 0 && map[x][left] == 1) {
			toLeft(x, left);
		} else if(right < 100 && map[x][right] == 1) {
			toRight(x, right);
		} else {
			toUp(x-1, y);
		}
	}
	public static void toLeft(int x, int y) {
		int left = y+pos[0]; // 좌
		if(left >= 0 && map[x][left] == 1) {
			toLeft(x, left);
		} else {
			toUp(x-1, y);
		}
	}
	public static void toRight(int x, int y) {
		int right = y+pos[1];
		if(right < 100 && map[x][right] == 1) {
			toRight(x, right);
		} else {
			toUp(x-1, y);
		}
	}
}