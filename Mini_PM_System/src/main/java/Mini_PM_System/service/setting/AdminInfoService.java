package Mini_PM_System.service.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Mini_PM_System.domain.AuthInfoDTO;
import Mini_PM_System.mapper.FindMapper;

@Service
public class AdminInfoService {
	
	@Autowired
	FindMapper findMapper;
	public void execute(String id, Model model) {
		
		AuthInfoDTO dto = findMapper.adminInfo(id);
		model.addAttribute("dto", dto);
	}

}
