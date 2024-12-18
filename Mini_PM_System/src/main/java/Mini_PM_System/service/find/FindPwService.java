package Mini_PM_System.service.find;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Mini_PM_System.mapper.FindMapper;

@Service
public class FindPwService {
	
	@Autowired
	FindMapper findMapper;
	public void execute(String empNum, String userId
						, String userJumin, Model model) {
		String userPw =
				findMapper.findPw(empNum, userId, userJumin);
		model.addAttribute("userPw", userPw);
		model.addAttribute("userId", userId);
	}

}
