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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ganesh.admin.dbmodel.Announcement;
import com.ganesh.admin.dbmodel.DepartmentDetails;
import com.ganesh.admin.dbmodel.Event;
import com.ganesh.admin.dbmodel.Notice;
import com.ganesh.admin.repository.AnnouncementRepository;
import com.ganesh.admin.repository.DepartmentDetailsRepository;
import com.ganesh.admin.repository.EventRepository;
import com.ganesh.admin.repository.NoticeRepository;

@Controller
public class EventController {

	String msg;
	@Autowired
	EventRepository eventRepository;
	@Autowired
	DepartmentDetailsRepository departmentDetailsRepository;
	
	@RequestMapping(value="/showPostEvent", method=RequestMethod.GET)
	public String showPostEvent(HttpServletRequest request, Model model)   
	{ 
		model.addAttribute("msg",msg);
		msg="";
		return "event/postEvent";
		
	}
	
	
	@RequestMapping(value="/showViewEvent", method=RequestMethod.GET)
	
	public String showViewEvent(HttpServletRequest request, Model model)   
	{ 
		List<DepartmentDetails> departmentDetailslist=departmentDetailsRepository.findByDelStatus(0);
try {
			
			List<Event> announcementList= eventRepository.findTop10IdAndByDelStatusOrderByIdDesc(0);
model.addAttribute("announcementList", announcementList);
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		

		model.addAttribute("departmentDetailslist",departmentDetailslist);
		model.addAttribute("msg",msg);
		msg="";
		return "event/viewEvent";
		 
	}
	
	
	@RequestMapping(value="/submitEvent", method=RequestMethod.POST )
	public String submitEvent(HttpServletRequest request, Model model,@RequestParam("file") MultipartFile file)   
	{ 
		Event event=new Event();
		
		event.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		event.setFullDesc(request.getParameter("full_desc"));
		event.setShortDesc(request.getParameter("short_desc"));
		event.setTitle(request.getParameter("title"));
		event.setStatus(0);
		event.setDelStatus(0);
		
		   
		
	try {
			
			String fileName=file.getOriginalFilename();
			VpsFileUploadApiController vpsImageUpload=new VpsFileUploadApiController();
			vpsImageUpload.uploadFile(file,fileName,2);

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		
		HttpSession session=request.getSession();
		DepartmentDetails departmentDetails=(DepartmentDetails)session.getAttribute("departmentDetails");
		event.setDeptId(departmentDetails.getDeptId());
		try {
			eventRepository.save(event);
			if(departmentDetails.getDeptId()!=1) {
				return "redirect:/showViewEvent";
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		model.addAttribute("msg",msg);
		msg="";
		return "redirect:/showViewEvent";
		
		 
	}
	
	@RequestMapping(value="/getEvent", method=RequestMethod.GET)
	public @ResponseBody List<Event> getEvent(HttpServletRequest request, Model model)   
	{ 
		int deptId=Integer.parseInt(request.getParameter("deptId"));
		List<Event> noticeList=new ArrayList<Event>();
				
		try {
			
			noticeList= eventRepository.findByDeptIdAndDelStatusOrderByIdDesc(deptId,0);

		}
		catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("msg",msg);
		msg="";
		return noticeList;
		
	}
	
	
	@RequestMapping(value="/approveEvent", method=RequestMethod.GET)
	public @ResponseBody String approveEvent(HttpServletRequest request, Model model)   
	{ 
		int id=Integer.parseInt(request.getParameter("id"));
	int res=	eventRepository.approve(id);
		return res+"";
	}
}
