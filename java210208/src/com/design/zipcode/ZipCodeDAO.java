package com.design.zipcode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import com.util.DBConnectionMgr;

public class ZipCodeDAO {

	DBConnectionMgr dbMgr = null;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public ZipCodeDAO() {
		dbMgr = DBConnectionMgr.getInstance();

		try {
			con = dbMgr.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * SELECT '전체' zdo FROM dual UNION ALL SELECT DISTINCT(zdo) FROM zipcode_t ORDER
	 * BY zdo ASC;
	 * 
	 * @return 전체 경기 강원 경북...
	 */
	public String[] getZdoList() {
		String[] zdos = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT '전체' zdo FROM dual UNION ALL SELECT DISTINCT(zdo) FROM zipcode_t ORDER BY zdo ASC");
		try {
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			Vector<String> vec = new Vector<String>();
			while (rs.next()) {
				String zdo = rs.getString("zdo");
				vec.add(zdo);
			}
			zdos = new String[vec.size()];
			vec.copyInto(zdos);

			dbMgr.freeConnection(con, pstmt, rs);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return zdos;
	}

	// 클래스 쪼개기에서 초급자가 항상 염두할 사항은 배달사고
	public ArrayList<ZipCodeVO> getZipCodeList(String dong) {
		System.out.println("getZipCodeList called successfully. " + dong);
		
		ArrayList<ZipCodeVO> zipcodeList = new ArrayList<ZipCodeVO>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT zipcode, address FROM zipcode_t WHERE dong LIKE ?||'%'");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dong);
			rs = pstmt.executeQuery();
			ZipCodeVO zcVO = null;
			while (rs.next()) {
				zcVO = new ZipCodeVO();
				zcVO.setZipcode(rs.getInt("zipcode"));
				zcVO.setAddress(rs.getString("address"));
				zipcodeList.add(zcVO);
			}

			dbMgr.freeConnection(con, pstmt, rs);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return zipcodeList;
	}

	/**********************************************************************
	 * 회원가입 사용자로부터 id, nickname, password 입력받아서 chat 테이블에 추가
	 * 
	 * @param id       - 사용자로부터 입력받는 아이디
	 * @param nickname - 사용자로부터 입력받는 닉네임
	 * @param password - 사용자로부터 입력받는 비밀번호
	 **********************************************************************/
	public void join(String m_id, String m_pw, String m_nickname, String m_name, int m_sex, int m_zipcode,
			String m_address) {
		Connection con = dbMgr.getConnection();
		try {
			String sql = "INSERT INTO membership_t(m_id, m_pw, m_nickname, m_name, m_sex, m_zipcode, m_address)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m_id);
			pstmt.setString(2, m_pw);
			pstmt.setString(3, m_nickname);
			pstmt.setString(4, m_name);
			pstmt.setInt(5, m_sex);
			pstmt.setInt(6, m_zipcode);
			pstmt.setString(7, m_address);
			pstmt.executeUpdate();

			dbMgr.freeConnection(con, pstmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**********************************************************************
	 * 회원가입 중복체크
	 * 
	 * @param id - 사용자로부터 입력받는 id
	 * @return 기본 false, 아이디 받아서 DB값이랑 비교해서 하나라도 일치하면 true
	 ***********************************************************************/
	public boolean idCompare(String id) {
		boolean isDuplicate = false;
		Connection con = dbMgr.getConnection();
		try {
			String sql = "SELECT id FROM chat";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					if (rs.getString("id").equals(id)) {
						isDuplicate = true;
						break;
					}
				} while (rs.next());
			}
			dbMgr.freeConnection(con, pstmt, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isDuplicate;
	}

	/**********************************************************************
	 * @param id       - 사용자로부터 입력받는 id
	 * @param password - 사용자로부터 입력받는 password
	 * @return 1:로그인 성공 2:비밀번호 불일치 3:등록된 아이디 없음
	 ***********************************************************************/
	public int login(String id, String password) {
		int result = 0;
		Connection con = dbMgr.getConnection();
		try {
			String sql = "SELECT password FROM chat WHERE id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString("password").equals(password)) {
					System.out.println("로그인 성공");
					result = 1;
				} else {
					System.out.println("비밀번호가 틀렸습니다");
					result = 2;
				}
			} else {
				System.out.println("등록된 아이디가 없습니다");
				result = 3;
			}
			dbMgr.freeConnection(con, pstmt, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**********************************************************************
	 * @param id - 사용자가 입력한 아이디
	 * @return 입력한 아이디와 일치하는 레코드의 닉네임
	 ***********************************************************************/
	public String getNickname(String id) {
		String nickname = "";
		Connection con = dbMgr.getConnection();
		try {
			String sql = "SELECT nickname FROM chat WHERE id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				nickname = rs.getString("nickname");
			}
			dbMgr.freeConnection(con, pstmt, rs);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nickname;
	}
	
//	public static void main(String[] args) {
//		ZipCodeDAO zcdao = new ZipCodeDAO();
//		ArrayList<ZipCodeVO> al = new ArrayList<ZipCodeVO>();
//		
//		al = zcdao.getZipCodeList("가산동"); 
//		
//		for (ZipCodeVO z : al) {
//			System.out.println(z.getAddress() + " " + z.getZipcode());
//		}
//		
//	}
	
}
