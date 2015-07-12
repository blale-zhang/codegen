package org.blade.personal.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/helloworld")
public class HelloWorldController {

	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String aMessage = "Hello World MVC!";

		ModelAndView modelAndView = new ModelAndView("hello_world");
		modelAndView.addObject("message", aMessage);

		return modelAndView;
	}
	
	@RequestMapping("hello")
	public ModelAndView greet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String aMessage = "Hello World MVC!";

		ModelAndView modelAndView = new ModelAndView("hello_world");
		modelAndView.addObject("message", aMessage);

		return modelAndView;
	}
	
	@RequestMapping("toFileUpload")
	public ModelAndView dispatch(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String aMessage = "Hello World MVC!";

		ModelAndView modelAndView = new ModelAndView("file-upload");
		modelAndView.addObject("message", aMessage);
		modelAndView.addObject("title", "文件上传");
		return modelAndView;
	}
	
	/**
	 * 上传
	 * @param myfiles
	 * @param request
	 */
	@RequestMapping("fileUpload")
	public void upload(@RequestParam MultipartFile[] myfiles, HttpServletRequest request){
		
		 for(MultipartFile myfile : myfiles){  
	            if(myfile.isEmpty()){  
	                System.out.println("文件未上传");  
	            }else{  
	                System.out.println("文件长度: " + myfile.getSize());  
	                System.out.println("文件类型: " + myfile.getContentType());  
	                System.out.println("文件名称: " + myfile.getName());  
	                System.out.println("文件原名: " + myfile.getOriginalFilename());  
	                System.out.println("========================================");  
	                //如果用的是Tomcat服务器，则文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\WEB-INF\\upload\\文件夹中  
	                String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");  
	                //这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉，我是看它的源码才知道的 
	                System.out.println(realPath);
	                try {
						FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(realPath, myfile.getOriginalFilename()));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
	            }  
	        }  
		
	}

}
