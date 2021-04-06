package mvc.address;

import java.io.*;
import java.util.*;

public class AddressCtrl {

	private AddressVO		returnVO	= new AddressVO();

	private static String	_DEL		= "delete";
	private static String	_INS		= "insert";
	private static String	_MOD		= "update";
	private static String	_SEL		= "select";
	private static String	_ALL		= "selectall";

	public AddressCtrl() {

	}

	public AddressVO send(AddressVO pvo) throws Exception {
		String command = pvo.getCommand();

		if (_DEL.equals(command)) {
			System.out.println("_DEL 호출 성공");
			DeleteEntity del = new DeleteEntity();
			del.delete(pvo);
		}
		else if (_INS.equals(command)) {
			System.out.println("_INS 호출 성공");
			RegisterEntity regi = new RegisterEntity();
			regi.insert(pvo);
		}
		else if (_MOD.equals(command)) {
			System.out.println("_MOD 호출 성공");
			ModifyEntity modi = new ModifyEntity();
			modi.update(pvo);
		}
		else if (_SEL.equals(command)) {
			System.out.println("_SEL 호출 성공");
			RetrieveEntity ret = new RetrieveEntity();
			ret.select(pvo);
		}
		return returnVO;
	}

	public AddressVO[] send() throws Exception {
		AddressVO[] returnVOs = null;
		System.out.println("send() 호출 성공 - return type : AddressVO[]");
		return returnVOs;
	}

	public List<AddressVO> sendAll() throws Exception {
		List<AddressVO>	selectAll	= null;
		RetrieveEntity	ret			= new RetrieveEntity();
		selectAll = ret.selectList();
		System.out.println("sendAll() 호출 성공 - return type : List<AddressVO>");
		return selectAll;
	}

	public List<Map<String, Object>> sendAllMap() throws Exception {
		List<Map<String, Object>>	selectAll	= null;
		RetrieveEntity				ret			= new RetrieveEntity();
//		selectAll = ret.selectList();
		System.out.println("sendAllMap() 호출 성공 - return type : List<Map<String, Object>>");
		return selectAll;
	}
}
