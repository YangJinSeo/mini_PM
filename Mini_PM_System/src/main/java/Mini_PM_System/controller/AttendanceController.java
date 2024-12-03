package Mini_PM_System.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Mini_PM_System.service.attendance.AttListService;

@Controller
@RequestMapping("attendance")
public class AttendanceController {
	@Autowired
	AttListService attListService;
	
	@RequestMapping("attList")
	public String attList(@RequestParam(value = "page", required = true, defaultValue = "1") int page
			,@RequestParam(value = "searchWord", required = false) String searchWord
			,@RequestParam(value = "startDate", required = false) String startDate
	        ,@RequestParam(value = "endDate", required = false) String endDate
			,Model model) {
		   LocalDate start = null;
	       LocalDate end = null;
	        
	        if (startDate != null && !startDate.isEmpty()) {
	            start = LocalDate.parse(startDate, DateTimeFormatter.ISO_LOCAL_DATE);
	        }
	        if (endDate != null && !endDate.isEmpty()) {
	            end = LocalDate.parse(endDate, DateTimeFormatter.ISO_LOCAL_DATE);
	        }
		attListService.execute(page, searchWord, startDate, endDate, model);
		return "thymeleaf/attendance/attList";
	}
	
}
