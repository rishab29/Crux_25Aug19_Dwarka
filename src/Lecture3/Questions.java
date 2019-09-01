package Lecture3;

public class Questions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int bin = 100000;
		System.out.println(binToDec(bin));

		int dec = 32;
		System.out.println(DecToBin(dec));

		System.out.println(DecToAny(31, 8));

		System.out.println(AnyToDec(37, 8));

		System.out.println(AnyToAny(37, 8, 2));

	}

	public static int binToDec(int bin) {
		int dec = 0;
		int twopowers = 1;
		while (bin != 0) {
			int rem = bin % 10;
			dec = dec + rem * twopowers;
			twopowers = twopowers * 2;
			bin = bin / 10;
		}

		return dec;
	}

	public static int DecToBin(int dec) {
		int bin = 0;
		int tenpowers = 1;
		while (dec != 0) {
			int rem = dec % 2;
			bin = bin + rem * tenpowers;
			tenpowers = tenpowers * 10;
			dec = dec / 2;
		}

		return bin;
	}

	public static int DecToAny(int dec, int db) {
		int num = 0;
		int tenpowers = 1;
		while (dec != 0) {
			int rem = dec % db;
			num = num + rem * tenpowers;
			tenpowers = tenpowers * 10;
			dec = dec / db;
		}

		return num;
	}

	public static int AnyToDec(int num, int sb) {
		int dec = 0;
		int sbpowers = 1;
		while (num != 0) {
			int rem = num % 10;
			dec = dec + rem * sbpowers;
			sbpowers = sbpowers * sb;
			num = num / 10;
		}

		return dec;
	}

	public static int AnyToAny(int num, int sb, int db) {
		int midans = AnyToDec(num, sb);
		int ans = DecToAny(midans, db);
		return ans;

	}

}
