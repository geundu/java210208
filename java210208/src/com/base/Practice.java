package com.base;

class ExtendsTest {
	public ExtendsTest() {
		System.out.println("수퍼클래스 생성자 호출");
	}

	public ExtendsTest(int x) {
		System.out.println("매개변수 있는 수퍼클래스 생성자 호출");
	}

	public void superMethod() {
		System.out.println("수퍼클래스가 선언한 메서드");
	}
}

public class Practice extends ExtendsTest {

	Practice() {
//		super(10);
		System.out.println("서브클래스 생성자 호출");
	}

//	@Override
	public void superMethod() {
		System.out.println("서브클래스에 의해 오버라이드된 메서드");
	}

	public static void main(String[] args) {
		ExtendsTest prac = new Practice();

		prac.superMethod();
	}
}
