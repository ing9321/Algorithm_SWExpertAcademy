package numbers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1240 {
	static int A;
	static char[][] map;
	static Map<String, String> hashMap;
	static List<Integer> codes;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1240.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		hashMap = new HashMap<String, String>();
		hashMap.put("0", "0001101");
		hashMap.put("1", "0011001");
		hashMap.put("2", "0010011");
		hashMap.put("3", "0111101");
		hashMap.put("4", "0100011");
		hashMap.put("5", "0110001");
		hashMap.put("6", "0101111");
		hashMap.put("7", "0111011");
		hashMap.put("8", "0110111");
		hashMap.put("9", "0001011");
		
		int T = Integer.parseInt(br.readLine().trim());
		for(int test_case=1; test_case<=T; test_case++) {
			String[] NM = br.readLine().split(" ");
			int N = Integer.parseInt(NM[0]);
			int M = Integer.parseInt(NM[1]);
			map = new char[N][M];
			for(int n=0; n<N; n++) {
				map[n] = br.readLine().toCharArray();
			}
			
			boolean isCode = false;
			for(int n=0; n<N; n++) {
				for(int m=M-1; m>=0; m--) {
					if(map[n][m] == '1') {
						codes = new ArrayList<Integer>();
						A = 0;
						calCode(n, m-55, m);
						checkCode();
						isCode = true;
						break;
					}
				}
				if(isCode) {
					break;
				}
			}
			System.out.println("#" + test_case + " " + A);
		}
	}
	
	public static void calCode(int line, int start, int end) {
		if(start > end) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<7; i++) {
			sb.append(map[line][start+i]);
		}

		for(String key : hashMap.keySet()) {
			if(hashMap.get(key).equals(sb.toString())) {
				codes.add(Integer.parseInt(key));
			}
		}
		
		calCode(line, start+7, end);
	}
	public static void checkCode() {
		int sum = (codes.get(0) + codes.get(2) + codes.get(4) + codes.get(6)) * 3 + codes.get(1) + codes.get(3) + codes.get(5) + codes.get(7);
		if(sum%10 == 0) {
			for(int c : codes) {
				A += c;
			}
		}
	}
}
