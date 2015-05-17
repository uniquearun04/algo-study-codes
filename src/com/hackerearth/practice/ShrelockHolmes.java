package com.hackerearth.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShrelockHolmes {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int t = 0;
		
		try {
			line = br.readLine();
			t = Integer.parseInt(line);
			
			char [][] matrix = null;
			for(int i = 0; i < t; i++){
				int n = 0;
				line = br.readLine();
				n = Integer.parseInt(line);
				line = br.readLine();
				String[] split = line.split(" ");
				int arr[] = new int[n];
				for(int j = 0; j < n; j++){
					arr[j] = Integer.parseInt(split[j]);
				}
				int sortedArr[] = mergeSort(arr);
				int sum = sum(sortedArr);
				
				if(sum % 2 != 0){
					System.out.println("NO");
				} else {
					int partialSum = 0;
					for(int j = 0; j < n; j ++){
						if(partialSum == sum/2){
							System.out.println("YES");
							break;
						} else if(partialSum > sum/2){
							System.out.println("NO");
							break;
						} else {
							partialSum += sortedArr[j];
						}
					}
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	private static int sum(int [] arr){
		int sum = 0;
		for(int i = 0; i < arr.length; i++){
			sum += arr[i];
		}
		return sum;
	}
	
    public static int[] mergeSort(int [] list) {
        if (list.length <= 1) {
            return list;
        }
        // Split the array in half
        int[] first = new int[list.length / 2];
        int[] second = new int[list.length - first.length];
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);
        
        // Sort each half
        mergeSort(first);
        mergeSort(second);
        
        // Merge the halves together, overwriting the original array
        merge(first, second, list);
        return list;
    }
    
    private static void merge(int[] first, int[] second, int [] result) {
        // Merge both halves into the result array
        // Next element to consider in the first array
        int iFirst = 0;
        // Next element to consider in the second array
        int iSecond = 0;
        
        // Next open position in the result
        int j = 0;
        // As long as neither iFirst nor iSecond is past the end, move the
        // smaller element into the result.
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                result[j] = first[iFirst];
                iFirst++;
                } else {
                result[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }
        // copy what's left
        System.arraycopy(first, iFirst, result, j, first.length - iFirst);
        System.arraycopy(second, iSecond, result, j, second.length - iSecond);
    }

}
