package com.dlizarra.starter.purchase;

import java.util.ArrayList;
import java.util.HashSet;
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

	@RequestMapping(value = "/addpurchase", method = RequestMethod.GET)
	public List<PurchaseDto> addPurchase() {
		System.out.println("Adding Mockup Data");	// TODO real logging
		purchaseService.updatePurchase(0, "Hans", 0F, "A cup of tea", "1.1.2020", 23.2f);
		return purchaseService.getPurchases();
	}
	

	@RequestMapping(value = "/purchasesum", method = RequestMethod.GET)
	public Float purchaseSum() {
		List<PurchaseDto> pList = purchaseService.getPurchases();

		// TODO should be implemented in SQL and not in code
		Float totalPurchaseSum = 0F;
		for (PurchaseDto p : pList) {
			totalPurchaseSum += p.getPrice();
		}
		return totalPurchaseSum;
	}

	@RequestMapping(value = "/purchases", method = RequestMethod.GET)
	public List<PurchaseDto> findAll() {
		List<PurchaseDto> pList = purchaseService.getPurchases();

		// TODO this should (definitely!) be done in an SQL-SUM statement and not in
		// code. This is really bad: has O+2O^2-Complexity (!), is bad to read and
		// verbose...
		// ... --> learn JPA ;-)
		List<ProcmanPurchaseSumPair> procmansumpair = new ArrayList<ProcmanPurchaseSumPair>();
		HashSet<String> procmans = new HashSet<String>(); // used to create a list of unique procurement managers
		for (PurchaseDto p : pList) {
			if (procmans.add(p.getProcmanname())) {
				procmansumpair.add(new ProcmanPurchaseSumPair(p.getProcmanname(), 0F));
			}
		}
		for (PurchaseDto p : pList) {
			for (ProcmanPurchaseSumPair thisPair : procmansumpair) {
				if (p.getProcmanname().equals(thisPair.getProcmanname())) {
					thisPair.addToPurchaseSum(p.getPrice());
				}
			}
		}
		for (PurchaseDto p : pList) {
			for (ProcmanPurchaseSumPair thisPair : procmansumpair) {
				if (p.getProcmanname().equals(thisPair.getProcmanname())) {
					p.setTotalperprocmanname(thisPair.getPurchaseSum());
				}
			}
		}

		return pList;
	}

	@RequestMapping(value = "/deletePurchase", method = RequestMethod.GET)
	public List<PurchaseDto> delete(@RequestParam("id") Integer id) {
		purchaseService.deletePurchase(id);
		return purchaseService.getPurchases();
	}

	@RequestMapping(value = "/updatePurchase", method = RequestMethod.GET)
	public List<PurchaseDto> update(@RequestParam("id") Integer id, String procmanname, Float totalperprocmanname,
			String prodname, String date, Float price) {
		purchaseService.updatePurchase(id, procmanname, 0F, prodname, date, price);
		return purchaseService.getPurchases();
	}

}
