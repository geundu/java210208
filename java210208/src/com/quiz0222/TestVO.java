package com.quiz0222;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestVO {
	
	public void testConect() {
		
		Connection conn = null; //자바와 데이터베이스를 연결
		Statement stmt = null; //쿼리문 대기 및 설정
		ResultSet rset = null; //결과값 받아오기
		
		try {
			String dbURL = "jdbc:oracle:thin:@121.139.85.156:15210:orcl11";
			String dbID = "SCOTT";
			String dbPassword = "tiger";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			System.out.println(conn);
			String sql = "SELECT * FROM emp";
//			String sql = "SELECT dvo.deptno, d.dname, e.ename FROM dvo, evo"
//					+ "WHERE evo.deptno(+) = d.deptno";
			
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			while (rset.next()) {
				System.out.println(rset.getInt("EMPNO") + ", " +
                        rset.getString("ENAME") + ", " +
                        rset.getString("JOB") + ", " +
                        rset.getInt("MGR") + ", " +
                        rset.getString("HIREDATE") + ", " +
                        rset.getInt("SAL") + ", " +
                        rset.getInt("COMM") + ", " +
                        rset.getInt("DEPTNO")
						);
				
			}
			
		}
		catch (ClassNotFoundException e1){
			e1.printStackTrace();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e3) {
				e3.printStackTrace();
			}
		}
	}
	

	public static void main(String[] args) {
		EmpVO evo = new EmpVO();
		DeptVO dvo = new DeptVO();
		
		TestVO tvo = new TestVO();
		tvo.testConect();

	}

}
