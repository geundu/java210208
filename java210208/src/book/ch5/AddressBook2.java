package book.ch5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.quiz0222.DeptVO;
import com.util.DBConnectionMgr;

public class AddressBook2 implements ActionListener {
	//선언부
	JFrame 				jf 			= null;
	JMenuBar 			jmb 		= new JMenuBar();
	JMenu 				jm_file 	= new JMenu("FILE");
	JMenu 				jm_oracle 	= new JMenu("DB 연동");
	JMenuItem 			jmi_sel 	= new JMenuItem("상세조회");
	JMenuItem 			jmi_selAll 	= new JMenuItem("전체조회");
	JMenuItem 			jmi_ins 	= new JMenuItem("입력");
	JMenuItem 			jmi_upd 	= new JMenuItem("수정");
	JMenuItem 			jmi_del 	= new JMenuItem("삭제");
	JMenuItem 			jmi_exit 	= new JMenuItem("종료");
	JMenuItem 			jmi_dbTest 	= new JMenuItem("오라클 연결");
	AddressDialog2 		aDia 		= new AddressDialog2();
	static AddressBook2 aBook 		= null;
	DeptVO 				dVO 		= null;
	
	String[] cols = {"부서번호", "부서명", "지역"};
	String[][] data = new String[0][3];
	//데이터셋을 담을 수 있는 클래스 생성하기
	//첫번째 파라미터 데이터영역, 두번째 컬럼 정보 초기화
	DefaultTableModel dtm_dept = new DefaultTableModel(data, cols);
	JTable jtb_dept = new JTable(dtm_dept);
	JScrollPane jsp_dept = new JScrollPane(jtb_dept);
	
	//생성자
	public AddressBook2() {
//		initDisplay();
	}
	
	//주소 목록 조회 - 새로고침 처리
	public void refresh() {
		System.out.println("refresh() called successfully");
	}
	
	//화면처리부
	public void initDisplay() {
		jf = new JFrame();
		jmb.add(jm_file);
		jmb.add(jm_oracle);
		jm_file.add(jmi_sel);
		jm_file.add(jmi_selAll);
		jm_file.add(jmi_ins);
		jm_file.add(jmi_upd);
		jm_file.add(jmi_del);
		jm_file.add(jmi_exit);
		jm_oracle.add(jmi_dbTest);
		jf.setJMenuBar(jmb);
		jf.add(jsp_dept);
		jmi_sel.addActionListener(this);
		jmi_ins.addActionListener(this);
		jmi_upd.addActionListener(this);
		jmi_del.addActionListener(this);
		jmi_dbTest.addActionListener(this);
		jmi_exit.addActionListener(this);
		jmi_selAll.addActionListener(this);
		jf.setTitle("주소록 ver1.0");
		jf.setSize(500, 400);
		jf.setVisible(true);
	}
	
	public static void main(String[] args) {
		aBook = new AddressBook2();
		aBook.initDisplay();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if (obj == jmi_sel) {
			int[] index = jtb_dept.getSelectedRows();
			
			if (index.length == 0) {
				JOptionPane.showMessageDialog(jf, "레코드를 선택해주세요."
												, "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (index.length > 1) {
				JOptionPane.showMessageDialog(jf, "레코드를 하나만 선택해주세요."
												, "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else {
				Integer deptno = Integer.parseInt(dtm_dept.getValueAt(index[0], 0).toString());
				
				DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String sql = "SELECT deptno, dname, loc FROM dept"
							+ " WHERE deptno = ?";
				try {
					con = dbMgr.getConnection();
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, deptno);
					rs = pstmt.executeQuery();
					
					if (rs.next()) {
						dVO = new DeptVO();
						dVO.setDeptno(rs.getInt("DEPTNO"));
						dVO.setDname(rs.getString("DNAME"));
						dVO.setLoc(rs.getString("LOC"));
					}
					else {
						dVO = new DeptVO();
					}
					aDia.set("상세조회", dVO, aBook, false);
					aDia.setTitle("상세조회");
					aDia.setVisible(true);
				} catch (SQLException se){
					System.out.println(se.getMessage());
				}////////////////////end of try-catch
				
			}///////////////////////end of inner if-else if-else
		}
		
		else if (obj == jmi_selAll) {
			DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			////////////////////////////[조회결과 처리]////////////////////////////////
//			DeptVO[] dVOS = null;
			String sql = "SELECT * FROM dept";
			
			try {
				con = dbMgr.getConnection();
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
//				DeptVO dVO = null;
				Vector<DeptVO> vecDVO = new Vector<DeptVO>();
				
				while(rs.next()) {
					dVO = new DeptVO();
					dVO.setDeptno(rs.getInt("DEPTNO"));
					dVO.setDname(rs.getString("DNAME"));
					dVO.setLoc(rs.getString("LOC"));
					vecDVO.add(dVO);
				}
//				dVOS = new DeptVO[vecDVO.size()];
//				vecDVO.copyInto(dVOS);
				
				while(dtm_dept.getRowCount() > 0) {
					dtm_dept.removeRow(0);
				}//////////////////////////이미 출력된 레코드 클리어
				
				for (int i = 0; i < vecDVO.size(); i++) {
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(vecDVO.get(i).getDeptno());
					oneRow.add(vecDVO.get(i).getDname());
					oneRow.add(vecDVO.get(i).getLoc());
					dtm_dept.addRow(oneRow);
					
//				for (int i = 0; i < dVOS.length; i++) {
//					Vector oneRow = new Vector();
//					oneRow.add(dVOS[i].getDeptno());
//					oneRow.add(dVOS[i].getDname());
//					oneRow.add(dVOS[i].getLoc());
//					dtm_dept.addRow(oneRow);
				}
			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}
			////////////////////////////[조회결과 처리]////////////////////////////////
		}
		
		else if (obj == jmi_ins) {
			
			/*
			 * @param1 제목 바꿔주기, 2는 조회된 결과 dialog에서 재사용해야할 경우 필요
			 * 3은 dialog에서 입력이 성공하거나 수정 성공하면 부모창 새로고침해야한다고 담당자 요청
			 * 4는 dialog 화면에서 사용자로부터 입력받는 JTextField들에 대한 상태값 반영  
			 * 
			 */
			aDia.set("입력", null, aBook, true);
			aDia.setTitle("입력");
		}
		else if (obj == jmi_upd) {
			
			int[] index = jtb_dept.getSelectedRows();
			
			if (index.length == 0) {
				JOptionPane.showMessageDialog(jf, "수정할 레코드를 선택해주세요."
												, "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (index.length > 1) {
				JOptionPane.showMessageDialog(jf, "수정할 레코드를 하나만 선택해주세요."
												, "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else {
				Integer deptno = Integer.parseInt(dtm_dept.getValueAt(index[0], 0).toString());
				
				DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String sql = "SELECT deptno, dname, loc FROM dept"
							+ " WHERE deptno = ?";
				try {
					con = dbMgr.getConnection();
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, deptno);
					rs = pstmt.executeQuery();
					
					if (rs.next()) {
						dVO = new DeptVO();
						dVO.setDeptno(rs.getInt("DEPTNO"));
						dVO.setDname(rs.getString("DNAME"));
						dVO.setLoc(rs.getString("LOC"));
					}
					else {
						dVO = new DeptVO();
					}
					aDia.set("수정", dVO, aBook, true);
					aDia.setTitle("수정");
					aDia.setVisible(true);
				} catch (SQLException se){
					System.out.println(se.getMessage());
				}////////////////////end of try-catch
				
			
			}///////////////////////end of inner if-else if-else
		}
		else if (obj == jmi_exit) {
			System.exit(0);
		}
		else if (obj == jmi_dbTest) {
			DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
			Connection con = dbMgr.getConnection();
			if (con != null) {
				JOptionPane.showMessageDialog(jf, "서버 연결 성공");
			}
			else
				JOptionPane.showMessageDialog(jf, "서버 연결 실패");
		}
		else {
			//삭제
		}
	}////////////////////end of actionPerformed
}
