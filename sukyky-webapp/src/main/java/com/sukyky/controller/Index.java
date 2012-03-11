package com.sukyky.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Index {
	
	@RequestMapping("/")
	public String show(Model model) {
		return "index";
	}
}
