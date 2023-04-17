package com.iu.base.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.iu.base.TestVO;

@Controller
public class HomeController {
	
	
	@GetMapping("/home")
	public void home() {
		
	}
}
