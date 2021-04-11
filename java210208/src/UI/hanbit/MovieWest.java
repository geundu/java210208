package UI.hanbit;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class MovieWest extends JPanel implements ActionListener {

	String[]	buttonName	= null;
	JButton[]	buttons		= null;
	MovieCenter	mc			= null;
	Font		font		= new Font("맑은 고딕", Font.BOLD, 20);

	public MovieWest(MovieCenter mc) {
		this.mc = mc;
		panelInit();
	}

	public void panelInit() {
		this.setLayout(new GridLayout(10, 1));
		buttonName = new String[10];
		buttons = new JButton[buttonName.length];

		for (int i = 0; i < buttonName.length; i++) {
			buttonName[i] = "버튼" + (i + 1);
			buttons[i] = new JButton(buttonName[i]);
			buttons[i].setFont(font);
			buttons[i].addActionListener(this);
			this.add(buttons[i]);

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (buttons[0] == obj) {
//			JColorChooser	chooser			= new JColorChooser();
			Color selectedColor = JColorChooser.showDialog(this, "색상을 선택하시오", Color.BLACK);
			mc.setBackground(selectedColor);
		}
		else if (buttons[1] == obj) {
			
		}
	}
}
