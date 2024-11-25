package Mini_PM_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Mini_PM_System.command.DepartmentCommand;
import Mini_PM_System.service.department.DepartmentInsertService;
import Mini_PM_System.service.department.DepartmentListService;

@Controller
@RequestMapping("department")
public class DepartmentController {
	@Autowired
	DepartmentInsertService departmentInsertService;
	@Autowired
	DepartmentListService departmentListService;
	
	@GetMapping("dpList")
	public String dpList(@RequestParam(value = "page", required = true, defaultValue = "1") int page
						,@RequestParam(value = "searchWord", required = false) String searchWord
			,			Model model) {
		departmentListService.execute(page, searchWord, model);
		return "thymeleaf/department/dpList";
	}
	
	@GetMapping("dpWrite")
	public String dpWrite() {
		
		return "thymeleaf/department/dpForm";
	}
	@PostMapping("dpInsert")
	public String dpInsert(DepartmentCommand departmentCommand) {
		departmentInsertService.execute(departmentCommand);
		return "redirect:dpList";
	}
}
