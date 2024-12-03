package Mini_PM_System;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Mini_PM_System.command.LoginCommand;
import Mini_PM_System.service.CookiesSevice;
import jakarta.servlet.http.HttpServletRequest;

@SpringBootApplication
@Controller
public class MiniPmSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniPmSystemApplication.class, args);
	}
	
	// LoginCommand loginCommand 방법도 있지만
	// @ModelAttribute("loginCommand") LoginCommand loginCommand) 이런 방법도 있다.
	/// 둘 중 하나 아무거나 사용
	
	@Autowired
	CookiesSevice cookiesService;
	
	@RequestMapping("/")
	public String index(LoginCommand loginCommand
						, HttpServletRequest request
						, Model model) {
		
		// index.html 페이지가 열릴 때 쿠키가 있는지 확인해야겠죠.
		cookiesService.execute(request, model);
		return "thymeleaf/index";
	}

}
