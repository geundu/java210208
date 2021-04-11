package mvc.address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.util.DBConnectionMgr;

public class RetrieveEntity {
	Logger				logger	= LogManager.getLogger(RetrieveEntity.class);
	Connection			con		= null;
	PreparedStatement	pstmt	= null;
	ResultSet			rs		= null;

	/**
	 * SELECT 컬럼1, 컬럼2, ... FROM mkaddrtb WHERE 주소순번 = ?
	 * 
	 * @param vo - vo.getId();
	 * @return AddressVO (or Map)
	 */
	public AddressVO select(AddressVO pVO) {
		System.out.println("RetrieveEntity's select(AddressVO) 호출 성공");
		return null;
	}

	public Map<String, Object> selectMap() {
		System.out.println("RetrieveEntity's select() 호출 성공");
		return null;
	}

	public AddressVO[] select() {
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT id, name, address, telephone, gender, relationship, birthday, comments, tegistedate FROM mkaddrtb");

		DBConnectionMgr		dbMgr	= DBConnectionMgr.getInstance();
		Vector<AddressVO>	v		= new Vector<AddressVO>();
		AddressVO[]			aVOS	= null;

		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(String.valueOf(sql));
			rs = pstmt.executeQuery();
			AddressVO aVO = null;

			while (rs.next()) {
				aVO = new AddressVO();
				aVO.setId(rs.getInt("id"));
				aVO.setName(rs.getString("name"));
				aVO.setAddress(rs.getString("address"));
				aVO.setTelephone(rs.getString("telephone"));
				aVO.setGender(rs.getString("gender"));
				aVO.setRelationship(rs.getString("relationship"));
				aVO.setBirthday(rs.getString("birthday"));
				aVO.setComments(rs.getString("comments"));
				aVO.setRegistedate(rs.getString("registedate"));
				v.add(aVO);
			}
			aVOS = new AddressVO[v.size()];
			v.copyInto(aVOS);
		}
		catch (SQLException e) {
			logger.info(e);
		}
		return aVOS;
	}

	public List<AddressVO> selectList(AddressVO pVO) {
		List<AddressVO>	addressList	= null;

		AddressDAO		aDAO		= new AddressDAO();
		addressList = aDAO.selectList(pVO);

		System.out.println("RetrieveEntity's selectList(AddressVO) 호출 성공");
		return addressList;
	}
}
