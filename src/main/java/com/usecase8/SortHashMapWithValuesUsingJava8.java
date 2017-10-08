package com.usecase8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class SortHashMapWithValuesUsingJava8 {

	public static void main(String[] args) {
		HashMap<Integer,String> unsortedMap=new HashMap<>();
		unsortedMap.put(19, "aa");unsortedMap.put(2, "bb");unsortedMap.put(10,"cc");unsortedMap.put(0, "dd");unsortedMap.put(56, "ee");unsortedMap.put(34, "ff");
		System.out.println(unsortedMap);
		
		Map<Integer, String> sortedMap = 
			     unsortedMap.entrySet().stream()
			    .sorted(Entry.comparingByValue())
			    .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
			                              (e1, e2) -> e1, LinkedHashMap::new));
		//System.out.println(sortedMap);
		
		unsortedMap.entrySet().stream()
        .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
        .forEach(k -> System.out.println(k.getKey() + ": " + k.getValue()));
		
		
	}

}
