package Mini_PM_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import Mini_PM_System.command.LoginCommand;
import Mini_PM_System.command.UserCommand;
import Mini_PM_System.service.CheckService;
import Mini_PM_System.service.login.UserLoginService;
import Mini_PM_System.service.login.UserRegistService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("login")
public class LoginController {
	
	
	//////////체크 서비스
	@Autowired
	CheckService checkService;
	////// 이메일
	@PostMapping("empEmailCheck")
	public @ResponseBody Integer empEmailCheck(String empEmail) {
		return checkService.email(empEmail);
	}
	//////// 아이디
	@PostMapping("userIdCheck")
	public @ResponseBody Integer userIdCheck(String userId) {
		return checkService.IdCheck(userId);
	}
	///////// 직원번호
	// 직원번호 중복
	@PostMapping("empNumCheck")
	public @ResponseBody Integer empNumCheck(String empNum) {
		return checkService.empNumCheck(empNum);
	}
	
	
	/////////////////////// 회원가입
	@GetMapping("userRegist")
	public String userCheck() {
		return "thymeleaf/login/userRegist";
	}
	
	@Autowired
	UserRegistService userRegistService;
	@PostMapping("userRegist")
	public @ResponseBody Integer userCheck(UserCommand userCommand) {
		return userRegistService.execute(userCommand); 
	}
	
	
	///////////////////////// 로그인
	@Autowired
	UserLoginService userLoginService;
	@PostMapping("login")
	public String login(@Validated LoginCommand loginCommand
						, BindingResult result
						, HttpSession session
						, HttpServletResponse response) {
		userLoginService.execute(loginCommand, result ,session, response);
		// 오류가 있으면 index 페이지가 열리게 만들자.
		if (result.hasErrors()) {
			return "redirect:/";
		}
		return "redirect:../attendance/attList";
	}
	
	//// 로그아웃
	@GetMapping("logout")
	public String logout(HttpSession session, HttpServletResponse response) {
		// 로그아웃에서 해당 쿠키만 삭제
		Cookie cookie = new Cookie("autoLogin", "");
		cookie.setPath("/"); 
		cookie.setMaxAge(0); // 해당쿠키 이름에 수명을 0으로 줘서 다시 사용자에게 보냅니다.
		response.addCookie(cookie);
		
		session.invalidate(); // 로그아웃시 모든 세션 삭제
		return "redirect:/";
	}
	
	
}
