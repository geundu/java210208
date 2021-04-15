package book.ch14;

public class UserException extends Exception {

	private int port = 7000;

	public UserException() {

	}

	public UserException(String msg) {
		// Exception을 가리킨다.
		super(msg);
	}

	public UserException(String msg, int port) {
		super(msg);
		// super 클래스에는 생성자 파라미터에 두 번째 자리에 int인 생성자가 없다
//		super(msg, port);
	}

	public int getPort() {
		return port;
	}
}
