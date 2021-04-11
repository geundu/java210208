package UI.hanbit;

import java.awt.Color;

import javax.swing.JFrame;

public class MovieManager extends JFrame {

	MovieCenter	jp_center	= null;
	MovieWest	jp_west		= null;

	public MovieManager() {
		jp_center = new MovieCenter();
		jp_center.setBackground(Color.ORANGE);
		jp_west = new MovieWest(jp_center);
		jp_west.setBackground(Color.CYAN);
	}

	public void initDisplay() {
		this.add("Center", jp_center);
		this.add("West", jp_west);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Movie Manager");
		this.setSize(500, 400);
		this.setResizable(false);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		MovieManager manage = new MovieManager();
		manage.initDisplay();
	}
}
