package stack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_D3_1234_비밀번호 {
	public static void main(String[] args) throws Exception {
//		BufferedReader in = new BufferedReader(new FileReader("res/d3_1234.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		Stack<Character> stack = new Stack<>();
		StringBuilder sb;
		String line;
		String[] tokens;
		for (int testcase = 1; testcase <=T; testcase++) {
			line = in.readLine().trim();
			tokens = line.split(" ");
			int N = Integer.parseInt(tokens[0]);
			line = tokens[1];
			stack.push(line.charAt(0));
			char data;
			int size;
			for (int i = 1; i <N; i++) {
				data = line.charAt(i);
				if(!stack.isEmpty() && stack.peek() == data) {
					stack.pop();
				}else {
					stack.push(data);
				}
			}
			size = stack.size();
			sb = new StringBuilder(size);
			for (int i = 0; i < size; i++) {
				sb.insert(0, stack.pop());
			}
			stack.clear();
			System.out.println("#"+testcase+" "+sb.toString());
		}
	}
}










