package sort;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution2063 {
	public static void bubbleSort(int[] arr) {
		int size = arr.length;
		
		for(int i=0; i<size-1; i++) {
			for(int j=i+1; j<size; j++) {
				if(arr[i]> arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input2063.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		bubbleSort(arr);
		
//		Arrays.sort(arr);
		
		System.out.println(arr[N/2]);
	}

}
