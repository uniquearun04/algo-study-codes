package com.test.hackerearth.medlife;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class RSum {

	private static final Map<Integer, Integer> factCache = new HashMap<Integer, Integer>();
	
	public static void main(String[] args) throws Exception{

//		test();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		
		line = br.readLine();
		int T = Integer.parseInt(line);
		
		for(int i = 0; i < T; i++){
			line = br.readLine();
			String[] split = line.split(" ");
			int a = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);
			System.out.println(findRSum(a,b));
		}
	}

	private static int findRSum(int a, int b) {
		int sum = 0;
		
		for(int i = a; i <= b; i++){
			int facti = fact(i);
			sum += findRSum(facti);
		}
		
		return sum;
	}
	
	private static int findRSum(int a){
		int r = 0;
		int sum = 0;
		while(true){
			r =  a % 10;
			a = a / 10;
			sum += r;
			if(a == 0){
				if(sum  >= 10){
					a = sum;
					sum = 0;
				} else {
					break;
				}
			}
		}
			
		return sum;
	}

	private static BigInteger factorial(Integer input){
		if(input == 1) return BigInteger.ONE;
        return factorial(input - 1).multiply(new BigInteger(String.valueOf(input)));
	}
	
	private static int fact(int n){
		int prod = 1;

		Integer integer = factCache.get(n);
		if(integer != null){
			prod = integer;
		} else {
			for(int i = 1; i <= n; i++){
				prod *= i;
			}
			factCache.put(n, (int)prod);
		}
		return prod;
	}

	private static BigInteger factBigInt(BigInteger n){
		BigInteger prod = BigInteger.ONE;
		for(BigInteger i = BigInteger.ONE; i.compareTo(n) <= 0; i.add(BigInteger.ONE)){
			prod.multiply(i);
		}
		return prod;
	}
	private static BigInteger factBigInt(int n){
		BigInteger prod = BigInteger.ONE;
		for(int i = 1; i <= n; i++){
			prod.multiply(BigInteger.valueOf(i));
		}
		return prod;
	}	
	
	public static void test(){
		
//		System.out.println(fact(5));
		System.out.println(findRSum(234587985));
		System.out.println(findRSum(15));
		System.out.println(findRSum(95));
		System.out.println(findRSum(995));
		System.out.println(findRSum(523));

	}

}
