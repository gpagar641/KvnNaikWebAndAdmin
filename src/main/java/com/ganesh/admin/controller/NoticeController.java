package com.ganesh.admin.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ganesh.admin.dbmodel.Announcement;
import com.ganesh.admin.dbmodel.DepartmentDetails;
import com.ganesh.admin.dbmodel.Notice;
import com.ganesh.admin.repository.AnnouncementRepository;
import com.ganesh.admin.repository.DepartmentDetailsRepository;
import com.ganesh.admin.repository.NoticeRepository;

@Controller
public class NoticeController {

	String msg;
	@Autowired
	NoticeRepository noticeRepository;
	@Autowired
	DepartmentDetailsRepository departmentDetailsRepository;
	
	@RequestMapping(value="/showPostNotice", method=RequestMethod.GET)
	public String showPostAnnouncement(HttpServletRequest request, Model model)   
	{ 
		model.addAttribute("msg",msg);
		msg="";
		return "noticeBoard/postNotice";
		
	}
	
	
	@RequestMapping(value="/showViewNotice", method=RequestMethod.GET)
	
	public String showViewNotice(HttpServletRequest request, Model model)   
	{ 
		List<DepartmentDetails> departmentDetailslist=departmentDetailsRepository.findByDelStatus(0);
		model.addAttribute("departmentDetailslist",departmentDetailslist);
		model.addAttribute("msg",msg);
		msg="";
		return "noticeBoard/viewNotice";
		 
	}
	
	
	@RequestMapping(value="/submitNotice", method=RequestMethod.POST)
	public String submitNotice(HttpServletRequest request, Model model)   
	{ 
		Notice notice=new Notice();
		
		notice.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		notice.setFullDesc(request.getParameter("full_desc"));
		notice.setShortDesc(request.getParameter("short_desc"));
		notice.setTitle(request.getParameter("title"));
		notice.setStatus(0);
		notice.setDelStatus(0);
		HttpSession session=request.getSession();
		DepartmentDetails departmentDetails=(DepartmentDetails)session.getAttribute("departmentDetails");
		notice.setDeptId(departmentDetails.getDeptId());
		try {
			noticeRepository.save(notice);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		model.addAttribute("msg",msg);
		msg="";
		return "redirect:/showViewNotice";
		
		 
	}
	
	@RequestMapping(value="/getNotice", method=RequestMethod.GET)
	public @ResponseBody List<Notice> getNotice(HttpServletRequest request, Model model)   
	{ 
		int deptId=Integer.parseInt(request.getParameter("deptId"));
		List<Notice> noticeList=new ArrayList<Notice>();
				
		try {
			
			noticeList= noticeRepository.findByDeptIdAndDelStatus(deptId,0);

		}
		catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("msg",msg);
		msg="";
		return noticeList;
		
	}
	
	
	@RequestMapping(value="/approveNotice", method=RequestMethod.GET)
	public @ResponseBody String approveNotice(HttpServletRequest request, Model model)   
	{ 
		int id=Integer.parseInt(request.getParameter("id"));
	int res=	noticeRepository.approve(id);
		return res+"";
	}
}
