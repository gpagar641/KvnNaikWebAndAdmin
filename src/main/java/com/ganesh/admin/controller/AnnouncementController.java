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
import com.ganesh.admin.repository.AnnouncementRepository;
import com.ganesh.admin.repository.DepartmentDetailsRepository;


@Controller
public class AnnouncementController {

	String msg;
	@Autowired
	AnnouncementRepository announcementRepository;
	@Autowired
	DepartmentDetailsRepository departmentDetailsRepository;
	
	@RequestMapping(value="/showPostAnnouncement", method=RequestMethod.GET)
	public String showPostAnnouncement(HttpServletRequest request, Model model)   
	{ 
		model.addAttribute("msg",msg);
		msg="";
		return "announcement/postAnnouncement";
		
	}
	
	
	@RequestMapping(value="/showViewAnnouncement", method=RequestMethod.GET)
	
	public String showViewAnnouncement(HttpServletRequest request, Model model)   
	{ 
		List<DepartmentDetails> departmentDetailslist=departmentDetailsRepository.findByDelStatus(0);
		try {
			
			List<Announcement> announcementList= announcementRepository.findTop10IdAndByDelStatusOrderByIdDesc(0);
			model.addAttribute("announcementList", announcementList);
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		
		model.addAttribute("departmentDetailslist",departmentDetailslist);
		model.addAttribute("msg",msg);
		msg="";
		return "announcement/viewAnnouncement";
		 
	}
	@RequestMapping(value="/showViewAnnouncementDept", method=RequestMethod.GET)
	
	public String showViewAnnouncementDept(HttpServletRequest request, Model model)   
	{ 
		 
		try {
			HttpSession session=request.getSession();
			DepartmentDetails departmentDetails=(DepartmentDetails)session.getAttribute("departmentDetails");
			List<Announcement> announcementList= announcementRepository.findByDeptIdAndDelStatusOrderByIdDesc(departmentDetails.getDeptId(),0);
			model.addAttribute("announcementList", announcementList);
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		
		 
		model.addAttribute("msg",msg);
		msg="";
		return "announcement/viewAnnouncementDept";
		 
	}
	
	
	@RequestMapping(value="/submitAnnouncement", method=RequestMethod.POST)
	public String submitAnnouncement(HttpServletRequest request, Model model, @RequestParam("file") MultipartFile file)   
	{ 
		Announcement announcement=new Announcement();
		
		announcement.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		announcement.setFullDesc(request.getParameter("full_desc"));
		announcement.setShortDesc(request.getParameter("short_desc"));
		announcement.setTitle(request.getParameter("title"));
		announcement.setFile("");
		HttpSession session=request.getSession();
		DepartmentDetails departmentDetails=(DepartmentDetails)session.getAttribute("departmentDetails");
		try {
			
			 if(file.getOriginalFilename().length()>0) {
		//	String fileName=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+file.getOriginalFilename();
			VpsFileUploadApiController vpsImageUpload=new VpsFileUploadApiController();
			String fileName = new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date())
					+ departmentDetails.getDeptId()+VpsFileUploadApiController.getFileExtension(file);
			vpsImageUpload.uploadFile(file,fileName,1);
			announcement.setFile(fileName);
			 }
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		
		
		
		announcement.setDeptId(departmentDetails.getDeptId());
		announcement.setDeptName(departmentDetails.getDeptName());
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
		if(departmentDetails.getDeptId()!=1) {
			return "redirect:/showViewAnnouncementDept";
		}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		model.addAttribute("msg",msg);
		msg="";
		return "redirect:/showViewAnnouncement";
		
		 
	}
	
	@RequestMapping(value="/getAnnouncement", method=RequestMethod.GET)
	public @ResponseBody List<Announcement> getAnnouncement(HttpServletRequest request, Model model)   
	{ 
		int deptId=Integer.parseInt(request.getParameter("deptId"));
		List<Announcement> announcementList=new ArrayList<Announcement>();
				
		try {
			
		 announcementList= announcementRepository.findByDeptIdAndStatusAndDelStatusOrderByIdDesc(deptId,1,0);

		}
		catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("msg",msg);
		msg="";
		return announcementList;
		
	}
	@RequestMapping(value="/getAnnouncementDept", method=RequestMethod.GET)
	public @ResponseBody List<Announcement> getAnnouncementDept(HttpServletRequest request, Model model)   
	{ 
		int deptId=Integer.parseInt(request.getParameter("deptId"));
		List<Announcement> announcementList=new ArrayList<Announcement>();
				
		try {
			
		 announcementList= announcementRepository.findByDeptIdAndDelStatusOrderByIdDesc(deptId,0);

		}
		catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("msg",msg);
		msg="";
		return announcementList;
		
	}
	
	@RequestMapping(value="/getAnnouncementById", method=RequestMethod.GET)
	public @ResponseBody Announcement getAnnouncementById(HttpServletRequest request, Model model)   
	{ 
		int id=Integer.parseInt(request.getParameter("id"));
		 	
		try {
			
			Announcement announcement= announcementRepository.findById(id);
			return announcement;
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		 
		return null;
		
	}
	
	@RequestMapping(value="/approveAnnouncement", method=RequestMethod.GET)
	public @ResponseBody String approveAnnouncement(HttpServletRequest request, Model model)   
	{ 
		int id=Integer.parseInt(request.getParameter("id"));
	int res=	announcementRepository.approve(1,id);
		return res+"";
	}
	
	@RequestMapping(value="/deleteAnnouncement", method=RequestMethod.GET)
	public @ResponseBody String deleteAnnouncement(HttpServletRequest request, Model model)   
	{ 
		int id=Integer.parseInt(request.getParameter("id"));
	int res=	announcementRepository.approve(3,id);
		return res+"";
	}
	
	
	
	
}
