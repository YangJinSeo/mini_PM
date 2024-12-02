package Mini_PM_System.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import Mini_PM_System.command.LoginCommand;
import Mini_PM_System.service.login.EmailCheckService;
import Mini_PM_System.service.login.IdCheckService;
import Mini_PM_System.service.login.UserCheckService;

@Controller
@RequestMapping("login")
public class LoginController {
	
	
	//////////체크 서비스
	////// 이메일
	@Autowired
	EmailCheckService emailCheckService;
	@PostMapping("empEmailCheck")
	public @ResponseBody Integer empEmailCheck(String empEmail) {
		return emailCheckService.empCheck(empEmail);
	}
	//////// 아이디
	@Autowired
	IdCheckService idCheckService;
	@PostMapping("userIdCheck")
	public @ResponseBody Integer userIdCheck(String userId) {
		return idCheckService.execute(userId);
	}
	
	///////// 회원가인
	//// 직원 체크
	@GetMapping("userCheck")
	public String userCheck() {
		return "thymeleaf/login/userCkeck";
	}
	
	@Autowired
	UserCheckService userCheckService;
	@PostMapping("userRegist")
	public @ResponseBody Integer userCheck(LoginCommand loginCommand) {
		return userCheckService.execute(loginCommand); 
	}
	
}
