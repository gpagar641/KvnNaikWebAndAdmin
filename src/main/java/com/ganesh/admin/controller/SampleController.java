package com.ganesh.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleController {

	
	@RequestMapping(value="/showSampleForm", method=RequestMethod.GET)

	public String showSampleForm(HttpServletRequest request)   
	{ 
		return "sample_form";
		
	}	
}
