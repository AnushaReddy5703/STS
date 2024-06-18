package com.apiDemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.apiDemo.entity.Emp;
import com.apiDemo.repository.EmpRepository;

@Service
public class EmpService {
	
	@Autowired
	EmpRepository empRepository;
	//EmpService empservice;

	public void addEmp(Emp e) {
		empRepository.save(e);
	}

	public List<Emp> getAllEmp() {
		List<Emp> empList =new ArrayList<>();
		 empRepository.findAll().forEach(empList::add);
		 return empList;
	}
	
	public Emp getEmp(String id) {
		return empRepository.findById(id).get();
	}
	
	public void updateEmp(Emp e) {
		empRepository.save(e);
	}

	public void deleteEmp(String id) {
        empRepository.deleteById(id);		
	}

	public Page<Emp> getEmpByPage(Optional<Integer> pageNo, Optional<String> sortColumn) {
		return empRepository.findAll(PageRequest.of
				          (pageNo.orElse(0),
				        		  2,
				        		  Direction.DESC,
				        		  sortColumn.orElse("id")			        		
				        		  ));
	}

	public List<Emp>searchEmp(String query) {
		return empRepository.searchEmp(query);
	}

	public List<Emp> getFilteredEmp(String name,String department) {
		return empRepository.filterByCriteria(name,department);
	}
	

}
