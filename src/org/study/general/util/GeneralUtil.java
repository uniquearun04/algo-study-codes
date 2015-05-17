package org.study.general.util;

public class GeneralUtil {
	
	public static void swapSubArrays(String[] A, int startIndexFirstSubArray, int endIndexFirstSubArray, int startIndexSecondSubArray, int endIndexSecondSubArray){
		
		int lenFirstSubArray = endIndexFirstSubArray - startIndexFirstSubArray + 1;
		int lenSecondSubArray = endIndexSecondSubArray - startIndexSecondSubArray + 1;
		
		if(lenFirstSubArray > lenSecondSubArray){
			
		} else if(lenFirstSubArray < lenSecondSubArray){
			
		} else {
			swapEqLenSubArrays(A, startIndexFirstSubArray, endIndexFirstSubArray, startIndexSecondSubArray, endIndexSecondSubArray);
		}
		
	}
	
	public static void swapEqLenSubArrays(String[] A, int startIndexFirstSubArray, int endIndexFirstSubArray, int startIndexSecondSubArray, int endIndexSecondSubArray){
		//do not swap subarrays of length 1
		if(endIndexFirstSubArray == startIndexFirstSubArray){
			return;
		}
		
		for(int i = 0; i < endIndexFirstSubArray - startIndexFirstSubArray + 1; i ++){
			swap(A, startIndexFirstSubArray + i, startIndexSecondSubArray + i);
		}
	}
		
	public static void swap(String [] A, int i, int j){
		String tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}

}
