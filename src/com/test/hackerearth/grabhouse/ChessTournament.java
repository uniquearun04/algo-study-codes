package com.test.hackerearth.grabhouse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ChessTournament {

	public static void main(String[] args) throws Exception{
//		test();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int totalParticipants = (int)Math.pow(2, N);
		int A[][] = new int[totalParticipants][totalParticipants];
		
		List<String> inputStringList = new ArrayList<String>();
		for(int i = 1; i < totalParticipants ; i++){
			inputStringList.add(br.readLine());
		}
		
		storeInput(A,inputStringList);
		
		int winnerId = findWinner(totalParticipants,A);
		System.out.println(winnerId +1);

	}
	
	private static int findWinner(int numParticipants, int A[][]){
		
		List<Integer> participants = new ArrayList<Integer>();
		for(int i = 0; i < numParticipants; i++){
			participants.add(i);
		}
		int n = numParticipants;
		while(n > 1){
			for(int i = 0; i < n; i+=2){
				int a = participants.remove(0);
				int b = participants.remove(0);
				
				int winner = ((A[b][a] == 1) ? b : a);
				
				participants.add(winner);
			}
			n = n/2;
		}
		
		return participants.get(0);
	}
	
	private static void storeInput(int A[][], List<String> strList){
		String entry[] = null;
		for(int i = 1; i <= strList.size(); i++){
			entry = strList.get(i-1).split(" ");
			for(int j = 0; j < entry.length; j++){
				A[i][j] = Integer.parseInt(entry[j]);
			}
		}
	}
	
	public static void test(){
		System.out.println(Math.pow(2, 0));
		System.out.println(Math.pow(2, 1));
		System.out.println(Math.pow(2, 2));
		System.out.println(Math.pow(2, 3));
		System.out.println(Math.pow(2, 4));
		System.out.println(Math.pow(2, 5));
	}

}
