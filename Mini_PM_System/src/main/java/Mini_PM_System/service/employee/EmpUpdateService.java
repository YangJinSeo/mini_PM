package Mini_PM_System.service.employee;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Mini_PM_System.command.EmpCommand;
import Mini_PM_System.domain.EmployeeDTO;
import Mini_PM_System.mapper.EmployeeMapper;

@Service
public class EmpUpdateService {
	
	@Autowired
	EmployeeMapper empMapper;
	public void execute(EmpCommand empCommand) {
		EmployeeDTO dto = new EmployeeDTO();
		BeanUtils.copyProperties(empCommand, dto);
		
		empMapper.empUpdate(dto);
		
	}

}
