package Mini_PM_System.service.personnel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Mini_PM_System.domain.PersonnelDTO;
import Mini_PM_System.domain.StartEndPageDTO;
import Mini_PM_System.mapper.PersonnelMapper;
import Mini_PM_System.service.StartEndPageService;

@Service
public class PersonnelListService {
		@Autowired
		PersonnelMapper personnelMapper;
		@Autowired
		StartEndPageService startEndPageService;
		
		public void execute(Integer page, String searchWord, Model model){
			int limit = 3;
			
			StartEndPageDTO sepDTO = startEndPageService.execute(limit, page, searchWord);
			List<PersonnelDTO> list = personnelMapper.personnelSelectList(sepDTO);
			
			Integer count = personnelMapper.personnelCount(searchWord);
			startEndPageService.execute(page, limit, count, searchWord, list, model);
		}

}
