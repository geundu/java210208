package book.ch5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.quiz0222.DeptVO;

public class AddressDialog2 extends JDialog implements ActionListener{
	
	JPanel 		jp_center 		= new JPanel();
	JPanel 		jp_south 		= new JPanel();
	JScrollPane jsp 			= null;
	JLabel 		jlb_deptno 		= new JLabel("부서번호");
	JTextField 	jtf_deptno	 	= new JTextField();
	JLabel 		jlb_dname 		= new JLabel("부서이름");
	JTextField 	jtf_dname 		= new JTextField();
	JLabel 		jlb_loc 		= new JLabel("지역");
	JTextField 	jtf_loc 		= new JTextField();
	JButton 	jb_account 		= new JButton("처리");
	JButton 	jb_close 		= new JButton("닫기");
	DeptVO 		dVO 			= null;
	static AddressBook2 aBook 	= null;
	
	
	/*
	 * @param str - 사용자가 선택한 요청에 대한 제목을 정함
	 * @param aBook - 부모창에서 화면처리에 대한 원본 주소번지가 필요
	 * 입력일 때 새 창을 열어서 입력을 받음
	 * 수정일 때는 오라클을 경유해서 그 결과를 화면에 출력해놓고 수정할 정보만 입력받음
	 * 상세조회일 때 오라클 경유하여 한 건만 출력해야 함 read only
	 * 수정과 입력일 때는 writable
	 * 수정과 상세조회 하나로 묶고 입력을 묶어서 처리
	 * 오라클을 경유했을 때 VO 유지해야 함
	 * 그 값을 가진 주소번지를 부모창에서 받아 자식창의 이벤트처리 메서드인
	 * actionPerformed에서 재사용해야 하므로 전역변수로 선언한 다음 지역변수와 초기화하여 사용하도록 한다
	 */
	public void set(String title, DeptVO dVO, AddressBook2 aBook) {
		this.aBook = aBook;
		this.dVO = dVO;
		this.setTitle(title);
	}
	
	public AddressDialog2() {
		initDisplay();
	}
	public void initDisplay() {
		this.setSize(400, 500);
		this.setVisible(false);
		
		jp_center.setLayout(null);
		jlb_deptno.setBounds(20, 20, 100, 20);
		jtf_deptno.setBounds(130, 20, 100, 20);
		jp_center.add(jlb_deptno);
		jp_center.add(jtf_deptno);
		jlb_dname.setBounds(20, 45, 100, 20);
		jtf_dname.setBounds(130, 45, 100, 20);
		jp_center.add(jlb_dname);
		jp_center.add(jtf_dname);
		jlb_loc.setBounds(20, 70, 100, 20);
		jtf_loc.setBounds(130, 70, 100, 20);
		jp_center.add(jlb_loc);
		jp_center.add(jtf_loc);
		
		jsp = new JScrollPane(jp_center);
		
		jp_south.add(jb_account);
		jp_south.add(jb_close);
		jb_account.addActionListener(this);
		jb_close.addActionListener(this);
		this.add("Center", jsp);
		this.add("South", jp_south);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if ("처리".equals(command)) {
			aBook.refresh();
		}
		if ("닫기".equals(command)) {
			this.dispose();
		}
		//처리버튼을 눌렀을 때
		//입력을 처리, 수정을 처리,
		//목적지가 다시 부모창의 목록페이지로 돌아가서 새로고침 일어남
		//부모창의 주소번지가 있어야 새로고침 처리하는 메서드 호출 가능
		//닫기 버튼을 눌렀을 때
		
		
	}
}
