package Mini_PM_System.service.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Mini_PM_System.domain.EmployeeDTO;
import Mini_PM_System.mapper.EmployeeMapper;

@Service
public class EmpListService {
	
	@Autowired
	EmployeeMapper empMapper;
	public void execute(Model model) {
		List<EmployeeDTO> list = empMapper.selectList();
		model.addAttribute("empCommand", list);
	}
	
	
}
