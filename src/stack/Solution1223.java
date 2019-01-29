package stack;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution1223 {
	static Stack<Character> operators;
	static Stack<Integer> stack;
	public static int getPriorty(char ch) {
		switch(ch) {
		case '+':
			return 1;
		case '*':
			return 2;
		default:
			return 0;
		}
	}
	public static void calc() {
		char op = operators.pop();
		int y = stack.pop();
		int x = stack.pop();
		int z = 0;
		switch(op) {
		case '+':
			z = x + y;
			break;
		case '*':
			z = x * y;
			break;
		}
		stack.push(z);
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1223.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for(int test_case=1; test_case<=T; test_case++) {
			int size = Integer.parseInt(br.readLine().trim());
			operators = new Stack<Character>();
			stack = new Stack<Integer>();
			
			char[] line = br.readLine().trim().toCharArray();
			for(int i=0; i<size; i++) {
				char ch = line[i];
				if(Character.isDigit(ch)) {
					stack.push(ch - '0');
				} else {
					while(!operators.isEmpty()) { 
						if(getPriorty(operators.peek()) < getPriorty(ch)) {
							break;
						}
						calc();
					}
					operators.push(ch);
				}
			}
			while(!operators.isEmpty()) {
				calc();
			}
			System.out.println("#" + test_case + " " + stack.pop());
		}
	}

}
