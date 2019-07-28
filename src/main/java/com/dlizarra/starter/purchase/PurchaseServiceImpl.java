package com.dlizarra.starter.purchase;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dlizarra.starter.support.orika.OrikaBeanMapper;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@Autowired
	private OrikaBeanMapper mapper;
	
	@Override
	public void createPurchase(PurchaseDto purchase) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public void updatePurchase(Integer id, String procmanname, Float totalperprocmanname, String prodname, String date, Float price) {
		Purchase purchaseToUpdate = new Purchase(id, procmanname, 0F, prodname, date, price);
		System.out.println("Updating id " + id);		// TODO remove or replace by real logging
		System.out.println("Values " + purchaseToUpdate);
		this.purchaseRepository.save(purchaseToUpdate);
	}

	@Transactional
	@Override
	public void deletePurchase(Integer id) {
		System.out.println("Deleting id " + id);		// TODO remove or replace by real logging
		this.purchaseRepository.delete(id);
	}

	@Override
	public PurchaseDto getPurchase(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Transactional(readOnly = true)
	@Override
	public List<PurchaseDto> getPurchases() {
		final List<Purchase> purchases = purchaseRepository.findAll(new Sort("id"));
		final List<PurchaseDto> purchasesDto = new ArrayList<PurchaseDto>();
		purchases.forEach(x -> purchasesDto.add(mapper.map(x, PurchaseDto.class)));

		return purchasesDto;		
	}


	

}
