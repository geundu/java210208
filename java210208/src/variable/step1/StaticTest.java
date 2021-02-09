package variable.step1;


public class StaticTest {
	/**************************
	 * 
	 * non-static 타입은 static 영역에서 접근불가능
	 */
	static void avg() { // 사용자 정의 메서드
		System.out.println("avg 호출 성공");
	}
	int toInt(String s) {
		return Integer.parseInt(s);
	}
	static int toIntStatic(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		//main은 자바가 제공하는 메서드인가? true
		//사용자 정의 메서드(user definition method) 사용 가능
		
		if (args.length == 0) {
			//아래 문장은 조건에 따라 실행되지 않을 수도 있다
			System.out.println("argument가 없음");
			return; //main 종료
		}
		StaticTest st = new StaticTest();

		avg(); //static method
		int	toint = st.toInt(args[0]);
		int	toint_s = toIntStatic(args[0]);
		System.out.println(toint + 10);
		System.out.println(toint_s + 10);
		
	}

}
