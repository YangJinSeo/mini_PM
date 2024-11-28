package Mini_PM_System.service.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Mini_PM_System.domain.EmployeeDTO;
import Mini_PM_System.domain.StartEndPageDTO;
import Mini_PM_System.mapper.EmployeeMapper;
import Mini_PM_System.service.StartEndPageService;

@Service
public class EmpListService {
	
	@Autowired
	EmployeeMapper empMapper;
	@Autowired
	StartEndPageService startEndPageService;
	
	public void execute(int page, String searchWord, Model model) {
		int limit = 3;
		StartEndPageDTO sepDTO 
		= startEndPageService.execute(page, limit, searchWord);
		
		List<EmployeeDTO> list = empMapper.selectList(sepDTO);
		Integer count = empMapper.empCount(searchWord);
		
		startEndPageService.execute(page, limit, count, searchWord, list, model);
	}
	
	
}
