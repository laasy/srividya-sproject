package com.cg.map.dao;

public class QueryMapper {
	
     
	public static final String insertPurchaseDetails = "INSERT into purchasedetails values(purchaseid_seq.nextval,?,?,?,sysdate,?)";
	
	public static final String getpurchaseId = "SELECT purchasedetails_seq.CURRVAL FROM dual";

	public static final String updateBasedOnQuantity = "update mobiles set quantity = quantity-1 where mobileid = ?";
	
	public static final String deleteBasedOnId = "delete from mobiles where mobileid = ? ";
	
	public static final String selectAll = "select *from mobiles ";
	
}
