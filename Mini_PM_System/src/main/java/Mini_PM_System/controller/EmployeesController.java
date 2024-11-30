package Mini_PM_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Mini_PM_System.command.EmpCommand;
import Mini_PM_System.domain.DropDownDTO;
import Mini_PM_System.service.AutoService;
import Mini_PM_System.service.DropDownService;
import Mini_PM_System.service.employee.EmpDeleteService;
import Mini_PM_System.service.employee.EmpDetailService;
import Mini_PM_System.service.employee.EmpInsertService;
import Mini_PM_System.service.employee.EmpListService;
import Mini_PM_System.service.employee.EmpUpdateService;



@Controller
@RequestMapping("employee")
public class EmployeesController {
	
	
	@Autowired
	EmpListService empListService;
	
	@RequestMapping("empList")
	public String empList(@RequestParam(value = "page", required = true, defaultValue = "1") int page
						,@RequestParam(value = "searchWord", required = false) String searchWord
						, Model model) {
		empListService.execute(page, searchWord, model);
		return "thymeleaf/employee/empList";
	}
	
	
	@Autowired
	AutoService autoService;
	@Autowired
	DropDownService dropDownService;
	@GetMapping("empWrite")
	public String empWrite(Model model) {
		
		// 부서, 직무 코드의 드롭다운 서비스
		//// 부서 -> 부서코드와 이름
		List<DropDownDTO> dp = 
		dropDownService.execute("department", "department_id", "department_name");
		model.addAttribute("dp", dp);
		//// 직무 -> 직무코드와 이름
		List<DropDownDTO> job = 
		dropDownService.execute("jobs", "job_id", "job_name");
		model.addAttribute("job", job);
		
		
		String autoNum 
		= autoService.autoNum("emp_", 5, "emp_num", "employees");
		EmpCommand empCommand = new EmpCommand();
		empCommand.setEmpNum(autoNum);
		model.addAttribute("empCommand", empCommand);
		
		return "thymeleaf/employee/empWrite";
	}
	
	@Autowired
	EmpInsertService empInsertService;
	@PostMapping("empInsert")
	public String empInsert(@Validated EmpCommand empCommand
							, BindingResult result
							, Model model) {
		
		if (result.hasErrors()) {
			// 부서, 직무 코드의 드롭다운 서비스
			//// 부서 -> 부서코드와 이름
			List<DropDownDTO> dp = 
			dropDownService.execute("department", "department_id", "department_name");
			model.addAttribute("dp", dp);
			//// 직무 -> 직무코드와 이름
			List<DropDownDTO> job = 
			dropDownService.execute("jobs", "job_id", "job_name");
			model.addAttribute("job", job);
					
			return "thymeleaf/employee/empWrite";
		}
		
		empInsertService.execute(empCommand);
		return "redirect:empList";
	}
	
	
	@Autowired
	EmpDetailService empDetailService;
	
	@RequestMapping("empDetail/{empNum}")
	public String empDetail(@PathVariable("empNum") String empNum
							,Model model) {
		empDetailService.execute(empNum, model);
		return "thymeleaf/employee/empDetail";
	}
	
	
	
	@Autowired
	EmpUpdateService empUpdateService;
	
	@GetMapping("empUpdate")
	public String empUpdate(String num, Model model) {
		// 부서, 직무 코드의 드롭다운 서비스
		//// 부서 -> 부서코드와 이름
		List<DropDownDTO> dp = 
		dropDownService.execute("department", "department_id", "department_name");
		model.addAttribute("dp", dp);
		//// 직무 -> 직무코드와 이름
		List<DropDownDTO> job = 
		dropDownService.execute("jobs", "job_id", "job_name");
		model.addAttribute("job", job);
		
		empDetailService.execute(num, model);
		return "thymeleaf/employee/empUpdate";
	}
	@PostMapping("empUpdate")
	public String empUpdate(@Validated EmpCommand empCommand
							, BindingResult result
							, Model model) {
		if (result.hasErrors()) {
			
			// 부서, 직무 코드의 드롭다운 서비스
			//// 부서 -> 부서코드와 이름
			List<DropDownDTO> dp = 
			dropDownService.execute("department", "department_id", "department_name");
			model.addAttribute("dp", dp);
			//// 직무 -> 직무코드와 이름
			List<DropDownDTO> job = 
			dropDownService.execute("jobs", "job_id", "job_name");
			model.addAttribute("job", job);
			
			return "thymeleaf/employee/empUpdate";
		}
		empUpdateService.execute(empCommand);
		
		return "redirect:empDetail/"+empCommand.getEmpNum();
	}
	

	@Autowired
	EmpDeleteService empDeleteService;
	@GetMapping("empDelete")
	public String empDelete(String num) {
		empDeleteService.execute(num);
		return "redirect:empList";
	}
	
}
