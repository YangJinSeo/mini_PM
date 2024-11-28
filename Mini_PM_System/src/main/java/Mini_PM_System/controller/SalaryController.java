package Mini_PM_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Mini_PM_System.command.SalaryCommand;
import Mini_PM_System.service.salary.SalaryInsertService;
import Mini_PM_System.service.salary.SalaryListService;

@Controller
@RequestMapping("salary")
public class SalaryController {
	@Autowired
	SalaryInsertService salaryInsertService;
	@Autowired
	SalaryListService salaryListService;
	
	@GetMapping("salaryList") 
	public String salaryList(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page
			, @RequestParam(value = "searchWord", required = false) String searchWord
			,Model model) {
		salaryListService.execute(page, searchWord, model);
		return "thymeleaf/salary/salaryList";
	}
	@GetMapping("salaryWrite")
	public String salaryWrite() {
		
		return "thymeleaf/salary/salaryForm";
	}
	@PostMapping("salaryInsert")
	public String salaryInsert(SalaryCommand salaryCommand) {
		salaryInsertService.execute(salaryCommand);
		return "redirect:salaryList";
	}
}
