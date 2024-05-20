package com.example.todowebapp.welcome;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeCotroller {
	
	
	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	public String gotWelcomePage(ModelMap model) {
		model.put("name", "in28minutes");
		return "welcome";
	}

}
