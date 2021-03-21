package athread.talk2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

public class GeunduServerThread extends Thread {
	public GeunduServer gs = null;
	Socket client = null;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	String chatName = null;//현재 서버에 입장한 클라이언트 스레드 닉네임 저장

	public GeunduServerThread(GeunduServer gs) {
		this.gs = gs;
		this.client = gs.socket;
		try {
			oos = new ObjectOutputStream(client.getOutputStream());
			ois = new ObjectInputStream(client.getInputStream());
			String msg = (String) ois.readObject();
			gs.jta_log.append(msg + "\n");
			StringTokenizer st = new StringTokenizer(msg, "#");
			st.nextToken();//100
			chatName = st.nextToken();
			gs.jta_log.append(chatName + "님이 입장하였습니다.\n");
			for (GeunduServerThread tst : gs.globalList) {
				//이전에 입장해 있는 친구들 정보 받아내기
				//String currentName = tst.chatName;
				this.send(100 + "#" + tst.chatName);
			}
			//현재 서버에 입장한 클라이언트 스레드 추가하기
			gs.globalList.add(this);
			this.broadCasting(msg);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	//현재 입장해 있는 친구들 모두에게 메시지 전송하기 구현
	public void broadCasting(String msg) {
		for (GeunduServerThread tst : gs.globalList) {
			tst.send(msg);
		}
	}

	//클라이언트에게 말하기 구현
	public void send(String msg) {
		try {
			oos.writeObject(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		String msg = null;
		boolean isStop = false;
		try {
			//while(true) {//무한루프에 빠질 수 있다.
			run_start: while (!isStop) {
				msg = (String) ois.readObject();
				gs.jta_log.append(msg + "\n");
				gs.jta_log.setCaretPosition(gs.jta_log.getDocument().getLength());
				StringTokenizer st = null;
				int protocol = 0;//100|200|201|202|500
				if (msg != null) {
					st = new StringTokenizer(msg, "#");
					protocol = Integer.parseInt(st.nextToken());//100
				}
				switch (protocol) {
				case 200: {

				}
					break;
				case 201: {
					String nickName = st.nextToken();
					String message = st.nextToken();
					broadCasting(201 + "#" + nickName + "#" + message);
				}
					break;
				case 202: {
					String nickName = st.nextToken();
					String afterName = st.nextToken();
					String message = st.nextToken();
					this.chatName = afterName;
					broadCasting(202 + "#" + nickName + "#" + afterName + "#" + message);
				}
					break;
				case 500: {
					String nickName = st.nextToken();
					gs.globalList.remove(this);
					broadCasting(500 + "#" + nickName);
				}
					break run_start;
				}/////////////end of switch
			} /////////////////end of while			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}/////////////////////////end of run
}