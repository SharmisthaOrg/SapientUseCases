package com.golmanproblems;

public class SpiralPrint {

	public static void main(String[] args) {
		int R = 3;
		int C = 6;
		int a[][] = { {1,  2,  3,  4,  5,  6},
					{7,  8,  9,  10, 11, 12},
					{13, 14, 15, 16, 17, 18}
					
		};
		spiralPrint(R,C,a);
	}

	private static void spiralPrint(int r, int c, int[][] a) {
		int startrow=0;int endrow=r-1;
		int startcol=0;int endcol=c-1;

		while(startrow<endrow && startcol<endcol) {
			for(int i=startcol;i<=endcol;i++) {
				System.out.print(a[startrow][i]+",");
			}
			startrow++;
			for(int i=startrow;i<=endrow;i++) {
				System.out.print(a[i][endcol]+",");
			}
			endcol--;
			for(int i=endcol;i>=startcol;i--) {
				System.out.print(a[endrow][i]+",");
			}
			endrow--;
			for(int i=endrow;i>=startrow;i--) {
				System.out.print(a[i][startcol]+",");
			}
			startcol++;
			
		}
		
	}

}
