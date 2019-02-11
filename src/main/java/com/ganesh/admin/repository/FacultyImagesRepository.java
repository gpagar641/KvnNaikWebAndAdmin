package com.ganesh.admin.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ganesh.admin.dbmodel.FacultyImages;

public interface FacultyImagesRepository extends JpaRepository<FacultyImages, Integer>{

	
	FacultyImages save(FacultyImages facultyImages);
	
	List<FacultyImages> findByDelStatusAndDeptIdOrderByOrderDesc(int delStatus, int deptId);
	List<FacultyImages> findByDeptIdOrderByOrderDesc( int deptId);
	
	@Modifying
	@Transactional
	@Query("update  FacultyImages m set  m.delStatus=:delStatus WHERE m.id=:id")
	int deleteImage(@Param("delStatus")int delStatus,@Param("id")int id );
	
	
}
