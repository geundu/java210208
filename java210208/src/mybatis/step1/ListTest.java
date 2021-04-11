package mybatis.step1;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ListTest {

	String				resource	= "mybatis\\step1\\MapperConfig.xml";
	SqlSessionFactory	sqlMapper	= null;

	public List<Map<String, Object>> testMap() {
		List<Map<String, Object>>	bookList	= null;
		SqlSession					session		= null;
		MessengerMap				msgrMap		= MessengerMap.getInstance();

		try {
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
//			Map<String, Object> pMap = new HashMap<String, Object>();
			session = sqlMapper.openSession();

			msgrMap.getMap().put("id", "testuser1");
			msgrMap.getMap().put("password", "123");

//			pMap.put("id", "testuser1");
//			pMap.put("password", "123");
//			msgrMap.setMap(pMap);
//			bookList = session.selectList("mybatis.mapper.testMapper.selectList", msgrMap.getMap());
			bookList = session.selectList("mybatis.mapper.testMapper.selectList2", msgrMap.getMap());

			session.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

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
