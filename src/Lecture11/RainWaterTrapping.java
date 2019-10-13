package Lecture11;

import java.util.Scanner;

public class RainWaterTrapping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner s=new Scanner(System.in);
       int total=s.nextInt();
       int tc=1;
       while(tc<=total) {
    	   int n=s.nextInt();
    	   int[] arr=new int[n];
    	   for(int i=0;i<n;i++) {
    		   arr[i]=s.nextInt();
    	   }
    	   int[] lmax=new int[n];
    	   int[] rmax=new int[n];
    	   lmax[0]=arr[0];
    	   for(int i=1;i<n;i++) {
    		  lmax[i]=Math.max(lmax[i-1], arr[i]);
    	   }
    	   rmax[rmax.length-1]=arr[arr.length-1];
    	   
    	   for(int i=arr.length-2;i>=0;i--) {
    		   rmax[i]=Math.max(rmax[i+1], arr[i]);
    	   }
    	   int water_sum=0;
    	   
    	   for(int i=0;i<arr.length;i++) {
    		   water_sum=water_sum+Math.min(lmax[i], rmax[i])-arr[i];
    	   }
    	   System.out.println(water_sum);
    	   tc++;
       }
	}

}
