package com.ganesh.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ganesh.admin.dbmodel.Announcement;
import com.ganesh.admin.repository.AnnouncementRepository;
 
@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	AnnouncementRepository announcementRepository;
	
	 
		@RequestMapping(value = { "/getAnnouncementAjax" }, method = RequestMethod.GET)
		@ResponseBody
		public List<Announcement> insertMachineEqCal(@RequestParam("deptId") int deptId) 
		{
		 
		List<Announcement> announcementList=new ArrayList<Announcement>();
				
		try {
			
		 announcementList= announcementRepository.findByDeptIdAndDelStatusOrderByIdDesc(deptId,0);

		}
		catch (Exception e) {
			// TODO: handle exception
		}
		 
		 
		return announcementList;
		
	}
	
}
