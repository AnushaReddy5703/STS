package com.apiDemo.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Payslip {
    
	@Id
	private String id;
	private String bank;
	private String acNo;
	
	@ManyToOne
	public Emp emp;
	
	public Payslip(){
		
	}
	
	public Payslip(String id, String bank, String acNo ,String empId) {
		super();
		this.id = id;
		this.bank = bank;
		this.acNo = acNo;
		this.emp=new Emp(empId,"","","");
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getBank() {
		return bank;
	}


	public void setBank(String bank) {
		this.bank = bank;
	}


	public String getAcNo() {
		return acNo;
	}


	public void setAcNo(String acNo) {
		this.acNo = acNo;
	}


	public Emp getEmp() {
		return emp;
	}


	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	
	@Override
	public String toString() {
		return "Payslip [id=" + id + ", bank=" + bank + ", acNo=" + acNo + ", emp=" + emp + "]";
	}
	
}
