package com.golmanproblems;

public class LongestPalindrome {

	public static void main(String[] args) {
		String str = "forgeeksskeegfor";
        System.out.println("Length is: " + 
                                 longestPalSubstr(str));

	}

	private static int longestPalSubstr(String s) {
		int start=0;
		int maxlength=1;
		int n=s.length();
		
		boolean[][] t=new boolean[s.length()][s.length()];
		for(int i=0;i<=s.length()-1;i++) {
			t[i][i]=true;
		}
		for(int i=0;i<=s.length()-2;i++) {
			if(s.charAt(i) == s.charAt(i+1)){
				t[i][i+1]=true;
				maxlength = 2;
				start = i;
			}
		}
		for(int k=3;k<=n;k++) {
			for(int i=0;i<=n-k;i++) {
				int j = i+k-1;
				if(t[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
					t[i][j]=true;
					maxlength = k;
					start = i;
				}
			}
		}
		System.out.println(s.substring(start, start+maxlength));
		return maxlength;
	}

}
