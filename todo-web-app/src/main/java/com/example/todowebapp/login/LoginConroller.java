package com.example.todowebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
@Controller
@SessionAttributes("name")
public class LoginConroller {

	
	
	
	
//	@RequestMapping("say")
//	@ResponseBody
	
//	@GetMapping(value="/log")
//	public String toLogin() {
//		return "login";
//	}
	
//private AuthenticationService authenticationService;
	
//	public LoginConroller(AuthenticationService authenticationService) {
//		super();
//		this.authenticationService = authenticationService;
//	}

//	@RequestMapping(value="login",method = RequestMethod.GET)
//	public String gotoLoginPage() {
//		return "login";
//	}
//	@RequestMapping(value="login",method = RequestMethod.POST)
//	public String gotowelcomePage() {
//		return "welcome";
//	}

//	@RequestMapping(value="login",method = RequestMethod.POST)
	//login?name=Ranga RequestParam
//	public String gotoWelcomePage(@RequestParam String name, 
//			@RequestParam String password, ModelMap model) {
////		
//		if(authenticationService.authenticate(name, password)) {
//		
//			model.put("name", name);
//			//Authentication 
//			//name - ravi
//			//password - dummy
//			
//			return "welcome";
//		}
//		
//		model.put("errorMessage", "Invalid Credentials! Please try again.");
//		return "login";
	
//	}
}
