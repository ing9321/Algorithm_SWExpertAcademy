package list;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution1228 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1228.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int test_case=1; test_case<=10; test_case++) {
			int N = Integer.parseInt(br.readLine().trim()); // 원본 암호문 길이
			LinkedList<String> list = new LinkedList<String>();
			// 원본암호문
			StringTokenizer stn = new StringTokenizer(br.readLine().trim());
			for(int i=0; i<N; i++) {
				list.add(stn.nextToken().trim());
			}
			// 명령어 횟수
			int M = Integer.parseInt(br.readLine().trim());
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for(int i=0; i<M; i++) {
				st.nextToken(); // 명령어 시작
				int index = Integer.parseInt(st.nextToken().trim()); // index 위치
				int count = Integer.parseInt(st.nextToken().trim()); // 추가갯수
				for(int j=index, size=index+count; j<size; j++) {
					list.add(j, st.nextToken().trim());
				}
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<10; i++) {
				sb.append(" ");
				sb.append(list.get(i));
			}
			
			System.out.println("#" + test_case + sb.toString());
		}
	}

}
