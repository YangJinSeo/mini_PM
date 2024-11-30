package Mini_PM_System.service.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Mini_PM_System.domain.ReviewDTO;
import Mini_PM_System.domain.StartEndPageDTO;
import Mini_PM_System.mapper.ReviewMapper;
import Mini_PM_System.service.StartEndPageService;

@Service
public class ReviewListService {
	@Autowired
	ReviewMapper reviewMapper;
	@Autowired
	StartEndPageService startEndPageService;
	
	public void execute(Integer page, String searchWord, Model model) {
		int limit = 3;
		StartEndPageDTO sepDTO = startEndPageService.execute(page, limit, searchWord);
		
		List<ReviewDTO> list = reviewMapper.reviewSelectList(sepDTO);
		int count = reviewMapper.reviewCount(searchWord);
		
		startEndPageService.execute(page, limit, count, searchWord, list, model);
	}

}
