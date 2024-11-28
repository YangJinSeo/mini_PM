package Mini_PM_System.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Mini_PM_System.command.PersonnelCommand;
import Mini_PM_System.service.personnel.DepartmentsService;
import Mini_PM_System.service.personnel.EmployeesService;
import Mini_PM_System.service.personnel.PersonnelInsertService;
import Mini_PM_System.service.personnel.PersonnelListService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("personnel")
public class PersonnelController {
	@Autowired
	PersonnelInsertService personnelInsertService;
	@Autowired
	EmployeesService employeesService;
	@Autowired
	DepartmentsService departmentsService;
	@Autowired
	PersonnelListService personnelListService;
	
	@GetMapping("perList")
	public String perList(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page
			, @RequestParam(value = "searchWord", required = false) String searchWord
			,Model model) {
		personnelListService.execute(page, searchWord, model);
		return "thymeleaf/personnel/perList";
	}
	@GetMapping("perWrite")
	public String perWrite() {
		
		return "thymeleaf/personnel/perForm";
	}
	@PostMapping("perInsert")
	public String perInsert(PersonnelCommand personnelCommand, HttpSession session) {
		personnelInsertService.execute(personnelCommand, session);
		return "redirect:perList";
	}
	@GetMapping("employees")
	public String employees() {
		return "thymeleaf/personnel/employees";
	}
	@PostMapping("employeesList")
	public @ResponseBody Map<String, Object> employeesList(
			@RequestParam(value = "page" , required = false , defaultValue = "1") int page
			,@RequestParam(value = "searchWord", required = false) String searchWord) {
		Map<String, Object> map = employeesService.execute(page, searchWord);
		return map;
	}
	@GetMapping("departments")
	public String departments() {
		return "thymeleaf/personnel/departments";
	}
	@PostMapping("departmentsList")
	public @ResponseBody Map<String, Object> departmentsList(
			@RequestParam(value = "page" , required = false , defaultValue = "1") int page
			,@RequestParam(value = "searchWord", required = false) String searchWord) {
		Map<String, Object> map = departmentsService.execute(page, searchWord);
		return map;
	}
}
