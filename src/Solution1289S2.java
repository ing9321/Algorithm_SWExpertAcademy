

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution1289S2 {

	public static void main(String[] args) throws Exception {
//		System.setIn(InputStream) : System.in을 통해 데이터 읽을 대상을 설정
		System.setIn(new FileInputStream("input1289.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String data = sc.next();
			int size = data.length();
			int N = 0;
//			첫 시작이 1이면 1로 채워야 하므로 변경값을 증가
			if(data.startsWith("1")) {
				N++;
			}
			for(int i=0; i<size-1; i++) {
				if(data.charAt(i) != data.charAt(i+1)) {
					N++;
				}
			}
			
			System.out.println("#"+test_case+" " + N);
		}
	}

}
