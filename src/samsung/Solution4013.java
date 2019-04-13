package samsung;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution4013 {
	static int K;
	static ArrayList<ArrayList<Integer>> magnets;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input4013_특이한자석.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			sb.append('#').append(tc).append(' ');
			K = Integer.parseInt(br.readLine().trim());
			magnets = new ArrayList<ArrayList<Integer>>();
			for (int i = 0; i < 4; i++) {
				magnets.add(new ArrayList<Integer>());
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < 8; j++) {
					magnets.get(i).add(Integer.parseInt(st.nextToken()));
				}
			}
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int num = Integer.parseInt(st.nextToken()) - 1;
				int dir = Integer.parseInt(st.nextToken());
				
				left(num, dir);
				turn(num, dir * (-1));
				right(num, dir);
			}
			
			int sum = magnets.get(0).get(0) * 1;
			sum += magnets.get(1).get(0) * 2;
			sum += magnets.get(2).get(0) * 4;
			sum += magnets.get(3).get(0) * 8;
			sb.append(sum).append('\n');
		}
		System.out.println(sb);
	}

	private static void left(int num, int dir) {
		if(num >= 1 && magnets.get(num).get(6) != magnets.get(num-1).get(2)) {
			left(num-1, dir*(-1));
		}
		turn(num, dir);
	}
	private static void right(int num, int dir) {
		if(num < 3 && magnets.get(num).get(2) != magnets.get(num+1).get(6)) {
			right(num+1, dir*(-1));
		}
		turn(num, dir);
	}
	private static void turn(int num, int dir) {
		if(dir > 0) {
			int last = magnets.get(num).size() - 1;
			int data = magnets.get(num).get(last);
			magnets.get(num).remove(last);
			magnets.get(num).add(0, data);
		} else {
			int data = magnets.get(num).get(0);
			magnets.get(num).remove(0);
			magnets.get(num).add(data);
		}
	}
}
