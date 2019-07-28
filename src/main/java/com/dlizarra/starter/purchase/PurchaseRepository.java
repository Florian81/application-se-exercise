package com.dlizarra.starter.purchase;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.dlizarra.starter.support.jpa.CustomJpaRepository;

@Repository
public interface PurchaseRepository extends CustomJpaRepository<Purchase, Integer> {

	Optional<Purchase> findByProcmanname(String procmanname);
	
}
