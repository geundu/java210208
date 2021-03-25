package com.design.zipcode;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ZipCodeDAO_MyBatis {

	String				resource	= "mybatis\\step1\\MapperConfig.xml";
	SqlSessionFactory	sqlMapper	= null;

	public List<Map<String, Object>> getZipCodeList() {
		List<Map<String, Object>>	bookList	= null;
		SqlSession					session		= null;

		try {
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			// auto commit true
//			session = sqlMapper.openSession(true);
			// auto commit false
			session = sqlMapper.openSession();
			bookList = session.selectList("mybatis.mapper.BookMapper.currentTime");

			session.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return bookList;
	}
}