package backtracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Solution1266 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1266.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/** factorial 선계산 */
		BigInteger[] fac = new BigInteger[19];
		fac[0] = fac[1] = BigInteger.ONE;
		for(int i=2; i<19; i++) {
			fac[i] = fac[i-1].multiply(BigInteger.valueOf(i));
		}
		/** combination 선계산 */
		int[] com = new int[19];
		com[0] = com[18] = 1;
		for(int i=1; i<18; i++) {
			com[i] = fac[18].divide(fac[18-i]).divide(fac[i]).intValue();
		}
		/** 18보다 작은 소수 */
		int[] prime = {2, 3, 5, 7, 11, 13, 17};
		
		int T = Integer.parseInt(br.readLine().trim());
		for(int test_case=1; test_case<=T; test_case++) {
			String[] strarr = br.readLine().split(" ");
			double skillA = Integer.parseInt(strarr[0]) * 0.01; // A가 완제품을 만들 확률
			double noSkillA = 1-skillA; // A가 완제품을 만들지 못할 확률
			double skillB = Integer.parseInt(strarr[1]) * 0.01; // B가 완제품을 만들 확률
			double noSkillB = 1-skillB; // B가 완제품을 만들지 못할 확류
			
			double[] successA = new double[19]; // A가 1부터 18까지 성공할 확률의 배열 p^r
			double[] failA = new double[19]; // A가 1부터 18까지 실패할 확률의 배열 (1-p)^(n-r)
			double[] successB = new double[19]; // B가 1부터 18까지 성공할 확률의 배열
			double[] failB = new double[19]; // B가 1부터 18까지 실패할 확률의 배열
			successA[1] = skillA;
			failA[1] = noSkillA;
			successB[1] = skillB;
			failB[1] = noSkillB;
			for(int i=2; i<=18; i++) {
				successA[i] = successA[i-1] * skillA;
				failA[i] = failA[i-1] * noSkillA;
				successB[i] = successB[i-1] * skillB;
				failB[i] = failB[i-1] * noSkillB;
			}
			
			double pA = 0;
			double pB = 0;
			for(int i=0, size=prime.length; i<size; i++) {
				int primeN = prime[i];
				pA += com[primeN] * successA[primeN] * failA[18-primeN];
				pB += com[primeN] * successB[primeN] * failB[18-primeN];
			}
			
			/** 
			 * A와 B 중에 적어도 한 명이 소수인 완제품을 생산할 확률 = AUB
			 * 확률의 덧셈 정리 P(AUB) = P(A) + P(B) - P(A교집합B)
			 * P(A교집합B) = P(A) * P(B)
			 * 혹은, 전체 확률 - A와 B 모두 소수가 아닌 완제품을 생산할 확률
			 */
			double result = pA + pB - (pA * pB);
			
			System.out.printf("#%d %.6f\n", test_case, result);
		}
	}
}
