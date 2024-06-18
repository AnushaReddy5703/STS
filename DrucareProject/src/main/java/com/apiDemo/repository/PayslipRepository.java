package com.apiDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiDemo.entity.Payslip;

@Repository
public interface PayslipRepository extends JpaRepository<Payslip,String>{

	Iterable<Payslip> findByEmpId(String id);

}
