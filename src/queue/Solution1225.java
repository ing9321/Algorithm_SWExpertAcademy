package queue;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution1225 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1225.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int test_case=1; test_case<=10; test_case++) {
			String tc = br.readLine();
			String[] strs = br.readLine().trim().split(" ");
			LinkedList<Integer> numbers = new LinkedList();
			for(int i=0, size=strs.length; i<size; i++) {
				numbers.offer(Integer.parseInt(strs[i]));
			}
			while(numbers.peekLast() != 0) {
				for(int i=1; i<6; i++) {
					int number = numbers.poll();
					number -= i;
					if(number <= 0) {
						number = 0;
					}
					numbers.offer(number);
					if(numbers.peekLast() == 0) {
						break;
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#");
			sb.append(test_case);
			for(int number : numbers) {
				sb.append(" ");
				sb.append(number);
			}
			System.out.println(sb.toString());
		}
	}

}
