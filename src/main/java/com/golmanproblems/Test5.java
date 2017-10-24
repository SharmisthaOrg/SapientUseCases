package com.golmanproblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Test5 {

	public static void main(String[] args) {
		int[] i= {2,4,2,8,16};
		System.out.println(isPow(8, 2));
		System.out.println(pow(4, 2));
		System.out.println(printPowerPairs(i));
		
	}

	private static String printPowerPairs(int[] ia) {
		HashSet<Double> m=new HashSet<>();		
		StringBuilder os=new StringBuilder();
		for(int i:ia) {
			m.add((double)i);			
		}
		List<Double> l=new ArrayList<>(m);
		for(int i=0;i<l.size()-1;i++) {
			for(int j=i+1;j<l.size();j++) {
				if(pow(l.get(i),l.get(j)) == pow(l.get(j),l.get(i))) {
					
					System.out.println(Math.pow(l.get(i),l.get(j)));
					System.out.println(Math.pow(l.get(j),l.get(i)));
					System.out.println(l.get(i)+","+l.get(j));
					
					os.append(l.get(i).intValue()).append(",").append(l.get(j).intValue()).append(" ");
				}		
			}
		}
		return os.toString();
	}
	public static boolean isPow(int a,int b)
	{
		if(a==1)return b==1;
		if(a==0) return false;
		int pow=1;
		while(pow<a) {
			pow=pow*b;
		}
		return pow == a;
	}
	public static double pow(double a,double b) {
		double count=0;
		double result=1;
		while(count<b) {
			result*=a;
			count++;
		}
		return result;
	}
}
