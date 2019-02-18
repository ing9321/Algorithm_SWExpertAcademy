package strpattern;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution1213 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1213.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int T=1; T<=10; T++) {
			br.readLine();
			String pattern = br.readLine().trim();
			String text = br.readLine().trim();
			int cnt = 0;
			while(true){
				int idx = text.indexOf(pattern);
				if(idx == -1) {
					break;
				}
				cnt++;
				text = text.substring(idx+1);
			}
			System.out.println("#" + T + " " + cnt);
		}
	}
}
