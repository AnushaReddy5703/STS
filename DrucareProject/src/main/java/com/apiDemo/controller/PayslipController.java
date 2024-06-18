package com.apiDemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apiDemo.entity.Award;
import com.apiDemo.entity.Emp;
import com.apiDemo.entity.Employee;
import com.apiDemo.entity.Movie;
import com.apiDemo.entity.Payslip;
import com.apiDemo.service.PayslipService;

@RestController
public class PayslipController {

	@Autowired
	PayslipService service;
	
	
	// to add payslips for particular employee
	@PostMapping("/emps/{id}/payslips")
	public void addpayslip(@RequestBody Payslip payslips,@PathVariable String id) {
		 payslips.setEmp(new Emp(id,"","",""));
		 service.addPayslip(payslips);
	}
	
	//API to hit  details of all payslips assosciated with a particular employee
	@GetMapping("/emps/{id}/payslips")
	public List<Payslip> getAllPayslip(@PathVariable String id) {
		return service.getAllPayslip(id);
	}
	//API to hit details of particular payslip
	@GetMapping("emps/{id}/payslips/{payslipId}")
	public Payslip getPayslip(@PathVariable String payslipId,@PathVariable String id) {
		return service.getPayslip(payslipId,id);
	}
	

	
	@DeleteMapping("emps/{id}/payslips/{payslipId}")
	public void deletePayslip(@PathVariable String payslipId)
	{
		service.deletePayslip(payslipId);
	}
	
	@PutMapping("emps/{id}/payslips/{payslipId}")
	public void updatePayslip(@RequestBody Payslip payslip,@PathVariable String payslipId) {
		service.updatePayslip(payslip,payslipId);
	}
	
	
	
	
}
