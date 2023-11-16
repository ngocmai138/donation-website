package com.example.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeControler {
	@RequestMapping("/")
	public String showMyPage() {
		return "main-menu";
	}
}
