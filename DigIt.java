package com.june.clash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class DigIt {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		String[] contents = input.split(" ");
		printResult(contents[0], new BigInteger(contents[1]),
				Integer.parseInt(contents[2]), Integer.parseInt(contents[3]),
				new BigInteger(contents[4]));
		//print("4567");
	}

	private static void printResult(String a,BigInteger b,int x,int y,BigInteger k){
		BigInteger i = new BigInteger(a);
		BigInteger count = BigInteger.ZERO;
		
		while(i.compareTo(b) <= 0){
			BigInteger temp = i;
			if(!(i.mod(k).equals(BigInteger.ZERO))){
				i = temp.add(BigInteger.ONE);
				continue;
			}
										
			String focus = String.valueOf(i);
			int length = focus.length() - 1;
			int sum = 0;
			boolean odd = false;
			if (focus.length() % 2 != 0) {
				odd = true;
			}
			for (int z = 0; z < focus.length() / 2; z++) {
				sum += Integer.parseInt(focus.charAt(z) + "")
						+ Integer.parseInt(focus.charAt(length - z) + "");
				if (sum > y)
					break;
			}
			if (odd) {
				sum += Integer.parseInt(focus.charAt(focus.length() / 2) + "");
			}
			i = temp.add(BigInteger.ONE);
			if (sum >= x && sum <= y) {
				count = count.add(BigInteger.ONE);
			}
				 
		}
		System.out.println(count);
	}
	
	private static void print(String focus){
		int length = focus.length() -1;
		int sum = 0;
		boolean odd = false;
		if(focus.length()%2 != 0){
			odd = true;
		}
		for(int z=0; z<focus.length()/2; z++){
			sum += Integer.parseInt(focus.charAt(z) + "")
					+ Integer.parseInt(focus.charAt(length - z) + "");
			//if(sum > y)
           	 break;
		}
		if(odd){
			sum += Integer.parseInt(focus.charAt(focus.length()/2)+"");
		}
		System.out.println(sum);
	}

}
