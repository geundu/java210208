package com.base;

import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력하시오 : ");
		int bound = sc.nextInt();
		
		for (int i = 0; i < bound; i++) {
			for (int j = 0; j < bound; j++) {
				if (j < i) {
					System.out.print(" ");
				}
				else {
					System.out.print("*");
				}
			}/////////////////end of j for
			System.out.println();
		}/////////////////////end of i for
		sc.close();
	}
}
