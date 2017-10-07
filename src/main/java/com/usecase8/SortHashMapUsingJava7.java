package com.usecase8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SortHashMapUsingJava7 {

	public static void main(String[] args) {
		HashMap<Integer,String> unsortedMap=new HashMap<>();
		unsortedMap.put(19, "aa");unsortedMap.put(2, "bb");unsortedMap.put(10,"cc");unsortedMap.put(0, "dd");unsortedMap.put(56, "ee");unsortedMap.put(34, "ff");
		System.out.println(unsortedMap);
		
		//Sort
		Set<Entry<Integer,String>> entrySet=unsortedMap.entrySet();
		List<Entry<Integer,String>> list=new ArrayList<Entry<Integer,String>>(entrySet);
		System.out.println(list);
		Collections.sort(list,new Comparator<Entry<Integer,String>>() {

			@Override
			public int compare(Entry<Integer, String> o1, Entry<Integer, String> o2) {
				
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		
		System.out.println(list);

	}

}
