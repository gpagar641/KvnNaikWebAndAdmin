package com.ganesh.admin.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ganesh.admin.dbmodel.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Integer>{

	List<Notice> findByDeptIdAndDelStatusOrderByIdDesc(int deptId,int delSataus);
	List<Notice> findTop10IdAndByDelStatusOrderByIdDesc( int delStatus);
	Notice findById(int id);
	

	@Modifying
	@Transactional
	@Query("update  Notice m set  m.status=1 WHERE m.id=:id")
	int approve(@Param("id")int id );
	
	@Modifying
	@Transactional
	@Query("update  Notice m set  m.delStatus=1 WHERE m.id=:id")
	int delete(@Param("id")int id );
}
