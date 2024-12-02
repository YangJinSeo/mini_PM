package Mini_PM_System.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("attendance")
public class AttendanceController {
	
	@RequestMapping("attList")
	public String attList() {
		return "thymeleaf/attendance/attList";
	}
}
