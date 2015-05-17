package com.test.hackerearth.medlife;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class StringConst {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String [] input = new String[N];
		
		for(int i= 0; i < N; i++){
			input[i] = br.readLine();
		}
		
		for(int i = 0; i < N; i++){
			System.out.println(getScore(input[i]));
		}
	}
	
	private static int getScore(String str){
		
		int len = str.length();
		Map<String, Integer> lm = new HashMap<String, Integer>();
		Map<String, Integer> rm = new HashMap<String, Integer>();

		int sum = 0;
		for(int i = 0; i < len; i++){
			sum += (lm.size() + rm.size()); 
			String c = str.substring(i, i+1);
			if(!lm.containsKey(c)){
				lm.put(c, 1);
			} else {
				rm.put(c, 1);
			}
		}
		
		return sum;
	}

}
