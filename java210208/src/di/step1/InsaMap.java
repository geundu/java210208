package di.step1;

import java.util.Map;

public class InsaMap extends Object {

	private Map<String, String> mapBean = null;

	public void printMap() {
		System.out.println(mapBean);

		if (mapBean != null) {

			for (int i = 0; i < mapBean.size(); i++) {
				System.out.print(mapBean.get("prop" + (i + 1)) + " ");
			}
			System.out.println();
		}
	}

	public Map<String, String> getMapBean() {
		return mapBean;
	}

	// setter 객체주입법 - java에서 하는 거, mybatis의 경우 java 코드의 경우 jar의 형태로 주입되므로,
	// constructor 주입법으로 처리함
	// DB커넥션 풀도 java 표준에서 제공하는 것은 아니므로 constructor 주입법으로 처리해야 할 것이다(xml에서 처리하는 것).
	public void setMapBean(Map<String, String> mapBean) {
		this.mapBean = mapBean;
	}

}
