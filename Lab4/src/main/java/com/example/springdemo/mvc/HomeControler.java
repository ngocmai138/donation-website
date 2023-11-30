package com.example.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HomeControler {
	@RequestMapping("/showForm")
	public String RequestForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String ProcessForm() {
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String LetShoutDude(HttpServletRequest request, Model model) {
		String theName = request.getParameter("studentName");
		theName=theName.toUpperCase();
		String result = "Yo!" +theName;
		model.addAttribute("message",result);
		return "helloworld";
	}
	
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
		theName = theName.toUpperCase();
		String result = "Hey my friend from v3!" +theName;
		model.addAttribute("message",result);
		return "helloworld";
	}
}
