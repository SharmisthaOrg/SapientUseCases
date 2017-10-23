package com.golmanproblems;

public class Atoi {

	public static void main(String[] args) {
		//Integer i=Integer.parseInt("-123");
		System.out.println(strToInt("-123"));

	}
	public static int strToInt( String str ){
		boolean neg=false;
		int num=0;
		int i=0;
		if(str.charAt(i) == '-')neg=true;
		i++;
		while(i<str.length()) {
			if(str.charAt(i)>='0' && str.charAt(i)<='9') {
				num =(num*10)+(str.charAt(i)-'0');
			}
			else {
				throw new NumberFormatException();
			}
			i++;
		}
		if(neg==true)num=-num;
		return num;
	}

}
