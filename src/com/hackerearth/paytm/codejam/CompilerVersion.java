package com.hackerearth.paytm.codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CompilerVersion {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = null;
		
		try {
			while((line = br.readLine()) != null){
				if(line.startsWith("//")){
					System.out.println(line);
				} else{
					int indexOf = line.indexOf("//");
					if(indexOf == -1){
						line = line.replaceAll("->", ".");
						System.out.println(line);

					} else {
						String fristSubString = line.substring(0,indexOf);
						String secondSubString = line.substring(indexOf);
						fristSubString = fristSubString.replaceAll("->", ".");
						System.out.println(fristSubString+secondSubString);
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
