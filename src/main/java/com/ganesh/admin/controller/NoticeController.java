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

import com.ganesh.admin.dbmodel.DepartmentDetails;
import com.ganesh.admin.dbmodel.Notice;
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
try {
			
			List<Notice> announcementList= noticeRepository.findTop10IdAndByDelStatusOrderByIdDesc(0);
model.addAttribute("announcementList", announcementList);
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		
		model.addAttribute("departmentDetailslist",departmentDetailslist);
		model.addAttribute("msg",msg);
		msg="";
		return "noticeBoard/viewNotice";
		 
	}
@RequestMapping(value="/showViewNoticeByDeptId", method=RequestMethod.GET)
	
	public String showViewNoticeByDeptId(HttpServletRequest request, Model model)   
	{ 
	
	 
try {
	HttpSession session=request.getSession();
	DepartmentDetails departmentDetails=(DepartmentDetails)session.getAttribute("departmentDetails");
			List<Notice> announcementList= noticeRepository.findByDeptIdAndDelStatusOrderByIdDesc(departmentDetails.getDeptId(),0);
model.addAttribute("announcementList", announcementList);
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		
		 
		model.addAttribute("msg",msg);
		msg="";
		return "noticeBoard/viewNoticeToDept";
		 
	}

	
	
	@RequestMapping(value="/submitNotice", method=RequestMethod.POST)
	public String submitNotice(HttpServletRequest request, Model model,@RequestParam("file") MultipartFile file)   
	{ 
		Notice notice=new Notice();
		
		notice.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		notice.setFullDesc(request.getParameter("full_desc"));
		notice.setShortDesc(request.getParameter("short_desc"));
		notice.setTitle(request.getParameter("title"));
		notice.setStatus(0);
		notice.setDelStatus(0);
		notice.setFile("");
		
		HttpSession session=request.getSession();
		DepartmentDetails departmentDetails=(DepartmentDetails)session.getAttribute("departmentDetails");
		
	try {      
		 if(file.getOriginalFilename().length()>0) {
		//	String fileName=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+file.getOriginalFilename();
			VpsFileUploadApiController vpsImageUpload=new VpsFileUploadApiController();
			String fileName = new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date())
					+ departmentDetails.getDeptId()+VpsFileUploadApiController.getFileExtension(file);
			vpsImageUpload.uploadFile(file,fileName,3);
			notice.setFile(fileName);
		 }
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	
		notice.setDeptId(departmentDetails.getDeptId());
		notice.setDeptName(departmentDetails.getDeptName());
		if(departmentDetails.getDeptId()==1) {
			notice.setStatus(1);
			}
		try {
			noticeRepository.save(notice);
			if(departmentDetails.getDeptId()!=1) {
			 
				return "redirect:/showViewNoticeByDeptId";
			}
			else
			{
				notice.setStatus(1);
			}
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
			
			noticeList= noticeRepository.findByDeptIdAndStatusAndDelStatusOrderByIdDesc(deptId,1,0);

		}
		catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("msg",msg);
		msg="";
		return noticeList;
		
	}

	@RequestMapping(value="/getNoticeToDept", method=RequestMethod.GET)
	public @ResponseBody List<Notice> getNoticeToDept(HttpServletRequest request, Model model)   
	{ 
		int deptId=Integer.parseInt(request.getParameter("deptId"));
		List<Notice> noticeList=new ArrayList<Notice>();
				
		try {
			
			noticeList= noticeRepository.findByDeptIdAndDelStatusOrderByIdDesc(deptId,0);

		}
		catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("msg",msg);
		msg="";
		return noticeList;
		
	}
	@RequestMapping(value="/getNoticeById", method=RequestMethod.GET)
	public @ResponseBody Notice getNoticeById(HttpServletRequest request, Model model)   
	{ 
		int id=Integer.parseInt(request.getParameter("id"));
		 	
		try {
			
			Notice notice= noticeRepository.findById(id);
			return notice;
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		 
		return null;
		
	}
	
	
	@RequestMapping(value="/approveNotice", method=RequestMethod.GET)
	public @ResponseBody String approveNotice(HttpServletRequest request, Model model)   
	{ 
		int id=Integer.parseInt(request.getParameter("id"));
	int res=	noticeRepository.approve(1,id);
		return res+"";
	}
	
	@RequestMapping(value="/deleteNotice", method=RequestMethod.GET)
	public @ResponseBody String deleteNotice(HttpServletRequest request, Model model)   
	{ 
		int id=Integer.parseInt(request.getParameter("id"));
	int res=	noticeRepository.approve(3,id);
		return res+"";
	}
	
}
