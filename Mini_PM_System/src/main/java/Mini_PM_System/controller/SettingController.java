package Mini_PM_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import Mini_PM_System.service.setting.AdminDeleteService;
import Mini_PM_System.service.setting.AdminInfoService;
import Mini_PM_System.service.setting.AdminListService;
import Mini_PM_System.service.setting.AdminOkService;
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
	
	///////////////////////// 유저 = 인사 직원들의 사이트 관리자 권한 관리
	
	@Autowired
	AdminListService adminListService;
	@GetMapping("adminList")
	public String userList(Model model) {
		adminListService.execute(model);
		return "thymeleaf/setting/admin/userList";
	}
	
	/// 관리지 상세정보
	@Autowired
	AdminInfoService adminInfoService;
	@GetMapping("adminInfo")
	public String adminInfo(String id, Model model) {
		adminInfoService.execute(id, model);
		return "thymeleaf/setting/admin/adminInfo";
	}
	
	// 관리자 권한 승인
	
	@Autowired
	AdminOkService adminOkService;
	@PostMapping("adminOk")
	public @ResponseBody Integer adminOk(String userId, String userAppr) {
		System.out.println(userId);
		if (userAppr != "" && userAppr != null) {
			return adminOkService.changeH(userId);
		}else {
			return adminOkService.changeY(userId);
		}
	}
	
	// 관리자 삭제
	@Autowired
	AdminDeleteService adminDeleteService;
	@RequestMapping("adminDelete")
	public String adminDelete(String id) {
		adminDeleteService.execute(id);
		return "redirect:adminList";
	}

}
