package stack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Solution5432 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("res/input5432.txt"));
		int T = Integer.parseInt(in.readLine().trim());
		for(int test_case = 1; test_case <= T; test_case++) {
			String N = in.readLine().trim();
			int size = N.length();
			int count = 0;
			Stack<Character> stack = new Stack<Character>();
			char next ;
			for(int i=0; i<size; i++) {
				System.out.println(stack.toString() + " " + count);
				next = N.charAt(i) ;
				if(next=='(') {
					stack.push(next);
				} else {
					if(!stack.isEmpty() && N.charAt(i-1) == ')') {
						stack.pop();
						count += 1;
					} else if(!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
						count += stack.size();
					}
				}
			}
			System.out.println("#"+test_case + " " + count);
			stack.clear();
		}
	}
}
