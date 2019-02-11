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
import org.springframework.web.multipart.MultipartFile;

import com.ganesh.admin.dbmodel.DepartmentDetails;
import com.ganesh.admin.dbmodel.FacultyImages;
import com.ganesh.admin.repository.FacultyImagesRepository;

@Controller
public class FacultyImagesUploadController {

	String msg;
	@Autowired
	FacultyImagesRepository facultyImagesRepository;
	
	@RequestMapping(value="/showPostFacultyImages", method=RequestMethod.GET)
	public String showPostFacultyImages(HttpServletRequest request, Model model)   
	{ 
		model.addAttribute("msg",msg);
		msg="";
		return "imagesUpload/postFacultyImage";
		
	}
	
	
@RequestMapping(value="/submitUploadImage", method=RequestMethod.POST)
	
	public String submitUploadImage(HttpServletRequest request, Model model,@RequestParam("file") MultipartFile file,@RequestParam("photo") MultipartFile photo)   
	{
	
	 FacultyImages facultyImages=new FacultyImages();
	 facultyImages.setDelStatus(0);
	 HttpSession session=request.getSession();
		DepartmentDetails departmentDetails=(DepartmentDetails)session.getAttribute("departmentDetails");
	 facultyImages.setDeptName(departmentDetails.getDeptName());
	 facultyImages.setDeptId(departmentDetails.getDeptId());
	 facultyImages.setName(request.getParameter("name"));
	 facultyImages.setPost(request.getParameter("post"));
	 facultyImages.setOrder(0);
	
	
		try {
			String photoName = new SimpleDateFormat("ddMMyyyyHHmms").format(new Date())
					+ departmentDetails.getDeptId()+VpsFileUploadApiController.getFileExtension(photo); 
			VpsFileUploadApiController.uploadFile(photo, photoName, 4);
			
			 facultyImages.setPhoto(photoName);
		
	}catch (Exception e) {
		System.out.println(e.getMessage());// TODO: handle exception
	}
	try {
		String fileName = new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date())
				+ departmentDetails.getDeptId()+VpsFileUploadApiController.getFileExtension(file);
				VpsFileUploadApiController.uploadFile(file, fileName, 4);
				facultyImages.setFile(fileName);
		}catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
	
	try {
		facultyImagesRepository.save(facultyImages);
		msg="Image Upload Successfully";
		
	}catch (Exception e) {
		System.out.println(e.getMessage());// TODO: handle exception
		msg="Failed to Upload Image";
	}
	
	return "redirect:/showPostFacultyImages";
	}

@RequestMapping(value="/getPostFacultyImagesByForSite", method=RequestMethod.GET)
public List<FacultyImages> getPostFacultyImagesByForSite(HttpServletRequest request)   
{ 
	 int deptId=Integer.parseInt(request.getParameter("deptId"));
	
	try {
		List<FacultyImages> facultyImagesList=facultyImagesRepository.findByDelStatusAndDeptIdOrderByOrderDesc(0, deptId);
		return facultyImagesList;
	}catch (Exception e) {
		System.out.println(e.getMessage());// TODO: handle exception
	}
	return null;
	
}

@RequestMapping(value="/showFacultyImages", method=RequestMethod.GET)
public String showFacultyImages(HttpServletRequest request, Model model)   
{ 
	 try {
	 HttpSession session=request.getSession();
		DepartmentDetails departmentDetails=(DepartmentDetails)session.getAttribute("departmentDetails");
		List<FacultyImages> facultyImagesList=facultyImagesRepository.findByDeptIdOrderByOrderDesc(departmentDetails.getDeptId());
		model.addAttribute("facultyImagesList",facultyImagesList);
	 }
	 catch (Exception e) {
		System.out.println(e.getMessage());// TODO: handle exception
	}
	return "imagesUpload/viewFacultyImage";
	
}

@RequestMapping(value="/deleteFacultyImagesByForSite", method=RequestMethod.GET)
public String deleteFacultyImagesByForSite(HttpServletRequest request)   
{ 
	 int id=Integer.parseInt(request.getParameter("id"));
	
	try {
		int res=facultyImagesRepository.deleteImage(1, id);
		if(res>0)
		return "delete";
	}catch (Exception e) {
		System.out.println(e.getMessage());// TODO: handle exception
	}
	return null;
	
}


}
