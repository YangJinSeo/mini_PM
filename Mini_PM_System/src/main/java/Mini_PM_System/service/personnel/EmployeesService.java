package Mini_PM_System.service.personnel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Mini_PM_System.domain.PersonnelDTO;
import Mini_PM_System.mapper.PersonnelMapper;
import Mini_PM_System.service.StartEndPageService;

@Service
public class EmployeesService {
	@Autowired
	PersonnelMapper personnelMapper;
	@Autowired
	StartEndPageService startEndPageService;
	public Map<String, Object> execute(int page, String searchWord) {
		if(searchWord == null) searchWord = ""; 
		int limit = 3;
		int startRow = ((page - 1) * limit) + 1; 
		int endRow = startRow + limit - 1;
		List<PersonnelDTO> list = personnelMapper.empSelectList(startRow, endRow, searchWord);
		int count = personnelMapper.empSelectListCount(searchWord);
		int limitPage = 10; 
		int startPageNum = (int)((double) page / limitPage + 0.95 - 1) * limitPage + 1;
		int endPageNum = startPageNum + limitPage - 1;
		int maxPage = (int)((double)count / limit + 0.95);
		if(endPageNum > maxPage) endPageNum = maxPage;
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("searchWord", searchWord);
		map.put("list", list);
		map.put("page", page);
		map.put("startPageNum", startPageNum);
		map.put("endPageNum", endPageNum);
		map.put("count", count);
		map.put("maxPage", maxPage);
		return map;
	}
}
