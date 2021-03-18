package thread.bakery;

import java.util.Vector;

public class BreadStack {

	Vector<String> breadVector = new Vector<String>();

	public synchronized String pop() {
		String bread = null;

		if (breadVector.size() == 0) {
			System.out.println("빵이 없습니다.");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		bread = breadVector.remove(breadVector.size() - 1);
		return bread;
	}

	public void push(String bread) {
		breadVector.add(bread);
		this.notify();
	}
}
