package Mini_PM_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Mini_PM_System.command.EmpCommand;
import Mini_PM_System.service.AutoService;
import Mini_PM_System.service.employee.EmpInsertService;
import Mini_PM_System.service.employee.EmpListService;


@Controller
@RequestMapping("employee")
public class EmployeesController {
	
	
	@Autowired
	EmpListService empListService;
	
	@RequestMapping("empList")
	public String empList(Model model) {
		empListService.execute(model);
		return "thymeleaf/employee/empList";
	}
	
	
	@Autowired
	AutoService autoService;
	@Autowired
	EmpInsertService empInsertService;
	
	@GetMapping("empWrite")
	public String empWrite(Model model) {
		String autoNum = autoService.autoNum("emp_", 5, "emp_num", "employees");
		model.addAttribute("autoNum", autoNum);
		
		return "thymeleaf/employee/empWrite";
	}
	
	@PostMapping("empInsert")
	public String empInsert(EmpCommand empCommand) {
		empInsertService.execute(empCommand);
		return "redirect:empList";
	}
}
