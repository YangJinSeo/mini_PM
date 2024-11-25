package Mini_PM_System.service.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Mini_PM_System.command.DepartmentCommand;
import Mini_PM_System.domain.DepartmentDTO;
import Mini_PM_System.mapper.DepartmentMapper;

@Service
public class DepartmentInsertService {
	@Autowired
	DepartmentMapper departmentMapper;
	
	public void execute(DepartmentCommand departmentCommand) {
		DepartmentDTO dto = new DepartmentDTO();
		dto.setDepartmentId(departmentCommand.getDepartmentId());
		dto.setDepartmentName(departmentCommand.getDepartmentName());
		dto.setDuty(departmentCommand.getDuty());
		dto.setManagerId(departmentCommand.getManagerId());
		dto.setOfficeLoc(departmentCommand.getOfficeLoc());
		
		departmentMapper.dpInsert(dto);
	}
	
}
