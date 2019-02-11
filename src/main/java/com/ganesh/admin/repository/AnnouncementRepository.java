package com.ganesh.admin.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ganesh.admin.dbmodel.Announcement;

public interface AnnouncementRepository extends JpaRepository<Announcement, Integer>{

	List<Announcement> findByDeptIdAndDelStatusOrderByIdDesc(int deptId, int delStatus);
	List<Announcement> findTop10IdAndByDelStatusOrderByIdDesc( int delStatus);
	Announcement findById(int id);
	
	@Modifying
	@Transactional
	@Query("update  Announcement m set  m.status=:status WHERE m.id=:id")
	int approve(@Param("status")int status,@Param("id")int id );
	
	@Modifying
	@Transactional
	@Query("update  Announcement m set  m.delStatus=1 WHERE m.id=:id")
	int delete(@Param("id")int id );
	List<Announcement> findByDeptIdAndStatusAndDelStatusOrderByIdDesc(int deptId, int i, int j);
	
}
