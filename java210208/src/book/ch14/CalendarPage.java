package book.ch14;

import javax.swing.JFrame;

public class CalendarPage extends JFrame {

	public CalendarPage() {

	}

	/**
	 * 
	 * @param mm : 0~11 사이의 숫자를 입력받는다.
	 * @param yy : 달력의 연도를 입력받는다.
	 */
	public void print(int mm, int yy) throws Exception {
		System.out.println("print() 호출 성공");

		if (mm < 0 || mm > 11) {
			throw new IllegalArgumentException("mm must be 0 ~ 11");
		}
		System.out.println("응애");
	}

	public void initDisplay() {
		this.setSize(400, 300);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		CalendarPage calendarPage = new CalendarPage();

		if (args.length == 2) {

			try {
				calendarPage.print(Integer.parseInt(args[0]) - 1, Integer.parseInt(args[1]));
			}
			catch (NumberFormatException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		else {
			System.out.println("달과 연도를 입력하십시오.");
			return;
		}
	}
}
