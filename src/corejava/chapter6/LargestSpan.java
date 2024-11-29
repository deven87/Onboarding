package corejava.chapter6;

import java.util.HashMap;

public class LargestSpan {
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,7,1,9,2,1}; 
		
		int maxSpan = 0;
		
		// store the array element as key and its index as value
		HashMap<Integer, Integer> map = new HashMap<>();
		
		// add array elements in map, if element already exists, update the span
		for(int i = 0; i < arr.length; i++) {
			
			if (map.containsKey(arr[i])) {
				int span = i - map.get(arr[i]) + 1;
				maxSpan = Math.max(maxSpan, span);
				
			} else {
				
				map.put(arr[i], i);
			}	
			
		}	
		
		System.out.println(maxSpan);
		
	}

}
