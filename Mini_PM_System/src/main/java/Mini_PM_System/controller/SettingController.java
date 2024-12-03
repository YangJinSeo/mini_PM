package Mini_PM_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Mini_PM_System.service.setting.UserInfoService;
import Mini_PM_System.service.setting.UserUpdateService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("setting")
public class SettingController {
	
	/// 주소는 리스트로 되어있지만 실상은 디테일
	@Autowired
	UserInfoService userInfoService;
	@GetMapping("settingList")
	public String settingList(HttpSession session, Model model) {
		userInfoService.execute(session ,model);
		return "thymeleaf/setting/settingList";
	}
	
	///////////////////////// 수정
	////// 내 정보
	@GetMapping("settingUpdate")
	public String settingUpdate(HttpSession session, Model model) {
		userInfoService.execute(session, model);
		return "thymeleaf/setting/settingUpdate";
	}
	
	@Autowired
	UserUpdateService userUpdateService;
	@PostMapping("settingUpdate")
	public String settingUpdate(String userName, String empNum) {
		userUpdateService.execute(userName, empNum);
		return "redirect:settingList";
	}
	
}
