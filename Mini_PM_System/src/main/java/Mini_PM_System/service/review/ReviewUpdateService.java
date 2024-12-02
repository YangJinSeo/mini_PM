package Mini_PM_System.service.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Mini_PM_System.command.ReviewCommand;
import Mini_PM_System.domain.ReviewDTO;
import Mini_PM_System.mapper.ReviewMapper;

@Service
public class ReviewUpdateService {
	@Autowired
	ReviewMapper reviewMapper;
	
	public void execute(ReviewCommand reviewCommand) {
		ReviewDTO dto = new ReviewDTO();
		dto.setEmpComment(reviewCommand.getEmpComment());
		dto.setScore(reviewCommand.getScore());
		dto.setEmpNum(reviewCommand.getEmpNum());
		reviewMapper.reviewUpdate(dto);
	}

}
