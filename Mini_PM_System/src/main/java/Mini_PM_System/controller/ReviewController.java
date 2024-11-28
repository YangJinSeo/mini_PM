package Mini_PM_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Mini_PM_System.command.ReviewCommand;
import Mini_PM_System.service.review.ReviewInsertService;
import Mini_PM_System.service.review.ReviewListService;

@Controller
@RequestMapping("review")
public class ReviewController {
	@Autowired
	ReviewInsertService reviewInsertService;
	@Autowired
	ReviewListService reviewListService;
	
	@GetMapping("reviewList")
	public String reviewList(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page
			, @RequestParam(value = "searchWord", required = false) String searchWord
			,Model model) {
		reviewListService.execute(page, searchWord, model);
		return "thymeleaf/review/reviewList";
	}
	@GetMapping("reviewWrite")
	public String reviewWrite() {
		
		return "thymeleaf/review/reviewForm";
	}
	@PostMapping("reviewInsert")
	public String reviewInsert(ReviewCommand reviewCommand) {
		reviewInsertService.execute(reviewCommand);
		return "redirect:reviewList";
	}
}
