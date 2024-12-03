package Mini_PM_System.service.find;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Mini_PM_System.mapper.FindMapper;

@Service
public class FindIdService {
	
	@Autowired
	FindMapper findMapper;
	public void execute(String empNum, String userName
						, Model model) {
		
		String userId =
		findMapper.findId(empNum, userName);
		model.addAttribute("userId", userId);
	}

}
