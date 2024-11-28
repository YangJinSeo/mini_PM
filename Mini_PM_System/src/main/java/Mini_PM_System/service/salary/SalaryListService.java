package Mini_PM_System.service.salary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Mini_PM_System.domain.SalaryDTO;
import Mini_PM_System.domain.StartEndPageDTO;
import Mini_PM_System.mapper.SalaryMapper;
import Mini_PM_System.service.StartEndPageService;

@Service
public class SalaryListService {
	@Autowired
	SalaryMapper salaryMapper;
	@Autowired
	StartEndPageService startEndPageService;
	
	public void execute(Integer page, String searchWord, Model model) {
		int limit = 3;
		
		StartEndPageDTO sepDTO = startEndPageService.execute(limit, page, searchWord);
		List<SalaryDTO> list = salaryMapper.salarySelectList(sepDTO);
		
		Integer count = salaryMapper.salaryCount(searchWord);
		startEndPageService.execute(page, limit, count, searchWord, list, model);
	}

}
