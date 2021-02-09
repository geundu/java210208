package com.base;

import variable.step1.A;
//접근제한자 public > protected > friendly > private

public class ATest {

	public static void main(String[] args) {

		A a = new A();
		System.out.println("국어 : " + a.kor);
	}

}
