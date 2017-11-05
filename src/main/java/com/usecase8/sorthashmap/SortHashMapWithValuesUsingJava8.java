package com.usecase8.sorthashmap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class SortHashMapWithValuesUsingJava8 {

	public static void main(String[] args) {
/*		HashMap<Integer,String> unsortedMap=new HashMap<>();
		unsortedMap.put(19, "aa");unsortedMap.put(2, "bb");unsortedMap.put(10,"cc");unsortedMap.put(0, "dd");unsortedMap.put(56, "ee");unsortedMap.put(34, "ff");
		System.out.println(unsortedMap);
		
		Map<Integer, String> sortedMap = 
			     unsortedMap.entrySet().stream()
			    .sorted(Entry.comparingByValue())
			    .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
			                              (e1, e2) -> e1, LinkedHashMap::new));
		System.out.println(sortedMap);
		
		unsortedMap.entrySet().stream()
        .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
        .forEach(k -> System.out.println(k.getKey() + ": " + k.getValue()));*/
		
		//List
		//Set
		//HashSet
		HashMap<Integer,String> hm=new HashMap<Integer,String>();
		for(int i=0;i<100;i++) {
			hm.put(i, "v"+i);
		}
		hm.forEach((i,j)->{System.out.println("key="+i+" value="+j);});
		System.out.println("***");
		
		hm.entrySet().stream().sorted((es1,es2)->es2.getValue().compareTo(es1.getValue())).forEach(System.out::println);
		hm.entrySet().stream().filter((entry)->entry.getKey().equals(10)).forEach((entry)->System.out.println(entry.getValue()+","+entry.getKey()));
		
		
		
	}

}
