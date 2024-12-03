package Mini_PM_System.service.attendance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Mini_PM_System.domain.AStartEndPageDTO;
import Mini_PM_System.domain.AttendanceDTO;
import Mini_PM_System.mapper.AttendanceMapper;
import Mini_PM_System.service.AStartEndPageService;

@Service
public class AttListService {
	@Autowired
	AttendanceMapper attendanceMapper;
	@Autowired
	AStartEndPageService astartEndPageService;
	public void execute(int page, String searchWord, String startDate, String endDate, Model model) {
		int limit = 3;
		AStartEndPageDTO sepDTO = astartEndPageService.execute(page, limit, searchWord, startDate, endDate);
		List<AttendanceDTO> list = attendanceMapper.attSelectList(sepDTO);
		Integer count = attendanceMapper.attCount(searchWord);
		Integer count1 = attendanceMapper.attCount1(searchWord);
		Integer count2 = attendanceMapper.attCount2(searchWord);
		Integer count3 = attendanceMapper.attCount3(searchWord);
		astartEndPageService.execute(page, limit, count, searchWord, list, startDate, endDate, model);
		
		model.addAttribute("count1", count1);
		model.addAttribute("count2", count2);
		model.addAttribute("count3", count3);
		
	}

}
