package Mini_PM_System.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import Mini_PM_System.domain.AuthInfoDTO;
import jakarta.servlet.http.HttpSession;

@ControllerAdvice
public class GlobalControllerAdvice {
	
	@ModelAttribute("userName")
	public String userName(HttpSession session) {
		
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		
		return auth != null ? auth.getUserName() : null;
	}

}
