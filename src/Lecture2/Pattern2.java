package Lecture2;

public class Pattern2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int n=5;
	        //prep for 1st row
	        int row=1;
	        int nst=1;
	        while(row<=n) {
	        	int cst=1;
	        	while(cst<=nst) {
	        		System.out.print("*");
	        		cst++;
	        	}
	        	
	        	//prep for next row
	        	nst++;
	        	row++;
	        	System.out.println();
	        }
	}

}
