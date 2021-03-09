package com.base;


public class Practice  {
	public static void main(String[] args) {
		
		
		String msg = "hello world man!";
		String[] split = msg.split(" ");
		
		
		for(String s : split) {
			System.out.println(s);
		}
		
//		Scanner sc = new Scanner(System.in);
//		
//		int x = Integer.parseUnsignedInt(sc.next());
//		System.out.println(x);
//		
//		
//		System.out.print("정수를 입력하시오 : ");
//		int bound = sc.nextInt();
//		
//		for (int i = 0; i < bound; i++) {
//			for (int j = 0; j < bound; j++) {
//				if (j < i) {
//					System.out.print(" ");
//				}
//				else {
//					System.out.print("*");
//				}
//			}/////////////////end of j for
//			System.out.println();
//		}/////////////////////end of i for
//		sc.close();
	}
}
