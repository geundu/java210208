package common.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.util.DBConnectionMgr;

public class MemberDAO {
	Connection con = null;
	CallableStatement cstmt = null;
	DBConnectionMgr dbMgr = null;

	public String login(String p_id, String p_pw) {
		dbMgr = DBConnectionMgr.getInstance();
		String msg = "";
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_login80(?, ?, ?)}");
			cstmt.setString(1, p_id);
			cstmt.setString(2, p_pw);
			cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			int result = cstmt.executeUpdate();
			if (result == 1) {
				msg = cstmt.getString(3);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbMgr.freeConnection(con, cstmt);
		}
		return msg;
	}
}
