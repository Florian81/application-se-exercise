package com.dlizarra.starter.purchase;

public class ProcmanPurchaseSumPair {
	private String procmanname;
	private Float purchasesum;
	
	public String getProcmanname() {
		return this.procmanname;
	}
	
	public Float getPurchaseSum() {
		return this.purchasesum;
	}
	
	public void addToPurchaseSum(Float price) {
		this.purchasesum+=price;
	}
	
	public ProcmanPurchaseSumPair(String procmanname, Float purchasesum) {
		super();
		this.procmanname = procmanname;
		this.purchasesum = purchasesum;
	}
	
		
}
