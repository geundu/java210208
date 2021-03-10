package com.design.zipcode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.util.DBConnectionMgr;

public class ZipCodeDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	DBConnectionMgr dbmgr = null;

	public ZipCodeDAO() {
		dbmgr = DBConnectionMgr.getInstance();
	}

	// 클래스 쪼개기에서 초급자가 항상 염두할 사항은 배달사고
	public ArrayList<ZipCodeVO> getZipCodeList(String dong) {
		System.out.println("getZipCodeList called successfully. " + dong);
		ArrayList<ZipCodeVO> zipcodeList = null;
		return zipcodeList;
	}

	public void join(String id, String password, String address) {
		Connection con = dbmgr.getConnection();
		try {
			String sql = "INSERT INTO 새로만드는데스? (아이디, 비번, 우편번호?) VALUES (?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			pstmt.setString(3, address);
			pstmt.executeUpdate();

			dbmgr.freeConnection(con, pstmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
