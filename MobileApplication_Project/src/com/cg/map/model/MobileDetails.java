package com.cg.map.model;

import java.util.Date;

public class MobileDetails {

	private String Customer_Name;
	private String MailId;
	private Long Phone_Number;
	private Integer PurchaseId;
	private Date Purchase_date;
    private Integer Mobile_id;
    
    
	public MobileDetails() {

	}

	public String getCustomer_Name() {
		return Customer_Name;
	}

	public void setCustomer_Name(String customer_Name) {
		Customer_Name = customer_Name;
	}

	public String getMailId() {
		return MailId;
	}

	public void setMailId(String mailId) {
		MailId = mailId;
	}

	public Long getPhone_Number() {
		return Phone_Number;
	}

	public void setPhone_Number(Long phone_Number) {
		Phone_Number = phone_Number;
	}

	public Integer getPurchaseId() {
		return PurchaseId;
	}

	public void setPurchaseId(Integer purchaseId) {
		PurchaseId = purchaseId;
	}

	public Date getPurchase_date() {
		return Purchase_date;
	}

	public void setPurchase_date(Date purchase_date) {
		Purchase_date = purchase_date;
	}

	public MobileDetails(String customer_Name, String mailId,
			Long phone_Number, Integer purchaseId, Date purchase_date) {
		super();
		Customer_Name = customer_Name;
		MailId = mailId;
		Phone_Number = phone_Number;
		PurchaseId = purchaseId;
		Purchase_date = purchase_date;
	}

	public Integer getMobile_id() {
		return Mobile_id;
	}

	public void setMobile_id(Integer mobile_id) {
		this.Mobile_id = mobile_id;
	}
}
