package com.ganesh.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.admin.dbmodel.DepartmentDetails;

public interface DepartmentDetailsRepository extends JpaRepository<DepartmentDetails, Integer>{

	
	DepartmentDetails save(DepartmentDetails departmentDetails);
	DepartmentDetails findByDeptIdAndDelStatus(int deptId, int delStatus);
	
	List<DepartmentDetails> findByDelStatus(int delStatus);
	
	
	DepartmentDetails findByEmailAndPasswordAndDelStatus(String email, String password, int delStatus);
}
