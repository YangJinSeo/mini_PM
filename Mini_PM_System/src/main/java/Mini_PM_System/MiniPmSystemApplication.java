package Mini_PM_System;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import Mini_PM_System.command.LoginCommand;

@SpringBootApplication
@Controller
public class MiniPmSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniPmSystemApplication.class, args);
	}
	
	// LoginCommand loginCommand 방법도 있지만
	// @ModelAttribute("loginCommand") LoginCommand loginCommand) 이런 방법도 있다.
	/// 둘 중 하나 아무거나 사용
	@RequestMapping("/")
	public String index(LoginCommand loginCommand) {
		return "thymeleaf/index";
	}

}
