package Lecture18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MaxConseqLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[] arr= {3,5,11,4,7,2};
       
       HashMap<Integer, Boolean> map=new HashMap<>();
       for(int i=0;i<arr.length;i++) {
    	   int num=arr[i];
    	   int nm1=arr[i]-1;
    	   int np1=arr[i]+1;
    	   if(map.containsKey(nm1)){
    		   map.put(num,false);
    	   }else {
    		   map.put(num,true);
    	   }
    	   
    	   if(map.containsKey(np1)){
    		   map.put(np1,false);
    	   }	   
       }
       
       Set<Map.Entry<Integer, Boolean>> entries=map.entrySet();
       int maxlen=0,maxseqstartvalue=0;
       for(Map.Entry<Integer, Boolean> entry:entries) {
    	   if(entry.getValue()==false) {
    		   continue;
    	   }
    	   int currseqlen=0,currseqstartvalue=entry.getKey();
    	   while(map.containsKey(currseqstartvalue+currseqlen)) {
    		   currseqlen++;
    	   }
    	   
    	   if(currseqlen>maxlen) {
    		   maxseqstartvalue=currseqstartvalue;
    		   maxlen=currseqlen;
    	   }
    	   
       }
       
       ArrayList<Integer> ans=new ArrayList<>();
       for(int i=0;i<maxlen;i++) {
    	   ans.add(maxseqstartvalue+i);
       }
       System.out.println(ans);
 	}
	


}
