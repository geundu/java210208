package com.design.zipcode;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ZipCodeDAO_MyBatis {

	String				resource	= "mybatis\\step1\\MapperConfig.xml";
	SqlSessionFactory	sqlMapper	= null;

	public List<String> getZDOList() {
		List<String>	bookList	= null;
		SqlSession		session		= null;

		try {
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			// auto commit true
//			session = sqlMapper.openSession(true);
			// auto commit false
			session = sqlMapper.openSession();
			bookList = session.selectList("mybatis.mapper.ZipcodeMapper.getZDOList");

			session.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return bookList;
	}

	public static void main(String[] args) {
		List<String>		result	= new Vector<String>();
		ZipCodeDAO_MyBatis	dao		= new ZipCodeDAO_MyBatis();
		result = dao.getZDOList();

		for (String al : result) {
			System.out.println(al);
		}

	}
}