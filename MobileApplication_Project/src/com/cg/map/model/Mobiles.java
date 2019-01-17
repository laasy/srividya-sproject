package com.cg.map.model;

public class Mobiles {

	private Integer mobileid;
	private String name;
	private Double price;
	private Integer quantity;

	public Mobiles() {

	}

	public Integer getMobileid() {
		return mobileid;
	}

	public void setMobileid(Integer mobileid) {
		this.mobileid = mobileid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Mobiles(Integer mobileid, String name, Double price, Integer quantity) {
		super();
		this.mobileid = mobileid;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}


}
