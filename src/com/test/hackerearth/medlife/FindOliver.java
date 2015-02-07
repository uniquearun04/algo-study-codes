package com.test.hackerearth.medlife;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindOliver {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = null;
		
		line = br.readLine();
		int N = Integer.parseInt(line);
		
		Map<Integer, List<Integer>> towardsMap = new HashMap<Integer, List<Integer>>();
		
		Map<Integer, List<Integer>> awayMap = new HashMap<Integer, List<Integer>>();
		
		for(int i = 0; i < N - 1; i++){
			line = br.readLine();
			String[] split = line.split(" ");
			int a = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);
		
			if(a > b){
				int t = a;
				a = b;
				b = t;
			}
			List<Integer> towardsList = towardsMap.get(b);
			if(towardsList == null){
				towardsList = new ArrayList<Integer>(); 
			}
			towardsList.add(a);
			towardsMap.put(b, towardsList);
			
			List<Integer> awayList = awayMap.get(a);
			if(awayList == null){
				awayList = new ArrayList<Integer>();
			}
			awayList.add(b);
			awayMap.put(a, awayList);
		}
		
		int Q = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < Q; i++){
			line = br.readLine();
			String[] split = line.split(" ");
			int binVal = Integer.parseInt(split[0]);
			int X = Integer.parseInt(split[1]);
			int Y = Integer.parseInt(split[2]);
			System.out.println(findIfBobFindsOliver(binVal, X, Y, towardsMap, awayMap) ? "YES" : "NO");
		}
	}

	private static boolean findIfBobFindsOliver(int binVal, int x, int y,
			Map<Integer, List<Integer>> towardsMap,
			Map<Integer, List<Integer>> awayMap) {

		boolean retVal = false;
		Map<Integer, List<Integer>> workingMap = null; 
		switch(binVal){
			case 0:
				workingMap = towardsMap;
				break;
			case 1:
				workingMap = awayMap;
				break;
		}
		
		List<Integer> list = workingMap.get(y);
		if(list != null && list.size() > 0){
			for(Integer i : list){
				retVal = retVal || findIfBobFindsOliver(i,x,workingMap);
			}
		}
		
		return retVal;
	}

	private static boolean findIfBobFindsOliver(Integer i, int x,
			Map<Integer, List<Integer>> workingMap) {

		if(x == i)
			return true;
		List<Integer> list = workingMap.get(i);
		if(list != null && list.size() > 0){
			boolean retVal = false;
			for(Integer j : list){
				retVal = retVal || findIfBobFindsOliver(j,x,workingMap);
			}
			return retVal;
		}
		
		return false;
	}

}
