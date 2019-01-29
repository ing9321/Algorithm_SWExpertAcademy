

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution1289S1 {
	
	public static void main(String[] args) throws Exception{
//		System.setIn(InputStream) : System.in을 통해 데이터 읽을 대상을 설정
		System.setIn(new FileInputStream("input1289.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String data = sc.next();
			int size = data.length();
			StringBuilder nData = new StringBuilder(data);
			int N = 1;
			int idx = data.indexOf("1"); // 첫 1의 위치 구하기
			for(int i=idx; i<size;) {
				change(nData, i, size, ""+(N%2));
//				변경 후 원래 메모리 값과 같은지 비교
				if(data.equals(nData.toString())) {
					break;
				}
				for(int j=i+1; j<size; j++) {
					if(data.charAt(j) != nData.charAt(j)) {
						i = j;
						break;
					}
				}
				N++;
			}
			
			System.out.println("#"+test_case+" " + N);
		}
	}

	private static void change(StringBuilder nData, int start, int size, String fill) {
		// TODO Auto-generated method stub
		for(int i=start; i<size; i++) {
			nData.replace(i, i+1, fill);
		}
	}
}
























