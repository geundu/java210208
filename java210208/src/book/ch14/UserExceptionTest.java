package book.ch14;

public class UserExceptionTest {
	public void test(String[] str) throws UserException {
		System.out.println("test 호출 성공");

		if (str.length < 1)
			throw new UserException("형 아무 것도 없어요");
		else
			throw new UserException("최종예선", 7000);
	}

	public static void main(String[] args) {
		UserExceptionTest uet = new UserExceptionTest();

		try {
			uet.test(args);
		}
		catch (UserException e) {
//			e.printStackTrace();
			/*
			라인번호도 안 나와서 println은 구리다.
			System.out.println("[[[[[[[[[[[[[[UserException]]]]]]]]]]]]]] " + e.toString());
			*/
//			System.out.println(e.printStackTrace()); 불가능하다.
//			System.exit(0); 여기서 JVM과의 연결이 끊기면 finally를 타지 않는다.
		}
		catch (Exception e) {
			e.toString();
			e.getMessage();
			e.printStackTrace();
		}
		finally {
			System.out.println("마지막에 태워줘");
		}
	}
}
