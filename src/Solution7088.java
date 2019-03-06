import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 은기의 송아지 세기
public class Solution7088 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input7088.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + "\n");
			st = new StringTokenizer(br.readLine().trim());
			int N = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			int[][] cowlevel = new int[N+1][4];
			for (int i = 1; i <= N; i++) {
				int level = Integer.parseInt(br.readLine().trim());
				System.arraycopy(cowlevel[i-1], 0, cowlevel[i], 0, 4);
				cowlevel[i][level]++;
			}
			for (int i = 0; i < Q; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int L = Integer.parseInt(st.nextToken());
				int R = Integer.parseInt(st.nextToken());
				for (int j = 1; j < 4; j++) {
					sb.append(cowlevel[R][j] - cowlevel[L-1][j]);
					sb.append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
