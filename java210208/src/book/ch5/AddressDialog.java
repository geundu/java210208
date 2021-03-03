package book.ch5;

import javax.swing.JDialog;

public class AddressDialog extends JDialog {
	
	private AddressDialog() {
		
	}
	
	public static AddressDialog getDialog() {
		AddressDialog aDia = null;
		if (aDia == null) {
			aDia = new AddressDialog();
		}
		return aDia;
	}
}
