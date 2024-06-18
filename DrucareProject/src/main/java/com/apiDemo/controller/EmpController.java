package com.apiDemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apiDemo.entity.Emp;
import com.apiDemo.service.EmpService;

@RestController
public class EmpController {
	
	@Autowired
	EmpService service;
	
	@PostMapping("/emps")
	public void addEmp(@RequestBody Emp e) {
		service.addEmp(e);
	}
	@GetMapping("/emps")
	public List<Emp> getAllEmp(){
		
		return service.getAllEmp();
	}
	
	@GetMapping("/emps/{id}")
	public Emp getEmp(@PathVariable String id){
		return service.getEmp(id);
	}
	
	@PutMapping("/emps/{id}")
	public void updateEmp(@RequestBody Emp e) {
		service.updateEmp(e);
	}
	
	@DeleteMapping("/emps/{id}")
	public void deleteEmp(@PathVariable String id) {
		service.deleteEmp(id);
	}
	//page and sorting
	@GetMapping("/emps/page")
	public  Page<Emp> getEmpByPage(@RequestParam("pageNo") Optional<Integer> pageNo,
			@RequestParam("sortBy") Optional<String> sortBy) {
		return service.getEmpByPage(pageNo,sortBy);
	}
	
	//search
	@GetMapping("/emps/search")
	public List<Emp> searchEmp(@RequestParam("query") String query){
		return service.searchEmp(query);

	}
	
	//Filter
	@GetMapping("/emps/filter")
	public List<Emp> getFilteredEmp(@RequestParam(value="name",required=false)String name,@RequestParam(value="department",required=false)String department ){
		return service.getFilteredEmp(name,department);
	}

}
