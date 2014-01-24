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
		int lenFirstSubArray = endIndexFirstSubArray - startIndexFirstSubArray + 1;
		
		for(int i = 0; i < lenFirstSubArray; i ++){
			swapOneVal(A, startIndexFirstSubArray + i, startIndexSecondSubArray + i);
		}
	}

		
	public static void swapOneVal(String [] A, int i, int j){
		String tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}

}
