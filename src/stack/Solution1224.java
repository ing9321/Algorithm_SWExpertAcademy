package stack;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution1224 {
	static Stack<Character> operators;
	static Stack<Integer> stack;
	public static int getPriorty(char ch, boolean isInstack) {
		switch(ch) {
		case '+':
			return 1;
		case '*':
			return 2;
		default:
			return isInstack ? 0 : 3;
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
		System.setIn(new FileInputStream("res/input1224.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for(int test_case=1; test_case<=T; test_case++) {
			int size = Integer.parseInt(br.readLine().trim());
			operators = new Stack<Character>();
			stack = new Stack<Integer>();
			
			char[] line = br.readLine().trim().toCharArray();
			for(int i=0; i<size; i++) {
				char c = line[i];
				if(Character.isDigit(c)) {
					stack.push(c-'0');
				} else if(c == ')') {
					while(!operators.isEmpty() && operators.peek() != '(') {
						calc();
					}
					operators.pop();
				} else {
					while(!operators.isEmpty()) { // 
						if(getPriorty(operators.peek(), true) < getPriorty(c, false)) {
							break;
						}
						calc();
					}
					operators.push(c);
				}
			}
			while(!operators.isEmpty()) {
				calc();
			}
			System.out.println("#" + test_case + " " + stack.pop());
		}
	}

}
