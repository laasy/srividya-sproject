package com.cg.map.service;

import com.cg.map.exception.MPException;
import com.cg.map.model.MobileDetails;
import com.cg.map.model.Mobiles;

public interface MAPService {

	boolean validateFields(MobileDetails details) throws MPException;

	int addPurchaseDetails(MobileDetails details) throws MPException;

	int deleteBasedonId(Mobiles mobiles2) throws MPException;

}
