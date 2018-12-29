package com.ganesh.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ganesh.admin.dbmodel.DepartmentDetails;
import com.ganesh.admin.repository.DepartmentDetailsRepository;

@Controller
public class MasterController {

	@Autowired
	DepartmentDetailsRepository departmentDetailsRepository;
	
	String msg;
	@RequestMapping(value="/htmlView", method=RequestMethod.GET)

	public String htmlView(HttpServletRequest request, Model model)   
	{ 
		model.addAttribute("msg",msg);
		msg="";
		return "aa";
		
	}
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)

	public String loginPage(HttpServletRequest request, Model model)   
	{ 
		model.addAttribute("msg",msg);
		msg="";
		return "loginPage";
		
	}
	
	
	
	@RequestMapping(value="/loginProcess", method=RequestMethod.POST)

	public String loginProcess(HttpServletRequest request)   
	{ 
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String url="/showPostAnnouncement";
		try
		{
		DepartmentDetails departmentDetails=departmentDetailsRepository.findByEmailAndPasswordAndDelStatus(email, password, 0);
		if(departmentDetails==null) {
			msg="Please Enter valid Credential";
			url="/";
		}
		else
		{
			HttpSession session=request.getSession();
			session.setAttribute("departmentDetails", departmentDetails);
			
		}
			
		}
		catch (Exception e) {
			msg="Please Enter valid Credential";
			url="/";
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		return "redirect:"+url;
	}
	
	@RequestMapping(value="/homePage", method=RequestMethod.GET)

	public String homePage(HttpServletRequest request, Model model)   
	{ 
		model.addAttribute("msg",msg);
		msg="";
		return "loginPage";
		
	}
	
	@RequestMapping(value="/showAddDept", method=RequestMethod.GET)

	public String showAddDept(HttpServletRequest request, Model model)   
	{ 
		model.addAttribute("msg",msg);
		msg="";
		return "master/addNewDept";
		
	}
	
	
	@RequestMapping(value="/submitAddDept", method=RequestMethod.POST)

	public String submitAddDept(HttpServletRequest request)   
	{ 
		
		DepartmentDetails departmentDetails=new DepartmentDetails();
		departmentDetails.setContactNo(request.getParameter("contactNo"));
		departmentDetails.setDeptName(request.getParameter("deptName"));
		departmentDetails.setDelStatus(0);
		departmentDetails.setEmail(request.getParameter("email"));
		departmentDetails.setPassword(request.getParameter("password"));
		try {
		departmentDetailsRepository.save(departmentDetails);
		msg="Information Save successfully";
		}
		catch (Exception e) {
			msg="failed to Save";
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		return "redirect:/showAddDept";
		
	}
	@RequestMapping(value="/showAllDept", method=RequestMethod.GET)
	public String showAllDept(HttpServletRequest request, Model model)   
	{ 
		try {
		model.addAttribute("deptList",departmentDetailsRepository.findByDelStatus(0));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		model.addAttribute("msg",msg);
		msg="";
		return "master/showAllDept";
		
	}
}
