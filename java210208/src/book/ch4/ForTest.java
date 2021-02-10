package book.ch4;

//import java.util.ArrayList;

public class ForTest {

	public static void main(String[] args) {
		
//		ArrayList<Integer> al = new ArrayList<Integer>();
		
		int evenSum = 0;
		int oddSum = 0;
//		int alEven = 0;
		
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				evenSum += i;
//				al.add(i);
			}
			else {oddSum += i;}
		}
//		for (Integer cnt : al) {
//			alEven += cnt;
//		}
		System.out.println("1~10 짝수의 합 = " + evenSum);
		System.out.println("1~10 홀수의 합 = " + oddSum);
//		System.out.println("1~10 짝수의 합(ArrayList) = " + alEven);
	}

}
