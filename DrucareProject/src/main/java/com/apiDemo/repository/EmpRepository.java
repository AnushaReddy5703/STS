package com.apiDemo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apiDemo.entity.Emp;
@Repository
public interface EmpRepository extends JpaRepository<Emp,String>{

	@Query(value="select*from Emp where name like concat(:query,'%')",nativeQuery=true)
	List<Emp> searchEmp(String query);

	@Query("select e from Emp e where e.name=:name AND e.department=:department")
	List<Emp> filterByCriteria(String name,String department);

}
