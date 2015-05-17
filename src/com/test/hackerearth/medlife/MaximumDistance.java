package com.test.hackerearth.medlife;


import java.io.BufferedReader;
import java.io.InputStreamReader;

 class MaximumDistance {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		double [][] input = new double[2][N];
		
		String split[] = br.readLine().split(" ");
		
		for(int i = 0; i < split.length; i++){
			input[0][i] = Double.parseDouble(split[i]);
		}
		split = br.readLine().split(" ");
		for(int i = 0; i < split.length; i++){
			input[1][i] = Double.parseDouble(split[i]);
		}
		
		double f = Double.parseDouble(br.readLine());
		
		double max = -1;
		
		double m = 0;
		for(int i = 0; i < N; i++){
			
			m = f/input[1][i];
			m = m * input[0][i];
			if(m > max){
				max = m;
			}
		}
		
		String str = m+"";
		int indexOf = str.indexOf(".");
		String out = str.substring(0, indexOf) + ".";
		String e = str.substring(indexOf+1);
		
		int l = e.length();
		int d = 3 - l;
		if(d > 0){
			for(int i = 0; i < d; i++){
				e += "0"; 
			}
		} else if(d < 0){
			e = str.substring(indexOf+1, indexOf+4);
		}
		out += e;
		
		System.out.println(out);
	}

}
