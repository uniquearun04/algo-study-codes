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
	public static int findNextLuckyNumber2(String N){
		int msd = 0;
		N = N.trim();
		int A[] = new int[N.length()];
		for(int i = 0, j = i+1; i < N.length(); i++){
			A[i] = Integer.parseInt(N.substring(i, j));
		}
		
		boolean isRest3 = false;
		boolean isRestValid = false;
		boolean isDigitsIncrNeeded = false;
		
		for(int i = A.length-1; i >= 0; i--){

			if(A[i] < 3){
				A[i] = 3;
				if(!isRest3){
					clearRest(A,i+1);
					isRest3 = true;
				}
				isDigitsIncrNeeded = false;
			}else if(A[i] == 3){
				if(!isRestValid){
					A[i] = 5;
					isRest3 = false;
				}
			} else if(A[i] < 5){
				A[i] = 5;
				if(!isRest3){
					clearRest(A,i+1);
					isRest3 = true;
				}
				isDigitsIncrNeeded = false;
			} else {
				A[i] = 3;
				if(!isRest3){
					clearRest(A,i+1);
					isRest3 = true;
				}
				isDigitsIncrNeeded = true;
			}
			isRestValid = true;
		}

		if(isDigitsIncrNeeded){
			msd = 3;
		}
		
		int retVal = msd;
		for(int i = 0; i < A.length; i++){
			retVal = retVal *10 + A[i];
		}
		return retVal;
	}
	public static int findNextLuckyNumber(String N){
		N = N.trim();
		int retVal = 0;
		int len = N.length();
		
		if(len == 1){
			int val = Integer.parseInt(N);
			if(val < 3){
				retVal = 3;
			} else if(val < 5){
				retVal = 5;
			} else {
				retVal = 33;
			}
		} else {
			int msd = Integer.parseInt(N.substring(0, 1));
			int secmsd = Integer.parseInt(N.substring(1, 2));
			
			if(msd < 3){
				msd = 3;
				secmsd = 3;
			} else if(msd == 3){
				if(secmsd < 3){
					secmsd = 3;
				} else if(secmsd < 5){
					secmsd = 5;
				} else {
					msd = 5;
					secmsd = 3;
				}
			}else if( msd < 5){
				msd = 5;
				secmsd = 3;
			} else if( msd == 5){
				if(secmsd < 3){
					secmsd = 3;
				} else if(secmsd < 5){
					secmsd = 5;
				} else{
					msd = 33;
					secmsd = 3;
				}
			} else {
				msd = 33;
				secmsd = 3;
			}
			
			retVal = msd * 10 + secmsd;
			for(int i = 0; i < len - 2; i++){
				retVal = (retVal*10 + 3);
			}
		}
		
		return retVal;
	}
}
