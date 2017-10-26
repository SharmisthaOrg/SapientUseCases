package com.golmanproblems;

import java.util.HashMap;
import java.util.Map;

public class MaximumAverageOfStudent {

	public static void main(String[] args) {
		String[][] ss= {{"a","-104"},{"a","-103"},{"a","-1030"},{"b","-11200"},{"b","-17700"},{"c","-1400"},{"c","-1090"}};
		HashMap<String,Student> m=new HashMap<>();
		int maxaverage =Integer.MIN_VALUE;
		Student s =null;
		for(int i=0;i<ss.length;i++) {
			String key=ss[i][0];
			Integer score=Integer.valueOf(ss[i][1]);
			if(!m.containsKey(key)) {
				s=new Student();
				s.count= s.count+1;
				s.sum = s.sum+score;
				s.avegare = s.sum /s.count;				
			}
			else {
				s=m.get(key);
				s.count= s.count+1;
				s.sum = s.sum+score;
				s.avegare = s.sum /s.count;
			}		
			m.put(key, s);			
		}
		
		for(Map.Entry<String,Student> es:m.entrySet()) {
			if(maxaverage<es.getValue().avegare) {
				maxaverage = es.getValue().avegare;
			}
			
		}
		
		System.out.println(m);
		System.out.println(maxaverage);
	}

}
class Student{
	int sum=0;
	int count=0;
	int avegare=0;
	@Override
	public String toString() {
		return "Student [sum=" + sum + ", count=" + count + ", avegare=" + avegare + "]";
	}
	
}