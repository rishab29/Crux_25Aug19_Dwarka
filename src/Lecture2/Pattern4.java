package Lecture2;

public class Pattern4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int n=5;
      int row=1;
      int place_holder=1;
      while(row<=n) {
    	  int place_value=1;
    	  while(place_value<=place_holder) {
    		  if(place_value%2==0) {
    			  System.out.print("*");
    		  }else {
    			  System.out.print(row);
    		  }
    		  place_value++;
    	  }
    	  place_holder=place_holder+2;
    	  System.out.println();
    	  row++;
      }
	}

}
