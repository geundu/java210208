package UI.hanbit;

import javax.swing.JFrame;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BookManager extends JFrame {

	Logger				logger	= LogManager.getLogger(BookManager.class);
//	JFrame				jf		= new JFrame();
//	static JFrame		bm		= new BookManager();
//	static BookManager	bm2		= new BookManager();
	static BookManager	bm3		= null;

	public BookManager() {

//		bm.initDisplay();
//		jf.initDisplay();
//		initDisplay();
//		this.setSize(500, 300);

		bm3.setSize(600, 700);
		bm3.setVisible(true);

//		this.setSize(600, 700);
//		this.setVisible(true);
	}

	public void initDisplay() {
		logger.info("initDisplay() called successfully.");
	}

	public static void main(String[] args) {
		bm3 = new BookManager();
		bm3.initDisplay();

	}
}
