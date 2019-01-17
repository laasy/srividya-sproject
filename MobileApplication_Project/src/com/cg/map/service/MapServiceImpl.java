package com.cg.map.service;

import java.util.ArrayList;
import java.util.List;




import java.util.regex.Pattern;

import com.cg.map.dao.MapDAO;
import com.cg.map.dao.MapDAOImpl;
import com.cg.map.exception.MPException;
import com.cg.map.model.MobileDetails;
import com.cg.map.model.Mobiles;

public class MapServiceImpl implements MAPService{
	List<String> list = new ArrayList<>();
	MapDAO mapdao = new MapDAOImpl();
	
	
 	@Override
	public boolean validateFields(MobileDetails details) throws MPException {
 		boolean validateFlag = false;
 		
		if (!checkName(details.getCustomer_Name())) {
			list.add("Name must start with capital letter and the max length should be between(5-20)characters");
		}

		if (!checkMailid(details.getMailId())) {
			list.add("Enter a valid mail id");
		}

		if (!checkPhonenumber(details.getPhone_Number())) {
			list.add("phone number should contain excatly 10 digits starting with 6|7|8|9");
		}

		if (!list.isEmpty()) {
			throw new MPException(list + "");
		} else {
			validateFlag = true;
		}
		return validateFlag;
		
	}

	public boolean checkName(String name) {
		String nameRegEx = "[A-Z]{1}[A-Za-z\\s]{4,19}$";
		return Pattern.matches(nameRegEx, name);

	}

	public boolean checkMailid(String mailid) {
		String mailidRegEx = "[a-zA-Z0-9._]*@[A-Za-z]*\\.[a-zA-Z]*";
		return Pattern.matches(mailidRegEx,mailid);
	}

	public boolean checkPhonenumber(Long phoneNumber) {

		String phoneRegEx = "[6|7|8|9]{1}[0-9]{9}";
		return Pattern.matches(phoneRegEx, String.valueOf(phoneNumber));
		
	}
	@Override
	public int addPurchaseDetails(MobileDetails details) throws MPException {
		
		return mapdao.addPurchaseDetails(details);
	
	}
@Override
public int deleteBasedonId(Mobiles mobiles2) throws MPException {
	
	return mapdao.deleteBasedOnId(mobiles2);
}
}
