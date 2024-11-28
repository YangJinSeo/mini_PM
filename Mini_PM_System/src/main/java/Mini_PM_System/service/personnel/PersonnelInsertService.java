package Mini_PM_System.service.personnel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Mini_PM_System.command.PersonnelCommand;
import Mini_PM_System.domain.EmployeeDTO;
import Mini_PM_System.domain.PersonnelDTO;
import Mini_PM_System.domain.UsersDTO;
import Mini_PM_System.mapper.DepartmentMapper;
import Mini_PM_System.mapper.EmployeeMapper;
import Mini_PM_System.mapper.PersonnelMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class PersonnelInsertService {
	@Autowired
	PersonnelMapper personnelMapper;
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	DepartmentMapper departmentMapper;
	
	public void execute(PersonnelCommand personnelCommand, HttpSession session) {
		String dpName = personnelCommand.getCurrdpName();
		String dpName1 = personnelCommand.getNextdpName();
		
		PersonnelDTO dto = new PersonnelDTO();
		dto.setAppointmentDate(personnelCommand.getAppointmentDate());
		dto.setAppointmentState(personnelCommand.getAppointmentState());
		dto.setApprovalDate(personnelCommand.getApprovalDate());
		dto.setCurrdpName(dpName);
		dto.setEmpNum(personnelCommand.getEmpNum());
		dto.setNextdpName(dpName1);
		dto.setNextPosition(personnelCommand.getNextPosition());
		
		personnelMapper.personnelInsert(dto);
	}

}
