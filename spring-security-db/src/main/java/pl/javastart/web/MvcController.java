package pl.javastart.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MvcController {

	@RequestMapping("/")
	public String home(){
		return "index";
	}
	
	@RequestMapping("/secured")
	public String secured() {
		return "secured";
	}
}
