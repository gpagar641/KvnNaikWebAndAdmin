package com.ganesh.admin.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ganesh.admin.dbmodel.Event;

public interface EventRepository extends JpaRepository<Event, Integer>{

	
	List<Event> findByDeptIdAndDelStatusOrderByIdDesc(int deptId,int delStatus);
	 
	List<Event> findTop10IdAndByDelStatusOrderByIdDesc( int delStatus);
	Event findById(int id);
	
	@Modifying
	@Transactional
	@Query("update  Event m set  m.status=1 WHERE m.id=:id")
	int approve(@Param("id")int id );
	
	@Modifying
	@Transactional
	@Query("update  Event m set  m.delStatus=1 WHERE m.id=:id")
	int delete(@Param("id")int id );
	
}
