package com.test.hackerearth.ibm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GameOfString {

	public static void main(String[] args)   throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int T = Integer.parseInt(line);

        GameOfString gs = new GameOfString();
        
        String S;
        int K;
        String retStr = "";
        
        for(int i = 0; i < T; i++){
        	line = br.readLine();
        	String[] split = line.split(" ");
        	S = split[0];
        	K = Integer.parseInt(split[1]);
        	retStr = gs.findSsubStr(S, K);
        	if(retStr.isEmpty()){
        		System.out.println("Puchi is a cheat!");
        	} else {
        		System.out.println(retStr);
        	}
        }
	}
	
	public String findSsubStr(String s, int k){
		String retStr = "";

		int len = s.length();
		
		for(int i = 0; i < len && i+1 < k; i++){
			if(s.charAt(i) == s.charAt(len - 1)){
				String subS = s.substring(0, i+1);
				String subE = s.substring(len - i - 1, len);
				if(subS.equals(subE)){
					String subM = s.substring(i+1, k);
					if(subM.contains(subS)){
						retStr = subS;
						break;
					}
				}
			}
		}
		return retStr;
	}

}
