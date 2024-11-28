package Mini_PM_System.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Mini_PM_System.domain.EmpDetailDTO;
import Mini_PM_System.mapper.EmployeeMapper;

@Service
public class EmpDetailService {
	
	@Autowired
	EmployeeMapper empMapper;
	
	public void execute(String empNum, Model model) {
		
		EmpDetailDTO dto = empMapper.selectOne(empNum);
		model.addAttribute("dto", dto); 
		model.addAttribute("empCommand", dto.getEmployeeDTO());
		
	}
	
	
	
}
