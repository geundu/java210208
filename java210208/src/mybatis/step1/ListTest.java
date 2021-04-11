package mybatis.step1;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.util.MyBatisCommonFactory;

public class ListTest {

	SqlSessionFactory factory = null;

	public List<Map<String, Object>> testMap() {

		factory = MyBatisCommonFactory.getInstance();
		List<Map<String, Object>>	bookList	= null;
		SqlSession					session		= factory.openSession();
		MessengerMap				msgrMap		= MessengerMap.getInstance();

		bookList = session.selectList("mybatis.mapper.testMapper.selectZipCode", msgrMap.getMap());

		session.close();

		return bookList;
	}

	public static void main(String[] args) {

		ListTest					lt		= new ListTest();
		List<Map<String, Object>>	list	= null;

		list = lt.testMap();

		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
	}
}
