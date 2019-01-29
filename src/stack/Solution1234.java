package stack;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution1234 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1234.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int test_case=1; test_case<=10; test_case++){
			String str = br.readLine().trim();
			StringTokenizer st = new StringTokenizer(str);
			int size = Integer.parseInt(st.nextToken().trim());
			String numbers = st.nextToken().trim();
			Stack<Character> stack = new Stack<Character>();
			
			for(int i=0; i<size; i++) {
				char c = numbers.charAt(i);
				if(!stack.isEmpty()) {
					if(stack.peek() != c) {
						stack.push(c);
					} else {
						stack.pop();
					}
				} else {
					stack.push(c);
				}
			}
			
			StringBuilder sb = new StringBuilder(stack.size());
			for(int i=0, s=stack.size(); i<s; i++) {
//				sb.append(stack.get(i));
				sb.insert(0, stack.pop());
			}
			System.out.println("#" + test_case + " " + sb.toString());
			stack.clear();
		}
	}
}
