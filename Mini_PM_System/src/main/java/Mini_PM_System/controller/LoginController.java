package Mini_PM_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import Mini_PM_System.service.login.EmailCheckService;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	EmailCheckService emailCheckService;
	
	@PostMapping("empEmailCheck")
	public @ResponseBody Integer empEmailCheck(String empEmail) {
		System.out.println(empEmail);
		return emailCheckService.empCheck(empEmail);
	}
	
}
