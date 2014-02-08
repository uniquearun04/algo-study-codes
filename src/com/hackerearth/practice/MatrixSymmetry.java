package com.hackerearth.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixSymmetry {

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
				matrix = new char[n][n];
				for(int j = 0; j < n; j++){
					line = br.readLine();
					for(int k = 0; k < n; k++){
						char c = line.charAt(k);
						matrix[j][k] = c;
					}
				}
				boolean verticalSymmetry = verticalSymmetry(matrix);
				boolean horizontalSymmetry = horizontalSymmetry(matrix);
				
				if(verticalSymmetry && horizontalSymmetry){
					System.out.println("BOTH");
				} else if(verticalSymmetry){
					System.out.println("VERTICAL");
				} else if(horizontalSymmetry){
					System.out.println("HORIZONTAL");
				} else{
					System.out.println("NO");
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static boolean horizontalSymmetry(char[][] matrix){
		boolean returnVal = false;
		
		int size = matrix.length;
		for(int i = 0; i < size/2; i++ ){
			for(int j = 0; j < size; j++){
				if(matrix[i][j] != matrix[size - i - 1][j]){
					return returnVal;
				}
			}
		}
		returnVal = true;
		return returnVal;
	}
	
	public static boolean verticalSymmetry(char[][] matrix){
		boolean returnVal = false;
		
		int size = matrix.length;
		for(int i = 0; i < size; i++ ){
			for(int j = 0; j < size/2; j++){
				if(matrix[i][j] != matrix[i][size - j - 1]){
					return returnVal;
				}
			}
		}
		returnVal = true;
		return returnVal;
	}

}
