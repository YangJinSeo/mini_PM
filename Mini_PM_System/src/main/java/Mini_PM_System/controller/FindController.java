package Mini_PM_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Mini_PM_System.service.find.FindIdService;
import Mini_PM_System.service.find.FindPwService;

@Controller
@RequestMapping("find")
public class FindController {
	
	
	//////////// 아아디 찾기
	@GetMapping("findId")
	public String findId() {
		return "thymeleaf/find/findId";
	}
	
	@Autowired
	FindIdService findIdService;
	@PostMapping("findId")
	public String findId(String empNum
						, String userName
						, Model model) {
		
		findIdService.execute(empNum, userName, model);
		return "thymeleaf/find/findIdOk";
	}
	
	
	/////////// 비밀번호 찾기
	@GetMapping("findPw")
	public String findPw() {
		return "thymeleaf/find/findPw";
	}
	@Autowired
	FindPwService findPwService;
	@PostMapping("findPw")
	public String findPw(String empNum
						, String userName
						, String userJumin
						, Model model) {
		findPwService.execute(empNum, userName, userJumin, model);
		return "thymeleaf/find/findPwOk";
	}
	
	
}
