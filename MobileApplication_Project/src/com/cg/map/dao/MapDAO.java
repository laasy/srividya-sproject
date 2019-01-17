package com.cg.map.dao;

import com.cg.map.exception.MPException;
import com.cg.map.model.MobileDetails;
import com.cg.map.model.Mobiles;

public interface MapDAO {

	int addPurchaseDetails(MobileDetails details) throws MPException;

	int deleteBasedOnId(Mobiles mobiles2) throws MPException;

}
