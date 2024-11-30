package Mini_PM_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Mini_PM_System.command.RetireCommand;
import Mini_PM_System.domain.DropDownDTO;
import Mini_PM_System.service.DropDownService;
import Mini_PM_System.service.retire.RetireDeleteService;
import Mini_PM_System.service.retire.RetireInfoService;
import Mini_PM_System.service.retire.RetireListService;
import Mini_PM_System.service.retire.RetireUpdateService;
import Mini_PM_System.service.retire.RetireWriteService;

@Controller
@RequestMapping("retire")
public class RetireController {
	
	@Autowired
	RetireListService retireListService;
	@GetMapping("retireList")
	public String retireList(@RequestParam(value = "page", required = true, defaultValue = "1") int page,
							@RequestParam(value = "searchWord", required = false) String searchWord,
							Model model) {
		
		retireListService.execute(page, searchWord ,model);
		return "thymeleaf/retire/retireList";
	}
	
	
	///////////////////////// 작성 
	
	@Autowired
	DropDownService dropDownService;
	@GetMapping("retireWrite")
	public String Write(Model model) {
		List<DropDownDTO> dp
		= dropDownService.execute("department", "department_id", "department_name");
		model.addAttribute("dp", dp);
		
		RetireCommand retireCommand = new RetireCommand();
		model.addAttribute("retireCommand", retireCommand);
		
		return "thymeleaf/retire/retireWrite";
	}
	
	@Autowired
	RetireWriteService retireWriteService;
	@PostMapping("retireWrite")
	public String retireWrite(@Validated RetireCommand retireCommand
								, BindingResult result
								, Model model) {
		if (result.hasErrors()) {
			List<DropDownDTO> dp
			= dropDownService.execute("department", "department_id", "department_name");
			model.addAttribute("dp", dp);
			
			return "thymeleaf/retire/retireWrite";
		}
		
		retireWriteService.execute(retireCommand);
		
		return "redirect:retireList";
	}
	
//	================ 디테일
	@Autowired
	RetireInfoService retireInfoService;
	@GetMapping("retireInfo")
	public String retireInfo(String num, Model model) {
		retireInfoService.execute(num, model);
		return "thymeleaf/retire/retireInfo";
	}
	
	
	/////////////////// 수정
	@GetMapping("retireUpdate")
	public String retireUpdate(String num, Model model) {
		List<DropDownDTO> dp
		= dropDownService.execute("department", "department_id", "department_name");
		model.addAttribute("dp", dp);
		
		RetireCommand retireCommand = new RetireCommand();
		model.addAttribute("retireCommand", retireCommand);
		
		retireInfoService.execute(num, model);
		
		return "thymeleaf/retire/retireUpdate";
	}
	
	@Autowired
	RetireUpdateService retireUpdateService;
	@PostMapping("retireUpdate")
	public String retireUpdate(@Validated RetireCommand retireCommand
								, BindingResult result
								, Model model) {
		if (result.hasErrors()) {
			List<DropDownDTO> dp
			= dropDownService.execute("department", "department_id", "department_name");
			model.addAttribute("dp", dp);
			
			return "thymeleaf/retire/retireUpdate";
		}
		
		retireUpdateService.execute(retireCommand);
		
		return "redirect:retireInfo?num="+retireCommand.getRetireNum();
	}
	
	/////////////// 삭제
	@Autowired
	RetireDeleteService retireDeleteService;
	@GetMapping("retireDelete")
	public String retireDelete(String num) {
		retireDeleteService.execute(num);
		return "redirect:retireList";
	}
	
	
}
