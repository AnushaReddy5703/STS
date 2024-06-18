package com.apiDemo.entity;






import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Emp {
	
	@Id
	private String id;
	private String name;
	private String email;
	private String department;
	
	//@OneToMany
	//List<Payslip> payslip;
	//@OneToMany
	//Payslip payslip;
	
	public Emp() {
		
	}

	public Emp(String id, String name, String email, String department) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.department = department;
		//this.payslip=new ArrayList<>();
		//this.payslip = new Payslip(payslipId,"","");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	//public List<Payslip> getPayslip() {
	//	return payslip;
	//}

	//public void setPayslip(Payslip payslip) {
	//	this.payslip=(List<Payslip>) payslip;
	//}

	//@Override
	//public String toString() {
	//	return "Emp [id=" + id + ", name=" + name + ", email=" + email + ", department=" + department + ",]";
	//}
	
	
	

}
