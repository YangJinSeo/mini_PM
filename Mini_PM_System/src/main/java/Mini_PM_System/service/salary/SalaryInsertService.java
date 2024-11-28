package Mini_PM_System.service.salary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Mini_PM_System.command.SalaryCommand;
import Mini_PM_System.domain.SalaryDTO;
import Mini_PM_System.mapper.SalaryMapper;

@Service
public class SalaryInsertService {
	@Autowired
	SalaryMapper salaryMapper;
	
	public void execute(SalaryCommand salaryCommand) {
		SalaryDTO dto = new SalaryDTO();
		dto.setAccount(salaryCommand.getAccount());
		dto.setEmpNum(salaryCommand.getEmpNum());
		dto.setEmpSalary(salaryCommand.getEmpSalary());
		salaryMapper.salaryMerge(dto);
	}

}
