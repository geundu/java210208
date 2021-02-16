package com.base;

import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {
		
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
		
//		int x = 5;
//		boolean b1 = true;
//		boolean b2 = false;
//		
//		if ((x == 4) && !b2) {
//			System.out.print("1 ");
//		}
//		System.out.print("2 ");
//		if ((b2 = true) && b1) {
//			System.out.println("3 ");
//		}
		
//		result : D
		
//		String #name = "Jane Doe";
//		int $age=24;
//		double _height = 123.5;
//		double ~temp = 37.5;
		
		int x = 5;
		Practice p = new Practice();
		p.doStuff(x);
		System.out.println("main x = " + x);
	}
	void doStuff(int x) {
		System.out.println("doStuff x = " + x++);
	}
}
