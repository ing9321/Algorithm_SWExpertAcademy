package divcon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 하나로 : PRIM
public class Solution1251 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1251.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			ArrayList<Integer> Xs = new ArrayList<Integer>();
			ArrayList<Integer> Ys = new ArrayList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				Xs.add(Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				Ys.add(Integer.parseInt(st.nextToken()));
			}
			double E = Double.parseDouble(br.readLine().trim());
			
			double[][] map = new double[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(i < j) {
						int x1 = Xs.get(i);
						int x2 = Xs.get(j);
						int y1 = Ys.get(i);
						int y2 = Ys.get(j);
						double EL2 = 0;
						if(x1 == x2 || y1 == y2) {
							long L2 = (x2-x1) + (y2-y1);
							EL2 = E * L2 * L2;
						} else {
							int xx = x2 - x1;
							int yy = y2 - y1;
							EL2 = (E * xx * xx) + (E * yy * yy);
						}
						map[i][j] = EL2;
						map[j][i] = EL2;
					}
				}
			}

			ArrayList<Integer> selected = new ArrayList<Integer>();
			boolean[] visited = new boolean[N];
			int index;
			double min;
			selected.add(0);
			visited[0] = true;
			double result = 0;
			for(int i=0; i<N-1; i++) {
				min = Double.MAX_VALUE;
				index = 0;
				for(Integer v : selected) {
					for(int j=0; j<N; j++) {
						if(map[v][j] > 0 && !visited[j] && map[v][j] < min) {
							min = map[v][j];
							index = j;
						}
					}
				}
				result += min;
				selected.add(index);
				visited[index] = true;
			}
			
			System.out.println("#" + tc + " " + Math.round(result));
		}
	}
}
