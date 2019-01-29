package tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1233 {
	static int N, index;
	static char[] tree;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input1233.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int test_case = 1; test_case <= 10; test_case++) {
			N = Integer.parseInt(br.readLine().trim());
			tree = new char[N+1];
			for(int i=1; i<=N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				tree[i] = st.nextToken().charAt(0);
			}
			sb = new StringBuilder();
			inorder(1);
			String str = sb.toString();
			int result = 1;
			for(int i=1; i<N; i=i+2) {
				if(Character.isDigit(str.charAt(i))) {
					result = 0;
					break;
				}
			}
			System.out.println("#" + test_case + " " + result);
		}
	}
	public static void inorder(int index) {
		if(index <= N && tree[index] != 0) {
			inorder(2*index);
			sb.append(tree[index]);
			inorder(2*index+1);
		}
	}
}