package com.dlizarra.starter.purchase;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(of = { "procmanname", "prodname" })
@ToString(of = { "id", "procmanname", "prodname" })
@Setter
@Getter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class PurchaseDto {

	private Integer id;
	private String procmanname;
	private Float totalperprocmanname;
	private String prodname;
	private String date;
	private Float price;
	
	
	
	public PurchaseDto(Integer id, String procmanname, Float totalperprocmanname, String prodname, String date, Float price) {
		super();
		this.id = id;
		this.procmanname = procmanname;
		this.totalperprocmanname = totalperprocmanname;
		this.prodname = prodname;
		this.date = date;
		this.price = price;
	}
	
}
