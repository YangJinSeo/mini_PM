package Mini_PM_System.service.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Mini_PM_System.mapper.DepartmentMapper;

@Service
public class DepartmentDeleteService {
	@Autowired
	DepartmentMapper departmentMapper;
	
	public void execute(String departmentId) {
		departmentMapper.dpDelete(departmentId);
	}

}
