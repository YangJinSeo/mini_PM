package Mini_PM_System.service.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Mini_PM_System.domain.AuthInfoDTO;
import Mini_PM_System.mapper.FindMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class UserInfoService {
	
	@Autowired
	FindMapper findMapper;
	public void execute(HttpSession session, Model model) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String empNum = auth.getPmEmpNum();
		AuthInfoDTO dto = findMapper.userOne(empNum);
		model.addAttribute("dto", dto);
		
	}

}
