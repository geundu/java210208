package constructor.step4;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JComboBoxTest1 extends JFrame implements ActionListener {

	JPanel jp_north = null;
	JComboBox<String> jcb_first = null;
	JComboBox<String> jcb_second = null;
	JComboBox<String> jcb_third = null;

	JComboBoxTest1() {
//		super("콤보박스 실습");

		Vector<String> firstItem = new Vector<String>();
		firstItem.add("전체");
		firstItem.add("가전");
		firstItem.add("컴퓨터");
		firstItem.add("모바일");

		String[] secondItem = { "전체" };

		jp_north = new JPanel();
		jcb_first = new JComboBox<>(firstItem);
		jcb_second = new JComboBox<>(secondItem);
		jcb_third = new JComboBox<>();
		initDisplay();
	}

	public void initDisplay() {
		jp_north.setBackground(Color.ORANGE);
		Font font = new Font("맑은 고딕", Font.PLAIN, 15);

		jcb_first.setFont(font);
		jcb_first.addActionListener(this);

		jcb_second.setFont(font);
		jcb_second.addActionListener(this);

		jcb_third.setFont(font);
		jcb_third.addItem("전체");
		jcb_third.addItem("냉장고");
		jcb_third.addItem("전기밥솥");
		jcb_third.addItem("에어프라이어");
		jcb_third.addActionListener(this);

		jp_north.add(jcb_first);
		jp_north.add(jcb_second);
		jp_north.add(jcb_third);
		this.add("North", jp_north);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("콤보박스 실습");
		this.setSize(500, 500);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new JComboBoxTest1();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (jcb_first.getSelectedItem().equals("가전")) {
			String[] secondItem = { "주방가전", "생활가전", "계절가전" };
			for (int i = 0; i < secondItem.length; i++) {
				jcb_second.addItem(secondItem[i]);
			}
		} else if (jcb_first.getSelectedItem().equals("컴퓨터")) {
			System.out.println("대분류 컴퓨터");
		} else {
			System.out.println("대분류 모바일");
		}
	}
}
