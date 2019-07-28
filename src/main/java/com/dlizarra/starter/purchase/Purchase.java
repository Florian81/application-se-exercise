package com.dlizarra.starter.purchase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(of = { "procmanname", "prodname" })
@ToString(of = { "id", "procmanname", "prodname" })
@Setter
@Getter
@Entity
@Table(name = "purchases")
public class Purchase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String procmanname;
	
	@Column
	private Float totalperprocmanname;
	
	@Column
	private String prodname;
	
	@Column
	private String date;

	@Column
	private Float price;

	
	
	public Purchase() {}

	
	
	public Purchase(
			Integer id,
			String procmanname,
			Float totalperprocmanname,
			String prodname,
			String date,
			Float price) {
		super();
		this.id = id;
		this.procmanname = procmanname;
		this.totalperprocmanname = totalperprocmanname;
		this.prodname = prodname;
		this.date = date;
		this.price = price;
	}

}
