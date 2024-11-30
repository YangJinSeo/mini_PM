package Mini_PM_System.service.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Mini_PM_System.domain.DepartmentDTO;
import Mini_PM_System.mapper.DepartmentMapper;

@Service
public class DepartmentDetailService {
	@Autowired
	DepartmentMapper departmentMapper;
	
	public void execute(String departmentId, Model model) {
		DepartmentDTO dto = departmentMapper.dpSelectOne(departmentId);
		model.addAttribute("departmentCommand", dto);
	}
	
}
