package junit.punam;

public class SumOddRange {

	public static void main(String[] args) {

		SumOddRange obj = new SumOddRange();
		
		System.out.println(obj.sumOdd(1, 5));
	}

	public static boolean isOdd(int number) {
		/*
		 * if (number > 0) { if (number % 2 != 0) return true; } return false;
		 */
		
		 return (number % 2 != 0)? true :  false;
	}

	public int sumOdd(int start, int end) {

		int sum = 0;
		if (start > 0 && end > 0 && end >= start) {
			for (int i = start; i <= end; i++) {
				if (isOdd(i))
					sum = sum + i;
			}
			return sum;
		}
		return -1;
	}
}
