package com.base;

public class Practice {

	public static void main(String[] args) {
		
		ATest ft = new ATest();
		
		int a_ = ft.a;
		System.out.println(a_);
		
		int evenSum = 0;
		int oddSum = 0;
		
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				evenSum += i;
			}
			else {oddSum += i;}
		}
		System.out.println("1~10 짝수의 합 = " + evenSum);
		System.out.println("1~10 홀수의 합 = " + oddSum);
		
		
		
	}

}
