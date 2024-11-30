package Mini_PM_System.service.retire;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Mini_PM_System.domain.RetireDTO;
import Mini_PM_System.domain.StartEndPageDTO;
import Mini_PM_System.mapper.RetireMapper;
import Mini_PM_System.service.StartEndPageService;

@Service
public class RetireListService {
	
	@Autowired
	RetireMapper retireMapper;
	@Autowired
	StartEndPageService startEndPageService;
	public void execute(int page, String searchWord, Model model) {
		int limit = 3;
		StartEndPageDTO sepDTO
		= startEndPageService.execute(page, limit, searchWord);
		
		List<RetireDTO> list = retireMapper.selectList(sepDTO);
		Integer count = retireMapper.count(searchWord);
		
		startEndPageService.execute(page, limit, count, searchWord, list, model);
	}

}
