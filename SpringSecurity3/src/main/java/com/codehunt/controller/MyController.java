package com.codehunt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {
	
	@GetMapping("/index")
	public String welcome() {
		return "index";
	}

	@GetMapping("/error")
	public String error() {
		return "error";
		
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@GetMapping("/member")
	public String member() {
		
		return "member";
	}
	@GetMapping("/login")
	public String loginpage() {
		return "login";
	}
}
