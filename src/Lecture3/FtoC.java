package Lecture3;

public class FtoC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int fmin = 0, fmax = 300, fstep = 20;
		int fcurrent = fmin;
		while (fcurrent <= fmax) {
           int celsius=(int)((5.0/9)*(fcurrent-32));
           System.out.println(fcurrent+"\t"+celsius);
           fcurrent=fcurrent+fstep;
		}
	}

}
