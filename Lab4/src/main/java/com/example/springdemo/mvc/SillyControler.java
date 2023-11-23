package com.example.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SillyControler {
	@RequestMapping("/showForm")
	public String displayTheForm() {
		return "silly";
	}
}
