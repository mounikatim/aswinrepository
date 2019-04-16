package com.main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LogicController {
	@Value("${welcome.message}")
	private String message=" ";
	@RequestMapping("/one")
	public ModelAndView view(){
		return new ModelAndView("welcome","message",message);
		
	}
	

}
