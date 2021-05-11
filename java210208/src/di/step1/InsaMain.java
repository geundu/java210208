package di.step1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InsaMain {

	public static void main(String[] args) {

		ApplicationContext	context		= new ClassPathXmlApplicationContext("di\\step1\\insaBean.xml");
		InsaList			insalist	= (InsaList) context.getBean("insa");
		InsaMap				insamap		= (InsaMap) context.getBean("insaMap");

		insalist.printList();

		System.out.println(insalist.getInsaBean());

		InsaList insalist_not_spring = new InsaList();

		insalist_not_spring.printList();

		System.out.println("여기부터는 맵");

		System.out.println(insamap.getMapBean());

		((ClassPathXmlApplicationContext) context).close();
	}
}
