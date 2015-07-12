package org.blade.personal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.blade.personal.manager.UserManager;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class PageConfigController implements Controller{
	
	private UserManager userManager;
	
	public org.springframework.web.servlet.ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String aMessage = "Hello World MVC!";

		ModelAndView modelAndView = new ModelAndView("hello_world");
		modelAndView.addObject("message", aMessage);
		System.out.println("PageConfigController");
		return modelAndView;
	}
	
	

}
