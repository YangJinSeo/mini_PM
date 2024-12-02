package Mini_PM_System.service.attendence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Mini_PM_System.domain.AttendanceDTO;
import Mini_PM_System.domain.StartEndPageDTO;
import Mini_PM_System.mapper.AttendanceMapper;
import Mini_PM_System.service.StartEndPageService;

@Service
public class AttListService {
	@Autowired
	AttendanceMapper attendanceMapper;
	@Autowired
	StartEndPageService startEndPageService;
	public void execute(int page, String searchWord, Model model) {
		int limit = 3;
		StartEndPageDTO sepDTO = startEndPageService.execute(page, limit, searchWord);
		List<AttendanceDTO> list = attendanceMapper.attSelectList(sepDTO);
		Integer count = attendanceMapper.attCount(searchWord);
		Integer count1 = attendanceMapper.attCount1(searchWord);
		Integer count2 = attendanceMapper.attCount2(searchWord);
		Integer count3 = attendanceMapper.attCount3(searchWord);
		startEndPageService.execute(page, limit, count, searchWord, list, model);
		
		model.addAttribute("count1", count1);
		model.addAttribute("count2", count2);
		model.addAttribute("count3", count3);
		
	}

}
