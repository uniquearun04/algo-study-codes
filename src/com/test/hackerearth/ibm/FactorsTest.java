package com.test.hackerearth.ibm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FactorsTest {

	public static void main(String[] args)  throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int D = Integer.parseInt(line);
        
        int X = 0;
        int Y = 0;
        int K = 0;
        int c = 0;
        
        FactorsTest ft = new FactorsTest();
        
        for(int i = 0; i < D; i++){
        	
        	line = br.readLine();
        	String[] split = line.split(" ");
        	
        	X = Integer.parseInt(split[0]);
        	Y = Integer.parseInt(split[1]);
        	K = Integer.parseInt(split[2]);

        	c = ft.findAmtGiven(X, Y, K);
        	if(c == 0){
        		System.out.println("No crymeth today");
        	} else {
        		System.out.println(c);
        	}
        
        }
        
        
	}
	public int findAmtGiven(int X, int Y, int K){
		int retAmt = 0;
	
		if( X > Y){
			int t = X;
			X = Y;
			Y = t;
		}
		List<Integer> commonFactorList = new ArrayList<Integer>();
		
		for(int i = 1; i <= X/2; i++){
			if(X % i == 0 && Y % i == 0){
				commonFactorList.add(0, i);
			}
		}
		
		if( Y % X == 0){
			commonFactorList.add(0, X);
		}
		
		if(K <= commonFactorList.size()){
			retAmt = commonFactorList.get(K -1);
		}
		
		return retAmt;
	}
	
	
	
	

}
