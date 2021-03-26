package mvc.address;

import java.util.List;

public class RetrieveEntity {

	public AddressVO select(AddressVO vo) {
		System.out.println("RetrieveEntity's select(AddressVO) 호출 성공");
		return null;
	}

	public AddressVO[] select() {
		System.out.println("RetrieveEntity's select() 호출 성공");
		return null;
	}

	public List<AddressVO> selectList() {
		List<AddressVO>	addressList	= null;

		AddressDAO		aDAO		= new AddressDAO();
		addressList = aDAO.selectList();

		System.out.println("RetrieveEntity's selectList(AddressVO) 호출 성공");
		return addressList;
	}
}
