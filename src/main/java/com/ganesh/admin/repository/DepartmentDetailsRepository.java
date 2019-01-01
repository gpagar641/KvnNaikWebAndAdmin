package com.ganesh.admin.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ganesh.admin.dbmodel.DepartmentDetails;

public interface DepartmentDetailsRepository extends JpaRepository<DepartmentDetails, Integer>{

	
	DepartmentDetails save(DepartmentDetails departmentDetails);
	DepartmentDetails findByDeptIdAndDelStatus(int deptId, int delStatus);
	
	List<DepartmentDetails> findByDelStatus(int delStatus);
	
	
	DepartmentDetails findByEmailAndPasswordAndDelStatus(String email, String password, int delStatus);
	 
	
	@Modifying
	@Transactional
	@Query("update  DepartmentDetails m set  m.password=:password WHERE m.deptId=:deptId")
	int changePassword(@Param("deptId")int deptId, @Param("password")String password );
}
