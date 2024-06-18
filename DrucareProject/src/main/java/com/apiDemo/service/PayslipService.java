package com.apiDemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.apiDemo.entity.Employee;
import com.apiDemo.entity.Payslip;
import com.apiDemo.repository.PayslipRepository;

@Service
public class PayslipService {
	
	@Autowired
	PayslipRepository payslipRepository;

	public void addPayslip(Payslip payslips) {
		payslipRepository.save(payslips);
	}

	public List<Payslip> getAllPayslip(String empId) {
		List<Payslip> payslipList=new ArrayList<>();
		payslipRepository.findByEmpId(empId).forEach(payslipList::add);
		return payslipList;
	}

	public Payslip getPayslip(String payslipId,String id) {
		return payslipRepository.findById(payslipId).get();
	}

	public void deletePayslip(String payslipId) {
		payslipRepository.deleteById(payslipId);	
	}

	public void updatePayslip(Payslip payslip, String payslipId) {
		payslipRepository.save(payslip);
		
	}


	

	/*public void addPayslip(Payslip p) {
		payslipRepository.save(p);
		
	}

	public List<Payslip> getAllPayslip() {
       List<Payslip> payslipList=new ArrayList<>();	
       payslipRepository.findAll().forEach(payslipList::add);
       return payslipList;
	}

	public Payslip getPayslip(String id) {
		return payslipRepository.findById(id).get() ;
	}

	public void deletePayslip(String id) {
		payslipRepository.deleteById(id);
	}

	public void updatePayslip(Payslip p) {
		payslipRepository.save(p);
	}*/

	

}
