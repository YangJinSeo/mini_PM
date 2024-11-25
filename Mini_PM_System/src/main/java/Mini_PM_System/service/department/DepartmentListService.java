package Mini_PM_System.service.department;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Mini_PM_System.domain.DepartmentDTO;
import Mini_PM_System.domain.StartEndPageDTO;
import Mini_PM_System.mapper.DepartmentMapper;
import Mini_PM_System.service.StartEndPageService;

@Service
public class DepartmentListService {
	@Autowired
	DepartmentMapper departmentMapper;
	@Autowired
	StartEndPageService startEndPageService;
	
	public void execute(int page, String searchWord, Model model) {
		int limit = 3;
		StartEndPageDTO sepDTO = startEndPageService.execute(page, limit, searchWord);
		List<DepartmentDTO> list = departmentMapper.dpSelectList(sepDTO);
		Integer count = departmentMapper.dpCount(searchWord);
		startEndPageService.execute(page, limit, count, searchWord, list, model);
	}

}
