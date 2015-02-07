package com.test.hackerearth.ul;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class NextLuckyNumber {

	public static void main(String[] args) throws Exception{
//		test();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		
		line = br.readLine();
		int T = Integer.parseInt(line);
		
		String inputA[] = new String[T];
		
		for(int i = 0; i < T; i++){
			inputA[i] = ((line=br.readLine()).trim());
		}
		
		for(int i = 0; i < T; i++){
			System.out.println(findNextLNBigInt(inputA[i]));
		}
	}
	
	private static void test() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while((line = br.readLine()) != null){
			System.out.println(findNextLNBigInt(line));
		}
	}
	
	private static void clearRest(int A[], int index){
		for(int i = index; i < A.length; i++){
			A[i] = 3;
		}
	}

	public static BigInteger findNextLNBigInt(String N){
		int msd = 0;
		N = N.trim();
		int A[] = new int[N.length()];
		for(int i = 0, j = i+1; i < N.length(); i++,j++){
			A[i] = Integer.parseInt(N.substring(i, j));
		}
		
		boolean restValid = false;
		boolean shouldDIncr = false;
		
		for(int i = A.length-1; i >= 0; i--){
			int k = A[i];
			if(k < 3){
				A[i] = 3;
				clearRest(A, i+1);
				restValid = true;
				shouldDIncr = false;
			} else if(k == 3){
				if(!restValid){
					A[i] = 5;
					clearRest(A, i+1);
					restValid = true;
					shouldDIncr = false;
				}
			} else if(k < 5){
				A[i] = 5;
				clearRest(A, i+1);
				restValid = true;
				shouldDIncr = false;
			} else if(k == 5){
				if(!restValid){
					A[i] = 3;
					restValid = false;
					shouldDIncr = true;
				}
			} else {
				A[i] = 3;					
				shouldDIncr = true;
				clearRest(A, i+1);
				restValid = false;
			}
		}
		
		if(shouldDIncr){
			msd = 3;
		}
		BigInteger retVal = BigInteger.valueOf(msd);
		for(int i = 0; i < A.length; i++){
			retVal = retVal.multiply(BigInteger.TEN).add(BigInteger.valueOf(A[i]));
		}
		return retVal;
	}
	public static int findNextLN(String N){
		int msd = 0;
		N = N.trim();
		int A[] = new int[N.length()];
		for(int i = 0, j = i+1; i < N.length(); i++,j++){
			A[i] = Integer.parseInt(N.substring(i, j));
		}
		
		boolean restValid = false;
		boolean shouldDIncr = false;
		
		for(int i = A.length-1; i >= 0; i--){
			int k = A[i];
			if(k < 3){
				A[i] = 3;
				clearRest(A, i+1);
				restValid = true;
				shouldDIncr = false;
			} else if(k == 3){
				if(!restValid){
					A[i] = 5;
					clearRest(A, i+1);
					restValid = true;
					shouldDIncr = false;
				}
			} else if(k < 5){
				A[i] = 5;
				clearRest(A, i+1);
				restValid = true;
				shouldDIncr = false;
			} else if(k == 5){
				if(!restValid){
					A[i] = 3;
					restValid = false;
					shouldDIncr = true;
				}
			} else {
				A[i] = 3;					
				shouldDIncr = true;
				clearRest(A, i+1);
				restValid = false;
			}
		}
		
		if(shouldDIncr){
			msd = 3;
		}
		int retVal = msd;
		for(int i = 0; i < A.length; i++){
			retVal = retVal *10 + A[i];
		}
		return retVal;
	}

}
