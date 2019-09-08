package Lecture4;

import java.util.Arrays;

public class HackerRank_Problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       long[] arr= {2,3,2};
       long goal=10;
       System.out.println(minTime(arr,goal));
       
	}
	
	public static long minTime(long[] arr, long goal) {
        Arrays.sort(arr);
        long low=arr[0];
        long high=arr[arr.length-1]*goal;
        long ans=1000000000;
        while(low<high){
            long days=(low+high)/2;
            long curr_items=0;
            for(int i=0;i<arr.length;i++){
                curr_items=curr_items+(days/arr[i]);
            }
            if(curr_items>=goal){
                if(days<ans){
                    ans=days;
                }
                high=days;
            }else{
                low=days+1;
            }
        }
        return low;

    }

}
