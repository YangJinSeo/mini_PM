package Mini_PM_System.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Mini_PM_System.domain.AStartEndPageDTO;
import Mini_PM_System.domain.StartEndPageDTO;

@Service
public class AStartEndPageService {
	public AStartEndPageDTO execute(int page, int limit, String searchWord, String startDate, String endDate) {
		int startRow = ((page-1) * limit) + 1;
		int endRow = startRow + limit - 1;
		AStartEndPageDTO sepDTO = new AStartEndPageDTO(startRow, endRow, searchWord, startDate,  endDate);
		return sepDTO;
	}
	public void execute(int page, int limit, int count, String searchWord
						, List list, String startDate, String endDate, Model model) {
		int limitPage = 10; // 1 ~ 10, 11 ~ 20, 21 ~ 30, ...
		int startPageNum = (int)((double) page / limitPage + 0.95 - 1) * limitPage + 1;
		int endPageNum = startPageNum + limitPage - 1;
		int maxPage = (int)((double)count / limit + 0.95);
		if(endPageNum > maxPage) endPageNum = maxPage;
		
		if(endPageNum == 0) endPageNum = 1;
		if(searchWord == null) searchWord="";
		model.addAttribute("list", list);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("page", page);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		model.addAttribute("count", count);
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
	}

}

