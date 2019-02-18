package strpattern;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

// 패턴 마디의 길이
public class Solution2007 {
	private static char[] text;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input2007.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int test_case=1; test_case<=T; test_case++) {
			text = br.readLine().trim().toCharArray();
			
			System.out.println("#" + test_case + " " + search());
		}
	}
	private static int search() {
		for(int i=1; i<=10; i++) {
			String p1 = String.copyValueOf(text, 0, i);
			String p2 = String.copyValueOf(text, i, i);
			
			if(p1.equals(p2)) {
				return i;
			}
		}
		return 1;
	}
}
