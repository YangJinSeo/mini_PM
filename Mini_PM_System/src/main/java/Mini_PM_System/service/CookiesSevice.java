package Mini_PM_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Mini_PM_System.command.LoginCommand;
import Mini_PM_System.domain.AuthInfoDTO;
import Mini_PM_System.mapper.LoginMapper;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class CookiesSevice {
	
	@Autowired
	LoginMapper loginMapper;
	public void execute(HttpServletRequest request, Model model) {
		// request가 웹브라우저에 있는 쿠키를 모두 가지고 옵니다. 모든 쿠키를 쿠키 배열로 받습니다.
		Cookie [] cookies = request.getCookies();
		// 쿠키를 가져왔는지 검사
		if (cookies != null && cookies.length > 0) {
			// 내가 원하는 쿠키가 있는지 확인
			for(Cookie cookie : cookies) {
				// idStore 라는 쿠키가 있는 확인
				if (cookie.getName().equals("idStore")) {
					// loginCommand에 저장해서 index.html에 아이디를 전달
					LoginCommand loginCommand = new LoginCommand();
					loginCommand.setUserId(cookie.getValue());
					loginCommand.setIdStore(true);
					model.addAttribute("loginCommand", loginCommand);
				}
				// 메인에서 있는지 확인
				if (cookie.getName().equals("autoLogin")) {
					// 있으면 로그인 정보를 가져와서 세션에 저장
					AuthInfoDTO auth = loginMapper.loginSelect(cookie.getValue());
					HttpSession session = request.getSession();
					session.setAttribute("auth", auth);
					
					/// 자동로그인을 하면 로그아웃해도 main에서 계속 session을 만들어서 
					// 로그아웃이 되지 않습니다.
				}
				
			}
			
		}
		
	}

}
