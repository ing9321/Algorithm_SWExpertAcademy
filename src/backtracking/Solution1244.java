package backtracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution1244 {
	static char[] numbers;
	static int size, exchange, MAX;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1244.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int test_case=1; test_case<=T; test_case++) {
			String[] str = br.readLine().split(" ");
			numbers = str[0].toCharArray();
			size = numbers.length;
			exchange = Integer.parseInt(str[1]);
			MAX = Integer.parseInt(new String(numbers));
			exchange(0, 0);
			
			System.out.println("#" + test_case + " " + MAX);
		}
	}
	
	public static void exchange(int idx, int cnt) {
		if(cnt == exchange) {
//			System.out.println(Arrays.toString(numbers));
			int result = Integer.parseInt(new String(numbers));
			MAX = Math.max(MAX, result);
			return;
		}
		for(int i=idx; i<size-1; i++) {
			for(int j=i+1; j<size; j++) {
//				System.out.println(i + ": " + numbers[i] + "<->" + j + ": " +numbers[j] + " cnt : " + cnt);
				if(numbers[i] <= numbers[j]) {
					char tmp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = tmp;
					exchange(i, cnt+1);
					numbers[j] = numbers[i];
					numbers[i] = tmp;					
				}
			}
		}
	}
}
