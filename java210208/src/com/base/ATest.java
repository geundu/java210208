package com.base;

import variable.step1.A;
//접근제한자 public > protected > friendly > private

public class ATest {
	
	int a;
	int b;
	
	ATest() {
		a = 3;
		b = 0;
		System.out.println("ATest() called");
	}

	public static void main(String[] args) {

		A a = new A();
		System.out.println("국어 : " + a.kor);
	}

}
