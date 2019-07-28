package com.dlizarra.starter.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseController {

	@Autowired
	private PurchaseService purchaseService;

	@RequestMapping(value = "/purchasesum", method = RequestMethod.GET)
	public Float purchaseSum() {
		List<PurchaseDto> pList = purchaseService.getPurchases();
		Float sum = 0F;
		for (PurchaseDto p : pList) {
			sum += p.getPrice();
		}
		return sum;
	}
	
	@RequestMapping(value = "/purchases", method = RequestMethod.GET)
	public List<PurchaseDto> findAll() {
		return purchaseService.getPurchases();
	}

	@RequestMapping(value = "/deletePurchase", method = RequestMethod.GET)
	public List<PurchaseDto> delete(@RequestParam("id") Integer id) {
		purchaseService.deletePurchase(id);
		return purchaseService.getPurchases();
	}

	@RequestMapping(value = "/updatePurchase", method = RequestMethod.GET)
	public List<PurchaseDto> update(@RequestParam("id") 
		Integer id,
		String procmanname, 
		String prodname,
		String date,
		Float price)
	{
		purchaseService.updatePurchase(id, procmanname, prodname, date, price);
		return purchaseService.getPurchases();
	}

}
