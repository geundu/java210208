package com.base;

import java.util.Scanner;

public class Practice {
	
	public void testIfA() {
		if(testIfB("true")) {
			System.out.println("True");
		}
		else {
			System.out.println("Not True");
		}
	}
	
	public Boolean testIfB(String str) {
		return Boolean.valueOf(str);
	}
	
	public static void main(String[] args) {
		Practice p = new Practice();
		
		p.testIfA();
		

//		int H = 0;
//		int M = 0;
//		
//		Scanner s = new Scanner(System.in);
//		
//		H = s.nextInt();
//		M = s.nextInt();
//		
//		if (H < 24 && H >= 0 && M < 60 && M >= 0) {
//			if (M > 45) {
//				System.out.printf("%d %d", H, M - 45);
//			}
//			else if (M < 45) {
//				if (H == 0) {
//					System.out.printf("%d %d", H + 23, M + 15);
//				}
//				else {
//					System.out.printf("%d %d", H - 1, M + 15);
//				}
//			}
//			else {
//				System.out.printf("%d %d", H, 0);
//			}
//		}
//		else {
//			System.out.println("H = 0~23, M = 0~59");
//		}
//		s.close();

	}
}
