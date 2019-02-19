package graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

// 최소 스패닝 트리
public class Solution3124 {
	static int[] p; // 부모 노드를 표현하는 배열
	static long result;
	static class Node implements Comparable<Node> {
		int A; // from
		int B; // to
		int C; // 가중치
		public Node(int a, int b, int c) {
			super();
			A = a;
			B = b;
			C = c;
		}
		@Override
		public int compareTo(Node node) {
			// TODO Auto-generated method stub
			return this.C - node.C > 0 ? 1 : -1; // 오름차순 정렬
		}
	}
	
	public static void makeSet(int x) {
		p[x] = x; // 대표 노드를 자기 자신으로 설정
	}
	
	public static int findSet(int x) {
		if(p[x] == x) {
			return x;
		} else {
			p[x] = findSet(p[x]);
			return p[x];
		}
	}
	
	public static void union(Node node) {
		int root1 = findSet(node.A); // A의 부모
		int root2 = findSet(node.B); // B의 부모
		if(root1 == root2) { // A-B 부모가 같으면 리턴
			return;
		}
		p[root1] = root2; // 연결해주고
		result += node.C; // 가중치 더해주기
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3124.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int test_case=1; test_case<=T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			// TreeSet : Comparable을 구현한 객체만 저장.
			// 			또는 생성시 Comparator 객체를 설정해야한다.
			TreeSet<Node> ts = new TreeSet<Node>();
			p = new int[V+1];
			for (int i = 0; i <= V; i++) {
				makeSet(i);
			}
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				ts.add(new Node(A, B, C));
			}
			result = 0;
			for (Node node : ts) { // 가중치를 기준으로 오름차순으로 정렬된 데이터
				// 이미 정렬된 데이터기 때문에 가져온 값이 최소값
				// 따라서 가져온 값으로 유니온
				union(node);
				
			}
			System.out.println("#" + test_case + " " + result);
		}
	}
}
