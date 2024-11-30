package Mini_PM_System.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("retire")
public class RetireController {
	
	@GetMapping("retireList")
	public String retireList() {
		return "thymeleaf/retire/retireList";
	}
}
