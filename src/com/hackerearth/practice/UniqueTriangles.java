package com.hackerearth.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueTriangles {
	public static void main(String args[]){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int n = 0;
		int countUniqTriangles = 0;
		try {
			line = br.readLine();
			n = Integer.parseInt(line);
			Map<Set<String>, Integer> map = new HashMap<Set<String>, Integer>();
			for(int i = 0; i < n; i++){
				line = br.readLine();
				Set<String> set = new HashSet<String>();
				String[] split = line.split(" ");
				for(String str : split){
					set.add(str);
				}
				if(map.containsKey(set)){
					map.put(set, map.get(set)+1);
				} else{
					map.put(set, 1);
				}
			}
			
			for(Set ks : map.keySet()){
				if(1 == map.get(ks)){
					countUniqTriangles++;
				}
			}
			System.out.println(countUniqTriangles);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}

class TestClass{
	public static void main(String args[]){
		
	}
	
	
}