package Mini_PM_System.service.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Mini_PM_System.domain.ReviewDTO;
import Mini_PM_System.mapper.ReviewMapper;

@Service
public class ReviewDetailService {
	@Autowired
	ReviewMapper reviewMapper;
	
	public void execute(String empNum, Model model) {
		ReviewDTO dto = reviewMapper.reviewSelectOne(empNum);
		model.addAttribute("reviewCommand", dto);
	}
	
}
