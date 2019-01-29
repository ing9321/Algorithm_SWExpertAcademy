package stack;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution1218 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input1218.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int test_case=1; test_case<=10; test_case++){
			int size = Integer.parseInt(br.readLine().trim());
			String S = br.readLine().trim();
			Stack<Character> stack = new Stack<Character>();
			boolean isNotMatch = false;
			for(int i=0; i<size; i++){
				char s = S.charAt(i);
				if(s == '{' || s == '[' || s == '(' || s == '<'){
					stack.push(s);
				} else if(!stack.isEmpty()) {
					if(s == '}' && stack.peek() == '{'){
						stack.pop();
					} else if(s == ']' && stack.peek() == '['){
						stack.pop();
					} else if(s == ')' && stack.peek() == '('){
						stack.pop();
					} else if(s == '>' && stack.peek() == '<'){
						stack.pop();
					} else {
						isNotMatch = true;
						break;
					}
				}
			}
			if(!isNotMatch){
				System.out.println("#"+test_case + " 1");
			} else {
				System.out.println("#"+test_case + " 0");
			}
			stack.clear();
		}
	}

}
