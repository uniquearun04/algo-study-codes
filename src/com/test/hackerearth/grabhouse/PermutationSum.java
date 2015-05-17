package com.test.hackerearth.grabhouse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class PermutationSum {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int A[] = new int[T];
		
		for(int i = 0; i < T; i++){
			A[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i =0; i < T; i++){
			System.out.println(computePermutationSumBI(A[i]));
		}
	}

	private static int computePermutationSum(int i) {
		if(i ==1) return 1;
		return i * (i-1)/2;
	}
	
	private static BigInteger computePermutationSumBI(int i) {
		if(i ==1) return BigInteger.ONE;
		return BigInteger.valueOf(i).multiply(BigInteger.valueOf(i-1)).divide(BigInteger.valueOf(2));
	}

}
