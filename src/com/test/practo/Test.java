package com.test.practo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test {

	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
        int N = Integer.parseInt(line);
        int S[] = new int[N];
        line = br.readLine();
        String split[] = line.split(" ");
        for (int i = 0; i < N; i++) {
        	S[i] = Integer.parseInt(split[i]);
        }
        
        Test test = new Test();
        test.cutSticks(S);
		
	}
	
	public void cutSticks(int S[]){
		int min = 0;
		while(true){
			min = findMin(S);
			if(min == Integer.MAX_VALUE){
				break;
			}
			int j = 0;
			for(int i = 0; i < S.length; i++){
				if(S[i] != 0){
					S[i] -= min;
					j++;
				}
			}
			System.out.println(j);
		}
		
	}
	
	public int findMin(int S[]){
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < S.length; i++){
			if(S[i] != 0){
				if(S[i] < min){
					min = S[i];
				}
			}
		}
		return min;
	}
}
