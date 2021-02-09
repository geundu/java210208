package variable.step1;

import java.util.Scanner;

public class Account {
	//메소드 안에 있는 , 는 열거형 연산자라고 한다.
	//접근제한자(Access modifier) - 수정자 - 리턴타입 - 메서드이름(매개변수 1, 2...)
	double sum(double kor,	double math, double eng) {
		double sumScore = kor + math + eng;
		System.out.print("점수 합 : " + sumScore + ", ");
		return sumScore;
	}
	
	/*********************************************
	 * 
	 * @param sum - 각 과목 점수의 합
	 * @param classNum - 과목 수
	 * @return
	 */
	double mean(double sum, int classNum) { //평균의 평균을 낼 수도 있기 때문에 return 줬음
		double meanScore = sum / classNum;
		System.out.println("평균 : " + String.format("%.2f", meanScore));
		return  meanScore;
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		Account acc = new Account();
		double[] korScore = new double[1000];
		double[] mathScore = new double[1000];
		double[] engScore = new double[1000];
		int classNum = 3;
		
		for (int i = 1; i <= 1000; i++) {
			
			System.out.print(i + "번째 학생의 국어 점수를 입력하시오 : ");
			korScore[i] = s.nextDouble();
			System.out.print(i + "번째 학생의 수학 점수를 입력하시오 : ");
			mathScore[i] = s.nextDouble();
			System.out.print(i + "번째 학생의 영어 점수를 입력하시오 : ");
			engScore[i] = s.nextDouble();
			acc.mean(acc.sum(korScore[i], mathScore[i], engScore[i]), classNum);
		}
	}
}
