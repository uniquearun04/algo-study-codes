package com.study.algo.g4g;

public class PeakElement {

	public static void main(String[] args) {

		PeakElement pe = new PeakElement();

		int A1[] =  {30,10, 20, 15, 2, 23, 90, 67, 81};
		
		pe.findPeaks(A1);
		
	}
	
	
	//linear order
	public void findPeaks(int [] A){
		int lastDiff = 0;
		int currDiff = 0;
		int len = A.length;
		for(int i = 1; i < A.length; i++){
			currDiff = A[i] - A[i-1];
			if(lastDiff >= 0 && currDiff < 0){
				System.out.println(A[i-1]);
			}
			lastDiff = currDiff;
		}
		if(A[len-1] > A[len-2]){
			System.out.println(A[len-1]);
		}
	}
	
	//logN order
	public void findPeaksV2(int[] A){
		
	}

}
