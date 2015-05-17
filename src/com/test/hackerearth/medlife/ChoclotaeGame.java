package com.test.hackerearth.medlife;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChoclotaeGame {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int [] input = new int[N];
		
		String[] split = br.readLine().split(" ");
		for(int i= 0; i < N; i++){
			input[i] = Integer.parseInt(split[i]);
		}
		
		System.out.println(findOptimalVal(input));
	}
	
	public static int findOptimalVal(int[] input){ 
		int max = -1;
		int m = 0;
		for(int i = 0; i < input.length; i++){
			m = findNumsLessThanI(input, i);
			if(m > max){
				max = m;
			}
		}
		return max;
	}
	
	
	private static int findNumsLessThanI(int[] input, int i){
		int count = 0;
		
		for(int j = i + 1; j < input.length; j++){
			if(input[j] < input[i]){
				count++;
			}
		}
		
		return count;
	}
	
	

}
