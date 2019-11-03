package Lecture18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MaxLenSubSeq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[] arr= {3,5,6,2,7,4,8};
       HashMap<Integer, Boolean> map=new HashMap<>();
       for(int i=0;i<arr.length;i++) {
    	   int num=arr[i];
    	   int nm1=num-1;
    	   int np1=num+1;
    	   if(map.containsKey(nm1)) {
    		  map.put(num, false); 
    	   }else {
    		   map.put(num, true);
    	   }
    	   
    	   if(map.containsKey(np1)) {
    		   map.put(np1 ,false);
    	   }
       }
       Set<Map.Entry<Integer, Boolean>> entries=map.entrySet();
       
       int maxseql=0,maxseqstart=0;
       
       for(Map.Entry<Integer, Boolean> entry:entries) {
    	   if (entry.getValue() == false) {
				continue;
			}
    	   int currseql=0,currseqstart=entry.getKey();
    	   while(map.containsKey(currseql+currseqstart)) {
    		   currseql++;
    	   }
    	   if(currseql>maxseql) {
    		   maxseql=currseql;
    		   maxseqstart=currseqstart;
    	   }
       }
       
       ArrayList<Integer> rv = new ArrayList<>();
		for (int i = 0; i < maxseql; i++) {
			rv.add(maxseqstart + i);
		}
		System.out.println(rv);
	}


}
