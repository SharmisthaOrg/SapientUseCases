package com.usecase9;

import java.util.Arrays;
import java.util.List;

public class FindKthLargestUsingJava8Stream {

	public static void main(String[] args) {
		Integer[] arr= {6,8,3,1,2,3,9};
		List<Integer> l = Arrays.asList(arr);
		int k=5;
		l.stream().sorted().limit(k).skip(k-1).forEach(System.out::println);
	}

}
