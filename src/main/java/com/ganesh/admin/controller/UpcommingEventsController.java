package com.ganesh.admin.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ganesh.admin.dbmodel.Announcement;
import com.ganesh.admin.dbmodel.DepartmentDetails;

@Controller
public class UpcommingEventsController {

	String msg;
	
	
	@RequestMapping(value="/showPostUpcommingEvent", method=RequestMethod.GET)
	public String showPostUpcommingEvent(HttpServletRequest request, Model model)   
	{ 
		model.addAttribute("msg",msg);
		msg="";
		return "upcommngEvent/postUpcommingEvent";
		
	}
	
/*
	
	@RequestMapping(value="/showViewUpcammingEvent", method=RequestMethod.GET)
	
	public String showViewUpcammingEvent(HttpServletRequest request, Model model)   
	{ 
		List<DepartmentDetails> departmentDetailslist=departmentDetailsRepository.findByDelStatus(0);
		model.addAttribute("departmentDetailslist",departmentDetailslist);
		model.addAttribute("msg",msg);
		msg="";
		return "announcement/viewAnnouncement";
		 
	}
	
	
	@RequestMapping(value="/submitUpcommingEvent", method=RequestMethod.POST)
	public String submitUpcommingEvent(HttpServletRequest request, Model model)   
	{ 
		Announcement announcement=new Announcement();
		
		announcement.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		announcement.setFullDesc(request.getParameter("full_desc"));
		announcement.setShortDesc(request.getParameter("short_desc"));
		announcement.setTitle(request.getParameter("title"));
		
		HttpSession session=request.getSession();
		DepartmentDetails departmentDetails=(DepartmentDetails)session.getAttribute("departmentDetails");
		announcement.setDeptId(departmentDetails.getDeptId());
		if(departmentDetails.getDeptId()==1) {
		announcement.setStatus(1);
		announcement.setDelStatus(0);
	}
		else {
			announcement.setStatus(0);
			announcement.setDelStatus(0);
		}
		try {
		announcementRepository.save(announcement);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		model.addAttribute("msg",msg);
		msg="";
		return "redirect:/showViewAnnouncement";
		
		 
	}
	
	@RequestMapping(value="/getUpcommingEvent", method=RequestMethod.GET)
	public @ResponseBody List<Announcement> getUpcommingEvent(HttpServletRequest request, Model model)   
	{ 
		int deptId=Integer.parseInt(request.getParameter("deptId"));
		List<Announcement> announcementList=new ArrayList<Announcement>();
				
		try {
			
		 announcementList= announcementRepository.findByDeptIdAndDelStatus(deptId,0);

		}
		catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("msg",msg);
		msg="";
		return announcementList;
		
	}
	
	
	@RequestMapping(value="/approveUpcommingEvent", method=RequestMethod.GET)
	public @ResponseBody String approveUpcommingEvent(HttpServletRequest request, Model model)   
	{ 
		int id=Integer.parseInt(request.getParameter("id"));
	int res=	announcementRepository.approve(id);
		return res+"";
	}
	*/
}
