package com.dlizarra.starter.purchase;

import java.util.List;

public interface PurchaseService {

	void createPurchase(PurchaseDto purchase);

	void updatePurchase(Integer id, String procmanname, Float totalperprocmanname, String prodname, String date, Float price);

	void deletePurchase(Integer id);

	PurchaseDto getPurchase(Integer id);

	List<PurchaseDto> getPurchases();

}
