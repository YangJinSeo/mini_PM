package Mini_PM_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Mini_PM_System.service.attendence.AttListService;

@Controller
@RequestMapping("attendance")
public class AttendanceController {
	@Autowired
	AttListService attListService;
	
	
	@RequestMapping("attList")
	public String attList(@RequestParam(value = "page", required = true, defaultValue = "1") int page
			,@RequestParam(value = "searchWord", required = false) String searchWord
			,Model model) {
		attListService.execute(page, searchWord, model);
		return "thymeleaf/attendance/attList";
	}
	
}
